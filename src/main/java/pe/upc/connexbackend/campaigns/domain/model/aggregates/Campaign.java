package pe.upc.connexbackend.campaigns.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.upc.connexbackend.campaigns.domain.model.entities.CampaignRegistration;
import pe.upc.connexbackend.campaigns.domain.model.valueobjects.Status;
import pe.upc.connexbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Campaign extends AuditableAbstractAggregateRoot<Campaign> {

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    private Integer creatorId;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Status status = Status.OPEN;

    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CampaignRegistration> registrations;

    public Campaign() {
    }

    // Getters and setters
}