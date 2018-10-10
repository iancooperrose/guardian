package com.houserose.guardian.repositories;

import com.houserose.guardian.model.Member;
import com.houserose.guardian.model.Picture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.houserose.guardian.GuardianTestDataFactory.elizabethCooperRoseDefaultProfilePicture;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PictureRepositoryTest {

   @Autowired
   private PictureRepository subject;

   @Autowired
   private MemberRepository memberRepository;

   private Member ecr;
   private Picture ecrDPPic;
   private Picture ecrPPic;
   private Picture ecrPic;

//   @Before
//   public void setUp() {
//      ecr = personRepository.save(elizabethCooperRose().build());
//      ecrDPPic = subject.save(elizabethCooperRoseDefaultProfilePicture().personFk(ecr.getId()).rank(1L).build());
//      ecrPPic = subject.save(elizabethCooperRoseDefaultProfilePicture().personFk(ecr.getId()).isDefault(false).rank(2L).build());
//      ecrPic = subject.save(elizabethCooperRoseDefaultProfilePicture().personFk(ecr.getId()).type("avatar").isDefault(false).rank(3L).build());
//   }
//
//   @After
//   public void tearDown() {
//      subject.delete(ecrDPPic);
//      subject.delete(ecrPPic);
//      subject.delete(ecrPic);
//      personRepository.delete(ecr);
//   }

   @Test
   public void shouldSavePictureInTheDatabase() {
      //given
      Picture picture = subject.save(elizabethCooperRoseDefaultProfilePicture().build());

      //when
      Picture result = subject.findById(picture.getId()).orElse(null);

      //then
      assertThat(result.getType()).isEqualTo("profile");
      assertThat(result.getIsDefault()).isTrue();
      assertThat(result.getName()).isEqualTo("elizabeth_cooper_rose.jpeg");
      assertThat(result.getUri()).isEqualTo("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/1");
      assertThat(result.getMediaType()).isEqualTo("image/jpeg");
      assertThat(result.getHeight()).isEqualTo(300L);
      assertThat(result.getWidth()).isEqualTo(300L);
      assertThat(result.getRank()).isEqualTo(1L);
   }

//   @Test
//   public void shouldGetDefaultProfilePictureForPerson() {
//      Picture result = subject.getDefaultProfilePictureByPerson(ecr.getId());
//      assertThat(result.getName()).isEqualTo("elizabeth_cooper_rose.jpeg");
//   }
//
//   @Test
//   public void shouldGetPicturesForPerson() {
//      List<Picture> result = subject.getPicturesByPerson(ecr.getId());
//      assertThat(result.size()).isEqualTo(3);
//   }
}

