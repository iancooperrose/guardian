package com.houserose.guardian.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
import java.util.UUID;

@ToString(exclude = {"member"})
@Entity
@Builder
@EqualsAndHashCode(exclude = {"id", "member"})
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Contact {

   @Id
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @GeneratedValue(generator = "uuid")
   @Column(name = "id", unique = true, nullable = false)
   private UUID id;
   private String type;
   private String value;
   private Long contactOrder;
   private Long notificationOrder;

   @ManyToOne
   @JoinColumn(name = "member_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//   @JsonBackReference
   private Member member;

}
