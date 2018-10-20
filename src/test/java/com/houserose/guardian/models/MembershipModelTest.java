package com.houserose.guardian.models;

import com.houserose.guardian.model.Contact;
import com.houserose.guardian.model.Level;
import com.houserose.guardian.model.Member;
import com.houserose.guardian.model.Membership;
import com.houserose.guardian.model.Organization;
import com.houserose.guardian.model.Picture;
import com.houserose.guardian.model.Term;
import com.houserose.guardian.repositories.ContactRepository;
import com.houserose.guardian.repositories.LevelRepository;
import com.houserose.guardian.repositories.MemberRepository;
import com.houserose.guardian.repositories.MembershipRepository;
import com.houserose.guardian.repositories.OrganizationRepository;
import com.houserose.guardian.repositories.PictureRepository;
import com.houserose.guardian.repositories.TermRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.houserose.guardian.GuardianTestDataFactory.arisia2019Term;
import static com.houserose.guardian.GuardianTestDataFactory.arisiaOrganization;
import static com.houserose.guardian.GuardianTestDataFactory.elizabethCooperRose;
import static com.houserose.guardian.GuardianTestDataFactory.elizabethCooperRoseDefaultProfilePicture;
import static com.houserose.guardian.GuardianTestDataFactory.elizabethCooperRoseMembership;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRose;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseDefaultPhoneContact;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseDefaultProfilePicture;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseDefaultSlackContact;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseDefaultTwitterContact;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseDefaultTxtContact;
import static com.houserose.guardian.GuardianTestDataFactory.laurelMariePickard;
import static com.houserose.guardian.GuardianTestDataFactory.laurelMariePickardDefaultPhoneContact;
import static com.houserose.guardian.GuardianTestDataFactory.laurelMariePickardDefaultProfilePicture;
import static com.houserose.guardian.GuardianTestDataFactory.laurelMariePickardDefaultSlackContact;
import static com.houserose.guardian.GuardianTestDataFactory.laurelMariePickardDefaultTxtContact;
import static com.houserose.guardian.GuardianTestDataFactory.turtleLevel;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MembershipModelTest {

   @Autowired
   private PictureRepository pictureRepository;

   @Autowired
   private ContactRepository contactRepository;

   @Autowired
   private MembershipRepository membershipRepository;

   @Autowired
   private MemberRepository memberRepository;

   @Autowired
   private OrganizationRepository organizationRepository;

   @Autowired
   private LevelRepository levelRepository;

   @Autowired
   private TermRepository termRepository;

   private Picture icrPicture;
   private Picture ecrPicture;
   private Picture lmpPicture;

   private Contact icrContact1;
   private Contact icrContact2;
   private Contact icrContact3;
   private Contact icrContact4;
   private Contact lmpContact1;
   private Contact lmpContact2;
   private Contact lmpContact3;

   private Organization arisia;
   private Membership ecrMembership;
   private Member ecr;
   private Member icr;
   private Member lmp;

   private Level level;
   private Level satellite;
   private Level commet;
   private Level teen;

   private Term term;
   private Term arisia2018;
   private Term arisia2019;

   @Before
   public void setUp() {

      ecrPicture = elizabethCooperRoseDefaultProfilePicture().build();
      ecr = elizabethCooperRose().build();
      ecr.addPicture(ecrPicture);

      icrPicture = ianCooperRoseDefaultProfilePicture().build();
      icrContact1 = ianCooperRoseDefaultPhoneContact().build();
      icrContact2 = ianCooperRoseDefaultTxtContact().build();
      icrContact3 = ianCooperRoseDefaultSlackContact().build();
      icrContact4 = ianCooperRoseDefaultTwitterContact().build();
      icr = ianCooperRose().build();
      icr.addPicture(icrPicture);
      icr.addContact(icrContact1);
      icr.addContact(icrContact2);
      icr.addContact(icrContact3);
      icr.addContact(icrContact4);

      lmpPicture = laurelMariePickardDefaultProfilePicture().build();
      lmpContact1 = laurelMariePickardDefaultPhoneContact().build();
      lmpContact2 = laurelMariePickardDefaultTxtContact().build();
      lmpContact3 = laurelMariePickardDefaultSlackContact().build();
      lmp = laurelMariePickard().build();
      lmp.addPicture(lmpPicture);
      lmp.addContact(lmpContact1);
      lmp.addContact(lmpContact2);
      lmp.addContact(lmpContact3);

      ecr = memberRepository.save(ecr);
      icr = memberRepository.save(icr);
      lmp = memberRepository.save(lmp);

      level = turtleLevel().build();
      level = levelRepository.save(level);
      term = arisia2019Term().build();
      term = termRepository.save(term);

      ecrMembership = elizabethCooperRoseMembership().build();
      ecrMembership.setLevel(level);
      ecrMembership.setTerm(term);
      ecrMembership.addMembershipMember(ecr, "ward");
      ecrMembership.addMembershipMember(icr, "guardian");
      ecrMembership.addMembershipMember(lmp, "guardian");

      arisia = arisiaOrganization().build();
      arisia.addLevel(level);
      arisia.addTerm(term);
      arisia = organizationRepository.save(arisia);
      arisia.addMembership(ecrMembership);
      ecrMembership = membershipRepository.save(ecrMembership);

   }

   @Test
   public void shouldReturnMembershipMembers() {
      Membership membershipResult = membershipRepository.findById(ecrMembership.getId()).orElse(null);
      assertThat(membershipResult).isNotNull();
      assertThat(membershipResult.getMembershipMembers().size()).isEqualTo(3);
      assertThat(membershipResult.getMembershipMembers().get(0).getMember().getLastName()).isEqualTo("Rose");
   }

   @Test
   public void shouldReturnMembershipType() {
      Membership result = membershipRepository.findById(ecrMembership.getId()).orElse(null);
      assertThat(result).isNotNull();
      assertThat(result.getMembershipMembers().get(0).getType()).isEqualTo("ward");
   }

}
