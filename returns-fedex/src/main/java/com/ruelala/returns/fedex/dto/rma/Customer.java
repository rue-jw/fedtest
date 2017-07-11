package com.ruelala.returns.fedex.dto.rma;

public class Customer {
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateCode;
    private String zipCode;
    private String countryCode;
    private String phoneNumber;
    private String emailAddress;

    public Customer() {
        // Default constructor
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

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Customer [firstName=").append(firstName).append(", lastName=").append(lastName).append(", addressLine1=").append(addressLine1)
                .append(", addressLine2=").append(addressLine2).append(", city=").append(city).append(", stateCode=").append(stateCode).append(", zipCode=")
                .append(zipCode).append(", countryCode=").append(countryCode).append(", phoneNumber=").append(phoneNumber).append(", emailAddress=")
                .append(emailAddress).append("]");
        return builder.toString();
    }
}
