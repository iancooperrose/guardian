package com.houserose.guardian.repositories;

import com.houserose.guardian.model.Membership;
import com.houserose.guardian.model.MembershipMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MembershipMemberRepository extends JpaRepository<MembershipMember, UUID> {

}
