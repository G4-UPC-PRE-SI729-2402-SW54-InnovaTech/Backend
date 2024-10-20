package pe.upc.connexbackend.users.interfaces.rest.transform;

import pe.upc.connexbackend.users.domain.model.aggregates.Influencer;
import pe.upc.connexbackend.users.interfaces.rest.resources.InfluencerResource;

public class InfluencerResourceFromEntityAssembler {
    public static InfluencerResource toResourceFromEntity(Influencer entity) {
        return new InfluencerResource(
                entity.getInfluencerId(),
                entity.getUser().getEmailAddress(),
                entity.getUser().getPasswordHash(),
                entity.getUser().getIsActive().toString(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getPhoneNumber(),
                entity.getSocialMediaHandle()
        );
    }
}
