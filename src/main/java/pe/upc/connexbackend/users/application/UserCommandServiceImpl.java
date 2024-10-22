package pe.upc.connexbackend.users.application;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.domain.model.commands.UpdateUserCommand;
import pe.upc.connexbackend.users.domain.model.valueobjects.EmailAddress;
import pe.upc.connexbackend.users.domain.services.UserCommandService;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Optional<User> handle(UpdateUserCommand command) {
        User user = userRepository.findById(command.id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setEmail(new EmailAddress(command.email()));
        user.setPasswordHash(command.passwordHash());
        user.setUserType(command.userType());
        return Optional.of(userRepository.save(user));
    }
}