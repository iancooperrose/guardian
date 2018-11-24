package com.houserose.guardian.serialization;

import com.houserose.guardian.model.Contact;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.houserose.guardian.GuardianTestDataFactory.ICR_PHONE_CONTACT_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRosePhoneContact;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class ContactSerializationTest {

   @Autowired
   private JacksonTester<Contact> json;

   private Contact subject;

   @Before
   public void setUp() {
      subject = ianCooperRosePhoneContact().build();
   }

   @Test
   public void serializationTest() throws IOException {

      System.out.println(this.json.write(subject));

      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.id")
              .isEqualTo("00000000-0000-0004-0000-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.type")
              .isEqualTo("phone");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.value")
              .isEqualTo("(413) 626-6101");
      assertThat(this.json.write(subject))
              .extractingJsonPathNumberValue("@.contactOrder")
              .isEqualTo(1);
      assertThat(this.json.write(subject))
              .extractingJsonPathNumberValue("@.notificationOrder")
              .isEqualTo(0);
   }

   @Test
   public void deserializationTest() throws IOException {
      String content = "{\"id\":\"00000000-0000-0004-0000-000000000000\",\"type\":\"phone\",\"value\":\"(413) 626-6101\",\"contactOrder\":1,\"notificationOrder\":0}";
      assertThat(this.json.parseObject(content).getId()).isEqualTo(ICR_PHONE_CONTACT_TEST_UUID);
      assertThat(this.json.parseObject(content).getType()).isEqualTo("phone");
      assertThat(this.json.parseObject(content).getValue()).isEqualTo("(413) 626-6101");
      assertThat(this.json.parseObject(content).getContactOrder()).isEqualTo(1L);
      assertThat(this.json.parseObject(content).getNotificationOrder()).isEqualTo(0L);
   }
}
