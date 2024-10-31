package pe.upc.connexbackend.users.domain.services;

import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.domain.model.queries.GetAllUsersQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetUserByEmailQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

//Interfaz para servicios de consultas sobre usuarios

public interface UserQueryService {

    //Obtiene todos los usuarios por su correo electrónico
    Optional<User> handle(GetUserByEmailQuery query);

    //Obtiene todos los usuarios mediante el ID
    Optional<User> handle(GetUserByIdQuery query);

    //Obtiene todos los usuarios
    List<User> handle(GetAllUsersQuery query);
}
