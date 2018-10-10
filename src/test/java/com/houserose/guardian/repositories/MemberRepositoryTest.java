package com.houserose.guardian.repositories;

import com.houserose.guardian.model.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static com.houserose.guardian.GuardianTestDataFactory.elizabethCooperRose;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRose;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

   @Autowired
   private MemberRepository subject;

   @Autowired
   private PictureRepository pictureRepository;

   @Test
   public void shouldSavePersonInTheDatabase() {
      //given
      Member ecr = elizabethCooperRose().build();
      subject.save(ecr);

      //when
      Member result = subject.findById(ecr.getId()).orElse(ianCooperRose().build());

      //then
      assertThat(result.getFirstName()).isEqualTo("Elizabeth");
      assertThat(result.getMiddleName()).isEqualTo("Cooper");
      assertThat(result.getLastName()).isEqualTo("Rose");
      assertThat(result.getNameSuffix()).isEqualTo("II");
      assertThat(result.getCommonName()).isEqualTo("Lizzie");
      assertThat(result.getDateOfBirth()).isEqualTo(LocalDate.of(2015, 9, 1));

      //cleanup
      subject.delete(result);
   }
}
