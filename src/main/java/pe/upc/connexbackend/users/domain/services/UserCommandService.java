package pe.upc.connexbackend.users.domain.services;

import pe.upc.connexbackend.users.domain.model.commands.CreateUserCommand;
import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.domain.model.commands.DeleteUserCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateUserCommand;

public interface UserCommandService {
    User handle(CreateUserCommand command);
    User handle(DeleteUserCommand command);
    User handle(UpdateUserCommand command);
}
