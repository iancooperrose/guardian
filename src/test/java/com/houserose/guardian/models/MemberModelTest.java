package com.houserose.guardian.models;

import com.houserose.guardian.model.Contact;
import com.houserose.guardian.model.Member;
import com.houserose.guardian.model.Picture;
import com.houserose.guardian.repositories.ContactRepository;
import com.houserose.guardian.repositories.MemberRepository;
import com.houserose.guardian.repositories.PictureRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRose;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseDefaultProfilePicture;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRosePhoneContact;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberModelTest {
   @Autowired
   private MemberRepository memberRepository;

   @Autowired
   private PictureRepository pictureRepository;

   @Autowired
   private ContactRepository contactRepository;

   private Member icr;

   @Before
   public void setUp() {
      icr = memberRepository.save(ianCooperRose().build());
      Picture pic = pictureRepository.save(ianCooperRoseDefaultProfilePicture().build());
      Contact phone = contactRepository.save(ianCooperRosePhoneContact().build());
      icr.addPicture(pic);
      icr.addContact(phone);
      memberRepository.save(icr);
   }

   @Test
   public void shouldReturnPersonPictures() {
      Member member = memberRepository.findById(icr.getId()).orElse(null);
      String result = member.getPictures().get(0).getName();
      assertThat(result).isEqualTo("ian_cooper_rose.jpeg");
   }

   @Test
   public void shouldReturnPersonContacts() {
      Member member = memberRepository.findById(icr.getId()).orElse(null);
      String result = member.getContacts().get(0).getType();
      assertThat(result).isEqualTo("phone");
   }
}
