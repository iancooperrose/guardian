package com.houserose.guardian.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@ToString(exclude = {"member"})
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String type;
   private String value;
   private Long contactOrder;
   private Long notificationOrder;
   private Long rank;

   @ManyToOne
   @JoinColumn(name = "member_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   private Member member;

}
