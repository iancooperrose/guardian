package com.houserose.guardian.repositories;

import com.houserose.guardian.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
   Membership findMembershipById(Long id);
}