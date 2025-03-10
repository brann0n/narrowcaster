package nl.ba99.narrowcaster.services;

import nl.ba99.narrowcaster.dto.ScreenDto;
import nl.ba99.narrowcaster.exception.DataNotFoundException;
import nl.ba99.narrowcaster.models.Screen;
import nl.ba99.narrowcaster.repositories.ScreenRepository;
import nl.ba99.narrowcaster.transformers.MappingUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.assertj.core.api.Assertions.assertThat;

class ScreenServiceTest {

    @Mock
    private ScreenRepository repo;

    @Mock
    private MappingUtility mapper;

    @Mock
    private Screen screenMock;

    @Mock
    private ScreenDto screenDtoMock;

    @InjectMocks
    private ScreenService screenService;

    @BeforeEach
    void setUp() {
        openMocks(this);
        when(mapper.mapObject(screenMock, ScreenDto.class)).thenReturn(screenDtoMock);
    }

    @Test
    void getScreenByAuthKey() {
        //Auth key belongs to a screen
        when(repo.findByAuthKey(anyString())).thenReturn(Optional.of(screenMock));

        assertThat(screenService.getScreenByAuthKey("abc")).isNotNull();
        //verify that the repository got checked and the screen mapped to a dto
        verify(repo).findByAuthKey(anyString());
        verify(mapper).mapObject(screenMock,ScreenDto.class);
    }

    @Test
    void getNonExistentScreenByAuthKey() {
        //Auth key does not belong to a screen
        when(repo.findByAuthKey(anyString())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> screenService.getScreenByAuthKey("abc")).isInstanceOf(DataNotFoundException.class);

        //verify that the repository got checked
        verify(repo).findByAuthKey(anyString());
    }
}