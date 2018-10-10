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
import javax.persistence.Table;

@ToString(exclude = {"member"})
@Table(name = "picture")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Picture {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String type;
   private Boolean isDefault;
   private String name;
   private String uri;
   private String mediaType;
   private Long height;
   private Long width;
   private Long rank;

   @ManyToOne
   @JoinColumn(name = "member_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   private Member member;
}
