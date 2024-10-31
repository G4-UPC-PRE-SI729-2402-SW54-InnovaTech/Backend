package pe.upc.connexbackend.campaigns.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.connexbackend.campaigns.domain.model.aggregates.Campaign;
import pe.upc.connexbackend.campaigns.domain.model.commands.AddRegistrationToCampaignCommand;
import pe.upc.connexbackend.campaigns.domain.model.commands.CreateCampaignCommand;
import pe.upc.connexbackend.campaigns.domain.model.commands.DeleteCampaignCommand;
import pe.upc.connexbackend.campaigns.domain.model.commands.UpdateCampaignCommand;
import pe.upc.connexbackend.campaigns.domain.model.entities.CampaignRegistration;
import pe.upc.connexbackend.campaigns.domain.model.valueobjects.RegistrationStatus;
import pe.upc.connexbackend.campaigns.domain.services.CampaignCommandService;
import pe.upc.connexbackend.campaigns.infraestructure.persistance.jpa.repositories.CampaignRepository;
import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.UserRepository;

import java.util.Optional;

@Service
public class CampaignCommandServiceImpl implements CampaignCommandService {
    private final CampaignRepository campaignRepository;
    private final UserRepository userRepository;

    public CampaignCommandServiceImpl(CampaignRepository campaignRepository, UserRepository userRepository) {
        this.campaignRepository = campaignRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Optional<Campaign> handle(CreateCampaignCommand command) {
        User creator = userRepository.findById(command.creatorId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        var campaign = new Campaign();
        campaign.setTitle(command.title());
        campaign.setDescription(command.description());
        campaign.setStatus(command.status());
        campaign.setCreator(creator);
        campaign.setStartDate(command.startDate());
        campaign.setEndDate(command.endDate());
        return Optional.of(campaignRepository.save(campaign));
    }

    @Override
    @Transactional
    public Optional<Campaign> handle(UpdateCampaignCommand command) {
        var campaign = campaignRepository.findById(command.campaignId())
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        User creator = userRepository.findById(command.creatorId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        campaign.setTitle(command.title());
        campaign.setDescription(command.description());
        campaign.setStatus(command.status());
        campaign.setCreator(creator);
        campaign.setStartDate(command.startDate());
        campaign.setEndDate(command.endDate());
        return Optional.of(campaignRepository.save(campaign));
    }

    @Override
    @Transactional
    public void handle(DeleteCampaignCommand command) {
        campaignRepository.deleteById(command.campaignId());
    }

    @Override
    @Transactional
    public Optional<Campaign> handle(AddRegistrationToCampaignCommand command) {
        Optional<Campaign> campaignOpt = campaignRepository.findById(command.campaignId());
        if (campaignOpt.isEmpty()) {
            return Optional.empty();
        }
        Campaign campaign = campaignOpt.get();
        User user = userRepository.findById(command.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        CampaignRegistration registration = new CampaignRegistration();
        registration.setCampaign(campaign);
        registration.setUser(user);
        registration.setStatus(RegistrationStatus.PENDING);

        campaign.getRegistrations().add(registration);
        campaignRepository.save(campaign);
        return Optional.of(campaign);
    }

}
