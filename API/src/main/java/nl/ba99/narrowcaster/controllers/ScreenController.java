package nl.ba99.narrowcaster.controllers;

import nl.ba99.narrowcaster.controllers.logic.AbstractAPIController;
import nl.ba99.narrowcaster.dto.ScreenDto;
import nl.ba99.narrowcaster.services.ScreenService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Screen Controller")
@RestController
@RequestMapping("screens")
public class ScreenController extends AbstractAPIController<ScreenService, ScreenDto> {
    public ScreenController(ScreenService service) {
        super(service);
    }
}
