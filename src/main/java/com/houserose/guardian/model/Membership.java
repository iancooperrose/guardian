package com.houserose.guardian.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.houserose.guardian.membership.CustomMembershipDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@ToString(exclude = {"membershipMembers"})
@Entity
@Builder
@EqualsAndHashCode(exclude = {"id", "membershipMembers"})
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@JsonDeserialize(using = CustomMembershipDeserializer.class)
public class Membership {

   @Id
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @GeneratedValue(generator = "uuid")
   @Column(name = "id", unique = true, nullable = false)
   private UUID id;

   private ZonedDateTime created;


   @ManyToOne
   @JoinColumn(name = "level_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Membership.class)
   private Level level;

   @ManyToOne
   @JoinColumn(name = "term_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Membership.class)
   private Term term;

   @ManyToOne
   @JoinColumn(name = "organization_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Membership.class)
   private Organization organization;

   @Builder.Default
   @OneToMany(mappedBy = "membership", cascade = CascadeType.ALL)
   @LazyCollection(LazyCollectionOption.FALSE)
   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
   private List<MembershipMember> membershipMembers = new ArrayList<>();


   public void addMembershipMember(Member member, String type) {
      MembershipMember membershipMember = MembershipMember.builder().membership(this).member(member).type(type).build();
      membershipMembers.add(membershipMember);
      member.getMembershipMembers().add(membershipMember);
   }

   public void removeMembershipMember(Member member) {
      for (Iterator<MembershipMember> iterator = membershipMembers.iterator(); iterator.hasNext(); ) {
         MembershipMember membershipMember = iterator.next();

         if (membershipMember.getMembership().equals(this) && membershipMember.getMember().equals(member)) {
            iterator.remove();
            membershipMember.getMember().getMembershipMembers().remove(membershipMember);
            membershipMember.setMembership(null);
            membershipMember.setMember(null);
         }
      }
   }
}
