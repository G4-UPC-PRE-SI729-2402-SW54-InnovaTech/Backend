package pe.upc.connexbackend.users.domain.services;

import pe.upc.connexbackend.users.domain.model.aggregates.Influencer;
import pe.upc.connexbackend.users.domain.model.commands.CreateInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.commands.DeleteInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateInfluencerCommand;

public interface InfluencerCommandService {
    Influencer handle(CreateInfluencerCommand command);
    Influencer handle(UpdateInfluencerCommand command);
    void handle(DeleteInfluencerCommand command);
}
