package de.svenbuhre.hexagonal.adapter.out;

import static java.util.Comparator.comparing;

import de.svenbuhre.hexagonal.adapter.out.entity.CertificateEntity;
import de.svenbuhre.hexagonal.adapter.out.mapper.CertificateMapper;
import de.svenbuhre.hexagonal.adapter.out.repository.CertificateJpaRepository;
import de.svenbuhre.hexagonal.adapter.out.repository.UserJpaRepository;
import de.svenbuhre.hexagonal.application.domain.model.Certificate;
import de.svenbuhre.hexagonal.application.domain.model.User;
import de.svenbuhre.hexagonal.application.port.out.CertificateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CertificatePersistenceAdapter implements CertificateRepository {

    private final UserJpaRepository userJpaRepository;
    private final CertificateJpaRepository certificateJpaRepository;


    @Override
    public Certificate saveCertificate(Certificate certificate) {
        var user = userJpaRepository.findByUsername(certificate.getOwner().getUsername());

        if (user.isEmpty()) {
            throw new EntityNotFoundException("User not found with username: " + certificate.getOwner().getUsername());
        }

        var certificateEntity = new CertificateEntity();
        certificateEntity.setFilename(certificate.getFilename());
        certificateEntity.setData(certificate.getData());
        certificateEntity.setOwner(user.get());

        certificateJpaRepository.save(certificateEntity);

        return CertificateMapper.INSTANCE.map(certificateEntity);
    }

    @Override
    public Certificate findNewestCertificate(User user) {
        var userEntity = userJpaRepository
                .findByUsername(user.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        var newestEntity = userEntity.getCertificateEntities()
                .stream()
                .max(comparing(CertificateEntity::getCreated))
                .orElseThrow(() -> new EntityNotFoundException("No certificate found"));

        return  CertificateMapper.INSTANCE.map(newestEntity);
    }
}