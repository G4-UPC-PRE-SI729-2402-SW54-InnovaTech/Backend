package pe.upc.connexbackend.users.interfaces.rest.transform;

import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        return new UserResource(
                user.getEmail().address(),
                user.getPasswordHash()

        );
    }
}