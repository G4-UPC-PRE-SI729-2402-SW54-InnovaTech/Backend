package pe.upc.connexbackend.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Location(String city, String country) {
    public Location() {
        this(null, null);
    }

    public Location {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City is required");
        }
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country is required");
        }
    }
}
