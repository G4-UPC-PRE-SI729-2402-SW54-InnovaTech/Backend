package pe.upc.connexbackend.users.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.connexbackend.users.domain.model.aggregates.Influencer;
import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.domain.model.commands.CreateInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.commands.DeleteInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.valueobjects.EmailAddress;
import pe.upc.connexbackend.users.domain.model.valueobjects.UserType;
import pe.upc.connexbackend.users.domain.services.InfluencerCommandService;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.InfluencerRepository;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.UserRepository;

import java.util.Optional;

@Service
public class InfluencerCommandServiceImpl implements InfluencerCommandService {

    private final InfluencerRepository influencerRepository;
    private final UserRepository userRepository;

    public InfluencerCommandServiceImpl(InfluencerRepository influencerRepository, UserRepository userRepository) {
        this.influencerRepository = influencerRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Optional<Influencer> handle(CreateInfluencerCommand command) {
        var emailAddress = new EmailAddress(command.email());
        userRepository.findByEmail(emailAddress).map(user -> {
            throw new IllegalArgumentException("User with email " + emailAddress.address() + " already exists");
        });

        var user = new User(command.email(), command.passwordHash(), UserType.INFLUENCER);
        var influencer = new Influencer();
        influencer.setUser(user);
        influencer.setFirstName(command.firstName());
        influencer.setLastName(command.lastName());
        influencer.setPhoneNumber(command.phoneNumber());
        influencer.setSocialMediaHandle(command.socialMediaHandle());

        var createdInfluencer = influencerRepository.save(influencer);

        return Optional.of(createdInfluencer);
    }

    @Override
    @Transactional
    public void handle(DeleteInfluencerCommand command) {
        influencerRepository.deleteById(command.influencerId());
    }

    @Override
    @Transactional
    public Optional<Influencer> handle(UpdateInfluencerCommand command) {
        Influencer influencer = influencerRepository.findById(command.influencerId())
                .orElseThrow(() -> new IllegalArgumentException("Influencer not found"));
        influencer.setFirstName(command.firstName());
        influencer.setLastName(command.lastName());
        influencer.setPhoneNumber(command.phoneNumber());
        influencer.setSocialMediaHandle(command.socialMediaHandle());
        return Optional.of(influencerRepository.save(influencer));
    }
}