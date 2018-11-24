package com.houserose.guardian.membership;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.houserose.guardian.model.Level;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomLevelListDeserializer extends StdDeserializer<List<Level>> {

   public CustomLevelListDeserializer() {
      this(null);
   }

   public CustomLevelListDeserializer(Class<?> vc) {
      super(vc);
   }

   @Override
   public List<Level> deserialize(
           JsonParser jsonparser,
           DeserializationContext context)
           throws IOException, JsonProcessingException {

      return new ArrayList<>();
   }
}