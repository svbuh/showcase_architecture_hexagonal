package de.svenbuhre.hexagonal.application.domain.model;

import lombok.Value;

@Value
public class User {
    private final String username;
    private final boolean privileged;
}
