package co.com.poli.servicemovies.service;

import co.com.poli.servicemovies.entities.Movies;

import java.util.List;

public interface MoviesService {

    void save(Movies movies);
    void delete(Movies movies);
    List<Movies> findAll();
    Movies findById(Long id);
    Movies findBytitle(String title);

}
