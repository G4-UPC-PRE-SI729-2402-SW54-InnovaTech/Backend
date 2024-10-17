package pe.upc.connexbackend.users.domain.services;

import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.domain.model.queries.GetAllUsersQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetUserByEmailQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {

    Optional<User> handle(GetUserByEmailQuery query);

    Optional<User> handle(GetUserByIdQuery query);

    List<User> handle(GetAllUsersQuery query);
}
