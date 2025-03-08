package nl.ba99.narrowcaster.controllers;

import nl.ba99.narrowcaster.controllers.logic.AbstractAPIController;
import nl.ba99.narrowcaster.dto.TextSlideDto;
import nl.ba99.narrowcaster.services.TextSlideService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Text Slide Controller")
@RestController
@RequestMapping("text_slides")
public class TextSlideController extends AbstractAPIController<TextSlideService, TextSlideDto> {
    public TextSlideController(TextSlideService service) {
        super(service);
    }
}

