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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Table(name = "member")
@ToString(exclude = {"pictures", "contacts", "memberships"})
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Member {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String firstName;
   private String middleName;
   private String lastName;
   private String nameSuffix;
   private String commonName;
   private LocalDate dateOfBirth;

   @Builder.Default
   @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
   @LazyCollection(LazyCollectionOption.FALSE)
   private List<Picture> pictures = new ArrayList<>();

   @Builder.Default
   @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
   @LazyCollection(LazyCollectionOption.FALSE)
   private List<Contact> contacts = new ArrayList<>();

   @Builder.Default
   @OneToMany(mappedBy = "membership", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   @LazyCollection(LazyCollectionOption.FALSE)
   private List<MembershipMember> memberships = new ArrayList<>();

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

   public void addMembership(Membership membership, String type) {
      MembershipMember membershipMember = new MembershipMember(membership, this, type);
      memberships.add(membershipMember);
      membership.getMembers().add(membershipMember);
   }

   public void removeMembership(Membership membership) {
      for (Iterator<MembershipMember> iterator = memberships.iterator(); iterator.hasNext(); ) {
         MembershipMember membershipMember = iterator.next();

         if (membershipMember.getMember().equals(this) &&
                 membershipMember.getMembership().equals(membership)) {
            iterator.remove();
            membershipMember.getMember().getMemberships().remove(membershipMember);
            membershipMember.setMembership(null);
            membershipMember.setMember(null);
         }
      }
   }
}
