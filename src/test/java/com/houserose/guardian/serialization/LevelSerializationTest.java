package com.houserose.guardian.serialization;

import com.houserose.guardian.model.Level;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.houserose.guardian.GuardianTestDataFactory.TURTLE_LEVEL_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.turtleLevel;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class LevelSerializationTest {

   @Autowired
   private JacksonTester<Level> json;

   private Level subject;

   @Before
   public void setUp() {
      subject = turtleLevel().build();
   }

   @Test
   public void serializationTest() throws IOException {
      System.out.println(this.json.write(subject));

      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.id")
              .isEqualTo("00000000-0000-0005-0000-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.name")
              .isEqualTo("Turtle Track");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.organization_fk")
              .isEqualTo(null);
   }

   @Test
   public void deserializationTest() throws IOException {
      String content = "{\"id\":\"00000000-0000-0005-0000-000000000000\",\"name\":\"Turtle Track\",\"memberships\":[],\"organization\":null}";
      assertThat(this.json.parseObject(content).getId()).isEqualTo(TURTLE_LEVEL_TEST_UUID);
      assertThat(this.json.parseObject(content).getName()).isEqualTo("Turtle Track");
      assertThat(this.json.parseObject(content).getOrganization()).isEqualTo(null);
   }
}
