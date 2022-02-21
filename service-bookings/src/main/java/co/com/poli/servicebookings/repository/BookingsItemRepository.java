package co.com.poli.servicebookings.repository;

import co.com.poli.servicebookings.entities.BookingsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsItemRepository extends JpaRepository<BookingsItem,Long> {
}
