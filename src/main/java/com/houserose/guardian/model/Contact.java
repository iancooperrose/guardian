package com.houserose.guardian.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@ToString(exclude = {"member"})
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
   private Long rank;

   @ManyToOne
   @JoinColumn(name = "member_fk")
   @LazyCollection(LazyCollectionOption.FALSE)
   private Member member;

}
