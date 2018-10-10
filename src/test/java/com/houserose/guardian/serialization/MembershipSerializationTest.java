package com.houserose.guardian.serialization;

import com.houserose.guardian.model.Membership;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.houserose.guardian.GuardianTestDataFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class MembershipSerializationTest {

   @Autowired
   private JacksonTester<Membership> json;

   @Test
   public void serializationTest() throws IOException {

      System.out.println(this.json.write(elizabethCooperRoseMembership().build()));
      System.out.println(this.json.write(kathleenLouiseBouchardMembership().build()));
      System.out.println(this.json.write(connorPaulBouchardMembership().build()));
      System.out.println(this.json.write(penelopeAdaPickardMembership().build()));
      System.out.println(this.json.write(maxwellAllenPickardMembership().build()));

      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathNumberValue("@.id")
              .isEqualTo(1);
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathNumberValue("@.member.id")
              .isEqualTo(1);
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.member.firstName")
              .isEqualTo("Elizabeth");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.member.middleName")
              .isEqualTo("Cooper");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.member.lastName")
              .isEqualTo("Rose");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.member.nameSuffix")
              .isEqualTo("II");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.member.commonName")
              .isEqualTo("Lizzie");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.member.dateOfBirth")
              .isEqualTo("2015-09-01");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathNumberValue("@.member.pictures[0].id")
              .isEqualTo(1);
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.member.pictures[0].name")
              .isEqualTo("elizabeth_cooper_rose.jpeg");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathNumberValue("@.guardians[0].id")
              .isEqualTo(7);
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.guardians[0].firstName")
              .isEqualTo("Ian");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.guardians[0].lastName")
              .isEqualTo("Rose");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathNumberValue("@.guardians[1].id")
              .isEqualTo(8);
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.guardians[1].firstName")
              .isEqualTo("Aimee");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.guardians[1].lastName")
              .isEqualTo("Bouchard");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathNumberValue("@.guardians[2].id")
              .isEqualTo(9);
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.guardians[2].firstName")
              .isEqualTo("Michelle");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.guardians[2].lastName")
              .isEqualTo("Driscoll");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathNumberValue("@.guardians[3].id")
              .isEqualTo(6);
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.guardians[3].firstName")
              .isEqualTo("Laurel");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.guardians[3].lastName")
              .isEqualTo("Pickard");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathNumberValue("@.guardians[4].id")
              .isEqualTo(10);
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.guardians[4].firstName")
              .isEqualTo("Michael");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.guardians[4].lastName")
              .isEqualTo("Schneider");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.term.start")
              .isEqualTo("2019-01-18");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathNumberValue("@.term.duration")
              .isEqualTo(4);
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathNumberValue("@.organization.id")
              .isEqualTo(1);
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.organization.name")
              .isEqualTo("Arisia");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.level")
              .isEqualTo("TURTLE");
      assertThat(this.json.write(elizabethCooperRoseMembership().build()))
              .extractingJsonPathStringValue("@.created")
              .isEqualTo("2018-08-25T17:53:37");
   }

   @Test
   public void deserializationTest() throws IOException {
//      String content = "{\"id\":1,\"member\":{\"id\":1,\"firstName\":\"Elizabeth\",\"middleName\":\"Cooper\",\"lastName\":\"Rose\",\"nameSuffix\":\"II\",\"commonName\":\"Lizzie\",\"dateOfBirth\":\"2015-09-01\",\"pictures\":[{\"id\":1,\"type\":\"profile\",\"isDefault\":true,\"name\":\"elizabeth_cooper_rose.jpeg\",\"uri\":\"http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/1\",\"mediaType\":\"image/jpeg\",\"height\":300,\"width\":300,\"timeAdded\":\"2018-08-18T03:27:45\"}],\"contacts\":null},\"guardians\":[{\"id\":7,\"firstName\":\"Ian\",\"middleName\":\"Cooper\",\"lastName\":\"Rose\",\"nameSuffix\":null,\"commonName\":\"Ian\",\"dateOfBirth\":\"1969-12-22\",\"pictures\":[{\"id\":7,\"type\":\"profile\",\"isDefault\":true,\"name\":\"ian_cooper_rose.jpeg\",\"uri\":\"http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7\",\"mediaType\":\"image/jpeg\",\"height\":300,\"width\":300,\"timeAdded\":\"2018-08-18T04:32:23\"}],\"contacts\":[{\"id\":1,\"type\":\"phone\",\"value\":\"(413) 626-6101\",\"contactOrder\":1,\"notificationOrder\":0},{\"id\":2,\"type\":\"txt\",\"value\":\"(413) 626-6101\",\"contactOrder\":2,\"notificationOrder\":1},{\"id\":3,\"type\":\"slack\",\"value\":\"POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX\",\"contactOrder\":3,\"notificationOrder\":2},{\"id\":4,\"type\":\"twitter\",\"value\":\"ian.cooper.rose\",\"contactOrder\":0,\"notificationOrder\":3}]},{\"id\":8,\"firstName\":\"Aimee\",\"middleName\":\"Katherine\",\"lastName\":\"Bouchard\",\"nameSuffix\":null,\"commonName\":\"Aimee\",\"dateOfBirth\":\"1980-07-29\",\"pictures\":[{\"id\":8,\"type\":\"profile\",\"isDefault\":true,\"name\":\"aimee_katherine_bouchard.jpeg\",\"uri\":\"http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/8\",\"mediaType\":\"image/jpeg\",\"height\":300,\"width\":300,\"timeAdded\":\"2018-08-18T04:33:24\"}],\"contacts\":[{\"id\":8,\"type\":\"phone\",\"value\":\"(860) 841-2322\",\"contactOrder\":1,\"notificationOrder\":0},{\"id\":9,\"type\":\"txt\",\"value\":\"(860) 841-2322\",\"contactOrder\":2,\"notificationOrder\":1},{\"id\":10,\"type\":\"slack\",\"value\":\"POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX\",\"contactOrder\":3,\"notificationOrder\":2}]},{\"id\":9,\"firstName\":\"Michelle\",\"middleName\":\"Louise\",\"lastName\":\"Driscoll\",\"nameSuffix\":null,\"commonName\":\"Michelle\",\"dateOfBirth\":\"1979-05-06\",\"pictures\":[{\"id\":9,\"type\":\"profile\",\"isDefault\":true,\"name\":\"michelle_louise_driscoll.jpeg\",\"uri\":\"http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/9\",\"mediaType\":\"image/jpeg\",\"height\":300,\"width\":300,\"timeAdded\":\"2018-08-18T04:34:15\"}],\"contacts\":[{\"id\":11,\"type\":\"phone\",\"value\":\"(860) 977-3131\",\"contactOrder\":1,\"notificationOrder\":0},{\"id\":12,\"type\":\"txt\",\"value\":\"(860) 977-3131\",\"contactOrder\":2,\"notificationOrder\":1},{\"id\":13,\"type\":\"slack\",\"value\":\"https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX\",\"contactOrder\":3,\"notificationOrder\":2},{\"id\":14,\"type\":\"facebook\",\"value\":\"9024704\",\"contactOrder\":3,\"notificationOrder\":2}]},{\"id\":6,\"firstName\":\"Laurel\",\"middleName\":\"Marie\",\"lastName\":\"Pickard\",\"nameSuffix\":null,\"commonName\":\"Laurel\",\"dateOfBirth\":\"1982-10-18\",\"pictures\":[{\"id\":6,\"type\":\"profile\",\"isDefault\":true,\"name\":\"laurel_marie_pickard.jpeg\",\"uri\":\"http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/6\",\"mediaType\":\"image/jpeg\",\"height\":300,\"width\":300,\"timeAdded\":\"2018-08-18T04:31:37\"}],\"contacts\":[{\"id\":5,\"type\":\"phone\",\"value\":\"(860) 558-9530\",\"contactOrder\":1,\"notificationOrder\":0},{\"id\":6,\"type\":\"txt\",\"value\":\"(860) 558-9530\",\"contactOrder\":2,\"notificationOrder\":1},{\"id\":7,\"type\":\"slack\",\"value\":\"POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX\",\"contactOrder\":3,\"notificationOrder\":2}]},{\"id\":10,\"firstName\":\"Michael\",\"middleName\":\"Andrew\",\"lastName\":\"Schneider\",\"nameSuffix\":null,\"commonName\":\"Micah\",\"dateOfBirth\":\"1971-06-18\",\"pictures\":[{\"id\":10,\"type\":\"profile\",\"isDefault\":true,\"name\":\"michael_andrew_schneider.jpeg\",\"uri\":\"http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/10\",\"mediaType\":\"image/jpeg\",\"height\":300,\"width\":300,\"timeAdded\":\"2018-08-18T04:35:24\"}],\"contacts\":[{\"id\":15,\"type\":\"phone\",\"value\":\"(413) 626-9760\",\"contactOrder\":1,\"notificationOrder\":0},{\"id\":16,\"type\":\"txt\",\"value\":\"(413) 626-9760\",\"contactOrder\":2,\"notificationOrder\":1},{\"id\":17,\"type\":\"slack\",\"value\":\"https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX\",\"contactOrder\":3,\"notificationOrder\":2}]}],\"term\":{\"start\":\"2019-01-18\",\"duration\":4},\"organization\":{\"id\":1,\"name\":\"Arisia\"},\"level\":\"TURTLE\",\"created\":\"2018-08-25T17:53:37\"}";
//      assertThat(this.json.parseObject(content).getId()).isEqualTo(1);
//      assertThat(this.json.parseObject(content).getMember().getId()).isEqualTo(1);
//      assertThat(this.json.parseObject(content).getMember().getFirstName()).isEqualTo("Elizabeth");
//      assertThat(this.json.parseObject(content).getMember().getMiddleName()).isEqualTo("Cooper");
//      assertThat(this.json.parseObject(content).getMember().getLastName()).isEqualTo("Rose");
//      assertThat(this.json.parseObject(content).getMember().getDateOfBirth()).isEqualTo(LocalDate.of(2015,9,1));
//      assertThat(this.json.parseObject(content).getGuardians().get(0).getId()).isEqualTo(7L);
//      assertThat(this.json.parseObject(content).getGuardians().get(0).getFirstName()).isEqualTo("Ian");
//      assertThat(this.json.parseObject(content).getGuardians().get(0).getLastName()).isEqualTo("Rose");
//      assertThat(this.json.parseObject(content).getGuardians().get(0).getPictures().get(0).getName()).isEqualTo("ian_cooper_rose.jpeg");
//      assertThat(this.json.parseObject(content).getGuardians().get(0).getContacts().get(0).getType()).isEqualTo("phone");
//      assertThat(this.json.parseObject(content).getGuardians().get(0).getContacts().get(1).getType()).isEqualTo("txt");
//      assertThat(this.json.parseObject(content).getGuardians().get(0).getContacts().get(2).getType()).isEqualTo("slack");
//      assertThat(this.json.parseObject(content).getGuardians().get(0).getContacts().get(3).getType()).isEqualTo("twitter");
//      assertThat(this.json.parseObject(content).getGuardians().get(1).getId()).isEqualTo(8L);
//      assertThat(this.json.parseObject(content).getGuardians().get(1).getFirstName()).isEqualTo("Aimee");
//      assertThat(this.json.parseObject(content).getGuardians().get(1).getLastName()).isEqualTo("Bouchard");
//      assertThat(this.json.parseObject(content).getGuardians().get(1).getPictures().get(0).getName()).isEqualTo("aimee_katherine_bouchard.jpeg");
//      assertThat(this.json.parseObject(content).getGuardians().get(1).getContacts().get(0).getType()).isEqualTo("phone");
//      assertThat(this.json.parseObject(content).getGuardians().get(2).getId()).isEqualTo(9L);
//      assertThat(this.json.parseObject(content).getGuardians().get(2).getFirstName()).isEqualTo("Michelle");
//      assertThat(this.json.parseObject(content).getGuardians().get(2).getLastName()).isEqualTo("Driscoll");
//      assertThat(this.json.parseObject(content).getGuardians().get(2).getPictures().get(0).getName()).isEqualTo("michelle_louise_driscoll.jpeg");
//      assertThat(this.json.parseObject(content).getGuardians().get(2).getContacts().get(0).getType()).isEqualTo("phone");
//      assertThat(this.json.parseObject(content).getGuardians().get(3).getId()).isEqualTo(6L);
//      assertThat(this.json.parseObject(content).getGuardians().get(3).getFirstName()).isEqualTo("Laurel");
//      assertThat(this.json.parseObject(content).getGuardians().get(3).getLastName()).isEqualTo("Pickard");
//      assertThat(this.json.parseObject(content).getGuardians().get(3).getPictures().get(0).getName()).isEqualTo("laurel_marie_pickard.jpeg");
//      assertThat(this.json.parseObject(content).getGuardians().get(3).getContacts().get(0).getType()).isEqualTo("phone");
//      assertThat(this.json.parseObject(content).getGuardians().get(4).getId()).isEqualTo(10L);
//      assertThat(this.json.parseObject(content).getGuardians().get(4).getFirstName()).isEqualTo("Michael");
//      assertThat(this.json.parseObject(content).getGuardians().get(4).getLastName()).isEqualTo("Schneider");
//      assertThat(this.json.parseObject(content).getGuardians().get(4).getPictures().get(0).getName()).isEqualTo("michael_andrew_schneider.jpeg");
//      assertThat(this.json.parseObject(content).getGuardians().get(4).getContacts().get(0).getType()).isEqualTo("phone");
//      assertThat(this.json.parseObject(content).getTerm().getStart()).isEqualTo(LocalDate.of(2019,1,18));
//      assertThat(this.json.parseObject(content).getTerm().getDuration()).isEqualTo(4);
//      assertThat(this.json.parseObject(content).getOrganization().getName()).isEqualTo("Arisia");
//      assertThat(this.json.parseObject(content).getLevel()).isEqualTo("TURTLE");
//      assertThat(this.json.parseObject(content).getCreated()).isEqualTo(LocalDateTime.of(2018,8,25,17,53,37));
   }
}
