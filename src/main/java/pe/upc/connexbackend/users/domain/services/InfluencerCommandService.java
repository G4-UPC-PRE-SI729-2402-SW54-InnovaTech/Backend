package pe.upc.connexbackend.users.domain.services;

import pe.upc.connexbackend.users.domain.model.aggregates.Influencer;
import pe.upc.connexbackend.users.domain.model.commands.CreateInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.commands.DeleteInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateInfluencerCommand;

import java.util.Optional;

//Interfaz que define los servicios de comandos para manejar operaciones con influencers
public interface InfluencerCommandService {
    //Manejar la creación de un nuevo influencer
    Optional<Influencer> handle(CreateInfluencerCommand command);
    //Manejar la actualización de un influencer existente
    Optional<Influencer> handle(UpdateInfluencerCommand command);
    //Manejar la eliminación de un influencer existente
    void handle(DeleteInfluencerCommand command);
}
