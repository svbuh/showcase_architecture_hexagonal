package de.svenbuhre.hexagonal.adapter.out.mapper;

import de.svenbuhre.hexagonal.adapter.out.entity.CertificateEntity;
import de.svenbuhre.hexagonal.application.domain.model.Certificate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CertificateMapper {

    CertificateMapper INSTANCE = Mappers.getMapper(CertificateMapper.class);

    Certificate map(CertificateEntity certificateEntity);
}
