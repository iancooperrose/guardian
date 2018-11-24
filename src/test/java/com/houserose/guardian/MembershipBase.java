package com.houserose.guardian;

import com.houserose.guardian.membership.MembershipController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

//import com.houserose.guardian.membership.MembershipService;

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
