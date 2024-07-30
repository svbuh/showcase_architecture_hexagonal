package de.svenbuhre.hexagonal.application.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Value;

@Value
public class Certificate {
    UUID id;
    byte[] data;
    String filename;
    OffsetDateTime created;
    User owner;
}
