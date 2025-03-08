package nl.ba99.narrowcaster.services;

import nl.ba99.narrowcaster.dto.MediaSlideDto;
import nl.ba99.narrowcaster.models.MediaSlide;
import nl.ba99.narrowcaster.repositories.MediaSlideRepository;
import nl.ba99.narrowcaster.services.logic.AbstractAPIService;
import nl.ba99.narrowcaster.transformers.MappingUtility;
import org.springframework.stereotype.Service;

@Service
public class MediaSlideService extends AbstractAPIService<MediaSlideRepository, MediaSlideDto, MediaSlide> {

    private final SlideshowService slideshowService;

    public MediaSlideService(MediaSlideRepository repo, MappingUtility mapper, LogService logService, SlideshowService slideshowService) {
        super(repo, mapper, MediaSlideDto.class, MediaSlide.class, logService);
        this.slideshowService = slideshowService;
    }

    @Override
    public long create(MediaSlideDto mediaSlideDto) {
        //Will throw a data not found runtime exception if screen does not exist
        slideshowService.get(mediaSlideDto.getSlideshowId());
        return super.create(mediaSlideDto);
    }

    @Override
    public void update(MediaSlideDto mediaSlideDto, long id) {
        //Will throw a data not found runtime exception if screen does not exist
        slideshowService.get(mediaSlideDto.getSlideshowId());
        super.update(mediaSlideDto, id);
    }
}
