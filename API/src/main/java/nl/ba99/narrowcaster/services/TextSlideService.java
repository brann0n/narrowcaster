package nl.ba99.narrowcaster.services;

import nl.ba99.narrowcaster.dto.TextSlideDto;
import nl.ba99.narrowcaster.models.TextSlide;
import nl.ba99.narrowcaster.repositories.TextSlideRepository;
import nl.ba99.narrowcaster.services.logic.AbstractAPIService;
import nl.ba99.narrowcaster.transformers.MappingUtility;
import org.springframework.stereotype.Service;

@Service
public class TextSlideService extends AbstractAPIService<TextSlideRepository, TextSlideDto, TextSlide> {
    private final SlideshowService slideshowService;

    public TextSlideService(TextSlideRepository repo, MappingUtility mapper, LogService logService, SlideshowService slideshowService) {
        super(repo, mapper, TextSlideDto.class, TextSlide.class, logService);
        this.slideshowService = slideshowService;
    }

    @Override
    public long create(TextSlideDto textSlideDto) {
        //Will throw a data not found runtime exception if screen does not exist
        slideshowService.get(textSlideDto.getSlideshowId());
        return super.create(textSlideDto);
    }

    @Override
    public void update(TextSlideDto textSlideDto, long id) {
        //Will throw a data not found runtime exception if screen does not exist
        slideshowService.get(textSlideDto.getSlideshowId());
        super.update(textSlideDto, id);
    }
}
