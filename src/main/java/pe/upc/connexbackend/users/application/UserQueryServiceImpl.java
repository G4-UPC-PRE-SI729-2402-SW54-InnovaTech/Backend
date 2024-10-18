package pe.upc.connexbackend.users.application;

import org.springframework.stereotype.Service;
import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.domain.model.queries.GetAllUsersQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetUserByEmailQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetUserByIdQuery;
import pe.upc.connexbackend.users.domain.services.UserQueryService;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return this.userRepository.findById(query.id());
    }

    @Override
    public Optional<User> handle(GetUserByEmailQuery query) {
        return this.userRepository.findByEmail(query.emailAddress());
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return this.userRepository.findAll();
    }
}