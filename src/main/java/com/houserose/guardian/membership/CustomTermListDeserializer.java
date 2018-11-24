package com.houserose.guardian.membership;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.houserose.guardian.model.Term;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomTermListDeserializer extends StdDeserializer<List<Term>> {

   public CustomTermListDeserializer() {
      this(null);
   }

   public CustomTermListDeserializer(Class<?> vc) {
      super(vc);
   }

   @Override
   public List<Term> deserialize(
           JsonParser jsonparser,
           DeserializationContext context)
           throws IOException, JsonProcessingException {

      return new ArrayList<>();
   }
}