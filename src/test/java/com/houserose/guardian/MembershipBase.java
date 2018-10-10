package com.houserose.guardian;

import com.houserose.guardian.membership.MembershipController;
//import com.houserose.guardian.membership.MembershipService;
import com.houserose.guardian.model.Membership;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.houserose.guardian.GuardianTestDataFactory.connorPaulBouchardMembership;
import static com.houserose.guardian.GuardianTestDataFactory.elizabethCooperRoseMembership;
import static com.houserose.guardian.GuardianTestDataFactory.kathleenLouiseBouchardMembership;
import static com.houserose.guardian.GuardianTestDataFactory.maxwellAllenPickardMembership;
import static com.houserose.guardian.GuardianTestDataFactory.penelopeAdaPickardMembership;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(MembershipController.class)
public abstract class MembershipBase {

//   @Autowired
//   private MembershipController membershipController;
//
//   @MockBean
//   private MembershipService membershipService;
//
//   private List<Membership> membershipList = new ArrayList<>();
//
//   private Page<Membership> membershipPage;
//   private Page<Membership> emptyPage;
//
//   @Before
//   public void setup() {
//
//      StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(membershipController);
//      RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
//
//      membershipList.add(elizabethCooperRoseMembership().build());
//      membershipList.add(kathleenLouiseBouchardMembership().build());
//      membershipList.add(connorPaulBouchardMembership().build());
//      membershipList.add(penelopeAdaPickardMembership().build());
//      membershipList.add(maxwellAllenPickardMembership().build());
//
//      membershipPage = new PageImpl<>(membershipList);
//      emptyPage = new PageImpl<>(Collections.emptyList());
//
//      when(membershipService.getAllMemberships(1, 30)).thenReturn(membershipPage);
//      when(membershipService.getAllMemberships(2, 30)).thenReturn(membershipPage);
//   }
}
