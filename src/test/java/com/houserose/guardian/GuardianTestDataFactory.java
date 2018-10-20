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

public class GuardianTestDataFactory {

   public static final ZonedDateTime ARISIA_2017_START = ZonedDateTime.of(2017, 1, 13, 0, 0, 0, 0, ZoneId.of("America/New_York"));
   public static final ZonedDateTime ARISIA_2018_START = ZonedDateTime.of(2018, 1, 12, 0, 0, 0, 0, ZoneId.of("America/New_York"));
   public static final ZonedDateTime ARISIA_2019_START = ZonedDateTime.of(2019, 1, 18, 0, 0, 0, 0, ZoneId.of("America/New_York"));
   public static final UUID ORGANIZATION_TEST_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");

   public static Contact.ContactBuilder ianCooperRoseDefaultPhoneContact() {
      return Contact.builder()
              .type("phone")
              .value("(413) 626-6101")
              .contactOrder(1L)
              .notificationOrder(0L)
              .rank(1L);
   }

   public static Contact.ContactBuilder ianCooperRoseDefaultTxtContact() {
      return Contact.builder()
              .type("txt")
              .value("(413) 626-6101")
              .contactOrder(2L)
              .notificationOrder(1L)
              .rank(2L);
   }

   public static Contact.ContactBuilder ianCooperRoseDefaultSlackContact() {
      return Contact.builder()
              .type("slack")
              .value("POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX")
              .contactOrder(3L)
              .notificationOrder(2L)
              .rank(3L);
   }

   public static Contact.ContactBuilder ianCooperRoseDefaultTwitterContact() {
      return Contact.builder()
              .type("twitter")
              .value("ian.cooper.rose")
              .contactOrder(0L)
              .notificationOrder(3L)
              .rank(4L);
   }

   public static Contact.ContactBuilder laurelMariePickardDefaultPhoneContact() {
      return Contact.builder()
              .type("phone")
              .value("(860) 558-9530")
              .contactOrder(1L)
              .notificationOrder(0L)
              .rank(1L);
   }

   public static Contact.ContactBuilder laurelMariePickardDefaultTxtContact() {
      return Contact.builder()
              .type("txt")
              .value("(860) 558-9530")
              .contactOrder(2L)
              .notificationOrder(1L)
              .rank(2L);
   }

   public static Contact.ContactBuilder laurelMariePickardDefaultSlackContact() {
      return Contact.builder()
              .type("slack")
              .value("POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX")
              .contactOrder(3L)
              .notificationOrder(2L)
              .rank(3L);
   }

   public static Contact.ContactBuilder aimeeKatherinBouchardDefaultPhoneContact() {
      return Contact.builder()
              .type("phone")
              .value("(860) 841-2322")
              .contactOrder(1L)
              .notificationOrder(0L)
              .rank(1L);
   }

   public static Contact.ContactBuilder aimeeKatherinBouchardDefaultTxtContact() {
      return Contact.builder()
              .type("txt")
              .value("(860) 841-2322")
              .contactOrder(2L)
              .notificationOrder(1L)
              .rank(2L);
   }

   public static Contact.ContactBuilder aimeeKatherinBouchardDefaultSlackContact() {
      return Contact.builder()
              .type("slack")
              .value("POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX")
              .contactOrder(3L)
              .notificationOrder(2L)
              .rank(3L);
   }

   public static Contact.ContactBuilder michelleLouiseDriscollDefaultPhoneContact() {
      return Contact.builder()
              .type("phone")
              .value("(860) 977-3131")
              .contactOrder(1L)
              .notificationOrder(0L)
              .rank(1L);
   }

   public static Contact.ContactBuilder michelleLouiseDriscollDefaultTxtContact() {
      return Contact.builder()
              .type("txt")
              .value("(860) 977-3131")
              .contactOrder(2L)
              .notificationOrder(1L)
              .rank(2L);
   }

   public static Contact.ContactBuilder michelleLouiseDriscollDefaultSlackContact() {
      return Contact.builder()
              .type("slack")
              .value("https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX")
              .contactOrder(3L)
              .notificationOrder(2L)
              .rank(3L);
   }

   public static Contact.ContactBuilder michelleLouiseDriscollDefaultFacebookContact() {
      return Contact.builder()
              .type("facebook")
              .value("9024704")
              .contactOrder(3L)
              .notificationOrder(2L)
              .rank(4L);
   }

   public static Contact.ContactBuilder michaelAndrewSchneiderDefaultPhoneContact() {
      return Contact.builder()
              .type("phone")
              .value("(413) 626-9760")
              .contactOrder(1L)
              .notificationOrder(0L)
              .rank(1L);
   }

   public static Contact.ContactBuilder michaelAndrewSchneiderDefaultTxtContact() {
      return Contact.builder()
              .type("txt")
              .value("(413) 626-9760")
              .contactOrder(2L)
              .notificationOrder(1L)
              .rank(2L);
   }

   public static Contact.ContactBuilder michaelAndrewSchneiderDefaultSlackContact() {
      return Contact.builder()
              .type("slack")
              .value("https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX")
              .contactOrder(3L)
              .notificationOrder(2L)
              .rank(3L);
   }

   public static Picture.PictureBuilder elizabethCooperRoseDefaultProfilePicture() {
      return Picture.builder()
              .type("profile")
              .isDefault(true)
              .name("elizabeth_cooper_rose.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/1")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L)
              .rank(1L);
   }

   public static Picture.PictureBuilder kathleenLouiseBouchardDefaultProfilePicture() {
      return Picture.builder()
              .type("profile")
              .isDefault(true)
              .name("kathleen_louise_bouchard.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/2")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L)
              .rank(1L);
   }

   public static Picture.PictureBuilder connorPaulBouchardDefaultProfilePicture() {
      return Picture.builder()
              .type("profile")
              .isDefault(true)
              .name("connor_paul_bouchard.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/3")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L)
              .rank(1L);
   }

   public static Picture.PictureBuilder penelopeAdaPickardDefaultProfilePicture() {
      return Picture.builder()
              .type("profile")
              .isDefault(true)
              .name("penelope_ada_pickard.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/4")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L)
              .rank(1L);
   }

   public static Picture.PictureBuilder maxwellAllenPickardDefaultProfilePicture() {
      return Picture.builder()
              .type("profile")
              .isDefault(true)
              .name("maxwell_allen_pickard.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/5")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L)
              .rank(1L);
   }

   public static Picture.PictureBuilder laurelMariePickardDefaultProfilePicture() {
      return Picture.builder()
              .type("profile")
              .isDefault(true)
              .name("laurel_marie_pickard.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/6")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L)
              .rank(1L);
   }

   public static Picture.PictureBuilder ianCooperRoseDefaultProfilePicture() {
      return Picture.builder()
              .type("profile")
              .isDefault(true)
              .name("ian_cooper_rose.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L)
              .rank(1L);
   }

   public static Picture.PictureBuilder aimeeKatherineBouchardDefaultProfilePicture() {
      return Picture.builder()
              .type("profile")
              .isDefault(true)
              .name("aimee_katherine_bouchard.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/8")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L)
              .rank(1L);
   }

   public static Picture.PictureBuilder michelleLouiseDriscollDefaultProfilePicture() {
      return Picture.builder()
              .type("profile")
              .isDefault(true)
              .name("michelle_louise_driscoll.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/9")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L)
              .rank(1L);
   }

   public static Picture.PictureBuilder michaelAndrewSchneiderDefaultProfilePicture() {
      return Picture.builder()
              .type("profile")
              .isDefault(true)
              .name("michael_andrew_schneider.jpeg")
              .uri("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/10")
              .mediaType("image/jpeg")
              .height(300L)
              .width(300L)
              .rank(1L);
   }

   public static Member.MemberBuilder elizabethCooperRose() {
      return Member.builder()
              .firstName("Elizabeth")
              .middleName("Cooper")
              .lastName("Rose")
              .nameSuffix("II")
              .commonName("Lizzie")
              .dateOfBirth(LocalDate.of(2015, 9, 1));
   }

   public static Member.MemberBuilder kathleenLouiseBouchard() {
      return Member.builder()
              .firstName("Kathleen")
              .middleName("Louise")
              .lastName("Bouchard")
              .commonName("Katie")
              .dateOfBirth(LocalDate.of(2013, 10, 9));
   }

   public static Member.MemberBuilder connorPaulBouchard() {
      return Member.builder()
              .firstName("Connor")
              .middleName("Paul")
              .lastName("Bouchard")
              .commonName("Connor")
              .dateOfBirth(LocalDate.of(2011, 4, 2));
   }

   public static Member.MemberBuilder pennyAdaPickard() {
      return Member.builder()
              .firstName("Penelope")
              .middleName("Ada")
              .lastName("Pickard")
              .commonName("Penny")
              .dateOfBirth(LocalDate.of(2015, 7, 20));
   }

   public static Member.MemberBuilder maxwellAllenPickard() {
      return Member.builder()
              .firstName("Maxwell")
              .middleName("Allen")
              .lastName("Pickard")
              .commonName("Max")
              .dateOfBirth(LocalDate.of(2018, 6, 18));
   }

   public static Member.MemberBuilder laurelMariePickard() {
      return Member.builder()
              .firstName("Laurel")
              .middleName("Marie")
              .lastName("Pickard")
              .commonName("Laurel")
              .dateOfBirth(LocalDate.of(1982, 10, 18));
   }

   public static Member.MemberBuilder ianCooperRose() {
      return Member.builder()
              .firstName("Ian")
              .middleName("Cooper")
              .lastName("Rose")
              .commonName("Ian")
              .dateOfBirth(LocalDate.of(1969, 12, 22));
   }

   public static Member.MemberBuilder aimeeKatherineBouchard() {
      return Member.builder()
              .firstName("Aimee")
              .middleName("Katherine")
              .lastName("Bouchard")
              .commonName("Aimee")
              .dateOfBirth(LocalDate.of(1980, 7, 29));
   }

   public static Member.MemberBuilder michelleLouiseDriscoll() {
      return Member.builder()
              .firstName("Michelle")
              .middleName("Louise")
              .lastName("Driscoll")
              .commonName("Michelle")
              .dateOfBirth(LocalDate.of(1979, 5, 6));
   }

   public static Member.MemberBuilder michaelAndrewSchneider() {
      return Member.builder()
              .firstName("Michael")
              .middleName("Andrew")
              .lastName("Schneider")
              .commonName("Micah")
              .dateOfBirth(LocalDate.of(1971, 6, 18));
   }

   public static Organization.OrganizationBuilder arisiaOrganization() {
      return Organization.builder()
              .id(ORGANIZATION_TEST_UUID)
              .name("Arisia");

   }

   public static Term.TermBuilder arisia2017Term() {
      return Term.builder()
              .start(ARISIA_2017_START)
              .duration(4L);
   }

   public static Term.TermBuilder arisia2018Term() {
      return Term.builder()
              .start(ARISIA_2018_START)
              .duration(4L);
   }

   public static Term.TermBuilder arisia2019Term() {
      return Term.builder()
              .start(ARISIA_2019_START)
              .duration(4L);
   }

   public static Level.LevelBuilder turtleLevel() {
      return Level.builder()
              .name("Turtle Track");
   }

   public static Level.LevelBuilder satelliteLevel() {
      return Level.builder()
              .name("Fast Track - Satellite");
   }

   public static Level.LevelBuilder cometLevel() {
      return Level.builder()
              .name("Fast Track - Comet");
   }

   public static Level.LevelBuilder teenLevel() {
      return Level.builder()
              .name("Teen Lounge");
   }

   public static Membership.MembershipBuilder elizabethCooperRoseMembership() {
      return Membership.builder()
              .level(turtleLevel().build())
              .term(arisia2019Term().build())
              .created(ZonedDateTime.of(2018, 8, 25, 17, 53, 37, 0, ZoneId.of("EST5EDT")));
   }

   public static Membership.MembershipBuilder kathleenLouiseBouchardMembership() {
      return Membership.builder()
              .level(satelliteLevel().build())
              .term(arisia2019Term().build())
              .created(ZonedDateTime.of(2018, 8, 25, 17, 54, 12, 0, ZoneId.of("EST5EDT")));
   }

   public static Membership.MembershipBuilder connorPaulBouchardMembership() {
      return Membership.builder()
              .level(cometLevel().build())
              .term(arisia2019Term().build())
              .created(ZonedDateTime.of(2018, 8, 25, 17, 54, 41, 0, ZoneId.of("EST5EDT")));
   }

   public static Membership.MembershipBuilder penelopeAdaPickardMembership() {
      return Membership.builder()
              .level(turtleLevel().build())
              .term(arisia2019Term().build())
              .created(ZonedDateTime.of(2018, 8, 25, 17, 55, 3, 0, ZoneId.of("EST5EDT")));
   }

   public static Membership.MembershipBuilder maxwellAllenPickardMembership() {
      return Membership.builder()
              .level(turtleLevel().build())
              .term(arisia2019Term().build())
              .created(ZonedDateTime.of(2018, 8, 25, 17, 56, 0, 0, ZoneId.of("EST5EDT")));
   }
}
