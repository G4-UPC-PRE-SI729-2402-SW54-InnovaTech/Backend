package pe.upc.connexbackend.campaigns.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.upc.connexbackend.campaigns.domain.model.entities.CampaignRegistration;
import pe.upc.connexbackend.campaigns.domain.model.valueobjects.Status;
import pe.upc.connexbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.upc.connexbackend.users.domain.model.aggregates.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Campaign extends AuditableAbstractAggregateRoot<Campaign> {
    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "id", nullable = false)
    private User creator;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Status status = Status.OPEN;

    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CampaignRegistration> registrations = new ArrayList<>();

    public Campaign() {
    }
}