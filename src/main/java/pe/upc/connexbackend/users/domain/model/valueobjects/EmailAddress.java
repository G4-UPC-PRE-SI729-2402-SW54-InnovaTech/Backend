package pe.upc.connexbackend.users.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record EmailAddress(String address) {
    public EmailAddress(){
        this(null);
    }
    public EmailAddress{
        if (address == null || address.isBlank()){
            throw new IllegalArgumentException("Email address is required");
        }
    }

}