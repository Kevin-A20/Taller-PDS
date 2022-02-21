package co.com.poli.serviceshowtime.repository;

import co.com.poli.serviceshowtime.entities.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {
    Showtime findById(long id);
}
