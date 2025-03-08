package nl.ba99.narrowcaster.controllers;

import nl.ba99.narrowcaster.controllers.logic.AbstractAPIController;
import nl.ba99.narrowcaster.dto.UserDto;
import nl.ba99.narrowcaster.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("User Controller")
@RestController
@RequestMapping("users")
public class UserController extends AbstractAPIController<UserService, UserDto> {
    public UserController(UserService service) {
        super(service);
    }

}

