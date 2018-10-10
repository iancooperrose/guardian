package com.houserose.guardian.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@ToString(exclude = {"membership", "member"})
@Data
@Table(name = "membership_member")
@Entity
public class MembershipMember {

   @EmbeddedId
   private MembershipMemberId id;

   @ManyToOne
   @MapsId("membershipId")
   @LazyCollection(LazyCollectionOption.FALSE)
   private Membership membership;

   @ManyToOne
   @MapsId("memberId")
   @LazyCollection(LazyCollectionOption.FALSE)
   private Member member;

   private String type;

   public MembershipMember(Membership membership, Member member, String type) {
      this.id = new MembershipMemberId(membership.getId(), member.getId());
      this.membership = membership;
      this.member = member;
      this.type = type;
   }

   private MembershipMember() {}

   public void addMembershipMemeber(Long membershipId, Long memberId, String MemberType) {

   }
}
