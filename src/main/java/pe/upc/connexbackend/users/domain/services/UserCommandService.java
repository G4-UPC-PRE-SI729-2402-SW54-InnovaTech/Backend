package pe.upc.connexbackend.users.domain.services;

import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.domain.model.commands.UpdateUserCommand;
import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(UpdateUserCommand command);
}
