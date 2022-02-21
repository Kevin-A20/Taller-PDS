package co.com.poli.serviceshowtime.service;

import co.com.poli.serviceshowtime.entities.Showtime;

import java.util.List;

public interface ShowtimeService {

    void save(Showtime showtime);
    void delete(Showtime showtime);
    List<Showtime> findAll();
    Showtime findById(Long id);
}
