package pe.upc.connexbackend.campaigns.infraestructure.persistance.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.connexbackend.campaigns.domain.model.aggregates.Campaign;

import java.time.LocalDate;
import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

    @Query("SELECT c FROM Campaign c WHERE c.startDate >= :startDate AND c.endDate <= :endDate")
    List<Campaign> findByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
