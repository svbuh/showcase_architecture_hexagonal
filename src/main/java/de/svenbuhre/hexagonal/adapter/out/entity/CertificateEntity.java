package de.svenbuhre.hexagonal.adapter.out.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "CERTIFICATES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @CreationTimestamp
    private OffsetDateTime created;

    private String filename;

    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private UserEntity owner;

}
