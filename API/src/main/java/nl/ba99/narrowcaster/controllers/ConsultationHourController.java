package nl.ba99.narrowcaster.controllers;

import nl.ba99.narrowcaster.controllers.logic.AbstractAPIController;
import nl.ba99.narrowcaster.dto.ConsultationHourDto;
import nl.ba99.narrowcaster.services.ConsultationHourService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Consultation Hour Controller")
@RestController
@RequestMapping("consultation_hours")
public class ConsultationHourController extends AbstractAPIController<ConsultationHourService, ConsultationHourDto> {

    public ConsultationHourController(ConsultationHourService service) {
        super(service);
    }
}
