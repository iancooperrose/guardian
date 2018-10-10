package com.houserose.guardian.serialization;

import com.houserose.guardian.GuardianTestDataFactory;
import com.houserose.guardian.model.Contact;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.houserose.guardian.GuardianTestDataFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class ContactSerializationTest {

   @Autowired
   private JacksonTester<Contact> json;

   @Test
   public void serializationTest() throws IOException {

//      System.out.println(this.json.write(ianCooperRoseDefaultPhoneContact().build()));

      assertThat(this.json.write(ianCooperRoseDefaultPhoneContact().build()))
              .extractingJsonPathNumberValue("@.id")
              .isEqualTo(1);
      assertThat(this.json.write(ianCooperRoseDefaultPhoneContact().build()))
              .extractingJsonPathStringValue("@.type")
              .isEqualTo("phone");
      assertThat(this.json.write(ianCooperRoseDefaultPhoneContact().build()))
              .extractingJsonPathStringValue("@.value")
              .isEqualTo("(413) 626-6101");
      assertThat(this.json.write(ianCooperRoseDefaultPhoneContact().build()))
              .extractingJsonPathNumberValue("@.contactOrder")
              .isEqualTo(1);
      assertThat(this.json.write(ianCooperRoseDefaultPhoneContact().build()))
              .extractingJsonPathNumberValue("@.notificationOrder")
              .isEqualTo(0);

   }

   @Test
   public void deserializationTest() throws IOException {
      String content = "{\"id\":1,\"type\":\"phone\",\"value\":\"(413) 626-6101\",\"contactOrder\":1,\"notificationOrder\":0}";
      assertThat(this.json.parseObject(content).getId()).isEqualTo(1L);
      assertThat(this.json.parseObject(content).getType()).isEqualTo("phone");
      assertThat(this.json.parseObject(content).getValue()).isEqualTo("(413) 626-6101");
      assertThat(this.json.parseObject(content).getContactOrder()).isEqualTo(1L);
      assertThat(this.json.parseObject(content).getNotificationOrder()).isEqualTo(0L);
   }
}
