package unifacisa.project.library.interfaces;

import java.util.List;

public interface CrudService<T> {
    T create(T entity);

    T findById(Long id);

    List<T> findAll();

    T update(Long id, T entity);

    void delete (Long id);
}
