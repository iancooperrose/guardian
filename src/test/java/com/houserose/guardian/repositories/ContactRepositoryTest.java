package com.houserose.guardian.repositories;

import com.houserose.guardian.GuardianTestDataFactory;
import com.houserose.guardian.model.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.houserose.guardian.GuardianTestDataFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactRepositoryTest {

   @Autowired
   private ContactRepository subject;

   @Test
   public void shouldSaveContactInTheDatabase() {
      //given

      //when
      Contact result = subject.save(ianCooperRoseDefaultPhoneContact().build());

      //then
      assertThat(result.getType()).isEqualTo("phone");
      assertThat(result.getValue()).isEqualTo("(413) 626-6101");
      assertThat(result.getContactOrder()).isEqualTo(1L);
      assertThat(result.getNotificationOrder()).isEqualTo(0L);
      assertThat(result.getRank()).isEqualTo(1L);

      //cleanup
      subject.delete(result);
   }
}
