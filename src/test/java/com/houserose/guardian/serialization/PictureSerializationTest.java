package com.houserose.guardian.serialization;

import com.houserose.guardian.model.Picture;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;

import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseDefaultPhoneContact;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseDefaultProfilePicture;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class PictureSerializationTest {

   @Autowired
   private JacksonTester<Picture> json;

   @Test
   public void serializationTest() throws IOException {
      System.out.println(this.json.write(ianCooperRoseDefaultProfilePicture().build()));

      assertThat(this.json.write(ianCooperRoseDefaultProfilePicture().build()))
              .extractingJsonPathNumberValue("@.id")
              .isEqualTo(7);
      assertThat(this.json.write(ianCooperRoseDefaultProfilePicture().build()))
              .extractingJsonPathStringValue("@.type")
              .isEqualTo("profile");
      assertThat(this.json.write(ianCooperRoseDefaultProfilePicture().build()))
              .extractingJsonPathStringValue("@.name")
              .isEqualTo("ian_cooper_rose.jpeg");
      assertThat(this.json.write(ianCooperRoseDefaultProfilePicture().build()))
              .extractingJsonPathStringValue("@.uri")
              .isEqualTo("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7");
      assertThat(this.json.write(ianCooperRoseDefaultProfilePicture().build()))
              .extractingJsonPathStringValue("@.mediaType")
              .isEqualTo("image/jpeg");
      assertThat(this.json.write(ianCooperRoseDefaultProfilePicture().build()))
              .extractingJsonPathNumberValue("@.height")
              .isEqualTo(300);
      assertThat(this.json.write(ianCooperRoseDefaultProfilePicture().build()))
              .extractingJsonPathNumberValue("@.width")
              .isEqualTo(300);
      assertThat(this.json.write(ianCooperRoseDefaultProfilePicture().build()))
              .extractingJsonPathStringValue("@.timeAdded")
              .isEqualTo("2018-08-18T04:32:23");
   }

   @Test
   public void deserializationTest() throws IOException {
      String content = "{\"id\":7,\"type\":\"profile\",\"isDefault\":true,\"name\":\"ian_cooper_rose.jpeg\",\"uri\":\"http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7\",\"mediaType\":\"image/jpeg\",\"height\":300,\"width\":300,\"timeAdded\":\"2018-08-18T04:32:23\"}";
      assertThat(this.json.parseObject(content).getId()).isEqualTo(7L);
      assertThat(this.json.parseObject(content).getType()).isEqualTo("profile");
      assertThat(this.json.parseObject(content).getName()).isEqualTo("ian_cooper_rose.jpeg");
      assertThat(this.json.parseObject(content).getUri()).isEqualTo(URI.create("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7"));
      assertThat(this.json.parseObject(content).getMediaType()).isEqualTo("image/jpeg");
      assertThat(this.json.parseObject(content).getHeight()).isEqualTo(300);
      assertThat(this.json.parseObject(content).getWidth()).isEqualTo(300);
      assertThat(this.json.parseObject(content).getRank()).isEqualTo(1L);
   }
}
