package de.svenbuhre.hexagonal.application.domain.service;

import de.svenbuhre.hexagonal.application.domain.model.User;
import de.svenbuhre.hexagonal.application.port.in.ShowUsersUseCase;
import de.svenbuhre.hexagonal.application.port.out.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsersService implements ShowUsersUseCase {

    private final UserRepository userRepository;

    @Override
    public List<User> showUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserByName(String userName) {
        return userRepository.findByUsername(userName);
    }
}
