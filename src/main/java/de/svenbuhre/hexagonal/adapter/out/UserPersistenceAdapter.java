package de.svenbuhre.hexagonal.adapter.out;

import de.svenbuhre.hexagonal.adapter.out.mapper.UserMapper;
import de.svenbuhre.hexagonal.adapter.out.repository.UserJpaRepository;
import de.svenbuhre.hexagonal.application.domain.model.User;
import de.svenbuhre.hexagonal.application.port.out.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public List<User> findAll() {
        var entities = userJpaRepository.findAll();
        return UserMapper.INSTANCE.mapEntityList(entities);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        var userEntity = userJpaRepository.findByUsername(username);
        if (userEntity.isEmpty()) {
            return Optional.empty();
        }
        return UserMapper.INSTANCE.mapOptionalEntity(userEntity);
    }

    @Override
    public void save(User user) {
        var userEntity = UserMapper.INSTANCE.map(user);
        userJpaRepository.save(userEntity);
    }
}

