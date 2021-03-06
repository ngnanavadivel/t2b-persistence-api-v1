package com.t2b.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2b.api.persistence.entity.Membership;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
