package com.houserose.guardian.membership;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.houserose.guardian.model.Membership;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomMembershipDeserializer extends StdDeserializer<Membership> {

   public CustomMembershipDeserializer() {
      this(null);
   }

   public CustomMembershipDeserializer(Class<?> vc) {
      super(vc);
   }

   @Override
   public Membership deserialize(
           JsonParser jsonparser,
           DeserializationContext context)
           throws IOException, JsonProcessingException {

      // JB: TODO
      return null;
   }
}