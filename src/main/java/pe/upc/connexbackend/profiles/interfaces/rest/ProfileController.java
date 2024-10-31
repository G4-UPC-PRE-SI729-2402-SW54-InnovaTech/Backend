package pe.upc.connexbackend.profiles.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.connexbackend.profiles.domain.model.aggregates.Profile;
import pe.upc.connexbackend.profiles.domain.model.commands.DeleteProfileCommand;
import pe.upc.connexbackend.profiles.domain.model.commands.UpdateProfileCommand;
import pe.upc.connexbackend.profiles.domain.model.queries.GetAllProfilesQuery;
import pe.upc.connexbackend.profiles.domain.model.queries.GetProfileByIdQuery;
import pe.upc.connexbackend.profiles.domain.model.queries.GetProfilesByCityQuery;
import pe.upc.connexbackend.profiles.domain.model.queries.GetProfilesByCountryQuery;
import pe.upc.connexbackend.profiles.domain.services.ProfileCommandService;
import pe.upc.connexbackend.profiles.domain.services.ProfileQueryService;
import pe.upc.connexbackend.profiles.interfaces.rest.resources.CreateProfileResource;
import pe.upc.connexbackend.profiles.interfaces.rest.resources.ProfileResource;
import pe.upc.connexbackend.profiles.interfaces.rest.resources.UpdateProfileResource;
import pe.upc.connexbackend.profiles.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import pe.upc.connexbackend.profiles.interfaces.rest.transform.ProfileResourceFromEntityAssembler;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/profiles")
@Tag(name = "Profiles", description = "Profile Management Endpoints")
public class ProfileController {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfileController(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    @PostMapping
    public ResponseEntity<ProfileResource> createProfile(@RequestBody CreateProfileResource resource) {
        var createProfileCommand = CreateProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        var profile = profileCommandService.handle(createProfileCommand);
        if (profile.isEmpty()) return ResponseEntity.badRequest().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());

        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Integer userId, @RequestBody UpdateProfileResource resource) {
        Optional<Profile> profile = profileCommandService.handle(new UpdateProfileCommand(
                userId,
                resource.bio(),
                resource.brandName(),
                resource.profilePictureUrl(),
                resource.city(),
                resource.country()));
        if (profile.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(profile.get());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Integer userId) {
        profileCommandService.handle(new DeleteProfileCommand(userId));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileQueryService.handle(new GetAllProfilesQuery());
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Integer userId) {
        Optional<Profile> profile = profileQueryService.handle(new GetProfileByIdQuery(userId));
        return profile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Profile>> getProfileByCity(@PathVariable String city) {
        List<Profile> profiles = profileQueryService.handle(new GetProfilesByCityQuery(city));
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Profile>> getProfileByCountry(@PathVariable String country) {
        List<Profile> profiles = profileQueryService.handle(new GetProfilesByCountryQuery(country));
        return ResponseEntity.ok(profiles);
    }




}
