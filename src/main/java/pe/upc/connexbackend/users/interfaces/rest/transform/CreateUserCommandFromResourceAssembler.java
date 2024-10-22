package pe.upc.connexbackend.users.interfaces.rest.transform;

import jakarta.validation.constraints.Email;
import pe.upc.connexbackend.users.domain.model.commands.CreateUserCommand;
import pe.upc.connexbackend.users.domain.model.valueobjects.UserType;
import pe.upc.connexbackend.users.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommand(CreateUserResource resource) {
        return new CreateUserCommand(
                resource.email(),
                resource.password(),
                UserType.valueOf(resource.userType())


        );
    }
}
