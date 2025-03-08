package nl.ba99.narrowcaster.services;

import nl.ba99.narrowcaster.dto.UserDto;
import nl.ba99.narrowcaster.exception.DataNotFoundException;
import nl.ba99.narrowcaster.exception.DeletionOfLastAdminAccountException;
import nl.ba99.narrowcaster.exception.ForbiddenActionException;
import nl.ba99.narrowcaster.exception.UserAlreadyExistsException;
import nl.ba99.narrowcaster.models.User;
import nl.ba99.narrowcaster.repositories.UserRepository;
import nl.ba99.narrowcaster.services.logic.AbstractAPIService;
import nl.ba99.narrowcaster.transformers.MappingUtility;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService extends AbstractAPIService<UserRepository, UserDto, User> {

    private final PasswordEncoder encoder;

    public UserService(UserRepository repo, MappingUtility mapper, PasswordEncoder encoder, LogService logService) {
        super(repo, mapper, UserDto.class, User.class, logService);
        this.encoder = encoder;
    }

    public UserDto findByUsername(String username) {
        User u = repo.findByUsername(username)
                .orElseThrow(() -> new DataNotFoundException("Could not find user " + username));

        return mapper.mapObject(u, dtoType);
    }

    @Override
    public List<UserDto> getList() {
        List<UserDto> returnList = super.getList();

        if (userHasAuthority("ROLE_DOCENT")) {
            // return a list with 1 object in it. The one object being the current user.
            return returnList.stream().filter(user -> user.getUsername().equals(getUsername())).collect(Collectors.toList());
        }

        for (UserDto user : returnList) {
            user.setPassword("");
        }

        return returnList;
    }

    @Override
    public UserDto get(long id) {
        UserDto user = super.get(id);

        if (userHasAuthority("ROLE_DOCENT"))
            if (!getUsername().equals(user.getUsername()))
                throw new ForbiddenActionException();

        user.setPassword("");
        return user;
    }

    @Override
    public long create(UserDto userDto) {
        // because of controller abstraction, annotations cause a proxy to be generated instead.
        // therefore, check inside the function.
        if(userHasAuthority("ROLE_DOCENT"))
            throw new ForbiddenActionException();

        Optional<User> u = repo.findByUsername(userDto.getUsername());
        if (u.isPresent())
            throw new UserAlreadyExistsException(String.format("The username '%s' is already taken", userDto.getUsername()));

        //when creating a new user, encode the password
        userDto.setPassword(encoder.encode(userDto.getPassword()));

        return super.create(userDto);
    }

    @Override
    public void update(UserDto userDto, long id) {
        User u = repo.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Could not find user with id" + id));

        //if the user is not an admin, check if they are updating their own useraccount.
        if (userHasAuthority("ROLE_DOCENT"))
            if (!getUsername().equals(u.getUsername()))
                throw new ForbiddenActionException();

        // if the username is changed, check if the new username is available.
        if (!u.getUsername().equals(userDto.getUsername())) {
            Optional<User> fndUser = repo.findByUsername(userDto.getUsername());
            if (fndUser.isPresent())
                throw new UserAlreadyExistsException(String.format("The username '%s' is already taken", userDto.getUsername()));
        }

        //when updating a user, encode the password
        if (!userDto.getPassword().isEmpty())
            userDto.setPassword(encoder.encode(userDto.getPassword()));
        else
            userDto.setPassword(u.getPassword());

        super.update(userDto, id);
    }

    @Override
    public void delete(long id) {
        // because of controller abstraction, annotations cause a proxy to be generated instead.
        // therefore, check inside the function.
        if(userHasAuthority("ROLE_DOCENT"))
            throw new ForbiddenActionException();

        if (getList().stream().filter(user -> user.getRole().equals("ROLE_ADMIN")).count() == 1
                && get(id).getRole().equals("ROLE_ADMIN"))
            throw new DeletionOfLastAdminAccountException();

        super.delete(id);
    }
}
