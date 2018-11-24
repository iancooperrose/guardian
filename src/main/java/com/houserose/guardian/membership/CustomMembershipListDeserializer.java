package com.houserose.guardian.membership;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.houserose.guardian.model.Membership;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomMembershipListDeserializer extends StdDeserializer<List<Membership>> {

   public CustomMembershipListDeserializer() {
      this(null);
   }

   public CustomMembershipListDeserializer(Class<?> vc) {
      super(vc);
   }

   @Override
   public List<Membership> deserialize(
           JsonParser jsonparser,
           DeserializationContext context)
           throws IOException, JsonProcessingException {

      return new ArrayList<>();
   }
}