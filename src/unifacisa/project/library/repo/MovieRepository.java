package unifacisa.project.library.repo;

import unifacisa.project.library.interfaces.Repository;
import unifacisa.project.library.model.Movie;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MovieRepository implements Repository<Movie> {
    private final Map<Long, Movie> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Movie save(Movie entity) {
        if (entity.getId() == null) {
            entity.setId(idGenerator.getAndIncrement());
        }
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<Movie> findById(long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Movie> findAll() {
        return List.copyOf(storage.values());
    }

    @Override
    public Movie update(Movie entity) {
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    public List<Movie> findByTitle(String title) {
        return storage.values().stream().filter(movie -> movie.getTitle().toLowerCase().contains(title.toLowerCase())).toList();
    }
}
