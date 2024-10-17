package pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.connexbackend.users.domain.model.aggregates.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}