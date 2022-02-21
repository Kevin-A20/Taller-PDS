package co.com.poli.servicemovies.service;

import co.com.poli.servicemovies.entities.Movies;
import co.com.poli.servicemovies.repository.MoviesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesServiceImpl implements MoviesService {

    private final MoviesRepository moviesRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Movies movies) {
        moviesRepository.save(movies);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Movies movies) {
        moviesRepository.delete(movies);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movies> findAll() {
        return moviesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Movies findById(Long id) {
        return moviesRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Movies findBytitle(String title) {
        return moviesRepository.findBytitle(title);
    }
}
