package de.svenbuhre.hexagonal.application.port.out;

import de.svenbuhre.hexagonal.application.domain.model.Certificate;
import de.svenbuhre.hexagonal.application.domain.model.User;

public interface CertificateRepository {
    Certificate saveCertificate(Certificate certificate);

    Certificate findNewestCertificate(User user);
}
