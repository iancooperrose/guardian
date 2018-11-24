package com.houserose.guardian.serialization;

import com.houserose.guardian.model.Term;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.houserose.guardian.GuardianTestDataFactory.ARISIA_2019_START;
import static com.houserose.guardian.GuardianTestDataFactory.ARISIA_2019_TERM_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.arisia2019Term;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class TermSerializationTest {

   @Autowired
   private JacksonTester<Term> json;

   private Term subject;

   @Before
   public void setUp() {
      subject = arisia2019Term().build();
   }

   @Test
   public void serializationTest() throws IOException {
      System.out.println(this.json.write(subject));

      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.id")
              .isEqualTo("00000000-0000-0006-0002-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.start")
              .isEqualTo("2019-01-18T00:00:00-05:00");
      assertThat(this.json.write(subject))
              .extractingJsonPathNumberValue("@.duration")
              .isEqualTo(4);
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.organization_fk")
              .isEqualTo(null);
   }

   @Test
   public void deserializationTest() throws IOException {
      String content = "{\"id\":\"00000000-0000-0006-0002-000000000000\",\"start\":\"2019-01-18T00:00:00-05:00\",\"duration\":4,\"memberships\":[],\"organization\":null}";
      assertThat(this.json.parseObject(content).getId()).isEqualTo(ARISIA_2019_TERM_TEST_UUID);
      assertThat(this.json.parseObject(content).getStart()).isEqualTo(ARISIA_2019_START);
      assertThat(this.json.parseObject(content).getDuration()).isEqualTo(4L);
      assertThat(this.json.parseObject(content).getOrganization()).isEqualTo(null);
   }
}
