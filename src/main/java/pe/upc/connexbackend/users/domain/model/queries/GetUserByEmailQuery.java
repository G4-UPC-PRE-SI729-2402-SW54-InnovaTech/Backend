package pe.upc.connexbackend.users.domain.model.queries;

import pe.upc.connexbackend.users.domain.model.valueobjects.EmailAddress;

public record GetUserByEmailQuery(EmailAddress emailAddress) {
    public GetUserByEmailQuery {
        if (emailAddress == null) {
            throw new IllegalArgumentException("emailAddress is required");
        }
    }
}
