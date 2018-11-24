package com.houserose.guardian.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.houserose.guardian.membership.CustomMembershipMemberListDeserializer;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@ToString(exclude = {"memberships"})
@EqualsAndHashCode(exclude = {"id", "memberships"})
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Level {

   @Id
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @GeneratedValue(generator = "uuid")
   @Column(name = "id", unique = true, nullable = false)
   private UUID id;
   private String name;

   @Builder.Default
   @OneToMany(mappedBy = "id")
   @LazyCollection(LazyCollectionOption.FALSE)
//   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
   @JsonDeserialize(using = CustomMembershipMemberListDeserializer.class)
   private List<Membership> memberships = new ArrayList<>();

   @ManyToOne
   @JoinColumn(name = "organization_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
   private Organization organization;
}
