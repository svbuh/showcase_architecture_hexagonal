package de.svenbuhre.hexagonal.adapter.out.mapper;

import de.svenbuhre.hexagonal.adapter.out.entity.UserEntity;
import de.svenbuhre.hexagonal.application.domain.model.User;
import java.util.List;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity map(User user);
    User mapEntity(UserEntity userEntity);
    List<User> mapEntityList(List<UserEntity> userEntity);

    default <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElseThrow();
    }

    default <T> Optional<T> wrapToOptional(T object) {
        return Optional.of(object);
    }

    default Optional<User> mapOptionalEntity(Optional<UserEntity> userEntity) {
        var entity = unwrapOptional(userEntity);
        return wrapToOptional(mapEntity(entity));
    }
}
