package nl.ba99.narrowcaster.services;

import nl.ba99.narrowcaster.dto.AvailabilityDto;
import nl.ba99.narrowcaster.models.Availability;
import nl.ba99.narrowcaster.repositories.AvailabilityRepository;
import nl.ba99.narrowcaster.services.logic.AbstractAPIService;
import nl.ba99.narrowcaster.transformers.MappingUtility;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityService extends AbstractAPIService<AvailabilityRepository, AvailabilityDto, Availability> {
    private final UserService userService;

    public AvailabilityService(AvailabilityRepository repo, MappingUtility mapper, LogService logService, UserService userService) {
        super(repo, mapper, AvailabilityDto.class, Availability.class, logService);
        this.userService = userService;
    }

    @Override
    public long create(AvailabilityDto availabilityDto) {
        //Will throw a data not found runtime exception if screen does not exist
        userService.get(availabilityDto.getUserId());
        return super.create(availabilityDto);
    }

    @Override
    public void update(AvailabilityDto availabilityDto, long id) {
        //Will throw a data not found runtime exception if screen does not exist
        userService.get(availabilityDto.getUserId());
        super.update(availabilityDto, id);
    }
}
