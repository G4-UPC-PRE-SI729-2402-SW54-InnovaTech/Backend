package pe.upc.connexbackend.campaigns.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.connexbackend.campaigns.domain.model.aggregates.Campaign;
import pe.upc.connexbackend.campaigns.domain.model.commands.DeleteCampaignCommand;
import pe.upc.connexbackend.campaigns.domain.model.commands.UpdateCampaignCommand;
import pe.upc.connexbackend.campaigns.domain.model.queries.GetAllCampaignsQuery;
import pe.upc.connexbackend.campaigns.domain.model.queries.GetCampaignsByDateRangeQuery;
import pe.upc.connexbackend.campaigns.domain.services.CampaignCommandService;
import pe.upc.connexbackend.campaigns.domain.services.CampaignQueryService;
import pe.upc.connexbackend.campaigns.interfaces.rest.resources.CampaignResource;
import pe.upc.connexbackend.campaigns.interfaces.rest.resources.CreateCampaignResource;
import pe.upc.connexbackend.campaigns.interfaces.rest.transform.CampaignResourceFromEntityAssembler;
import pe.upc.connexbackend.campaigns.interfaces.rest.transform.CreateCampaignCommandFromResourceAssembler;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/campaigns")
@Tag(name = "Campaigns", description = "Campaign Management Endpoints")
public class CampaignController {
    private final CampaignCommandService campaignCommandService;
    private final CampaignQueryService campaignQueryService;

    public CampaignController(CampaignCommandService campaignCommandService, CampaignQueryService campaignQueryService) {
        this.campaignCommandService = campaignCommandService;
        this.campaignQueryService = campaignQueryService;
    }

    @PostMapping
    public ResponseEntity<CampaignResource> createCampaign(@RequestBody CreateCampaignResource resource){
        var createCampaignCommand = CreateCampaignCommandFromResourceAssembler.toCommandFromResource(resource);
        var campaign = campaignCommandService.handle(createCampaignCommand);
        if (campaign.isEmpty()) return ResponseEntity.badRequest().build();
        var campaignResource = CampaignResourceFromEntityAssembler.toResourceFromEntity(campaign.get());
        return new ResponseEntity<>(campaignResource, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Integer id){
        campaignCommandService.handle(new DeleteCampaignCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampaignResource> updateCampaign(@PathVariable Integer id, @RequestBody CreateCampaignResource resource){
        Optional<Campaign> campaign = campaignCommandService.handle(
                new UpdateCampaignCommand(
                        id, resource.title(),resource.description(),
                        resource.status(),resource.creatorId() ,resource.startDate(), resource.endDate()));
        if (campaign.isEmpty()) return ResponseEntity.notFound().build();
        var campaignResource = CampaignResourceFromEntityAssembler.toResourceFromEntity(campaign.get());
        return ResponseEntity.ok(campaignResource);
    }

    @GetMapping
    public ResponseEntity<List<Campaign>> getAllCampaigns(){
        List<Campaign> campaigns = campaignQueryService.handle(new GetAllCampaignsQuery());
        return ResponseEntity.ok(campaigns);
    }
    @GetMapping("/date-range")
    public ResponseEntity<List<Campaign>> getCampaignsByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        List<Campaign> campaigns = campaignQueryService.handle(new GetCampaignsByDateRangeQuery(startDate, endDate));
        return ResponseEntity.ok(campaigns);
    }


}
