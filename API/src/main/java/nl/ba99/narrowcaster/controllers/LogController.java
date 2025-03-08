package nl.ba99.narrowcaster.controllers;

import nl.ba99.narrowcaster.controllers.logic.AbstractAPIController;
import nl.ba99.narrowcaster.dto.LogDto;
import nl.ba99.narrowcaster.services.LogService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Log Controller")
@RestController
@RequestMapping("logs")
public class LogController extends AbstractAPIController<LogService, LogDto> {
    public LogController(LogService service) {
        super(service);
    }
}
