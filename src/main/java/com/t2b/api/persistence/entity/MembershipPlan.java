package com.t2b.api.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Entity
public class MembershipPlan extends AuditableEntity {
    private static final long serialVersionUID = 3013996932401904612L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long              membershipPlanId;

    @NotNull
    private String            planName;

    @NotNull
    @Lob
    private String            planDescription;

    public Long getMembershipPlanId() {
        return membershipPlanId;
    }

    public void setMembershipPlanId(Long membershipPlanId) {
        this.membershipPlanId = membershipPlanId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MembershipPlan [membershipPlanId=");
        builder.append(membershipPlanId);
        builder.append(", planName=");
        builder.append(planName);
        builder.append(", planDescription=");
        builder.append(planDescription);
        builder.append("]");
        return builder.toString();
    }

}
