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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = {"memberships", "organization"})
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Level {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;

   @Builder.Default
   @OneToMany(mappedBy = "membership", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   @LazyCollection(LazyCollectionOption.FALSE)
   private List<MembershipMember> memberships = new ArrayList<>();

   @ManyToOne
   @JoinColumn(name = "organization_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   private Organization organization;
}
