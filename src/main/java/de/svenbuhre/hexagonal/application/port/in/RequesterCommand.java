package de.svenbuhre.hexagonal.application.port.in;

import de.svenbuhre.hexagonal.application.domain.model.User;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class RequesterCommand {
    @NonNull User requester;
}
