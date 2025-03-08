package nl.ba99.narrowcaster.services;

import nl.ba99.narrowcaster.dto.AvailabilityDto;
import nl.ba99.narrowcaster.dto.UserDto;
import nl.ba99.narrowcaster.exception.DataNotFoundException;
import nl.ba99.narrowcaster.models.Availability;
import nl.ba99.narrowcaster.repositories.AvailabilityRepository;
import nl.ba99.narrowcaster.transformers.MappingUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class AvailabilityServiceTest {
    @Mock
    private UserService userServiceMock;

    @Mock
    private AvailabilityRepository repository;

    @Mock
    private MappingUtility mapper;

    @Mock
    private AvailabilityDto availabilityDtoMock;

    @Mock
    private UserDto userDtoMock;

    @Mock
    private Availability availabilityMock;

    @InjectMocks
    private AvailabilityService availabilityService;


    @BeforeEach
    void setup() {
        openMocks(this);

        //mocks for user service
        when(userServiceMock.get(1L)).thenReturn(userDtoMock);
        when(userServiceMock.get(999L)).thenThrow(DataNotFoundException.class);

        //mocks for the repo
        when(repository.save(any(Availability.class))).
                thenReturn(availabilityMock);
        when(repository.findById(1L)).
                thenReturn(Optional.of(availabilityMock));

        //mocks for the mapper
        when(mapper.mapObject(any(Availability.class), eq(AvailabilityDto.class))).
                thenReturn(availabilityDtoMock);
        when(mapper.mapObject(any(AvailabilityDto.class), eq(Availability.class))).
                thenReturn(availabilityMock);
    }

    @Test
    void testCreateAvailabilityWithValidUserId() {
        //User id belongs to an existing user
        when(availabilityDtoMock.getUserId()).thenReturn(1L);
        when(availabilityDtoMock.getId()).thenReturn(null);
        Long id = availabilityService.create(availabilityDtoMock);

        assertThat(id)
                .isNotNull();
        //verify that the availability got saved and mapped correctly
        verify(repository).
                save(any());
        verify(mapper).
                mapObject(availabilityDtoMock, Availability.class);
    }

    @Test
    void testCreateAvailabilityWithInvalidUserId() {
        //User id doesn't belong to an existing user
        when(availabilityDtoMock.getUserId()).thenReturn(999L);

        assertThatThrownBy(() -> availabilityService.create(availabilityDtoMock)).isInstanceOf(DataNotFoundException.class);

        //verify that the availability didn't get saved
        verify(repository, Mockito.never())
                .save(any());
    }

    @Test
    void testUpdateAvailabilityWithValidUserId() {
        //User id belongs to an existing user
        when(availabilityDtoMock.getUserId()).thenReturn(1L);

        availabilityService.update(availabilityDtoMock, 1L);

        //verify that the availability got saved and mapped correctly and compared to the right objects
        verify(repository).
                findById(anyLong());
        verify(repository).
                save(any());
        verify(userServiceMock).
                get(anyLong());
        verify(mapper).
                mapObject(availabilityDtoMock, Availability.class);
    }

    @Test
    void testUpdateAvailabilityWithInvalidUserId() {
        //User id doesn't belong to an existing user
        when(availabilityDtoMock.getUserId()).thenReturn(999L);

        assertThatThrownBy(() -> availabilityService.update(availabilityDtoMock, 1L)).isInstanceOf(DataNotFoundException.class);
        //verify that the availability got saved correctly
        verify(userServiceMock).
                get(anyLong());
        verify(repository, Mockito.never()).
                save(any());
    }
}
