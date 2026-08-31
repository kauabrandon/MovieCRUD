package unifacisa.project.library.repo;

import unifacisa.project.library.enums.SupportStatus;
import unifacisa.project.library.interfaces.Repository;
import unifacisa.project.library.model.Movie;
import unifacisa.project.library.model.Support;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class SupportRepository implements Repository<Support> {
    private final Map<Long, Support> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Support save(Support entity) {
        if (entity.getId() == null) {
            entity.setId(idGenerator.getAndIncrement());
        }
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<Support> findById(long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Support> findAll() {
        return List.copyOf(storage.values());
    }

    @Override
    public Support update(Support entity) {
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    public List<Support> findByStatus(SupportStatus status) {
        return storage.values().stream().filter(support -> support.getStatus() == status).toList();
    }

    public List<Support> findByRequesterId(Long requesterId) {
        return storage.values().stream().filter(support -> support.getRequester().getId().equals(requesterId)).toList();
    }
}
