package nl.ba99.narrowcaster.services;

import nl.ba99.narrowcaster.dto.SlideshowVariableDto;
import nl.ba99.narrowcaster.models.SlideshowVariable;
import nl.ba99.narrowcaster.repositories.SlideshowVariableRepository;
import nl.ba99.narrowcaster.services.logic.AbstractAPIService;
import nl.ba99.narrowcaster.transformers.MappingUtility;
import org.springframework.stereotype.Service;

@Service
public class SlideshowVariableService extends AbstractAPIService<SlideshowVariableRepository, SlideshowVariableDto, SlideshowVariable> {
    private final SlideshowService slideshowService;

    public SlideshowVariableService(SlideshowVariableRepository repo, MappingUtility mapper, LogService logService, SlideshowService slideshowService) {
        super(repo, mapper, SlideshowVariableDto.class, SlideshowVariable.class, logService);
        this.slideshowService = slideshowService;
    }

    @Override
    public long create(SlideshowVariableDto slideshowVariableDto) {
        //Will throw a data not found runtime exception if screen does not exist
        slideshowService.get(slideshowVariableDto.getSlideshowId());
        return super.create(slideshowVariableDto);
    }

    @Override
    public void update(SlideshowVariableDto slideshowVariableDto, long id) {
        //Will throw a data not found runtime exception if screen does not exist
        slideshowService.get(slideshowVariableDto.getSlideshowId());
        super.update(slideshowVariableDto, id);
    }
}
