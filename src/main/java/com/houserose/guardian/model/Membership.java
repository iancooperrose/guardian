package com.houserose.guardian.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import java.util.UUID;

@ToString(exclude = {"membershipMembers", "organization", "level", "term"})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Membership {

   @Id
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @GeneratedValue(generator = "uuid")
   @Column(name = "id", unique = true, nullable = false)
   private UUID id;

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
   @OneToMany(mappedBy = "membership", cascade = CascadeType.ALL)
   @LazyCollection(LazyCollectionOption.FALSE)
   private List<MembershipMember> membershipMembers = new ArrayList<>();

   @ManyToOne
   @JoinColumn(name = "organization_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   private Organization organization;

   public void addMembershipMember(Member member, String type) {
      MembershipMember membershipMember = MembershipMember.builder().membership(this).member(member).type(type).build();
      membershipMembers.add(membershipMember);
      member.getMembershipMembers().add(membershipMember);
   }

//   public void removeMember(Member member) {
//      for (Iterator<MembershipMember> iterator = members.iterator(); iterator.hasNext(); ) {
//         MembershipMember membershipMember = iterator.next();
//
//         if (membershipMember.getMembership().equals(this) && membershipMember.getMember().equals(member)) {
//            iterator.remove();
//            membershipMember.getMember().getMemberships().remove(membershipMember);
//            membershipMember.setMembership(null);
//            membershipMember.setMember(null);
//         }
//      }
//   }

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
