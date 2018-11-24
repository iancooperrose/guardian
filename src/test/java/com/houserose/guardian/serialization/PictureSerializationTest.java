package com.houserose.guardian.serialization;

import com.houserose.guardian.model.Picture;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.houserose.guardian.GuardianTestDataFactory.ICR_PICTURE_TEST_UUID;
import static com.houserose.guardian.GuardianTestDataFactory.ianCooperRoseDefaultProfilePicture;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class PictureSerializationTest {

   @Autowired
   private JacksonTester<Picture> json;

   private Picture subject;

   @Before
   public void setUp() {
      subject = ianCooperRoseDefaultProfilePicture().build();
   }

   @Test
   public void serializationTest() throws IOException {
      System.out.println(this.json.write(subject));

      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.id")
              .isEqualTo("00000000-0000-0003-0005-000000000000");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.type")
              .isEqualTo("profile");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.name")
              .isEqualTo("ian_cooper_rose.jpeg");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.uri")
              .isEqualTo("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7");
      assertThat(this.json.write(subject))
              .extractingJsonPathStringValue("@.mediaType")
              .isEqualTo("image/jpeg");
      assertThat(this.json.write(subject))
              .extractingJsonPathNumberValue("@.height")
              .isEqualTo(300);
      assertThat(this.json.write(subject))
              .extractingJsonPathNumberValue("@.width")
              .isEqualTo(300);
   }

   @Test
   public void deserializationTest() throws IOException {
      String content = "{\"id\":\"00000000-0000-0003-0005-000000000000\",\"type\":\"profile\",\"isDefault\":true,\"name\":\"ian_cooper_rose.jpeg\",\"uri\":\"http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7\",\"mediaType\":\"image/jpeg\",\"height\":300,\"width\":300,\"timeAdded\":\"2018-08-18T04:32:23\"}";
      assertThat(this.json.parseObject(content).getId()).isEqualTo(ICR_PICTURE_TEST_UUID);
      assertThat(this.json.parseObject(content).getType()).isEqualTo("profile");
      assertThat(this.json.parseObject(content).getName()).isEqualTo("ian_cooper_rose.jpeg");
      assertThat(this.json.parseObject(content).getUri()).isEqualTo("http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7");
      assertThat(this.json.parseObject(content).getMediaType()).isEqualTo("image/jpeg");
      assertThat(this.json.parseObject(content).getHeight()).isEqualTo(300);
      assertThat(this.json.parseObject(content).getWidth()).isEqualTo(300);
   }
}
