package pe.upc.connexbackend.users.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.domain.model.commands.CreateUserCommand;
import pe.upc.connexbackend.users.domain.model.commands.DeleteUserCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateUserCommand;
import pe.upc.connexbackend.users.domain.model.valueobjects.EmailAddress;
import pe.upc.connexbackend.users.domain.services.UserCommandService;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User handle(CreateUserCommand command) {

        var emailAddress= new EmailAddress(command.email());
        userRepository.findByEmail(emailAddress).map(user -> {
            throw new RuntimeException("User already exists");
        });

        var user = new User(command.email(), command.passwordHash(), command.userType());
        var createdUser= userRepository.save(user);

        return Optional.of(createdUser).orElseThrow(() -> new RuntimeException("User not created"));
    }

    @Override
    public void handle(DeleteUserCommand command) {
        var user = userRepository.findById(command.id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public User handle(UpdateUserCommand command) {
        User user = userRepository.findById(command.id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setEmail(new EmailAddress(command.email()));
        user.setPasswordHash(command.passwordHash());
        user.setUserType(command.userType());
        return userRepository.save(user);
    }
}