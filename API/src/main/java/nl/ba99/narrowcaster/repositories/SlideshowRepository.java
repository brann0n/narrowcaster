package nl.ba99.narrowcaster.repositories;

import nl.ba99.narrowcaster.models.Slideshow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlideshowRepository extends JpaRepository<Slideshow, Long> {
    List<Slideshow> findSlideshowsByScreenName(String screenName);
}
