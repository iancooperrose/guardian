package com.houserose.guardian.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

//@ToString(exclude = {"membership", "member"})
@Builder
@Data
@Table(name = "membership_member")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MembershipMember {

   @Id
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @GeneratedValue(generator = "uuid")
   @Column(name = "id", unique = true, nullable = false)
   private UUID id;

   @ManyToOne
   @JoinColumn(name = "membership_id")
   @LazyCollection(LazyCollectionOption.FALSE)
   private Membership membership;

   @ManyToOne
   @JoinColumn(name = "member_id")
   @LazyCollection(LazyCollectionOption.FALSE)
   private Member member;

   private String type;

}
