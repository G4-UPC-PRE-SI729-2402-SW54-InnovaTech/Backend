package pe.upc.connexbackend.users.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.connexbackend.users.domain.model.aggregates.Influencer;
import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.domain.model.commands.CreateInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.commands.DeleteInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.valueobjects.UserType;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.InfluencerRepository;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.UserRepository;

@Service
public class InfluencerCommandServiceImpl {
    @Autowired
    private InfluencerRepository influencerRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Influencer handle(CreateInfluencerCommand command) {
        User user = new User(command.email(), command.passwordHash(), UserType.INFLUENCER);
        userRepository.save(user);

        Influencer influencer = new Influencer();
        influencer.setUser(user);
        influencer.setFirstName(command.firstName());
        influencer.setLastName(command.lastName());
        influencer.setPhoneNumber(command.phoneNumber());
        influencer.setSocialMediaHandle(command.socialMediaHandle());
        return influencerRepository.save(influencer);
    }

    @Transactional
    public void handle(DeleteInfluencerCommand command) {
        influencerRepository.deleteById(command.influencerId());
    }

    @Transactional
    public Influencer handle(UpdateInfluencerCommand command) {
        Influencer influencer = influencerRepository.findById(command.influencerId())
                .orElseThrow(() -> new IllegalArgumentException("Influencer not found"));
        influencer.setFirstName(command.firstName());
        influencer.setLastName(command.lastName());
        influencer.setPhoneNumber(command.phoneNumber());
        influencer.setSocialMediaHandle(command.socialMediaHandle());
        return influencerRepository.save(influencer);
    }
}