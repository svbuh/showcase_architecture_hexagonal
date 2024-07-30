package de.svenbuhre.hexagonal.adapter.in;

import de.svenbuhre.hexagonal.adapter.in.api.UsersApi;
import de.svenbuhre.hexagonal.adapter.in.mapper.UserMapper;
import de.svenbuhre.hexagonal.adapter.in.models.UserDto;
import de.svenbuhre.hexagonal.application.domain.service.UsersService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {

    private final UsersService usersService;
    @Override
    public ResponseEntity<List<UserDto>> listUsers() {
        var users = usersService.showUsers();

        return ResponseEntity.ok(UserMapper.INSTANCE.mapList(users));
    }
}

