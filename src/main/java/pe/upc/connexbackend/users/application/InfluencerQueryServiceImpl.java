package pe.upc.connexbackend.users.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.connexbackend.users.domain.model.aggregates.Influencer;
import pe.upc.connexbackend.users.domain.model.queries.GetAllInfluencersQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetInfluencerByIdQuery;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.InfluencerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InfluencerQueryServiceImpl {
    @Autowired
    private InfluencerRepository influencerRepository;

    public Optional<Influencer> handle(GetInfluencerByIdQuery query) {
        return influencerRepository.findById(query.influencerId());
    }

    public List<Influencer> handle(GetAllInfluencersQuery query) {
        return influencerRepository.findAll();
    }
}
