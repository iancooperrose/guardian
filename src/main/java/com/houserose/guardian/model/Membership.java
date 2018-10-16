package com.houserose.guardian.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ToString(exclude = {"members", "organization", "level", "term"})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Membership {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne
   @JoinColumn(name = "level_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   private Level level;

   @ManyToOne
   @JoinColumn(name = "term_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   private Term term;

   private ZonedDateTime created;

   @Builder.Default
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "membership_member", joinColumns = @JoinColumn(name = "membership_id"), inverseJoinColumns = @JoinColumn(name = "member_id"))
   @LazyCollection(LazyCollectionOption.FALSE)
   private List<MembershipMember> members = new ArrayList<>();

   @ManyToOne
   @JoinColumn(name = "organization_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   private Organization organization;
//
//   public List<MembershipMember> getMembershipMembers() {
//      return members;
//   }

   public void addMember(Member member, String type) {
      MembershipMember membershipMember = MembershipMember.builder().membership(this).member(member).type(type).build();
      members.add(membershipMember);
      member.getMemberships().add(membershipMember);
   }

   public void removeMember(Member member) {
      for (Iterator<MembershipMember> iterator = members.iterator(); iterator.hasNext(); ) {
         MembershipMember membershipMember = iterator.next();

         if (membershipMember.getMembership().equals(this) && membershipMember.getMember().equals(member)) {
            iterator.remove();
            membershipMember.getMember().getMemberships().remove(membershipMember);
            membershipMember.setMembership(null);
            membershipMember.setMember(null);
         }
      }
   }

//   public void addLevel(Level level) {
//      this.setLevel(level);
//      level.getMemberships().add(this);
//   }
//
//   public void removeLevel(Level level) {
//      level.setMemberships(null);
//      this.level.remove(level);
//   }

//   public void addTerm(Term term) {
//      this.setTerm(term);
//      term.getMemberships().add(this);
//   }
//
//   public void removeTerm(Term term) {
//      term.setOrganization(null);
//      this.term.remove(term);
//   }
}
