package com.houserose.guardian.membership;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.houserose.guardian.model.Membership;
import com.houserose.guardian.model.Organization;
import com.houserose.guardian.model.Term;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

public class CustomTermDeserializer extends StdDeserializer<Term> {

    public CustomTermDeserializer() {
        this(null);
    }

    public CustomTermDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Term deserialize(
            JsonParser jsonparser,
            DeserializationContext context)
            throws IOException, JsonProcessingException {

        JsonNode node = jsonparser.getCodec().readTree(jsonparser);

        UUID id = UUID.fromString(node.get("id").asText());
//      ZonedDateTime start = ZonedDateTime.parse(node.get("start").asText());
        long duration = node.get("duration").asLong();

        return Term.builder()
                .id(id)
                // JB: TODO String => ZoneDateTime
                .start(null)
                .duration(duration)
                // JB: TODO actually parse out and build
                .memberships(Collections.singletonList(Membership.builder().build()))
                // JB: TODO actually parse out and build
                .organization(Organization.builder().build())
                .build();
    }
}