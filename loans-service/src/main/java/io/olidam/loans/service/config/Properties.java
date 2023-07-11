package io.olidam.loans.service.config;

import lombok.Builder;

import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;
import static org.apache.logging.log4j.util.Strings.EMPTY;

@Builder
public record Properties(
        String msg,
        String buildVersion,
        Map<String, String> mailDetails,
        List<String> activeBranches
) {
    public Properties {
        msg = ofNullable(msg).orElse(EMPTY);
        buildVersion = ofNullable(buildVersion).orElse(EMPTY);
        mailDetails = ofNullable(mailDetails).orElse(Map.of());
        activeBranches = ofNullable(activeBranches).orElse(List.of());
    }
}
