package com.houserose.guardian.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class MembershipMemberId implements Serializable {
   private Long membershipId;
   private Long memberId;

   public MembershipMemberId(
           Long membershipId,
           Long memberId) {
      this.membershipId = membershipId;
      this.memberId = memberId;
   }
}
