package pe.upc.connexbackend.campaigns.domain.model.queries;

import java.time.LocalDate;

public record GetCampaignsByDateRangeQuery(LocalDate startDate, LocalDate endDate) {
    public GetCampaignsByDateRangeQuery {
        if (startDate == null) {
            throw new IllegalArgumentException("Start date is required");
        }
        if (endDate == null) {
            throw new IllegalArgumentException("End date is required");
        }
    }
}