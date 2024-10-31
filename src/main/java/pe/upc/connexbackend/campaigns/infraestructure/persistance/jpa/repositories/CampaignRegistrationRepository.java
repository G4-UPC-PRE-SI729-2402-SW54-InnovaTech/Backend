package pe.upc.connexbackend.campaigns.infraestructure.persistance.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.connexbackend.campaigns.domain.model.entities.CampaignRegistration;

import java.util.List;
import java.util.Optional;

public interface CampaignRegistrationRepository extends JpaRepository<CampaignRegistration, Integer> {
    Optional<CampaignRegistration> findByCampaignIdAndUser_UserId(Integer campaignId, Integer userId);
    List<CampaignRegistration> findByCampaignId(Integer campaignId);
}
