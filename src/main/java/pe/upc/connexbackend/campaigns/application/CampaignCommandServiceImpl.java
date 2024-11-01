package pe.upc.connexbackend.campaigns.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.connexbackend.campaigns.domain.model.aggregates.Campaign;
import pe.upc.connexbackend.campaigns.domain.model.commands.*;
import pe.upc.connexbackend.campaigns.domain.model.entities.CampaignRegistration;
import pe.upc.connexbackend.campaigns.domain.model.valueobjects.RegistrationStatus;
import pe.upc.connexbackend.campaigns.domain.model.valueobjects.UserRegistered;
import pe.upc.connexbackend.campaigns.domain.services.CampaignCommandService;
import pe.upc.connexbackend.campaigns.infraestructure.persistance.jpa.repositories.CampaignRegistrationRepository;
import pe.upc.connexbackend.campaigns.infraestructure.persistance.jpa.repositories.CampaignRepository;
import pe.upc.connexbackend.profiles.domain.model.aggregates.Profile;
import pe.upc.connexbackend.profiles.infraestructure.persistance.jpa.repositories.ProfileRepository;
import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.UserRepository;

import java.util.Optional;

@Service
public class CampaignCommandServiceImpl implements CampaignCommandService {
    private final CampaignRepository campaignRepository;
    private final UserRepository userRepository;
    private final CampaignRegistrationRepository campaignRegistrationRepository;
    private final ProfileRepository profileRepository;


    public CampaignCommandServiceImpl(CampaignRepository campaignRepository, UserRepository userRepository, CampaignRegistrationRepository campaignRegistrationRepository, ProfileRepository profileRepository) {
        this.campaignRepository = campaignRepository;
        this.userRepository = userRepository;
        this.campaignRegistrationRepository = campaignRegistrationRepository;
        this.profileRepository=profileRepository;
    }

    @Override
    @Transactional
    public Optional<Campaign> handle(CreateCampaignCommand command) {
        Profile profile = profileRepository.findByUserId(command.creatorId())
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        var campaign = new Campaign();
        campaign.setTitle(command.title());
        campaign.setDescription(command.description());
        campaign.setStatus(command.status());
        campaign.setCreator(new UserRegistered(profile.getUser().getId(),profile.getBrandName(),profile.getUser().getEmailAddress(),profile.getUser().getUserTypeEnum()));
        campaign.setStartDate(command.startDate());
        campaign.setEndDate(command.endDate());
        return Optional.of(campaignRepository.save(campaign));
    }

    @Override
    @Transactional
    public Optional<Campaign> handle(UpdateCampaignCommand command) {
        var campaign = campaignRepository.findById(command.campaignId())
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        campaign.setTitle(command.title());
        campaign.setDescription(command.description());
        campaign.setStatus(command.status());
        campaign.setCreator(campaign.getCreator());
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
        // Busca la campaña en el repositorio usando el ID de campaña provisto en el comando.
        // Si no se encuentra la campaña, lanza una excepción.
        Campaign campaign = campaignRepository.findById(command.campaignId())
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        Profile profile = profileRepository.findByUserId(command.userId())
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        // Verifica si el usuario que intenta registrarse es el creador de la campaña.
       // Si lo es, lanza una excepción, ya que el creador no puede registrarse en su propia campaña.
        if(campaign.getCreator().getUserId()==command.userId()){
            throw new RuntimeException("The creator of the campaign cannot register");
        }
        if(campaign.getRegistrations().stream().anyMatch(registration -> registration.getUser().getUserId()==command.userId())){
            throw new RuntimeException("The user is already registered");
        }

        CampaignRegistration registration = new CampaignRegistration();
        registration.setCampaign(campaign);
        registration.setUser(new UserRegistered(profile.getUser().getId(),profile.getBrandName(),profile.getUser().getEmailAddress(),profile.getUser().getUserTypeEnum()));
        registration.setStatus(RegistrationStatus.PENDING);

        campaign.getRegistrations().add(registration);
        campaignRepository.save(campaign);
        return Optional.of(campaign);
    }

    @Override
    @Transactional
    public void handle(RemoveRegistrationInCampaignCommand command) {
        Campaign campaign = campaignRepository.findById(command.campaignId())
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        CampaignRegistration registration = campaignRegistrationRepository.findByCampaignIdAndUser_UserId(command.campaignId(), command.userId())
                .orElseThrow(() -> new RuntimeException("Registration not found"));

        campaign.getRegistrations().remove(registration);
        campaignRegistrationRepository.delete(registration);
    }

}
