package nl.ba99.narrowcaster.controllers;

import nl.ba99.narrowcaster.controllers.logic.AbstractAPIController;
import nl.ba99.narrowcaster.dto.AvailabilityDto;
import nl.ba99.narrowcaster.services.AvailabilityService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Availability Controller", protocols = "GET,PUT,POST,DELETE", consumes = "application/json", produces = "application/json")
@RestController
@RequestMapping("availabilities")
public class AvailabilityController extends AbstractAPIController<AvailabilityService, AvailabilityDto> {
    public AvailabilityController(AvailabilityService service) {
        super(service);
    }
}
