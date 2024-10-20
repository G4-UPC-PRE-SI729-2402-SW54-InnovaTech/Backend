package pe.upc.connexbackend.users.domain.services;

import pe.upc.connexbackend.users.domain.model.aggregates.Influencer;
import pe.upc.connexbackend.users.domain.model.commands.CreateInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.commands.DeleteInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateInfluencerCommand;

import java.util.Optional;

public interface InfluencerCommandService {
    Optional<Influencer> handle(CreateInfluencerCommand command);
    Optional<Influencer> handle(UpdateInfluencerCommand command);
    void handle(DeleteInfluencerCommand command);
}
