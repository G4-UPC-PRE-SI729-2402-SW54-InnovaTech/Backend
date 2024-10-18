package pe.upc.connexbackend.users.domain.services;

import pe.upc.connexbackend.users.domain.model.aggregates.Influencer;
import pe.upc.connexbackend.users.domain.model.queries.GetAllInfluencersQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetInfluencerByIdQuery;


import java.util.List;
import java.util.Optional;

public interface InfluencerQueryService {
    Optional<Influencer> handle(GetInfluencerByIdQuery query);

    List<Influencer> handle(GetAllInfluencersQuery query);

}
