package com.houserose.guardian.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.houserose.guardian.membership.CustomMembershipMemberDeserializer;
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
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@ToString(exclude = {"membershipMembers", "pictures", "contacts"})
@EqualsAndHashCode(exclude = {"id", "membershipMembers", "pictures", "contacts"})
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Member {

   @Id
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @GeneratedValue(generator = "uuid")
   @Column(name = "id", unique = true, nullable = false)
   private UUID id;
   private String firstName;
   private String middleName;
   private String lastName;
   private String nameSuffix;
   private String commonName;
   private LocalDate dateOfBirth;

   @Builder.Default
   @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
   @LazyCollection(LazyCollectionOption.FALSE)
   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
   private List<Picture> pictures = new ArrayList<>();

   @Builder.Default
   @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
   @LazyCollection(LazyCollectionOption.FALSE)
   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
   private List<Contact> contacts = new ArrayList<>();

   @Builder.Default
   @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
   @LazyCollection(LazyCollectionOption.FALSE)
//   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
   private List<MembershipMember> membershipMembers = new ArrayList<>();

   public void addPicture(Picture picture) {
      pictures.add(picture);
      picture.setMember(this);
   }

   public void removePicture(Picture picture) {
      picture.setMember(null);
      this.pictures.remove(picture);
   }

   public void addContact(Contact contact) {
      contacts.add(contact);
      contact.setMember(this);
   }

   public void removeContact(Contact contact) {
      contact.setMember(null);
      this.contacts.remove(contact);
   }

   public void addMembershipMember(Membership membership, String type) {
      MembershipMember membershipMember = MembershipMember.builder().membership(membership).member(this).type(type).build();
      membershipMembers.add(membershipMember);
      membership.getMembershipMembers().add(membershipMember);
   }

//   public void removeMembership(Membership membership) {
//      for (Iterator<MembershipMember> iterator = memberships.iterator(); iterator.hasNext(); ) {
//         MembershipMember membershipMember = iterator.next();
//
//         if (membershipMember.getMember().equals(this) &&
//                 membershipMember.getMembership().equals(membership)) {
//            iterator.remove();
//            membershipMember.getMember().getMemberships().remove(membershipMember);
//            membershipMember.setMembership(null);
//            membershipMember.setMember(null);
//         }
//      }
//   }
}
