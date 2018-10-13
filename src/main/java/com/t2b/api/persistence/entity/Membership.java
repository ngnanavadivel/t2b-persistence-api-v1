package com.t2b.api.persistence.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Membership extends AuditableEntity {

    private static final long   serialVersionUID = 4591375810571419180L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long                membershipId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "membership_id")
    private Set<MembershipPlan> plans            = new HashSet<>();

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date                startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date                endDate;

    @NotNull
    private boolean             cancelled        = false;

    public Long getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Long membershipId) {
        this.membershipId = membershipId;
    }

    public Set<MembershipPlan> getPlans() {
        return plans;
    }

    public void setPlans(Set<MembershipPlan> plans) {
        this.plans = plans;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Membership [membershipId=");
        builder.append(membershipId);
        builder.append(", plans=");
        builder.append(plans);
        builder.append(", startDate=");
        builder.append(startDate);
        builder.append(", endDate=");
        builder.append(endDate);
        builder.append(", cancelled=");
        builder.append(cancelled);
        builder.append("]");
        return builder.toString();
    }

}
