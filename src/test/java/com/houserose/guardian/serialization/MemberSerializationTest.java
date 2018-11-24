package com.houserose.guardian.serialization;

import com.houserose.guardian.model.Contact;
import com.houserose.guardian.model.Member;
import com.houserose.guardian.model.MembershipMember;
import com.houserose.guardian.model.Picture;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.houserose.guardian.GuardianTestDataFactory.ICR_MEMBER_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.ICR_PHONE_CONTACT_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.ICR_PICTURE_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.ICR_SLACK_CONTACT_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.ICR_SMS_CONTACT_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.ICR_TWITTER_CONTACT_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.elizabethCooperRose;
import static com.houserose.guardian.GuardianTestDataFactory.elizabethCooperRoseMembership;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRose;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseDefaultProfilePicture;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRosePhoneContact;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseSlackContact;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseSmsContact;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseTwitterContact;
import static com.houserose.guardian.GuardianTestDataFactory.kathleenLouiseBouchardMembership;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class MemberSerializationTest {

   @Autowired
   private JacksonTester<Member> json;

   private Member subject;

   @Before
   public void setUp() {
      List<Picture> pictureList = new ArrayList<>();
      pictureList.add(ianCooperRoseDefaultProfilePicture().build());

      List<Contact> contactList = new ArrayList<>();
      contactList.add(ianCooperRosePhoneContact().build());
      contactList.add(ianCooperRoseSmsContact().build());
      contactList.add(ianCooperRoseSlackContact().build());
      contactList.add(ianCooperRoseTwitterContact().build());

      List<MembershipMember> memberMembershipMemberList = new ArrayList<>();
      memberMembershipMemberList.add(MembershipMember.builder()
              .type("guardian")
              .membership(elizabethCooperRoseMembership().build())
              .member(ianCooperRose().build())
              .build());

      List<MembershipMember> membershipMembershipMemberList = new ArrayList<>();
      membershipMembershipMemberList.add(MembershipMember.builder()
              .type("ward")
              .membership(elizabethCooperRoseMembership().build())
              .member(elizabethCooperRose().build())
              .build());
      membershipMembershipMemberList.add(MembershipMember.builder()
              .type("guardian")
              .membership(elizabethCooperRoseMembership().build())
              .member(ianCooperRose().build())
              .build());

      List<MembershipMember> membershipMemberList = new ArrayList<>();
      membershipMemberList.add(MembershipMember.builder()
              .type("guardian")
              .membership(elizabethCooperRoseMembership().membershipMembers(membershipMembershipMemberList).build())
              .member(ianCooperRose().membershipMembers(memberMembershipMemberList).build())
              .build());

      subject = ianCooperRose()
              .pictures(pictureList)
              .contacts(contactList)
              .membershipMembers(membershipMemberList)
              .build();

//      subject.addMembershipMember(elizabethCooperRoseMembership().build(), "guardian");
//      subject.addMembershipMember(kathleenLouiseBouchardMembership().build(), "guardian");
   }

   @Test
   public void serializationTest() throws IOException {

      System.out.println(this.json.write(subject));

      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.id")
              .isEqualTo("00000000-0000-0001-0005-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.firstName")
              .isEqualTo("Ian");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.middleName")
              .isEqualTo("Cooper");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.lastName")
              .isEqualTo("Rose");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.nameSuffix")
              .isEqualTo(null);
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.commonName")
              .isEqualTo("Ian");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.dateOfBirth")
              .isEqualTo("1969-12-22");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.pictures[0].id")
              .isEqualTo("00000000-0000-0003-0005-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.pictures[0].name")
              .isEqualTo("ian_cooper_rose.jpeg");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.contacts[0].id")
              .isEqualTo("00000000-0000-0004-0000-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.contacts[0].type")
              .isEqualTo("phone");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.contacts[1].id")
              .isEqualTo("00000000-0000-0004-0001-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.contacts[1].type")
              .isEqualTo("sms");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.contacts[2].id")
              .isEqualTo("00000000-0000-0004-0002-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.contacts[2].type")
              .isEqualTo("slack");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.contacts[3].id")
              .isEqualTo("00000000-0000-0004-0003-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.contacts[3].type")
              .isEqualTo("twitter");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.membershipMembers[0].member.id")
              .isEqualTo("00000000-0000-0001-0005-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.membershipMembers[0].membership.id")
              .isEqualTo("00000000-0000-0000-0000-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.membershipMembers[0].type")
              .isEqualTo("guardian");
   }

   @Test
   public void deserializationTest() throws IOException {
      String content = "{\"id\":\"00000000-0000-0001-0005-000000000000\",\"firstName\":\"Ian\",\"middleName\":\"Cooper\",\"lastName\":\"Rose\",\"nameSuffix\":null,\"commonName\":\"Ian\",\"dateOfBirth\":\"1969-12-22\",\"pictures\":[{\"id\":\"00000000-0000-0003-0005-000000000000\",\"type\":\"profile\",\"isDefault\":true,\"name\":\"ian_cooper_rose.jpeg\",\"uri\":\"http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7\",\"mediaType\":\"image/jpeg\",\"height\":300,\"width\":300,\"member\":null}],\"contacts\":[{\"id\":\"00000000-0000-0004-0000-000000000000\",\"type\":\"phone\",\"value\":\"(413) 626-6101\",\"contactOrder\":1,\"notificationOrder\":0,\"member\":null},{\"id\":\"00000000-0000-0004-0001-000000000000\",\"type\":\"sms\",\"value\":\"(413) 626-6101\",\"contactOrder\":2,\"notificationOrder\":1,\"member\":null},{\"id\":\"00000000-0000-0004-0002-000000000000\",\"type\":\"slack\",\"value\":\"POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX\",\"contactOrder\":3,\"notificationOrder\":2,\"member\":null},{\"id\":\"00000000-0000-0004-0003-000000000000\",\"type\":\"twitter\",\"value\":\"ian.cooper.rose\",\"contactOrder\":0,\"notificationOrder\":3,\"member\":null}],\"membershipMembers\":[{\"id\":null,\"membership\":{\"id\":\"00000000-0000-0000-0000-000000000000\",\"created\":\"2018-08-25T17:53:37-04:00\",\"level\":{\"id\":\"00000000-0000-0005-0000-000000000000\",\"name\":\"Turtle Track\",\"memberships\":[],\"organization\":null},\"term\":{\"id\":\"00000000-0000-0006-0002-000000000000\",\"start\":\"2019-01-18T00:00:00-05:00\",\"duration\":4,\"memberships\":[],\"organization\":null},\"organization\":null,\"membershipMembers\":[{\"id\":null,\"membership\":{\"id\":\"00000000-0000-0000-0000-000000000000\",\"created\":\"2018-08-25T17:53:37-04:00\",\"level\":{\"id\":\"00000000-0000-0005-0000-000000000000\",\"name\":\"Turtle Track\",\"memberships\":[],\"organization\":null},\"term\":{\"id\":\"00000000-0000-0006-0002-000000000000\",\"start\":\"2019-01-18T00:00:00-05:00\",\"duration\":4,\"memberships\":[],\"organization\":null},\"organization\":null,\"membershipMembers\":[]},\"member\":{\"id\":\"00000000-0000-0001-0000-000000000000\",\"firstName\":\"Elizabeth\",\"middleName\":\"Cooper\",\"lastName\":\"Rose\",\"nameSuffix\":\"II\",\"commonName\":\"Lizzie\",\"dateOfBirth\":\"2015-09-01\",\"pictures\":[],\"contacts\":[],\"membershipMembers\":[]},\"type\":\"ward\"},{\"id\":null,\"membership\":{\"id\":\"00000000-0000-0000-0000-000000000000\",\"created\":\"2018-08-25T17:53:37-04:00\",\"level\":{\"id\":\"00000000-0000-0005-0000-000000000000\",\"name\":\"Turtle Track\",\"memberships\":[],\"organization\":null},\"term\":{\"id\":\"00000000-0000-0006-0002-000000000000\",\"start\":\"2019-01-18T00:00:00-05:00\",\"duration\":4,\"memberships\":[],\"organization\":null},\"organization\":null,\"membershipMembers\":[]},\"member\":{\"id\":\"00000000-0000-0001-0005-000000000000\",\"firstName\":\"Ian\",\"middleName\":\"Cooper\",\"lastName\":\"Rose\",\"nameSuffix\":null,\"commonName\":\"Ian\",\"dateOfBirth\":\"1969-12-22\",\"pictures\":[],\"contacts\":[],\"membershipMembers\":[]},\"type\":\"guardian\"}]},\"member\":{\"id\":\"00000000-0000-0001-0005-000000000000\",\"firstName\":\"Ian\",\"middleName\":\"Cooper\",\"lastName\":\"Rose\",\"nameSuffix\":null,\"commonName\":\"Ian\",\"dateOfBirth\":\"1969-12-22\",\"pictures\":[],\"contacts\":[],\"membershipMembers\":[{\"id\":null,\"membership\":{\"id\":\"00000000-0000-0000-0000-000000000000\",\"created\":\"2018-08-25T17:53:37-04:00\",\"level\":{\"id\":\"00000000-0000-0005-0000-000000000000\",\"name\":\"Turtle Track\",\"memberships\":[],\"organization\":null},\"term\":{\"id\":\"00000000-0000-0006-0002-000000000000\",\"start\":\"2019-01-18T00:00:00-05:00\",\"duration\":4,\"memberships\":[],\"organization\":null},\"organization\":null,\"membershipMembers\":[]},\"member\":{\"id\":\"00000000-0000-0001-0005-000000000000\",\"firstName\":\"Ian\",\"middleName\":\"Cooper\",\"lastName\":\"Rose\",\"nameSuffix\":null,\"commonName\":\"Ian\",\"dateOfBirth\":\"1969-12-22\",\"pictures\":[],\"contacts\":[],\"membershipMembers\":[]},\"type\":\"guardian\"},{\"id\":null,\"membership\":{\"id\":\"00000000-0000-0000-0001-000000000000\",\"created\":\"2018-08-25T17:54:12-04:00\",\"level\":{\"id\":\"00000000-0000-0005-0001-000000000000\",\"name\":\"Fast Track - Satellite\",\"memberships\":[],\"organization\":null},\"term\":{\"id\":\"00000000-0000-0006-0002-000000000000\",\"start\":\"2019-01-18T00:00:00-05:00\",\"duration\":4,\"memberships\":[],\"organization\":null},\"organization\":null,\"membershipMembers\":[]},\"member\":{\"id\":\"00000000-0000-0001-0005-000000000000\",\"firstName\":\"Ian\",\"middleName\":\"Cooper\",\"lastName\":\"Rose\",\"nameSuffix\":null,\"commonName\":\"Ian\",\"dateOfBirth\":\"1969-12-22\",\"pictures\":[],\"contacts\":[],\"membershipMembers\":[]},\"type\":\"guardian\"}]},\"type\":\"guardian\"}]}";
      assertThat(this.json.parseObject(content).getId()).isEqualTo(ICR_MEMBER_TEST_UUID);
      assertThat(this.json.parseObject(content).getFirstName()).isEqualTo("Ian");
      assertThat(this.json.parseObject(content).getMiddleName()).isEqualTo("Cooper");
      assertThat(this.json.parseObject(content).getLastName()).isEqualTo("Rose");
      assertThat(this.json.parseObject(content).getNameSuffix()).isEqualTo(null);
      assertThat(this.json.parseObject(content).getCommonName()).isEqualTo("Ian");
      assertThat(this.json.parseObject(content).getDateOfBirth()).isEqualTo(LocalDate.of(1969, 12, 22));
      assertThat(this.json.parseObject(content).getPictures().get(0).getId()).isEqualTo(ICR_PICTURE_TEST_UUID);
      assertThat(this.json.parseObject(content).getPictures().get(0).getName()).isEqualTo("ian_cooper_rose.jpeg");
      assertThat(this.json.parseObject(content).getContacts().get(0).getId()).isEqualTo(ICR_PHONE_CONTACT_TEST_UUID);
      assertThat(this.json.parseObject(content).getContacts().get(0).getType()).isEqualTo("phone");
      assertThat(this.json.parseObject(content).getContacts().get(1).getId()).isEqualTo(ICR_SMS_CONTACT_TEST_UUID);
      assertThat(this.json.parseObject(content).getContacts().get(1).getType()).isEqualTo("sms");
      assertThat(this.json.parseObject(content).getContacts().get(2).getId()).isEqualTo(ICR_SLACK_CONTACT_TEST_UUID);
      assertThat(this.json.parseObject(content).getContacts().get(2).getType()).isEqualTo("slack");
      assertThat(this.json.parseObject(content).getContacts().get(3).getId()).isEqualTo(ICR_TWITTER_CONTACT_TEST_UUID);
      assertThat(this.json.parseObject(content).getContacts().get(3).getType()).isEqualTo("twitter");
   }
}
