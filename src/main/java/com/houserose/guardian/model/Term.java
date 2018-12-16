package com.houserose.guardian.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.houserose.guardian.membership.CustomMembershipListDeserializer;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@ToString(exclude = {"memberships", "organization"})
@EqualsAndHashCode(exclude = {"id", "memberships", "organization"})
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Term {

   @Id
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @GeneratedValue(generator = "uuid")
   @Column(name = "id", unique = true, nullable = false)
   private UUID id;
   private ZonedDateTime start;
   private Long duration;

   @Builder.Default
   @OneToMany(mappedBy = "id")
   @LazyCollection(LazyCollectionOption.FALSE)
//   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
   @JsonDeserialize(using = CustomMembershipListDeserializer.class)
   private List<Membership> memberships = new ArrayList<>();

   @ManyToOne
   @JoinColumn(name = "organization_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
//   @JsonIgnore
   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
   private Organization organization;
}