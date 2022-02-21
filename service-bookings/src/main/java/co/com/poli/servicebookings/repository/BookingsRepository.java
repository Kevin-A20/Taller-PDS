package co.com.poli.servicebookings.repository;


import co.com.poli.servicebookings.entities.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings,Long> {

    Bookings findByAllBookings(String id);
}
