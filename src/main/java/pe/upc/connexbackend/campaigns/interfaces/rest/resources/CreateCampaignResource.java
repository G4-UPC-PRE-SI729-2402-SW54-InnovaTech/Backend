package pe.upc.connexbackend.campaigns.interfaces.rest.resources;

import pe.upc.connexbackend.campaigns.domain.model.valueobjects.Status;

import java.time.LocalDate;

public record CreateCampaignResource(
        String title,
        String description,
        Status status,
        Integer creatorId,
        LocalDate startDate,
        LocalDate endDate
) {
}
