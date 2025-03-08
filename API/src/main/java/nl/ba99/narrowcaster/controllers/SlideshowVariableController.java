package nl.ba99.narrowcaster.controllers;

import nl.ba99.narrowcaster.controllers.logic.AbstractAPIController;
import nl.ba99.narrowcaster.dto.SlideshowVariableDto;
import nl.ba99.narrowcaster.services.SlideshowVariableService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Slideshow Variable Controller")
@RestController
@RequestMapping("slideshow_variables")
public class SlideshowVariableController extends AbstractAPIController<SlideshowVariableService, SlideshowVariableDto> {
    public SlideshowVariableController(SlideshowVariableService service) {
        super(service);
    }
}
