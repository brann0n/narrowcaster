package nl.ba99.narrowcaster.controllers;

import nl.ba99.narrowcaster.controllers.logic.AbstractAPIController;
import nl.ba99.narrowcaster.dto.MediaSlideDto;
import nl.ba99.narrowcaster.services.MediaSlideService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Media Slide Controller")
@RestController
@RequestMapping("media_slides")
public class MediaSlideController extends AbstractAPIController<MediaSlideService, MediaSlideDto> {
    public MediaSlideController(MediaSlideService service) {
        super(service);
    }
}
