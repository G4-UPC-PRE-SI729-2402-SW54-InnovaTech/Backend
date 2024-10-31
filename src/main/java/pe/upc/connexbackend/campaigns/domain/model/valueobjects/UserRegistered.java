package pe.upc.connexbackend.campaigns.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import pe.upc.connexbackend.users.domain.model.valueobjects.UserType;

@Getter
@Setter
@Embeddable
public class UserRegistered {
    private Integer userId;
    private String name;
    private String email;
    private UserType userType;

    public UserRegistered() {
    }

    public UserRegistered(Integer userId, String name, String email, UserType userType) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.userType = userType;
    }
}
