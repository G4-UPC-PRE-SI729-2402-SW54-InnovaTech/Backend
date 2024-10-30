package pe.upc.connexbackend.profiles.application;

import org.springframework.stereotype.Service;
import pe.upc.connexbackend.profiles.domain.model.aggregates.Profile;
import pe.upc.connexbackend.profiles.domain.model.queries.GetAllProfilesQuery;
import pe.upc.connexbackend.profiles.domain.model.queries.GetProfileByIdQuery;
import pe.upc.connexbackend.profiles.domain.model.queries.GetProfilesByCityQuery;
import pe.upc.connexbackend.profiles.domain.model.queries.GetProfilesByCountryQuery;
import pe.upc.connexbackend.profiles.domain.services.ProfileQueryService;
import pe.upc.connexbackend.profiles.infraestructure.persistance.jpa.repositories.ProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findByUserId(query.userId());
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }

    @Override
    public List<Profile> handle(GetProfilesByCityQuery query) {
        return profileRepository.findByLocation_City(query.city());
    }

    @Override
    public List<Profile> handle(GetProfilesByCountryQuery query) {
        return profileRepository.findByLocation_Country(query.country());
    }

}
