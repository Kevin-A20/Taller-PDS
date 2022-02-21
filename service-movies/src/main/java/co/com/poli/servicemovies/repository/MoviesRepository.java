package co.com.poli.servicemovies.repository;

import co.com.poli.servicemovies.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,Long> {
    Movies findBytitle(String title);
}
