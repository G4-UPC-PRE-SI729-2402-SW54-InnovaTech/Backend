package pe.upc.connexbackend.profiles.infraestructure.persistance.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.connexbackend.profiles.domain.model.aggregates.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    List<Profile> findByLocation_City(String city);
    List<Profile> findByLocation_Country(String country);
    Optional<Profile> findByUserId (Integer userId);
    void deleteByUserId(Integer userId);
}