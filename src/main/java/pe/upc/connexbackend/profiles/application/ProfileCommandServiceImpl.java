package pe.upc.connexbackend.profiles.application;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pe.upc.connexbackend.profiles.domain.model.aggregates.Profile;
import pe.upc.connexbackend.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.connexbackend.profiles.domain.model.commands.DeleteProfileCommand;
import pe.upc.connexbackend.profiles.domain.model.commands.UpdateProfileCommand;
import pe.upc.connexbackend.profiles.domain.model.valueobjects.Location;
import pe.upc.connexbackend.profiles.domain.services.ProfileCommandService;
import pe.upc.connexbackend.profiles.infraestructure.persistance.jpa.repositories.ProfileRepository;

import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.UserRepository;


import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Optional<Profile> handle(CreateProfileCommand command) {
        var location = new Location(command.city(), command.country());
        var user = userRepository.findById(command.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        var profile = new Profile();
        profile.setUser(user);
        profile.setBio(command.bio());
        profile.setBrandName(command.brandName());
        profile.setProfilePictureUrl(command.profilePictureUrl());
        profile.setLocation(location);

        var createdProfile = profileRepository.save(profile);
        return Optional.of(createdProfile);
    }

    @Override
    @Transactional
    public Optional<Profile> handle(UpdateProfileCommand command) {
        var profile = profileRepository.findByUserId(command.userId())
                .orElseThrow(() -> new IllegalArgumentException("Profile not found"));

        var location = new Location(command.city(), command.country());
        profile.setBio(command.bio());
        profile.setBrandName(command.brandName());
        profile.setProfilePictureUrl(command.profilePictureUrl());
        profile.setLocation(location);

        var updatedProfile = profileRepository.save(profile);
        return Optional.of(updatedProfile);
    }

    @Override
    @Transactional
    public void handle(DeleteProfileCommand command) {
        profileRepository.deleteByUserId(command.userId());
    }
}
