package pe.upc.connexbackend.users.application;

// Importa las anotaciones y dependencias necesarias de Spring y las clases del dominio de usuarios
import org.springframework.stereotype.Service;
import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.domain.model.queries.GetAllUsersQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetUserByEmailQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetUserByIdQuery;
import pe.upc.connexbackend.users.domain.services.UserQueryService;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

// Marca la clase como un servicio de Spring para la capa de aplicación
@Service
public class UserQueryServiceImpl implements UserQueryService {

    // Repositorio de usuarios para interactuar con la base de datos
    private final UserRepository userRepository;

    // Constructor que inyecta el repositorio de usuarios
    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Maneja la consulta para obtener un usuario por su ID
    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return this.userRepository.findById(query.id());
    }

    // Maneja la consulta para obtener un usuario por su correo electrónico
    @Override
    public Optional<User> handle(GetUserByEmailQuery query) {
        return this.userRepository.findByEmail(query.emailAddress());
    }

    // Maneja la consulta para obtener todos los usuarios
    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return this.userRepository.findAll();
    }
}
