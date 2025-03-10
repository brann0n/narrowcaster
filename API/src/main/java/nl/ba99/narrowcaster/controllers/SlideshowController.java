package nl.ba99.narrowcaster.controllers;

import nl.ba99.narrowcaster.controllers.logic.AbstractAPIController;
import nl.ba99.narrowcaster.dto.SlideshowDto;
import nl.ba99.narrowcaster.dto.SlideshowSlidesDto;
import nl.ba99.narrowcaster.dto.SlideshowVariableDto;
import nl.ba99.narrowcaster.services.SlideshowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("Slideshow Controller")
@RestController
@RequestMapping("slideshows")
public class SlideshowController extends AbstractAPIController<SlideshowService, SlideshowDto> {
    public SlideshowController(SlideshowService service) {
        super(service);
    }

    @ApiOperation(value = "Gets the related variables for the requested slideshow")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Invalid slideshow id")})
    @GetMapping("/{id}/variables")
    ResponseEntity<List<SlideshowVariableDto>> getVariables(@PathVariable("id") final long id){
        return ResponseEntity.ok(service.getVariables(id));
    }

    @ApiOperation(value = "Gets all the slides belonging to the requested slideshow")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Invalid slideshow id")})
    @GetMapping("/{id}/slides")
    ResponseEntity<List<SlideshowSlidesDto>> getSlides(@PathVariable("id") final long id){
        return ResponseEntity.ok(service.getSlides(id));
    }
}
