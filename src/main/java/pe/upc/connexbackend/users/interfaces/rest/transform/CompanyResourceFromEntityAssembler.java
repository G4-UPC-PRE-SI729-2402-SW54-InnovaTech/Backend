package pe.upc.connexbackend.users.interfaces.rest.transform;

import pe.upc.connexbackend.users.domain.model.aggregates.Company;
import pe.upc.connexbackend.users.interfaces.rest.resources.CompanyResource;

public class CompanyResourceFromEntityAssembler {
    public static CompanyResource toResourceFromEntity(Company entity) {
        return new CompanyResource(
                entity.getId(),
                entity.getUser().getEmailAddress(),
                entity.getUser().getPasswordHash(),
                entity.getName(),
                entity.getIndustry(),
                entity.getPhoneNumber(),
                entity.getWebsite()
        );
    }
}
