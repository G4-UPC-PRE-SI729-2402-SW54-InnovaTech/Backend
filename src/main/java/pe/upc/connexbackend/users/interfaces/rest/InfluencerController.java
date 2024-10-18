package pe.upc.connexbackend.users.interfaces.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.connexbackend.users.application.InfluencerCommandServiceImpl;
import pe.upc.connexbackend.users.application.InfluencerQueryServiceImpl;
import pe.upc.connexbackend.users.domain.model.aggregates.Influencer;
import pe.upc.connexbackend.users.domain.model.commands.CreateInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.commands.DeleteInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateInfluencerCommand;
import pe.upc.connexbackend.users.domain.model.queries.GetAllInfluencersQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetInfluencerByIdQuery;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/influencers")
public class InfluencerController {

    @Autowired
    private InfluencerCommandServiceImpl influencerCommandService;

    @Autowired
    private InfluencerQueryServiceImpl influencerQueryService;

    @PostMapping
    public ResponseEntity<Influencer> createInfluencer(@RequestBody CreateInfluencerCommand command) {
        Influencer influencer = influencerCommandService.handle(command);
        return ResponseEntity.ok(influencer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInfluencer(@PathVariable Integer id) {
        influencerCommandService.handle(new DeleteInfluencerCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Influencer> updateInfluencer(@PathVariable Integer id, @RequestBody UpdateInfluencerCommand command) {
        Influencer influencer = influencerCommandService.handle(new UpdateInfluencerCommand(id, command.firstName(), command.lastName(), command.phoneNumber(), command.socialMediaHandle()));
        return ResponseEntity.ok(influencer);
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