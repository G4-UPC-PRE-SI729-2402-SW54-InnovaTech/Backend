//Paquete que contiene la clase
package pe.upc.connexbackend.shared.domain.model.entities;

//Importaciones necesarias para JPA, Lombok y auditoría 
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

//Genera getters 
@Getter
//Activa la auditoría para la entidad
@EntityListeners(AuditingEntityListener.class)
//Superclase mapeada 
@MappedSuperclass
public class AuditableModel {

    //Campo de fecha de creación
    @CreatedDate
    @Column(nullable = false, updatable = false) //Es no nula ni modificable 
    private Date createdAt;

    //Campo de ultimas modificaciones
    @LastModifiedDate
    @Column(nullable = false) //No nula
    private Date updatedAt;
}
