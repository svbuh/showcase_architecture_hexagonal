package de.svenbuhre.hexagonal.adapter.out.repository;

import de.svenbuhre.hexagonal.adapter.out.entity.CertificateEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateJpaRepository extends JpaRepository<CertificateEntity, UUID> {
}
