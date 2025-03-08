package nl.ba99.narrowcaster.services.custom;

import nl.ba99.narrowcaster.dto.NoIdEntityDto;
import nl.ba99.narrowcaster.models.NoIdEntity;
import nl.ba99.narrowcaster.repositories.NoIdEntityRepository;
import nl.ba99.narrowcaster.services.LogService;
import nl.ba99.narrowcaster.services.logic.AbstractAPIService;
import nl.ba99.narrowcaster.transformers.MappingUtility;

public class NoIdDtoService extends AbstractAPIService<NoIdEntityRepository, NoIdEntityDto, NoIdEntity> {
    public NoIdDtoService(NoIdEntityRepository repo, MappingUtility mapper, LogService logService) {
        super(repo, mapper, NoIdEntityDto.class, NoIdEntity.class, logService);
    }
}