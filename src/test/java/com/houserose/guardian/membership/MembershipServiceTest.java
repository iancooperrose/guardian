package com.houserose.guardian.membership;

import com.houserose.guardian.model.Membership;
//import com.houserose.guardian.repositories.MembershipRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static com.houserose.guardian.GuardianTestDataFactory.connorPaulBouchardMembership;
import static com.houserose.guardian.GuardianTestDataFactory.elizabethCooperRoseMembership;
import static com.houserose.guardian.GuardianTestDataFactory.kathleenLouiseBouchardMembership;
import static com.houserose.guardian.GuardianTestDataFactory.maxwellAllenPickardMembership;
import static com.houserose.guardian.GuardianTestDataFactory.penelopeAdaPickardMembership;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MembershipServiceTest {

//   @Autowired
//   private MembershipService subject;
//
//   @Mock
//   private MembershipRepository membershipRepository;
//
//   private List<Membership> membershipList = new ArrayList<>();
//
//   private Page<Membership> membershipPage;
//
//   @Before
//   public void setUp() throws Exception {
//      subject = new MembershipService(membershipRepository);
//   }
//
//   @Test
//   public void shouldReturnAPageOfAllMemberships() {
//      //given
//      membershipList.add(elizabethCooperRoseMembership().build());
//      membershipList.add(kathleenLouiseBouchardMembership().build());
//      membershipList.add(connorPaulBouchardMembership().build());
//      membershipList.add(penelopeAdaPickardMembership().build());
//      membershipList.add(maxwellAllenPickardMembership().build());
//
//      membershipPage = new PageImpl<>(membershipList);
//
//      Sort sort = Sort.by(Sort.Direction.DESC, "created");
//      Pageable pageRequest = PageRequest.of(1,30, sort);
//
//      when(membershipRepository.findAll(pageRequest)).thenReturn(membershipPage);
//
//      //when
//      Page<Membership> resultPage = subject.getAllMemberships(1,30);
//
//      //then
//      assertThat(resultPage).isNotNull();
//      assertThat(resultPage.getTotalPages()).isEqualTo(1);
//      assertThat(resultPage.getTotalElements()).isEqualTo(5);
//      assertThat(resultPage.getContent().get(0).getId()).isEqualTo(1L);
//      assertThat(resultPage.getContent().get(0).getMember().getCommonName()).isEqualTo("Lizzie");
//      assertThat(resultPage.getContent().get(1).getId()).isEqualTo(2L);
//      assertThat(resultPage.getContent().get(1).getMember().getCommonName()).isEqualTo("Katie");
//      assertThat(resultPage.getContent().get(2).getId()).isEqualTo(3L);
//      assertThat(resultPage.getContent().get(2).getMember().getCommonName()).isEqualTo("Connor");
//      assertThat(resultPage.getContent().get(3).getId()).isEqualTo(4L);
//      assertThat(resultPage.getContent().get(3).getMember().getCommonName()).isEqualTo("Penny");
//      assertThat(resultPage.getContent().get(4).getId()).isEqualTo(5L);
//      assertThat(resultPage.getContent().get(4).getMember().getCommonName()).isEqualTo("Max");
//   }
}
