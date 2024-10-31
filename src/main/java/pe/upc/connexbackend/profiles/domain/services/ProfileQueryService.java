package pe.upc.connexbackend.profiles.domain.services;

import pe.upc.connexbackend.profiles.domain.model.aggregates.Profile;
import pe.upc.connexbackend.profiles.domain.model.queries.GetAllProfilesQuery;
import pe.upc.connexbackend.profiles.domain.model.queries.GetProfileByIdQuery;
import pe.upc.connexbackend.profiles.domain.model.queries.GetProfilesByCityQuery;
import pe.upc.connexbackend.profiles.domain.model.queries.GetProfilesByCountryQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByIdQuery query);
    List<Profile> handle(GetAllProfilesQuery query);
    List<Profile> handle(GetProfilesByCityQuery query);
    List<Profile> handle(GetProfilesByCountryQuery query);
}
