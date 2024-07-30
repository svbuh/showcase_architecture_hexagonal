package de.svenbuhre.hexagonal.application.configuration.security;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
@ConfigurationProperties(prefix = "cert")
public class UserBasicAuthProperties {
    @Getter
    @Setter
    private List<UserDetail> users;

    public record UserDetail(String username, String password, boolean isPrivileged) {
        public UserDetails toUserDetails() {
            return User
                    .withUsername(username())
                    .password(password())
                    .roles(isPrivileged ? "ADMIN" : "USER")
                    .build();
        }
    }
}

