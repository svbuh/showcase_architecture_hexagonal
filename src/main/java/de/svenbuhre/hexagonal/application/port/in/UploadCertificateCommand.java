package de.svenbuhre.hexagonal.application.port.in;

import de.svenbuhre.hexagonal.application.domain.model.Certificate;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class UploadCertificateCommand {
    @NonNull Certificate certificate;
}

