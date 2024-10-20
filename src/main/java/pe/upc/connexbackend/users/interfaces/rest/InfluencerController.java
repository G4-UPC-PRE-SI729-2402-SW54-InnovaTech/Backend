package pe.upc.connexbackend.users.interfaces.rest;


import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.connexbackend.users.domain.model.aggregates.Influencer;
import pe.upc.connexbackend.users.domain.model.commands.DeleteInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.queries.GetAllInfluencersQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetInfluencerByIdQuery;
import pe.upc.connexbackend.users.domain.services.InfluencerCommandService;
import pe.upc.connexbackend.users.domain.services.InfluencerQueryService;
import pe.upc.connexbackend.users.interfaces.rest.resources.CreateInfluencerResource;
import pe.upc.connexbackend.users.interfaces.rest.resources.InfluencerResource;
import pe.upc.connexbackend.users.interfaces.rest.transform.CreateInfluencerCommandFromResourceAssembler;
import pe.upc.connexbackend.users.interfaces.rest.transform.InfluencerResourceFromEntityAssembler;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/influencers")
@Tag(name = "influencers", description = "Influencer Management Endpoints")
public class InfluencerController {

    private final InfluencerCommandService influencerCommandService;
    private final InfluencerQueryService influencerQueryService;

    public InfluencerController(InfluencerCommandService influencerCommandService, InfluencerQueryService influencerQueryService) {
        this.influencerCommandService = influencerCommandService;
        this.influencerQueryService = influencerQueryService;
    }

    @PostMapping
    public ResponseEntity<InfluencerResource> createInfluencer(@RequestBody CreateInfluencerResource resource) {
        var createInfluencerCommand = CreateInfluencerCommandFromResourceAssembler.toCommandFromResource(resource);
        var influencer = influencerCommandService.handle(createInfluencerCommand);
        if (influencer.isEmpty()) return ResponseEntity.badRequest().build();
        var influencerResource = InfluencerResourceFromEntityAssembler.toResourceFromEntity(influencer.get());

        return new ResponseEntity<>(influencerResource, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInfluencer(@PathVariable Integer id) {
        influencerCommandService.handle(new DeleteInfluencerCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Influencer> updateInfluencer(@PathVariable Integer id, @RequestBody UpdateInfluencerCommand command) {
        Optional<Influencer> influencer = influencerCommandService.handle(new UpdateInfluencerCommand(id, command.firstName(), command.lastName(), command.phoneNumber(), command.socialMediaHandle()));
        if (influencer.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(influencer.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Influencer> getInfluencerById(@PathVariable Integer id) {
        Optional<Influencer> influencer = influencerQueryService.handle(new GetInfluencerByIdQuery(id));
        return influencer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Influencer>> getAllInfluencers() {
        List<Influencer> influencers = influencerQueryService.handle(new GetAllInfluencersQuery());
        return ResponseEntity.ok(influencers);
    }
}