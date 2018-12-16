package com.houserose.guardian.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.houserose.guardian.model.Organization;
import com.houserose.guardian.model.Term;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.houserose.guardian.GuardianTestDataFactory.ARISIA_2017_START;
import static com.houserose.guardian.GuardianTestDataFactory.ARISIA_2017_TERM_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.ARISIA_2018_START;
import static com.houserose.guardian.GuardianTestDataFactory.ARISIA_2018_TERM_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.ARISIA_2019_START;
import static com.houserose.guardian.GuardianTestDataFactory.ARISIA_2019_TERM_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.ARISIA_ORGANIZATION_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.COMET_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.SATELLITE_LEVEL_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.TEEN_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.TURTLE_LEVEL_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.arisia2017Term;
import static com.houserose.guardian.GuardianTestDataFactory.arisia2018Term;
import static com.houserose.guardian.GuardianTestDataFactory.arisia2019Term;
import static com.houserose.guardian.GuardianTestDataFactory.arisiaOrganization;
import static com.houserose.guardian.GuardianTestDataFactory.cometLevel;
import static com.houserose.guardian.GuardianTestDataFactory.satelliteLevel;
import static com.houserose.guardian.GuardianTestDataFactory.teenLevel;
import static com.houserose.guardian.GuardianTestDataFactory.turtleLevel;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class OrganizationSerializationTest {

   @Autowired
   private JacksonTester<Organization> json;

   private Organization subject;

   @Before
   public void setUp() {

      subject = arisiaOrganization().build();
      subject.addTerm(arisia2017Term().build());
      subject.addTerm(arisia2018Term().build());
      subject.addTerm(arisia2019Term().build());
      subject.addLevel(turtleLevel().build());
      subject.addLevel(satelliteLevel().build());
      subject.addLevel(cometLevel().build());
      subject.addLevel(teenLevel().build());
   }

   @Test
   // JB: Throw generic Exceptions for tests vs IOException
   public void serializationTest() throws Exception {
      // JB: For William Wallace!
      JsonContent<Organization> content = this.json.write(subject);

      assertThat(content).extractingJsonPathStringValue("@.id").isEqualTo("00000000-0000-0002-0000-000000000000");
      assertThat(content).extractingJsonPathStringValue("@.name").isEqualTo("Arisia");

      // JB: Blue
      assertThat(content).extractingJsonPathArrayValue("@.levels").hasSize(4);
      assertThat(content).extractingJsonPathStringValue("@.levels[0].id").isEqualTo("00000000-0000-0005-0000-000000000000");
      assertThat(content).extractingJsonPathStringValue("@.levels[0].name").isEqualTo("Turtle Track");

      assertThat(content).extractingJsonPathStringValue("@.levels[1].id").isEqualTo("00000000-0000-0005-0001-000000000000");
      assertThat(content).extractingJsonPathStringValue("@.levels[1].name").isEqualTo("Fast Track - Satellite");

      assertThat(content).extractingJsonPathStringValue("@.levels[2].id").isEqualTo("00000000-0000-0005-0002-000000000000");
      assertThat(content).extractingJsonPathStringValue("@.levels[2].name").isEqualTo("Fast Track - Comet");

      assertThat(content).extractingJsonPathStringValue("@.levels[3].id").isEqualTo("00000000-0000-0005-0003-000000000000");
      assertThat(content).extractingJsonPathStringValue("@.levels[3].name").isEqualTo("Teen Lounge");

      // JB: And White
      assertThat(content).extractingJsonPathArrayValue("@.terms").hasSize(3);
      assertThat(content).extractingJsonPathStringValue("@.terms[0].id").isEqualTo("00000000-0000-0006-0000-000000000000");
      assertThat(content).extractingJsonPathStringValue("@.terms[0].start").isEqualTo("2017-01-13T00:00:00-05:00");
      assertThat(content).extractingJsonPathNumberValue("@.terms[0].duration").isEqualTo(4);

      assertThat(content).extractingJsonPathStringValue("@.terms[1].id").isEqualTo("00000000-0000-0006-0001-000000000000");
      assertThat(content).extractingJsonPathStringValue("@.terms[1].start").isEqualTo("2018-01-12T00:00:00-05:00");
      assertThat(content).extractingJsonPathNumberValue("@.terms[1].duration").isEqualTo(4);

      assertThat(content).extractingJsonPathStringValue("@.terms[2].id").isEqualTo("00000000-0000-0006-0002-000000000000");
      assertThat(content).extractingJsonPathStringValue("@.terms[2].start").isEqualTo("2019-01-18T00:00:00-05:00");
      assertThat(content).extractingJsonPathNumberValue("@.terms[2].duration").isEqualTo(4);
   }

   @Test
   public void deserializationTest() throws Exception {
      // JB: Make Robert Bruce proud and use object mapper vs literal string
      // This also helps rule out typos!
      String content = new ObjectMapper().writeValueAsString(subject);
      System.out.println(content);

      // JB: Deserialize only once! Name this whatever you want
      Organization obj = this.json.parseObject(content);
      System.out.println(obj);

      assertThat(obj.getId()).isEqualTo(ARISIA_ORGANIZATION_TEST_UUID);
      assertThat(obj.getName()).isEqualToIgnoringCase("Arisia");

      // JB: Always check first that the length matches so you can avoid cryptic index out of bounds failures
      assertThat(obj.getTerms()).hasSize(3);

      assertThat(obj.getTerms().get(0).getId()).isEqualTo(ARISIA_2017_TERM_TEST_UUID);
      assertThat(obj.getTerms().get(0).getStart()).isEqualTo(ARISIA_2017_START);
      assertThat(obj.getTerms().get(0).getDuration()).isEqualTo(4L);

      assertThat(obj.getTerms().get(1).getId()).isEqualTo(ARISIA_2018_TERM_TEST_UUID);
      assertThat(obj.getTerms().get(1).getStart()).isEqualTo(ARISIA_2018_START);
      assertThat(obj.getTerms().get(1).getDuration()).isEqualTo(4L);

      assertThat(obj.getTerms().get(2).getId()).isEqualTo(ARISIA_2019_TERM_TEST_UUID);
      assertThat(obj.getTerms().get(2).getStart()).isEqualTo(ARISIA_2019_START);
      assertThat(obj.getTerms().get(2).getDuration()).isEqualTo(4L);

      // JB: For Scotland!
      assertThat(obj.getLevels()).hasSize(4);

      assertThat(obj.getLevels().get(0).getId()).isEqualTo(TURTLE_LEVEL_TEST_UUID);
      assertThat(obj.getLevels().get(0).getName()).isEqualTo("Turtle Track");

      assertThat(obj.getLevels().get(1).getId()).isEqualTo(SATELLITE_LEVEL_TEST_UUID);
      assertThat(obj.getLevels().get(1).getName()).isEqualTo("Fast Track - Satellite");

      assertThat(obj.getLevels().get(2).getId()).isEqualTo(COMET_TEST_UUID);
      assertThat(obj.getLevels().get(2).getName()).isEqualTo("Fast Track - Comet");

      assertThat(obj.getLevels().get(3).getId()).isEqualTo(TEEN_TEST_UUID);
      assertThat(obj.getLevels().get(3).getName()).isEqualTo("Teen Lounge");
   }
}
