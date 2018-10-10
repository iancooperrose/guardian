package com.houserose.guardian.serialization;

import com.houserose.guardian.model.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;

import static com.houserose.guardian.GuardianTestDataFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class MemberSerializationTest {

   @Autowired
   private JacksonTester<Member> json;

   @Test
   public void serializationTest() throws IOException {

      System.out.println(this.json.write(ianCooperRose().build()));

      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathNumberValue("@.id")
              .isEqualTo(7);
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathStringValue("@.firstName")
              .isEqualTo("Ian");
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathStringValue("@.middleName")
              .isEqualTo("Cooper");
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathStringValue("@.lastName")
              .isEqualTo("Rose");
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathStringValue("@.nameSuffix")
              .isEqualTo(null);
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathStringValue("@.commonName")
              .isEqualTo("Ian");
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathStringValue("@.dateOfBirth")
              .isEqualTo("1969-12-22");
//      assertThat(this.json.write(ianCooperRose().build()))
//              .extractingJsonPathNumberValue("@.pictures[0].id")
//              .isEqualTo(7);
//      assertThat(this.json.write(ianCooperRose().build()))
//              .extractingJsonPathStringValue("@.pictures[0].name")
//              .isEqualTo("ian_cooper_rose.jpeg");
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathNumberValue("@.contacts[0].id")
              .isEqualTo(1);
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathStringValue("@.contacts[0].type")
              .isEqualTo("phone");
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathNumberValue("@.contacts[1].id")
              .isEqualTo(2);
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathStringValue("@.contacts[1].type")
              .isEqualTo("txt");
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathNumberValue("@.contacts[2].id")
              .isEqualTo(3);
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathStringValue("@.contacts[2].type")
              .isEqualTo("slack");
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathNumberValue("@.contacts[3].id")
              .isEqualTo(4);
      assertThat(this.json.write(ianCooperRose().build()))
              .extractingJsonPathStringValue("@.contacts[3].type")
              .isEqualTo("twitter");
   }

   @Test
   public void deserializationTest() throws IOException {
      String content = "{\"id\":7,\"firstName\":\"Ian\",\"middleName\":\"Cooper\",\"lastName\":\"Rose\",\"nameSuffix\":null,\"commonName\":\"Ian\",\"dateOfBirth\":\"1969-12-22\",\"pictures\":[{\"id\":7,\"type\":\"profile\",\"isDefault\":true,\"name\":\"ian_cooper_rose.jpeg\",\"uri\":\"http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7\",\"mediaType\":\"image/jpeg\",\"height\":300,\"width\":300,\"timeAdded\":\"2018-08-18T04:32:23\"}],\"contacts\":[{\"id\":1,\"type\":\"phone\",\"value\":\"(413) 626-6101\",\"contactOrder\":1,\"notificationOrder\":0},{\"id\":2,\"type\":\"txt\",\"value\":\"(413) 626-6101\",\"contactOrder\":2,\"notificationOrder\":1},{\"id\":3,\"type\":\"slack\",\"value\":\"POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX\",\"contactOrder\":3,\"notificationOrder\":2},{\"id\":4,\"type\":\"twitter\",\"value\":\"ian.cooper.rose\",\"contactOrder\":0,\"notificationOrder\":3}]}";
      assertThat(this.json.parseObject(content).getId()).isEqualTo(7L);
      assertThat(this.json.parseObject(content).getFirstName()).isEqualTo("Ian");
      assertThat(this.json.parseObject(content).getMiddleName()).isEqualTo("Cooper");
      assertThat(this.json.parseObject(content).getLastName()).isEqualTo("Rose");

      assertThat(this.json.parseObject(content).getNameSuffix()).isEqualTo(null);
      assertThat(this.json.parseObject(content).getCommonName()).isEqualTo("Ian");
      assertThat(this.json.parseObject(content).getDateOfBirth()).isEqualTo(LocalDate.of(1969,12,22));
//      assertThat(this.json.parseObject(content).getPictures().get(0).getId()).isEqualTo(7L);
//      assertThat(this.json.parseObject(content).getPictures().get(0).getName()).isEqualTo("ian_cooper_rose.jpeg");
//      assertThat(this.json.parseObject(content).getContacts().get(0).getId()).isEqualTo(1L);
//      assertThat(this.json.parseObject(content).getContacts().get(0).getType()).isEqualTo("phone");
//      assertThat(this.json.parseObject(content).getContacts().get(1).getId()).isEqualTo(2L);
//      assertThat(this.json.parseObject(content).getContacts().get(1).getType()).isEqualTo("txt");
//      assertThat(this.json.parseObject(content).getContacts().get(2).getId()).isEqualTo(3L);
//      assertThat(this.json.parseObject(content).getContacts().get(2).getType()).isEqualTo("slack");
//      assertThat(this.json.parseObject(content).getContacts().get(3).getId()).isEqualTo(4L);
//      assertThat(this.json.parseObject(content).getContacts().get(3).getType()).isEqualTo("twitter");
   }
}
