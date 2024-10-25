package pe.upc.connexbackend.profiles.domain.services;

import org.springframework.stereotype.Service;
import pe.upc.connexbackend.profiles.domain.model.aggregates.Profile;
import pe.upc.connexbackend.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.connexbackend.profiles.domain.model.commands.DeleteProfileCommand;
import pe.upc.connexbackend.profiles.domain.model.commands.UpdateProfileCommand;

import java.util.Optional;

@Service
public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
    Optional<Profile> handle(UpdateProfileCommand command);
    void handle(DeleteProfileCommand command);
}
