package co.com.poli.servicebookings.service;

import co.com.poli.servicebookings.entities.Bookings;

import java.util.List;

public interface BookingsService {

    void save(Bookings bookings);
    void delete(Bookings bookings);
    List<Bookings> findAll();
    Bookings findById(Long id);
    Bookings findByAllBookings(String id);

}
