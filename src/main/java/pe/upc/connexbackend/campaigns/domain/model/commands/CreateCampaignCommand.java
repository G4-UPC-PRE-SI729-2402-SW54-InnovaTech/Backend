package pe.upc.connexbackend.campaigns.domain.model.commands;

import pe.upc.connexbackend.campaigns.domain.model.valueobjects.Status;

import java.time.LocalDate;

public record CreateCampaignCommand(
        String title,
        String description,
        Status status,
        Integer creatorId,
        LocalDate startDate,
        LocalDate endDate
) {
    public CreateCampaignCommand {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description is required");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status is required");
        }
        if (creatorId == null) {
            throw new IllegalArgumentException("Creator ID is required");
        }
        if (startDate == null) {
            throw new IllegalArgumentException("Start date is required");
        }
        if (endDate == null) {
            throw new IllegalArgumentException("End date is required");
        }
    }
}
