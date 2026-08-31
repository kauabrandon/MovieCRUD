package unifacisa.project.library.services;

import unifacisa.project.library.enums.SupportStatus;
import unifacisa.project.library.exceptions.TicketNotFoundException;
import unifacisa.project.library.model.Support;
import unifacisa.project.library.repo.SupportRepository;

import java.util.List;

public class SupportService implements unifacisa.project.library.interfaces.SupportService {
    private final SupportRepository supportRepository;

    public SupportService(SupportRepository supportRepository) {
        this.supportRepository = supportRepository;
    }

    @Override
    public void startHandling(Long supportId) {
        Support support = findById(supportId);
        support.startHandling();
        supportRepository.update(support);
    }

    @Override
    public void resolve(Long supportId) {
        Support support = findById(supportId);
        support.resolve();
        supportRepository.update(support);
    }

    @Override
    public void close(Long supportId) {
        Support support = findById(supportId);
        support.close();
        supportRepository.update(support);
    }

    @Override
    public List<Support> findByStatus(SupportStatus status) {
        return supportRepository.findByStatus(status);
    }

    @Override
    public Support create(Support entity) {
        return supportRepository.save(entity);
    }

    @Override
    public Support findById(Long id) {
        return supportRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
    }

    @Override
    public List<Support> findAll() {
        return supportRepository.findAll();
    }

    @Override
    public Support update(Long id, Support entity) {
        findById(id);
        entity.setId(id);
        return supportRepository.update(entity);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        supportRepository.deleteById(id);
    }
}
