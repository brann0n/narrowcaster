package nl.ba99.narrowcaster.controllers;

import nl.ba99.narrowcaster.controllers.logic.AbstractAPIController;
import nl.ba99.narrowcaster.dto.RssItemDto;
import nl.ba99.narrowcaster.dto.RssSlideDto;
import nl.ba99.narrowcaster.services.RssSlideService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Rss Slide Controller")
@RestController
@RequestMapping("rss_slides")
public class RssSlideController extends AbstractAPIController<RssSlideService, RssSlideDto> {
    public RssSlideController(RssSlideService service) {
        super(service);
    }

    @ApiOperation(value = "Gets the latest rss item from the requested rss feed")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Invalid RssSlide id")})
    @GetMapping("/{id}/latest")
    ResponseEntity<RssItemDto> latestFeedItem(@PathVariable("id") final long id) {
        //get the current rss slide info
        RssItemDto rssSlide = service.getLatestFeedItem(id);

        return ResponseEntity.ok()
                .body(rssSlide);
    }
}
