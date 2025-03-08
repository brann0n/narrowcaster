package nl.ba99.narrowcaster.services;

import nl.ba99.narrowcaster.dto.LogDto;
import nl.ba99.narrowcaster.exception.DataNotFoundException;
import nl.ba99.narrowcaster.models.Log;
import nl.ba99.narrowcaster.repositories.LogRepository;
import nl.ba99.narrowcaster.repositories.UserRepository;
import nl.ba99.narrowcaster.services.logic.AbstractAPIService;
import nl.ba99.narrowcaster.transformers.MappingUtility;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LogService extends AbstractAPIService<LogRepository, LogDto, Log> {
    private final UserRepository userRepository;

    public LogService(LogRepository repo, MappingUtility mapper, UserRepository userRepository) {
        super(repo, mapper, LogDto.class, Log.class, null);
        this.userRepository = userRepository;
    }

    @Override
    public long create(LogDto logDto) {
        //Will throw a data not found runtime exception if screen does not exist
        if(logDto.getUserId() != null)
            findUser(logDto.getUserId());

        if(logDto.getDatetime() == null) logDto.setDatetime(Instant.now().getEpochSecond());
        return super.create(logDto);
    }

    @Override
    public void update(LogDto logDto, long id) {
        //Will throw a data not found runtime exception if screen does not exist
        if(logDto.getUserId() != null)
            findUser(logDto.getUserId());
        if(logDto.getDatetime() == null) logDto.setDatetime(Instant.now().getEpochSecond());
        super.update(logDto, id);
    }

    private void findUser(long userId){
        userRepository.findById(userId)
                .orElseThrow(() -> new DataNotFoundException(getClass().getSimpleName() + " could not find user " + userId));
    }
}
