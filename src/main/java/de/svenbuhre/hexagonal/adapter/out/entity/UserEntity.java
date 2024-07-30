package de.svenbuhre.hexagonal.adapter.out.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column
    private boolean privileged;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<CertificateEntity> certificateEntities;

}
