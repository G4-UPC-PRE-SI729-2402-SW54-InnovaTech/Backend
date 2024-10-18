package pe.upc.connexbackend.users.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.connexbackend.users.application.UserCommandServiceImpl;
import pe.upc.connexbackend.users.application.UserQueryServiceImpl;
import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.domain.model.commands.CreateUserCommand;
import pe.upc.connexbackend.users.domain.model.commands.DeleteUserCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateUserCommand;
import pe.upc.connexbackend.users.domain.model.queries.GetAllUsersQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetUserByEmailQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetUserByIdQuery;
import pe.upc.connexbackend.users.domain.model.valueobjects.EmailAddress;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserCommandServiceImpl userCommandService;

    @Autowired
    private UserQueryServiceImpl userQueryService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserCommand command) {
        User user = userCommandService.handle(command);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userCommandService.handle(new DeleteUserCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody UpdateUserCommand command) {
        User user = userCommandService.handle(new UpdateUserCommand(id, command.email(), command.passwordHash(), command.userType()));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userQueryService.handle(new GetUserByIdQuery(id));
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        EmailAddress emailAddress = new EmailAddress(email);
        Optional<User> user = userQueryService.handle(new GetUserByEmailQuery(emailAddress));
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userQueryService.handle(new GetAllUsersQuery());
        return ResponseEntity.ok(users);
    }
}