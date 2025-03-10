package nl.ba99.narrowcaster.services;

import nl.ba99.narrowcaster.dto.MediaSlideDto;
import nl.ba99.narrowcaster.exception.DataNotFoundException;
import nl.ba99.narrowcaster.models.MediaSlide;
import nl.ba99.narrowcaster.repositories.MediaSlideRepository;
import nl.ba99.narrowcaster.transformers.MappingUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class MediaSlideServiceTest {
    @Mock
    private MediaSlideRepository repo;

    @Mock
    private MappingUtility mapper;

    @Mock
    private SlideshowService slideshowService;

    @Mock
    private MediaSlide mediaSlideMock;

    @InjectMocks
    private MediaSlideService mediaSlideServiceMock;

    @BeforeEach
    void setup() {
        openMocks(this);
        //Throw exception when trying to retrieve a non-existing slideshow
        when(slideshowService.get(999L)).thenThrow(DataNotFoundException.class);
        //mocks for the repo
        when(repo.save(any(MediaSlide.class))).
                thenReturn(mediaSlideMock);
        when(repo.findById(1L)).
                thenReturn(Optional.of(mediaSlideMock));

        //mock for the mapper
        when(mapper.mapObject(any(MediaSlideDto.class), eq(MediaSlide.class))).
                thenReturn(mediaSlideMock);

        when(mediaSlideMock.getId()).thenReturn(1L);
    }

    @Test
    void testMediaSlideCreateWithExistingSlideshow(){
        //uses a dto instead of mocked dto as using a mocked dto causes getIdFieldValue
        //from AbstractVigmoService to no longer be able to find the id field
        MediaSlideDto mediaSlideDto = new MediaSlideDto();
        //Slideshow id is of an existing slideshow
        mediaSlideDto.setSlideshowId(1L);

        assertThat(mediaSlideServiceMock.create(mediaSlideDto)).isEqualTo(1L);

        //verify media slide was saved
        verify(repo).save(mediaSlideMock);
    }

    @Test
    void testMediaSlideCreateWithNonExistingSlideshow(){
        MediaSlideDto mediaSlideDto = new MediaSlideDto();
        //Slideshow id is of a non-existing slideshow
        mediaSlideDto.setSlideshowId(999L);

        assertThatThrownBy(() -> mediaSlideServiceMock.create(mediaSlideDto)).isInstanceOf(DataNotFoundException.class);

        //verify that the object was not saved
        verify(repo, Mockito.never()).save(mediaSlideMock);
    }

    @Test
    void testMediaSlideUpdateWithExistingSlideshow(){
        MediaSlideDto mediaSlideDto = new MediaSlideDto();
        //Slideshow id is of an existing slideshow
        mediaSlideDto.setSlideshowId(1L);

        mediaSlideServiceMock.update(mediaSlideDto, 1L);

        //verify media slide was saved
        verify(repo).save(mediaSlideMock);
    }

    @Test
    void testMediaSlideUpdateWithNonExistingSlideshow(){
        MediaSlideDto mediaSlideDto = new MediaSlideDto();
        //Slideshow id is of an existing slideshow
        mediaSlideDto.setSlideshowId(999L);

        assertThatThrownBy(() -> mediaSlideServiceMock.update(mediaSlideDto, 1L)).isInstanceOf(DataNotFoundException.class);

        //verify that the save was not called
        verify(repo, Mockito.never()).save(mediaSlideMock);
    }
}
