package com.houserose.guardian.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.houserose.guardian.membership.CustomMembershipListDeserializer;
import com.houserose.guardian.membership.CustomTermListDeserializer;
import lombok.AccessLevel;
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@ToString(exclude = {"levels", "terms", "memberships"})
@EqualsAndHashCode(exclude = {"id", "levels", "terms", "memberships"})
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organization {

   @Id
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @GeneratedValue(generator = "uuid")
   @Column(name = "id", unique = true, nullable = false)
   private UUID id;
   private String name;

   @Builder.Default
   @Setter(value = AccessLevel.NONE)
   @OneToMany(mappedBy = "organization")
   @LazyCollection(LazyCollectionOption.FALSE)
//   @JsonDeserialize(using = CustomTermListDeserializer.class)
   private List<Term> terms = new ArrayList<>();

   @Builder.Default
   @Setter(value = AccessLevel.NONE)
   @OneToMany(mappedBy = "organization")
   @LazyCollection(LazyCollectionOption.FALSE)
//   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Organization.class)
//   @JsonDeserialize(using = CustomLevelListDeserializer.class)
   private List<Level> levels = new ArrayList<>();

   @Builder.Default
   @OneToMany(mappedBy = "organization")
   @LazyCollection(LazyCollectionOption.FALSE)
//   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope=Organization.class)
   @JsonDeserialize(using = CustomMembershipListDeserializer.class)
   private List<Membership> memberships = new ArrayList<>();

   public void addMembership(Membership membership) {
      memberships.add(membership);
      membership.setOrganization(this);
   }

   public void removeMembership(Membership membership) {
      membership.setOrganization(null);
      this.memberships.remove(membership);
   }

   public void addLevel(Level level) {
      this.levels.add(level);
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