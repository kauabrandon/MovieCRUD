package unifacisa.project.library.services;

import unifacisa.project.library.exceptions.MovieNotFoundException;
import unifacisa.project.library.interfaces.CrudService;
import unifacisa.project.library.model.Movie;
import unifacisa.project.library.repo.MovieRepository;

import java.util.List;

public class MovieService implements CrudService<Movie> {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie create(Movie entity) {
        return movieRepository.save(entity);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie update(Long id, Movie entity) {
        findById(id);
        entity.setId(id);
        return movieRepository.update(entity);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        movieRepository.deleteById(id);
    }

    public List<Movie> searchByTitle(String title) {
        return movieRepository.findByTitle(title);
    }
}
