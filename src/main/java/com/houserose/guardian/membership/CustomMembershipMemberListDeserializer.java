package com.houserose.guardian.membership;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.houserose.guardian.model.MembershipMember;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomMembershipMemberListDeserializer extends StdDeserializer<List<MembershipMember>> {

   public CustomMembershipMemberListDeserializer() {
      this(null);
   }

   public CustomMembershipMemberListDeserializer(Class<?> vc) {
      super(vc);
   }

   @Override
   public List<MembershipMember> deserialize(
           JsonParser jsonparser,
           DeserializationContext context)
           throws IOException, JsonProcessingException {

      return new ArrayList<>();
   }
}