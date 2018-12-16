package com.houserose.guardian.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Builder
@ToString
@EqualsAndHashCode(exclude = {"id"})
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "membership_member")
@JsonDeserialize(using = CustomMembershipMemberDeserializer.class)
public class MembershipMember {

   @Id
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @GeneratedValue(generator = "uuid")
   @Column(name = "id", unique = true, nullable = false)
   private UUID id;

   @ManyToOne
   @JoinColumn(name = "membership_id")
   @LazyCollection(LazyCollectionOption.FALSE)
   @JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
   private Membership membership;

   @ManyToOne
   @JoinColumn(name = "member_id")
   @LazyCollection(LazyCollectionOption.FALSE)
   @JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
   private Member member;

   private String type;

}
