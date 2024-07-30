package de.svenbuhre.hexagonal.adapter.in.mapper;

import de.svenbuhre.hexagonal.adapter.in.models.CertificateDto;
import de.svenbuhre.hexagonal.application.domain.model.Certificate;
import de.svenbuhre.hexagonal.application.domain.model.User;
import java.io.IOException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface CertificateMapper {
    CertificateMapper INSTANCE = Mappers.getMapper(CertificateMapper.class);

    @Mapping(source = "file.bytes", target = "data")
    @Mapping(source = "file.originalFilename", target = "filename")
    Certificate mapBody(MultipartFile file, User owner) throws IOException;

    @Mapping(source = "data", target = "fileSize", qualifiedByName = "byteArrayLength")
    CertificateDto certificateToDto(Certificate certificate);

    @Named("byteArrayLength")
    public static int inchToCentimeter(byte[] data) {
        return data.length;
    }
}
