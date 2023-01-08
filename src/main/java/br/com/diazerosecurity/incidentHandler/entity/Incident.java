package br.com.diazerosecurity.incidentHandler.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "IncidentTable")
public class Incident {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        // Definido UUID para organização dos incidentes.
        private Long id;

        // Id que especifique o tipo de incidente que ocorre neste caso.
        private int idIncident;
        // Nome Do cliente
        private String name;
        // Descrição do problema
        private String description;
        // Utilizando a class Instant para melhor correlação da JVM com a data.
        private Instant createdAt;
        @UpdateTimestamp
        private Instant updatedAt;
        private Instant closedAt;

        }






