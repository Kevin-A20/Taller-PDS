package co.com.poli.servicebookings.service;

import co.com.poli.servicebookings.client.ShowtimesidClient;
import co.com.poli.servicebookings.client.MoviesClient;
import co.com.poli.servicebookings.client.UsersClient;
import co.com.poli.servicebookings.entities.Bookings;
import co.com.poli.servicebookings.entities.BookingsItem;
import co.com.poli.servicebookings.model.Movies;
import co.com.poli.servicebookings.model.Showtimes;
import co.com.poli.servicebookings.model.Users;
import co.com.poli.servicebookings.repository.BookingsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingsService {

    private final BookingsRepository bookingsRepository;
    private final UsersClient usersClient ;
    private final MoviesClient moviesClient;

    @Override
    public void save(Bookings bookings) {
        bookingsRepository.save(bookings);
    }

    @Override
    public void delete(Bookings bookings) {
        bookingsRepository.delete(bookings);
    }

    @Override
    public List<Bookings> findAll() {
        return bookingsRepository.findAll();
    }

    @Override
    public Bookings findById(Long id) {
        return bookingsRepository.findById(id).orElse(null);
    }

    @Override
    public Bookings findByAllBookings(String id) {
        Bookings bookings = bookingsRepository.findByAllBookings(id);
        ModelMapper modelMapper = new ModelMapper();
        Users users = modelMapper.
                map(usersClient.findById(bookings.getUserid()).getData(), Users.class);
        bookings.setUsers(users);
        List<BookingsItem> itemsList = bookings.getItems().stream()
                .map(bookingsItem -> {
                    Movies movies = modelMapper.map(moviesClient.findById(bookingsItem.getMovies_id()).getData(), Movies.class);
                    bookingsItem.setMovies(movies);
                    return bookingsItem;
                }).collect(Collectors.toList());
        return bookingsRepository.findByAllBookings(id);
    }
}
