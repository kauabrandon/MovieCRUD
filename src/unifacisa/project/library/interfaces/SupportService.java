package unifacisa.project.library.interfaces;

import unifacisa.project.library.enums.SupportStatus;
import unifacisa.project.library.model.Support;

import java.util.List;

public interface SupportService extends CrudService<Support> {

    void startHandling(Long supportId);

    void resolve(Long supportId);

    void close(Long supportId);

    List<Support> findByStatus(SupportStatus status);
}
