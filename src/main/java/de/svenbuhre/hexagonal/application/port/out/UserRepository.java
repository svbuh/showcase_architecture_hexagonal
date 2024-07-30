package de.svenbuhre.hexagonal.application.port.out;

import de.svenbuhre.hexagonal.application.domain.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    Optional<User> findByUsername(String username);

    void save(User owner);
}
