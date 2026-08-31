package unifacisa.project.library.repo;

import unifacisa.project.library.interfaces.Repository;
import unifacisa.project.library.model.Loan;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class LoanRepository implements Repository<Loan> {
    private final Map<Long, Loan> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Loan save(Loan entity) {
        if(entity.getId() == null) {
            entity.setId((idGenerator.getAndIncrement()));
        }
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<Loan> findById(long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Loan> findAll() {
        return List.copyOf(storage.values());
    }

    @Override
    public Loan update(Loan entity) {
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    public List<Loan> findByUserId(Long userId) {
        return storage.values().stream().filter(loan -> loan.getUser().getId().equals(userId)).toList();
    }

    public List<Loan> findActiveLoans() {
        return storage.values().stream().filter(loan -> !loan.isReturned()).toList();
    }
}
