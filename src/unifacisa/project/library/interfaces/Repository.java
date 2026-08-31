package unifacisa.project.library.interfaces;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    T save(T entity);

    Optional<T> findById(long id);

    List<T> findAll();

    T update(T entity);

    void deleteById(Long id);
}
