package nl.ba99.narrowcaster.repositories;

import nl.ba99.narrowcaster.models.NoIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoIdEntityRepository extends JpaRepository<NoIdEntity, Long> {
}
