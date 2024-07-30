package de.svenbuhre.hexagonal.adapter.in;

import de.svenbuhre.hexagonal.adapter.in.api.CertificatesApi;
import de.svenbuhre.hexagonal.adapter.in.mapper.CertificateMapper;
import de.svenbuhre.hexagonal.adapter.in.models.CertificateDto;
import de.svenbuhre.hexagonal.application.domain.model.User;
import de.svenbuhre.hexagonal.application.domain.service.CertificateService;
import de.svenbuhre.hexagonal.application.domain.service.UsersService;
import de.svenbuhre.hexagonal.application.port.in.RequesterCommand;
import de.svenbuhre.hexagonal.application.port.in.UploadCertificateCommand;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

@RestController
@RequiredArgsConstructor
public class CertificateController implements CertificatesApi {

    private final CertificateService certificateService;
    private final UsersService userService;


    @SneakyThrows
    @Override
    public ResponseEntity<CertificateDto> uploadCertificate(String username, @RequestParam MultipartFile file) {
        var user = userService.findUserByName(username).orElse(new User(username, false));
        var certificateRequest = CertificateMapper.INSTANCE.mapBody(file, user);
        var command = UploadCertificateCommand.builder()
                .certificate(certificateRequest)
                .build();
        var certificate = certificateService.uploadCertificate(command);

        return ResponseEntity.ok(CertificateMapper.INSTANCE.certificateToDto(certificate));
    }

    @Override
    public ResponseEntity<Resource> downloadCertificate() {
        var command = RequesterCommand.builder()
                .requester(getRequester())
                .build();
        var certificate = certificateService.downloadCertificate(command);
        var resource = new ByteArrayResource(certificate.getData());

        return ResponseEntity.ok()
                .header(CONTENT_DISPOSITION, "attachment; filename=" + certificate.getFilename())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    private User getRequester() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var currentPrincipalName = authentication.getName();
        return userService.findUserByName(currentPrincipalName)
                .orElseThrow(() -> new IllegalArgumentException("Unknown user: " + currentPrincipalName));
    }
}