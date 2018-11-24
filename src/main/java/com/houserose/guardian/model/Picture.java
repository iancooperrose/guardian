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

@Entity
@Builder
@ToString
@EqualsAndHashCode(exclude = {"id"})
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Picture {

   @Id
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @GeneratedValue(generator = "uuid")
   @Column(name = "id", unique = true, nullable = false)
   private UUID id;
   private String type;
   private Boolean isDefault;
   private String name;
   private String uri;
   private String mediaType;
   private Long height;
   private Long width;

   @ManyToOne
   @JoinColumn(name = "member_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//   @JsonBackReference
   private Member member;
}
