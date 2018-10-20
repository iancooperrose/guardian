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
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = {"levels", "terms", "memberships"})
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;

   @Builder.Default
   @OneToMany(mappedBy = "organization")
   @LazyCollection(LazyCollectionOption.FALSE)
   private List<Membership> memberships = new ArrayList<>();

   @Builder.Default
   @OneToMany(mappedBy = "organization")
   @LazyCollection(LazyCollectionOption.FALSE)
   private List<Level> levels = new ArrayList<>();

   @Builder.Default
   @OneToMany(mappedBy = "organization")
   @LazyCollection(LazyCollectionOption.FALSE)
   private List<Term> terms = new ArrayList<>();

   public void addMembership(Membership membership) {
      memberships.add(membership);
      membership.setOrganization(this);
   }

   public void removeMembership(Membership membership) {
      membership.setOrganization(null);
      this.memberships.remove(membership);
   }

   public void addLevel(Level level) {
      levels.add(level);
      level.setOrganization(this);
   }

   public void removeLevel(Level level) {
      level.setOrganization(null);
      this.levels.remove(level);
   }

   public void addTerm(Term term) {
      terms.add(term);
      term.setOrganization(this);
   }

   public void removeTerm(Term term) {
      term.setOrganization(null);
      this.terms.remove(term);
   }
}


