package com.houserose.guardian.membership;

//import com.houserose.guardian.repositories.MembershipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.houserose.guardian.GuardianTestDataFactory.connorPaulBouchardMembership;
import static com.houserose.guardian.GuardianTestDataFactory.elizabethCooperRoseMembership;
import static com.houserose.guardian.GuardianTestDataFactory.kathleenLouiseBouchardMembership;
import static com.houserose.guardian.GuardianTestDataFactory.maxwellAllenPickardMembership;
import static com.houserose.guardian.GuardianTestDataFactory.penelopeAdaPickardMembership;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MembershipIntegrationTest {
//
//   @Autowired
//   private MockMvc mvc;
//
//   @Autowired
//   private MembershipService membershipService;
//
//   @Autowired
//   private MembershipRepository membershipRepository;

//   @After
//   public void tearDown() throws Exception {
//      mongoTemplate.dropCollection(Membership.class);
//   }

   @Test
   public void shouldPageMemberships() throws Exception {
//      mongoTemplate.save(elizabethCooperRoseMembership());
//      mongoTemplate.save(kathleenLouiseBouchardMembership());
//      mongoTemplate.save(connorPaulBouchardMembership());
//      mongoTemplate.save(penelopeAdaPickardMembership());
//      mongoTemplate.save(maxwellAllenPickardMembership());

//      MockHttpServletResponse result = mvc.perform(get("/memberships")
//              .param("page", "0")
//              .param("pageSize", "30"))
//              .andExpect(status().isOk())
//              .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//              .andReturn().getResponse();
//
//      assertThat(result.getContentAsString().contains("comonName")).isEqualTo("Lizzie");

   }
}
