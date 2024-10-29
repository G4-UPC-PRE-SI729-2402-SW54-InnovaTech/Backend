package pe.upc.connexbackend.users.domain.services;

import pe.upc.connexbackend.users.domain.model.aggregates.Influencer;
import pe.upc.connexbackend.users.domain.model.queries.GetAllInfluencersQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetInfluencerByIdQuery;


import java.util.List;
import java.util.Optional;

//Interfaz para el servicio de consultas sobre influencers
public interface InfluencerQueryService {
    //Obtiene influencers por su ID
    Optional<Influencer> handle(GetInfluencerByIdQuery query);
    //Obtiene todos los influencers
    List<Influencer> handle(GetAllInfluencersQuery query);

}
