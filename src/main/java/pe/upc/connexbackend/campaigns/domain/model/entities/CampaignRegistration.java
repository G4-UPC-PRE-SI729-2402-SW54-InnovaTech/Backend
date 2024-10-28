package pe.upc.connexbackend.campaigns.domain.model.entities;

import jakarta.persistence.*;
import pe.upc.connexbackend.campaigns.domain.model.aggregates.Campaign;
import pe.upc.connexbackend.campaigns.domain.model.valueobjects.RegistrationStatus;
import pe.upc.connexbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDateTime;

@Entity
public class CampaignRegistration extends AuditableAbstractAggregateRoot<CampaignRegistration> {
    // Attributes
    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaign;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private RegistrationStatus status = RegistrationStatus.PENDING;

    @Column(nullable = false, updatable = false)
    private LocalDateTime registrationDate = LocalDateTime.now();

    // Getters and setters
    public CampaignRegistration() {
    }

}