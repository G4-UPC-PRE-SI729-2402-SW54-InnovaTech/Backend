package pe.upc.connexbackend.campaigns.interfaces.rest.resources;

import pe.upc.connexbackend.campaigns.domain.model.valueobjects.Status;

import java.time.LocalDate;

public record CampaignResource (
        Integer id,
        String title,
        String description,
        Integer creatorId,
        Status status,
        LocalDate startDate,
        LocalDate endDate
) {
}
