package pe.upc.connexbackend.users.interfaces.rest.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserRequest {
    // Getters and setters
    private String email;
    private String passwordHash;

}
