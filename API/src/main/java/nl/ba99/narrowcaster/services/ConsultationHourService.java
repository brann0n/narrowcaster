package nl.ba99.narrowcaster.services;

import nl.ba99.narrowcaster.dto.ConsultationHourDto;
import nl.ba99.narrowcaster.models.ConsultationHour;
import nl.ba99.narrowcaster.repositories.ConsultationHourRepository;
import nl.ba99.narrowcaster.services.logic.AbstractAPIService;
import nl.ba99.narrowcaster.transformers.MappingUtility;
import org.springframework.stereotype.Service;

@Service
public class ConsultationHourService extends AbstractAPIService<ConsultationHourRepository, ConsultationHourDto, ConsultationHour> {

    public ConsultationHourService(ConsultationHourRepository repo, MappingUtility mapper, LogService logService) {
        super(repo, mapper, ConsultationHourDto.class, ConsultationHour.class, logService);
    }

}
