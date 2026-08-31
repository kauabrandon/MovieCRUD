package unifacisa.project.library.repo;

import unifacisa.project.library.interfaces.Repository;
import unifacisa.project.library.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository implements Repository<User> {
    private final Map<Long, User> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public User save(User entity) {
        if (entity.getId() == null) {
            entity.setId(idGenerator.getAndIncrement());
        }
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<User> findAll() {
        return List.copyOf(storage.values());
    }

    @Override
    public User update(User entity) {
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    public Optional<User> findByEmail(String email) {
        return storage.values().stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst();
    }
}
