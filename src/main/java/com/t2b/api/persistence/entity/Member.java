package com.t2b.api.persistence.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Member extends AuditableEntity {
    private static final long serialVersionUID = 2716356425907074920L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long              memberId;
    @Column
    private String            firstName;
    @Column
    private String            lastName;
    @Column
    private String            emailAddress;
    @Column
    private String            addressLine1;
    @Column
    private String            addressLine2;
    @Column
    private String            city;
    @Column
    private String            state;
    @Column
    private String            zipCode;
    @Column
    private String            phoneNumber;
    @Column
    private boolean           isCancel;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Set<Membership>   memberships      = new HashSet<>();

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isCancel() {
        return isCancel;
    }

    public void setCancel(boolean isCancel) {
        this.isCancel = isCancel;
    }

    public Set<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(Set<Membership> memberships) {
        this.memberships = memberships;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Member [memberId=");
        builder.append(memberId);
        builder.append(", firstName=");
        builder.append(firstName);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", emailAddress=");
        builder.append(emailAddress);
        builder.append(", addressLine1=");
        builder.append(addressLine1);
        builder.append(", addressLine2=");
        builder.append(addressLine2);
        builder.append(", city=");
        builder.append(city);
        builder.append(", state=");
        builder.append(state);
        builder.append(", zipCode=");
        builder.append(zipCode);
        builder.append(", phoneNumber=");
        builder.append(phoneNumber);
        builder.append(", isCancel=");
        builder.append(isCancel);
        builder.append(", memberships=");
        builder.append(memberships);
        builder.append("]");
        return builder.toString();
    }

}
