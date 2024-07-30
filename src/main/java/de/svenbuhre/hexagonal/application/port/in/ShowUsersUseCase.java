package de.svenbuhre.hexagonal.application.port.in;

import de.svenbuhre.hexagonal.application.domain.model.User;
import java.util.List;

public interface ShowUsersUseCase {

    List<User> showUsers();
}
