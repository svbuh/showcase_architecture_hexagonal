package de.svenbuhre.hexagonal.adapter.in.mapper;

import de.svenbuhre.hexagonal.adapter.in.models.UserDto;
import de.svenbuhre.hexagonal.application.domain.model.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto map(User user);

    List<UserDto> mapList(List<User> user);
}
