package com.t2b.api.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.t2b.api.persistence.entity.MembershipPlan;

@Repository
public interface MembershipPlanRepository extends PagingAndSortingRepository<MembershipPlan, Long> {
}
