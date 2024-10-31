package pe.upc.connexbackend.campaigns.application;

import org.springframework.stereotype.Service;
import pe.upc.connexbackend.campaigns.domain.model.aggregates.Campaign;
import pe.upc.connexbackend.campaigns.domain.model.entities.CampaignRegistration;
import pe.upc.connexbackend.campaigns.domain.model.queries.GetAllCampaignsQuery;
import pe.upc.connexbackend.campaigns.domain.model.queries.GetCampaignsByDateRangeQuery;
import pe.upc.connexbackend.campaigns.domain.model.queries.GetRegistrationsByCampaignIdQuery;
import pe.upc.connexbackend.campaigns.domain.services.CampaignQueryService;
import pe.upc.connexbackend.campaigns.infraestructure.persistance.jpa.repositories.CampaignRegistrationRepository;
import pe.upc.connexbackend.campaigns.infraestructure.persistance.jpa.repositories.CampaignRepository;

import java.util.List;

@Service
public class CampaignQueryServiceImpl implements CampaignQueryService {
    private final CampaignRepository campaignRepository;
    private final CampaignRegistrationRepository campaignRegistrationRepository;

    public CampaignQueryServiceImpl(CampaignRepository campaignRepository, CampaignRegistrationRepository campaignRegistrationRepository) {
        this.campaignRepository = campaignRepository;
        this.campaignRegistrationRepository = campaignRegistrationRepository;
    }

    @Override
    public List<Campaign> handle(GetAllCampaignsQuery query) {
        return campaignRepository.findAll();
    }

    @Override
    public List<Campaign> handle(GetCampaignsByDateRangeQuery query) {
        return campaignRepository.findByDateRange(query.startDate(), query.endDate());
    }

    @Override
    public List<CampaignRegistration> handle(GetRegistrationsByCampaignIdQuery query) {
        if (!campaignRepository.existsById(query.campaignId())) {
            throw new RuntimeException("Campaign not found");
        }
        return campaignRegistrationRepository.findByCampaignId(query.campaignId());
    }
}
