package pe.upc.connexbackend.users.application;

import org.springframework.stereotype.Service;
import pe.upc.connexbackend.users.domain.model.aggregates.Influencer;
import pe.upc.connexbackend.users.domain.model.queries.GetAllInfluencersQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetInfluencerByIdQuery;
import pe.upc.connexbackend.users.domain.services.InfluencerQueryService;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.InfluencerRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar las consultas relacionadas con influencers.
 */
@Service
public class InfluencerQueryServiceImpl implements InfluencerQueryService {

    private final InfluencerRepository influencerRepository;

    /**
     * Constructor que inyecta el repositorio de influencers.
     */
    public InfluencerQueryServiceImpl(InfluencerRepository influencerRepository) {
        this.influencerRepository = influencerRepository;
    }

    /**
     * Maneja la consulta para obtener un influencer por su ID.
     */
    @Override
    public Optional<Influencer> handle(GetInfluencerByIdQuery query) {
        return influencerRepository.findById(query.influencerId());
    }

    /**
     * Maneja la consulta para obtener todos los influencers.
     */
    @Override
    public List<Influencer> handle(GetAllInfluencersQuery query) {
        return influencerRepository.findAll();
    }
}
