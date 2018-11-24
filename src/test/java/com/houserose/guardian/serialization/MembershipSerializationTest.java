package com.houserose.guardian.serialization;

import com.houserose.guardian.model.Member;
import com.houserose.guardian.model.Membership;
import com.houserose.guardian.model.Organization;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URI;

import static com.houserose.guardian.GuardianTestDataFactory.ECR_MEMBERSHIP_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.arisiaOrganization;
import static com.houserose.guardian.GuardianTestDataFactory.elizabethCooperRose;
import static com.houserose.guardian.GuardianTestDataFactory.elizabethCooperRoseDefaultProfilePicture;
import static com.houserose.guardian.GuardianTestDataFactory.elizabethCooperRoseMembership;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRose;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseDefaultProfilePicture;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRosePhoneContact;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseSlackContact;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseSmsContact;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseTwitterContact;
import static com.houserose.guardian.GuardianTestDataFactory.laurelMariePickard;
import static com.houserose.guardian.GuardianTestDataFactory.laurelMariePickardDefaultPhoneContact;
import static com.houserose.guardian.GuardianTestDataFactory.laurelMariePickardDefaultProfilePicture;
import static com.houserose.guardian.GuardianTestDataFactory.laurelMariePickardDefaultSlackContact;
import static com.houserose.guardian.GuardianTestDataFactory.laurelMariePickardDefaultTxtContact;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class MembershipSerializationTest {

   @Autowired
   private JacksonTester<Membership> json;

   private Membership subject;

   @Before
   public void setUp() {
      Member ecr = elizabethCooperRose().build();
      ecr.addPicture(elizabethCooperRoseDefaultProfilePicture().build());
      Member icr = ianCooperRose().build();
      icr.addPicture(ianCooperRoseDefaultProfilePicture().build());
      icr.addContact(ianCooperRosePhoneContact().build());
      icr.addContact(ianCooperRoseSmsContact().build());
      icr.addContact(ianCooperRoseSlackContact().build());
      icr.addContact(ianCooperRoseTwitterContact().build());
      Member lmp = laurelMariePickard().build();
      lmp.addPicture(laurelMariePickardDefaultProfilePicture().build());
      lmp.addContact(laurelMariePickardDefaultPhoneContact().build());
      lmp.addContact(laurelMariePickardDefaultTxtContact().build());
      lmp.addContact(laurelMariePickardDefaultSlackContact().build());

      Organization arisia = arisiaOrganization().build();

      subject = elizabethCooperRoseMembership().build();
      subject.addMembershipMember(ecr, "ward");
      subject.addMembershipMember(icr, "guardian");
      subject.addMembershipMember(lmp, "guardian");
//      subject.setOrganization(arisia);

      arisia.addMembership(subject);
   }

   @Test
   public void serializationTest() throws IOException {

      System.out.println(this.json.write(subject));

      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.created")
              .isEqualTo("2018-08-25T17:53:37-04:00");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.id")
              .isEqualTo("00000000-0000-0000-0000-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.level.id")
              .isEqualTo("00000000-0000-0005-0000-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.level.name")
              .isEqualTo("Turtle Track");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.term.id")
              .isEqualTo("00000000-0000-0006-0002-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.term.start")
              .isEqualTo("2019-01-18T00:00:00-05:00");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.organization.id")
              .isEqualTo("00000000-0000-0002-0000-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.organization.name")
              .isEqualTo("Arisia");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.membershipMembers[0].membership")
              .isEqualTo("00000000-0000-0000-0000-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.membershipMembers[0].member")
              .isEqualTo("00000000-0000-0001-0000-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.membershipMembers[0].type")
              .isEqualTo("ward");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.membershipMembers[1].member")
              .isEqualTo("00000000-0000-0001-0005-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.membershipMembers[1].type")
              .isEqualTo("guardian");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.membershipMembers[2].member")
              .isEqualTo("00000000-0000-0001-0006-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.membershipMembers[2].type")
              .isEqualTo("guardian");
   }

   @Test
   public void deserializationTest() throws IOException {
      String content = "{\"id\":\"00000000-0000-0000-0000-000000000000\",\"created\":\"2018-08-25T17:53:37-04:00\",\"level\":{\"id\":\"00000000-0000-0005-0000-000000000000\",\"name\":\"Turtle Track\",\"memberships\":[],\"organization\":null},\"term\":{\"id\":\"00000000-0000-0006-0002-000000000000\",\"start\":\"2019-01-18T00:00:00-05:00\",\"duration\":4,\"memberships\":[],\"organization\":null},\"organization\":{\"id\":\"00000000-0000-0002-0000-000000000000\",\"name\":\"Arisia\",\"terms\":[{\"id\":\"00000000-0000-0006-0000-000000000000\",\"start\":\"2017-01-13T00:00:00-05:00\",\"duration\":4,\"memberships\":[],\"organization\":null},{\"id\":\"00000000-0000-0006-0001-000000000000\",\"start\":\"2018-01-12T00:00:00-05:00\",\"duration\":4,\"memberships\":[],\"organization\":null},{\"id\":\"00000000-0000-0006-0002-000000000000\",\"start\":\"2019-01-18T00:00:00-05:00\",\"duration\":4,\"memberships\":[],\"organization\":null}],\"levels\":[{\"id\":\"00000000-0000-0005-0000-000000000000\",\"name\":\"Turtle Track\",\"memberships\":[],\"organization\":null},{\"id\":\"00000000-0000-0005-0001-000000000000\",\"name\":\"Fast Track - Satellite\",\"memberships\":[],\"organization\":null},{\"id\":\"00000000-0000-0005-0002-000000000000\",\"name\":\"Fast Track - Comet\",\"memberships\":[],\"organization\":null},{\"id\":\"00000000-0000-0005-0003-000000000000\",\"name\":\"Teen Lounge\",\"memberships\":[],\"organization\":null}],\"memberships\":[{\"id\":\"00000000-0000-0000-0000-000000000000\",\"created\":\"2018-08-25T17:53:37-04:00\",\"level\":\"00000000-0000-0005-0000-000000000000\",\"term\":\"00000000-0000-0006-0002-000000000000\",\"organization\":\"00000000-0000-0002-0000-000000000000\",\"membershipMembers\":[{\"id\":null,\"membership\":{\"id\":\"00000000-0000-0000-0000-000000000000\",\"created\":\"2018-08-25T17:53:37-04:00\",\"level\":\"00000000-0000-0005-0000-000000000000\",\"term\":\"00000000-0000-0006-0002-000000000000\",\"organization\":\"00000000-0000-0002-0000-000000000000\",\"membershipMembers\":[{\"id\":null,\"membership\":\"00000000-0000-0000-0000-000000000000\",\"member\":{\"id\":\"00000000-0000-0001-0000-000000000000\",\"firstName\":\"Elizabeth\",\"middleName\":\"Cooper\",\"lastName\":\"Rose\",\"nameSuffix\":\"II\",\"commonName\":\"Lizzie\",\"dateOfBirth\":\"2015-09-01\",\"pictures\":[{\"id\":\"00000000-0000-0003-0000-000000000000\",\"type\":\"profile\",\"isDefault\":true,\"name\":\"elizabeth_cooper_rose.jpeg\",\"uri\":\"http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/1\",\"mediaType\":\"image/jpeg\",\"height\":300,\"width\":300,\"member\":\"00000000-0000-0001-0000-000000000000\"}],\"contacts\":[],\"membershipMembers\":[{\"id\":null,\"membership\":\"00000000-0000-0000-0000-000000000000\",\"member\":\"00000000-0000-0001-0000-000000000000\",\"type\":\"ward\"}]},\"type\":\"ward\"},{\"id\":null,\"membership\":\"00000000-0000-0000-0000-000000000000\",\"member\":{\"id\":\"00000000-0000-0001-0005-000000000000\",\"firstName\":\"Ian\",\"middleName\":\"Cooper\",\"lastName\":\"Rose\",\"nameSuffix\":null,\"commonName\":\"Ian\",\"dateOfBirth\":\"1969-12-22\",\"pictures\":[{\"id\":\"00000000-0000-0003-0005-000000000000\",\"type\":\"profile\",\"isDefault\":true,\"name\":\"ian_cooper_rose.jpeg\",\"uri\":\"http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7\",\"mediaType\":\"image/jpeg\",\"height\":300,\"width\":300,\"member\":\"00000000-0000-0001-0005-000000000000\"}],\"contacts\":[{\"id\":\"00000000-0000-0004-0000-000000000000\",\"type\":\"phone\",\"value\":\"(413) 626-6101\",\"contactOrder\":1,\"notificationOrder\":0,\"member\":\"00000000-0000-0001-0005-000000000000\"},{\"id\":\"00000000-0000-0004-0001-000000000000\",\"type\":\"sms\",\"value\":\"(413) 626-6101\",\"contactOrder\":2,\"notificationOrder\":1,\"member\":\"00000000-0000-0001-0005-000000000000\"},{\"id\":\"00000000-0000-0004-0002-000000000000\",\"type\":\"slack\",\"value\":\"POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX\",\"contactOrder\":3,\"notificationOrder\":2,\"member\":\"00000000-0000-0001-0005-000000000000\"},{\"id\":\"00000000-0000-0004-0003-000000000000\",\"type\":\"twitter\",\"value\":\"ian.cooper.rose\",\"contactOrder\":0,\"notificationOrder\":3,\"member\":\"00000000-0000-0001-0005-000000000000\"}],\"membershipMembers\":[{\"id\":null,\"membership\":\"00000000-0000-0000-0000-000000000000\",\"member\":\"00000000-0000-0001-0005-000000000000\",\"type\":\"guardian\"}]},\"type\":\"guardian\"},{\"id\":null,\"membership\":\"00000000-0000-0000-0000-000000000000\",\"member\":{\"id\":\"00000000-0000-0001-0006-000000000000\",\"firstName\":\"Laurel\",\"middleName\":\"Marie\",\"lastName\":\"Pickard\",\"nameSuffix\":null,\"commonName\":\"Laurel\",\"dateOfBirth\":\"1982-10-18\",\"pictures\":[{\"id\":\"00000000-0000-0003-0006-000000000000\",\"type\":\"profile\",\"isDefault\":true,\"name\":\"laurel_marie_pickard.jpeg\",\"uri\":\"http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/6\",\"mediaType\":\"image/jpeg\",\"height\":300,\"width\":300,\"member\":\"00000000-0000-0001-0006-000000000000\"}],\"contacts\":[{\"id\":\"00000000-0000-0004-0004-000000000000\",\"type\":\"phone\",\"value\":\"(860) 558-9530\",\"contactOrder\":1,\"notificationOrder\":0,\"member\":\"00000000-0000-0001-0006-000000000000\"},{\"id\":\"00000000-0000-0004-0005-000000000000\",\"type\":\"sms\",\"value\":\"(860) 558-9530\",\"contactOrder\":2,\"notificationOrder\":1,\"member\":\"00000000-0000-0001-0006-000000000000\"},{\"id\":\"00000000-0000-0004-0006-000000000000\",\"type\":\"slack\",\"value\":\"POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX\",\"contactOrder\":3,\"notificationOrder\":2,\"member\":\"00000000-0000-0001-0006-000000000000\"}],\"membershipMembers\":[{\"id\":null,\"membership\":\"00000000-0000-0000-0000-000000000000\",\"member\":\"00000000-0000-0001-0006-000000000000\",\"type\":\"guardian\"}]},\"type\":\"guardian\"}]},\"member\":\"00000000-0000-0001-0000-000000000000\",\"type\":\"ward\"},{\"id\":null,\"membership\":\"00000000-0000-0000-0000-000000000000\",\"member\":\"00000000-0000-0001-0005-000000000000\",\"type\":\"guardian\"},{\"id\":null,\"membership\":\"00000000-0000-0000-0000-000000000000\",\"member\":\"00000000-0000-0001-0006-000000000000\",\"type\":\"guardian\"}]}]},\"membershipMembers\":[{\"id\":null,\"membership\":\"00000000-0000-0000-0000-000000000000\",\"member\":\"00000000-0000-0001-0000-000000000000\",\"type\":\"ward\"},{\"id\":null,\"membership\":\"00000000-0000-0000-0000-000000000000\",\"member\":\"00000000-0000-0001-0005-000000000000\",\"type\":\"guardian\"},{\"id\":null,\"membership\":\"00000000-0000-0000-0000-000000000000\",\"member\":\"00000000-0000-0001-0006-000000000000\",\"type\":\"guardian\"}]}";
      assertThat(this.json.parseObject(content).getId()).isEqualTo(ECR_MEMBERSHIP_TEST_UUID);
//      assertThat(this.json.parseObject(content).getMembershipMembers().get(0).getId()).isEqualTo(1);
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
