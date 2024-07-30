package de.svenbuhre.hexagonal.application.configuration;

import de.svenbuhre.hexagonal.application.domain.service.CertificateService;
import de.svenbuhre.hexagonal.application.domain.service.UsersService;
import de.svenbuhre.hexagonal.application.port.out.CertificateRepository;
import de.svenbuhre.hexagonal.application.port.out.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public UsersService usersService(UserRepository userRepository) {
        return new UsersService(userRepository);
    }

    @Bean
    public CertificateService certificateService(CertificateRepository certificateRepository, UserRepository userRepository){
        return new CertificateService(certificateRepository, userRepository);
    }
}
