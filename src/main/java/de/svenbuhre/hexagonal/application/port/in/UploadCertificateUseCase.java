package de.svenbuhre.hexagonal.application.port.in;

import de.svenbuhre.hexagonal.application.domain.model.Certificate;

public interface UploadCertificateUseCase {
    Certificate uploadCertificate(UploadCertificateCommand uploadCertificateCommand);
}
