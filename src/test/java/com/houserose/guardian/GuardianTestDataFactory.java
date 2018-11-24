package com.houserose.guardian;

import com.houserose.guardian.model.Contact;
import com.houserose.guardian.model.Level;
import com.houserose.guardian.model.Member;
import com.houserose.guardian.model.Membership;
import com.houserose.guardian.model.Organization;
import com.houserose.guardian.model.Picture;
import com.houserose.guardian.model.Term;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import static java.util.Arrays.asList;

public class GuardianTestDataFactory {

   public static final ZonedDateTime ARISIA_2017_START = ZonedDateTime.of(2017, 1, 13, 0, 0, 0, 0, ZoneId.of("America/New_York"));
   public static final ZonedDateTime ARISIA_2018_START = ZonedDateTime.of(2018, 1, 12, 0, 0, 0, 0, ZoneId.of("America/New_York"));
   public static final ZonedDateTime ARISIA_2019_START = ZonedDateTime.of(2019, 1, 18, 0, 0, 0, 0, ZoneId.of("America/New_York"));

   public static final UUID ECR_MEMBERSHIP_TEST_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
   public static final UUID KLB_MEMBERSHIP_TEST_UUID = UUID.fromString("00000000-0000-0000-0001-000000000000");
   public static final UUID CPB_MEMBERSHIP_TEST_UUID = UUID.fromString("00000000-0000-0000-0002-000000000000");
   public static final UUID PAP_MEMBERSHIP_TEST_UUID = UUID.fromString("00000000-0000-0000-0003-000000000000");
   public static final UUID MAP_MEMBERSHIP_TEST_UUID = UUID.fromString("00000000-0000-0000-0004-000000000000");
   public static final UUID ECR_MEMBER_TEST_UUID = UUID.fromString("00000000-0000-0001-0000-000000000000");
   public static final UUID KLB_MEMBER_TEST_UUID = UUID.fromString("00000000-0000-0001-0001-000000000000");
   public static final UUID CPB_MEMBER_TEST_UUID = UUID.fromString("00000000-0000-0001-0002-000000000000");
   public static final UUID PAP_MEMBER_TEST_UUID = UUID.fromString("00000000-0000-0001-0003-000000000000");
   public static final UUID MAP_MEMBER_TEST_UUID = UUID.fromString("00000000-0000-0001-0004-000000000000");
   public static final UUID ICR_MEMBER_TEST_UUID = UUID.fromString("00000000-0000-0001-0005-000000000000");
   public static final UUID LMP_MEMBER_TEST_UUID = UUID.fromString("00000000-0000-0001-0006-000000000000");
   public static final UUID AKB_MEMBER_TEST_UUID = UUID.fromString("00000000-0000-0001-0007-000000000000");
   public static final UUID MLD_MEMBER_TEST_UUID = UUID.fromString("00000000-0000-0001-0008-000000000000");
   public static final UUID MAS_MEMBER_TEST_UUID = UUID.fromString("00000000-0000-0001-0009-000000000000");
   public static final UUID ARISIA_ORGANIZATION_TEST_UUID = UUID.fromString("00000000-0000-0002-0000-000000000000");
   public static final UUID ECR_PICTURE_TEST_UUID = UUID.fromString("00000000-0000-0003-0000-000000000000");
   public static final UUID KLB_PICTURE_TEST_UUID = UUID.fromString("00000000-0000-0003-0001-000000000000");
   public static final UUID CPB_PICTURE_TEST_UUID = UUID.fromString("00000000-0000-0003-0002-000000000000");
   public static final UUID PAP_PICTURE_TEST_UUID = UUID.fromString("00000000-0000-0003-0003-000000000000");
   public static final UUID MAP_PICTURE_TEST_UUID = UUID.fromString("00000000-0000-0003-0004-000000000000");
   public static final UUID ICR_PICTURE_TEST_UUID = UUID.fromString("00000000-0000-0003-0005-000000000000");
   public static final UUID LMP_PICTURE_TEST_UUID = UUID.fromString("00000000-0000-0003-0006-000000000000");
   public static final UUID AKB_PICTURE_TEST_UUID = UUID.fromString("00000000-0000-0003-0007-000000000000");
   public static final UUID MLD_PICTURE_TEST_UUID = UUID.fromString("00000000-0000-0003-0008-000000000000");
   public static final UUID MAS_PICTURE_TEST_UUID = UUID.fromString("00000000-0000-0003-0009-000000000000");
   public static final UUID ICR_PHONE_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0000-000000000000");
   public static final UUID ICR_SMS_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0001-000000000000");
   public static final UUID ICR_SLACK_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0002-000000000000");
   public static final UUID ICR_TWITTER_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0003-000000000000");
   public static final UUID LMP_PHONE_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0004-000000000000");
   public static final UUID LMP_SMS_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0005-000000000000");
   public static final UUID LMP_SLACK_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0006-000000000000");
   public static final UUID AKB_PHONE_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0007-000000000000");
   public static final UUID AKB_SMS_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0008-000000000000");
   public static final UUID AKB_SLACK_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0009-000000000000");
   public static final UUID MLD_PHONE_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0010-000000000000");
   public static final UUID MLD_SMS_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0011-000000000000");
   public static final UUID MLD_SLACK_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0012-000000000000");
   public static final UUID MLD_FACEBOOK_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0013-000000000000");
   public static final UUID MAS_PHONE_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0014-000000000000");
   public static final UUID MAS_SMS_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0015-000000000000");
   public static final UUID MAS_SLACK_CONTACT_TEST_UUID = UUID.fromString("00000000-0000-0004-0016-000000000000");
   public static final UUID TURTLE_LEVEL_TEST_UUID = UUID.fromString("00000000-0000-0005-0000-000000000000");
   public static final UUID SATELLITE_LEVEL_TEST_UUID = UUID.fromString("00000000-0000-0005-0001-000000000000");
   public static final UUID COMET_TEST_UUID = UUID.fromString("00000000-0000-0005-0002-000000000000");
   public static final UUID TEEN_TEST_UUID = UUID.fromString("00000000-0000-0005-0003-000000000000");
   public static final UUID ARISIA_2017_TERM_TEST_UUID = UUID.fromString("00000000-0000-0006-0000-000000000000");
   public static final UUID ARISIA_2018_TERM_TEST_UUID = UUID.fromString("00000000-0000-0006-0001-000000000000");
   public static final UUID ARISIA_2019_TERM_TEST_UUID = UUID.fromString("00000000-0000-0006-0002-000000000000");

   public static Contact.ContactBuilder ianCooperRosePhoneContact() {
      return Contact.builder()
              .id(ICR_PHONE_CONTACT_TEST_UUID)
              .type("phone")
              .value("(413) 626-6101")
              .contactOrder(1L)
              .notificationOrder(0L);
   }

   public static Contact.ContactBuilder ianCooperRoseSmsContact() {
      return Contact.builder()
              .id(ICR_SMS_CONTACT_TEST_UUID)
              .type("sms")
              .value("(413) 626-6101")
              .contactOrder(2L)
              .notificationOrder(1L);
   }

   public static Contact.ContactBuilder ianCooperRoseSlackContact() {
      return Contact.builder()
              .id(ICR_SLACK_CONTACT_TEST_UUID)
              .type("slack")
              .value("POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX")
              .contactOrder(3L)
              .notificationOrder(2L);
   }

   public static Contact.ContactBuilder ianCooperRoseTwitterContact() {
      return Contact.builder()
              .id(ICR_TWITTER_CONTACT_TEST_UUID)
              .type("twitter")
              .value("ian.cooper.rose")
              .contactOrder(0L)
              .notificationOrder(3L);
   }

   public static Contact.ContactBuilder laurelMariePickardDefaultPhoneContact() {
      return Contact.builder()
              .id(LMP_PHONE_CONTACT_TEST_UUID)
              .type("phone")
              .value("(860) 558-9530")
              .contactOrder(1L)
              .notificationOrder(0L);
   }

   public static Contact.ContactBuilder laurelMariePickardDefaultTxtContact() {
      return Contact.builder()
              .id(LMP_SMS_CONTACT_TEST_UUID)
              .type("sms")
              .value("(860) 558-9530")
              .contactOrder(2L)
              .notificationOrder(1L);
   }

   public static Contact.ContactBuilder laurelMariePickardDefaultSlackContact() {
      return Contact.builder()
              .id(LMP_SLACK_CONTACT_TEST_UUID)
              .type("slack")
              .value("POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX")
              .contactOrder(3L)
              .notificationOrder(2L);
   }

   public static Contact.ContactBuilder aimeeKatherinBouchardDefaultPhoneContact() {
      return Contact.builder()
              .id(AKB_PHONE_CONTACT_TEST_UUID)
              .type("phone")
              .value("(860) 841-2322")
              .contactOrder(1L)
              .notificationOrder(0L);
   }

   public static Contact.ContactBuilder aimeeKatherinBouchardDefaultTxtContact() {
      return Contact.builder()
              .id(AKB_SMS_CONTACT_TEST_UUID)
              .type("sms")
              .value("(860) 841-2322")
              .contactOrder(2L)
              .notificationOrder(1L);
   }

   public static Contact.ContactBuilder aimeeKatherinBouchardDefaultSlackContact() {
      return Contact.builder()
              .id(AKB_SLACK_CONTACT_TEST_UUID)
              .type("slack")
              .value("POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX")
              .contactOrder(3L)
              .notificationOrder(2L);
   }

   public static Contact.ContactBuilder michelleLouiseDriscollDefaultPhoneContact() {
      return Contact.builder()
              .id(MLD_PHONE_CONTACT_TEST_UUID)
              .type("phone")
              .value("(860) 977-3131")
              .contactOrder(1L)
              .notificationOrder(0L);
   }

   public static Contact.ContactBuilder michelleLouiseDriscollDefaultTxtContact() {
      return Contact.builder()
              .id(MLD_SMS_CONTACT_TEST_UUID)
              .type("sms")
              .value("(860) 977-3131")
              .contactOrder(2L)
              .notificationOrder(1L);
   }

   public static Contact.ContactBuilder michelleLouiseDriscollDefaultSlackContact() {
      return Contact.builder()
              .id(MLD_SLACK_CONTACT_TEST_UUID)
              .type("slack")
              .value("https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX")
              .contactOrder(3L)
              .notificationOrder(2L);
   }

   public static Contact.ContactBuilder michelleLouiseDriscollDefaultFacebookContact() {
      return Contact.builder()
              .id(MLD_FACEBOOK_CONTACT_TEST_UUID)
              .type("facebook")
              .value("9024704")
              .contactOrder(3L)
              .notificationOrder(2L);
   }

   public static Contact.ContactBuilder michaelAndrewSchneiderDefaultPhoneContact() {
      return Contact.builder()
              .id(MAS_PHONE_CONTACT_TEST_UUID)
              .type("phone")
              .value("(413) 626-9760")
              .contactOrder(1L)
              .notificationOrder(0L);
   }

   public static Contact.ContactBuilder michaelAndrewSchneiderDefaultTxtContact() {
      return Contact.builder()
              .id(MAS_SMS_CONTACT_TEST_UUID)
              .type("sms")
              .value("(413) 626-9760")
              .contactOrder(2L)
              .notificationOrder(1L);
   }

   public static Contact.ContactBuilder michaelAndrewSchneiderDefaultSlackContact() {
      return Contact.builder()
              .id(MAS_SLACK_CONTACT_TEST_UUID)
              .type("slack")
              .value("https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX")
              .contactOrder(3L)
              .notificationOrder(2L);
   }

   public static Picture.PictureBuilder elizabethCooperRoseDefaultProfilePicture() {
      return Picture.builder()
              .id(ECR_PICTURE_TEST_UUID)
              .type("profile")
              .isDefault(true)
              .name("elizabeth_cooper_rose.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/1")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L);
   }

   public static Picture.PictureBuilder kathleenLouiseBouchardDefaultProfilePicture() {
      return Picture.builder()
              .id(KLB_PICTURE_TEST_UUID)
              .type("profile")
              .isDefault(true)
              .name("kathleen_louise_bouchard.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/2")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L);
   }

   public static Picture.PictureBuilder connorPaulBouchardDefaultProfilePicture() {
      return Picture.builder()
              .id(CPB_PICTURE_TEST_UUID)
              .type("profile")
              .isDefault(true)
              .name("connor_paul_bouchard.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/3")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L);
   }

   public static Picture.PictureBuilder penelopeAdaPickardDefaultProfilePicture() {
      return Picture.builder()
              .id(PAP_PICTURE_TEST_UUID)
              .type("profile")
              .isDefault(true)
              .name("penelope_ada_pickard.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/4")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L);
   }

   public static Picture.PictureBuilder maxwellAllenPickardDefaultProfilePicture() {
      return Picture.builder()
              .id(MAP_PICTURE_TEST_UUID)
              .type("profile")
              .isDefault(true)
              .name("maxwell_allen_pickard.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/5")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L);
   }

   public static Picture.PictureBuilder laurelMariePickardDefaultProfilePicture() {
      return Picture.builder()
              .id(LMP_PICTURE_TEST_UUID)
              .type("profile")
              .isDefault(true)
              .name("laurel_marie_pickard.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/6")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L);
   }

   public static Picture.PictureBuilder ianCooperRoseDefaultProfilePicture() {
      return Picture.builder()
              .id(ICR_PICTURE_TEST_UUID)
              .type("profile")
              .isDefault(true)
              .name("ian_cooper_rose.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L);
   }

   public static Picture.PictureBuilder aimeeKatherineBouchardDefaultProfilePicture() {
      return Picture.builder()
              .id(AKB_PICTURE_TEST_UUID)
              .type("profile")
              .isDefault(true)
              .name("aimee_katherine_bouchard.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/8")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L);
   }

   public static Picture.PictureBuilder michelleLouiseDriscollDefaultProfilePicture() {
      return Picture.builder()
              .id(MLD_PICTURE_TEST_UUID)
              .type("profile")
              .isDefault(true)
              .name("michelle_louise_driscoll.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/9")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L);
   }

   public static Picture.PictureBuilder michaelAndrewSchneiderDefaultProfilePicture() {
      return Picture.builder()
              .id(MAS_PICTURE_TEST_UUID)
              .type("profile")
              .isDefault(true)
              .name("michael_andrew_schneider.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/10")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L);
   }

   public static Member.MemberBuilder elizabethCooperRose() {
      return Member.builder()
              .id(ECR_MEMBER_TEST_UUID)
              .firstName("Elizabeth")
              .middleName("Cooper")
              .lastName("Rose")
              .nameSuffix("II")
              .commonName("Lizzie")
              .dateOfBirth(LocalDate.of(2015, 9, 1));
   }

   public static Member.MemberBuilder kathleenLouiseBouchard() {
      return Member.builder()
              .id(KLB_MEMBER_TEST_UUID)
              .firstName("Kathleen")
              .middleName("Louise")
              .lastName("Bouchard")
              .commonName("Katie")
              .dateOfBirth(LocalDate.of(2013, 10, 9));
   }

   public static Member.MemberBuilder connorPaulBouchard() {
      return Member.builder()
              .id(CPB_MEMBER_TEST_UUID)
              .firstName("Connor")
              .middleName("Paul")
              .lastName("Bouchard")
              .commonName("Connor")
              .dateOfBirth(LocalDate.of(2011, 4, 2));
   }

   public static Member.MemberBuilder pennyAdaPickard() {
      return Member.builder()
              .id(PAP_MEMBER_TEST_UUID)
              .firstName("Penelope")
              .middleName("Ada")
              .lastName("Pickard")
              .commonName("Penny")
              .dateOfBirth(LocalDate.of(2015, 7, 20));
   }

   public static Member.MemberBuilder maxwellAllenPickard() {
      return Member.builder()
              .id(MAP_MEMBER_TEST_UUID)
              .firstName("Maxwell")
              .middleName("Allen")
              .lastName("Pickard")
              .commonName("Max")
              .dateOfBirth(LocalDate.of(2018, 6, 18));
   }

   public static Member.MemberBuilder laurelMariePickard() {
      return Member.builder()
              .id(LMP_MEMBER_TEST_UUID)
              .firstName("Laurel")
              .middleName("Marie")
              .lastName("Pickard")
              .commonName("Laurel")
              .dateOfBirth(LocalDate.of(1982, 10, 18));
   }

   public static Member.MemberBuilder ianCooperRose() {
      return Member.builder()
              .id(ICR_MEMBER_TEST_UUID)
              .firstName("Ian")
              .middleName("Cooper")
              .lastName("Rose")
              .commonName("Ian")
              .dateOfBirth(LocalDate.of(1969, 12, 22));
   }

   public static Member.MemberBuilder aimeeKatherineBouchard() {
      return Member.builder()
              .id(AKB_MEMBER_TEST_UUID)
              .firstName("Aimee")
              .middleName("Katherine")
              .lastName("Bouchard")
              .commonName("Aimee")
              .dateOfBirth(LocalDate.of(1980, 7, 29));
   }

   public static Member.MemberBuilder michelleLouiseDriscoll() {
      return Member.builder()
              .id(MLD_MEMBER_TEST_UUID)
              .firstName("Michelle")
              .middleName("Louise")
              .lastName("Driscoll")
              .commonName("Michelle")
              .dateOfBirth(LocalDate.of(1979, 5, 6));
   }

   public static Member.MemberBuilder michaelAndrewSchneider() {
      return Member.builder()
              .id(MAS_MEMBER_TEST_UUID)
              .firstName("Michael")
              .middleName("Andrew")
              .lastName("Schneider")
              .commonName("Micah")
              .dateOfBirth(LocalDate.of(1971, 6, 18));
   }

   public static Organization.OrganizationBuilder arisiaOrganization() {
      return Organization.builder()
              .id(ARISIA_ORGANIZATION_TEST_UUID)
              .name("Arisia");
   }

   public static Term.TermBuilder arisia2017Term() {
      return Term.builder()
              .id(ARISIA_2017_TERM_TEST_UUID)
              .start(ARISIA_2017_START)
              .duration(4L);
   }

   public static Term.TermBuilder arisia2018Term() {
      return Term.builder()
              .id(ARISIA_2018_TERM_TEST_UUID)
              .start(ARISIA_2018_START)
              .duration(4L);
   }

   public static Term.TermBuilder arisia2019Term() {
      return Term.builder()
              .id(ARISIA_2019_TERM_TEST_UUID)
              .start(ARISIA_2019_START)
              .duration(4L);
   }

   public static Level.LevelBuilder turtleLevel() {
      return Level.builder()
              .id(TURTLE_LEVEL_TEST_UUID)
              .name("Turtle Track");
   }

   public static Level.LevelBuilder satelliteLevel() {
      return Level.builder()
              .id(SATELLITE_LEVEL_TEST_UUID)
              .name("Fast Track - Satellite");
   }

   public static Level.LevelBuilder cometLevel() {
      return Level.builder()
              .id(COMET_TEST_UUID)
              .name("Fast Track - Comet");
   }

   public static Level.LevelBuilder teenLevel() {
      return Level.builder()
              .id(TEEN_TEST_UUID)
              .name("Teen Lounge");
   }

   public static Membership.MembershipBuilder elizabethCooperRoseMembership() {
      return Membership.builder()
              .id(ECR_MEMBERSHIP_TEST_UUID)
              .level(turtleLevel().build())
              .term(arisia2019Term().build())
              .created(ZonedDateTime.of(2018, 8, 25, 17, 53, 37, 0, ZoneId.of("EST5EDT")));
   }

   public static Membership.MembershipBuilder kathleenLouiseBouchardMembership() {
      return Membership.builder()
              .id(KLB_MEMBERSHIP_TEST_UUID)
              .level(satelliteLevel().build())
              .term(arisia2019Term().build())
              .created(ZonedDateTime.of(2018, 8, 25, 17, 54, 12, 0, ZoneId.of("EST5EDT")));
   }

   public static Membership.MembershipBuilder connorPaulBouchardMembership() {
      return Membership.builder()
              .id(CPB_MEMBERSHIP_TEST_UUID)
              .level(cometLevel().build())
              .term(arisia2019Term().build())
              .created(ZonedDateTime.of(2018, 8, 25, 17, 54, 41, 0, ZoneId.of("EST5EDT")));
   }

   public static Membership.MembershipBuilder penelopeAdaPickardMembership() {
      return Membership.builder()
              .id(PAP_MEMBERSHIP_TEST_UUID)
              .level(turtleLevel().build())
              .term(arisia2019Term().build())
              .created(ZonedDateTime.of(2018, 8, 25, 17, 55, 3, 0, ZoneId.of("EST5EDT")));
   }

   public static Membership.MembershipBuilder maxwellAllenPickardMembership() {
      return Membership.builder()
              .id(MAP_MEMBERSHIP_TEST_UUID)
              .level(turtleLevel().build())
              .term(arisia2019Term().build())
              .created(ZonedDateTime.of(2018, 8, 25, 17, 56, 0, 0, ZoneId.of("EST5EDT")));
   }
}
