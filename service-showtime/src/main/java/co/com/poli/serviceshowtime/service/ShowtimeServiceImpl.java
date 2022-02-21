package co.com.poli.serviceshowtime.service;

import co.com.poli.serviceshowtime.entities.Showtime;
import co.com.poli.serviceshowtime.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Showtime showtime) {
        showtimeService.save(showtime);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Showtime showtime) {
        showtimeService.delete(showtime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Showtime> findAll() {
        return showtimeService.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Showtime findById(Long id) {
        return showtimeService.findById(id).orElse(null);
    }
}