package pe.upc.connexbackend.campaigns.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.upc.connexbackend.campaigns.domain.model.aggregates.Campaign;
import pe.upc.connexbackend.campaigns.domain.model.valueobjects.RegistrationStatus;
import pe.upc.connexbackend.campaigns.domain.model.valueobjects.UserRegistered;
import pe.upc.connexbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.upc.connexbackend.users.domain.model.aggregates.User;


@Entity
@Getter
@Setter
public class CampaignRegistration extends AuditableAbstractAggregateRoot<CampaignRegistration> {
    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false)
    @JsonBackReference
    private Campaign campaign;

    @Embedded
    private UserRegistered user;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private RegistrationStatus status = RegistrationStatus.PENDING;

    public CampaignRegistration() {
    }
}