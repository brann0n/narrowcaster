package nl.ba99.narrowcaster.it;

import nl.ba99.narrowcaster.dto.NoIdEntityDto;
import nl.ba99.narrowcaster.models.NoIdEntity;
import nl.ba99.narrowcaster.models.TestEntity;
import nl.ba99.narrowcaster.repositories.NoIdEntityRepository;
import nl.ba99.narrowcaster.repositories.TestEntityRepository;
import nl.ba99.narrowcaster.services.custom.NoIdDtoService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import nl.ba99.narrowcaster.TestApplicationContext;
import nl.ba99.narrowcaster.dto.TestEntityDto;
import nl.ba99.narrowcaster.services.custom.TestEntityService;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.nhlstenden.student.vigmo", excludeFilters = {
        //Exclude custom classes used only in unit tests
        @Filter(type = FilterType.ASSIGNABLE_TYPE,
                value = {TestEntityDto.class, TestEntity.class,
                        TestEntityService.class, TestEntityRepository.class,
                        NoIdEntityDto.class, NoIdEntity.class,
                        NoIdEntityRepository.class, NoIdDtoService.class})})
public class IntegrationTestConfig extends TestApplicationContext {

}
