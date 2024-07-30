package de.svenbuhre.hexagonal.application.domain.service;

import de.svenbuhre.hexagonal.application.domain.model.Certificate;
import de.svenbuhre.hexagonal.application.port.in.DownloadCertificateUseCase;
import de.svenbuhre.hexagonal.application.port.in.RequesterCommand;
import de.svenbuhre.hexagonal.application.port.in.UploadCertificateCommand;
import de.svenbuhre.hexagonal.application.port.in.UploadCertificateUseCase;
import de.svenbuhre.hexagonal.application.port.out.CertificateRepository;
import de.svenbuhre.hexagonal.application.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;

@RequiredArgsConstructor
public class CertificateService implements UploadCertificateUseCase, DownloadCertificateUseCase {

    private final CertificateRepository certificateRepository;
    private final UserRepository userRepository;

    @Override
    public Certificate uploadCertificate(UploadCertificateCommand uploadCertificateCommand) {
        var owner = uploadCertificateCommand.getCertificate().getOwner();
        if (userRepository.findByUsername(owner.getUsername()).isEmpty()) {
            userRepository.save(owner);
        }

        return certificateRepository.saveCertificate(uploadCertificateCommand.getCertificate());
    }

    @Override
    public Certificate downloadCertificate(RequesterCommand command) {
        return certificateRepository.findNewestCertificate(command.getRequester());
    }
}

