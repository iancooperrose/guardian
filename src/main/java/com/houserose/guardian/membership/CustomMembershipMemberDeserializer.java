package com.houserose.guardian.membership;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.houserose.guardian.model.MembershipMember;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomMembershipMemberDeserializer extends StdDeserializer<MembershipMember> {

   public CustomMembershipMemberDeserializer() {
      this(null);
   }

   public CustomMembershipMemberDeserializer(Class<?> vc) {
      super(vc);
   }

   @Override
   public MembershipMember deserialize(
           JsonParser jsonparser,
           DeserializationContext context)
           throws IOException, JsonProcessingException {

      // JB: TODO
      return null;
   }
}