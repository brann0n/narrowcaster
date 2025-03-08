package nl.ba99.narrowcaster.services.custom;

import nl.ba99.narrowcaster.dto.TestEntityDto;
import nl.ba99.narrowcaster.models.TestEntity;
import nl.ba99.narrowcaster.repositories.TestEntityRepository;
import nl.ba99.narrowcaster.services.LogService;
import nl.ba99.narrowcaster.services.logic.AbstractAPIService;
import nl.ba99.narrowcaster.transformers.MappingUtility;
import org.springframework.stereotype.Service;

@Service
public class TestEntityService extends AbstractAPIService<TestEntityRepository, TestEntityDto, TestEntity> {
    public TestEntityService(TestEntityRepository repo, MappingUtility mapper, LogService logService) {
        super(repo, mapper, TestEntityDto.class, TestEntity.class, logService);
    }
}
