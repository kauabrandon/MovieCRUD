package unifacisa.project.library.services;

import unifacisa.project.library.exceptions.UserNotFoundException;
import unifacisa.project.library.interfaces.CrudService;
import unifacisa.project.library.model.User;
import unifacisa.project.library.repo.UserRepository;

import java.util.List;

public class UserService implements CrudService<User> {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, User entity) {
        findById(id);
        entity.setId(id);
        return userRepository.update(entity);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
