package pe.upc.connexbackend.users.domain.services;

import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.domain.model.commands.UpdateUserCommand;
import java.util.Optional;

//Interfaz que define los servicios de comandos para manejar operaciones con usuarios
public interface UserCommandService {
    //Método para actualizar un usuario
    Optional<User> handle(UpdateUserCommand command);
}
