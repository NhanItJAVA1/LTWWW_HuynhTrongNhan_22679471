package iuh.fit.Models;

import java.util.Date;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String datePfBirth;
    private String email;
    private String phoneNumber;
    private String gender;
    private String address;
    private String  pinCode;
    private String state;
    private String country;
    private List<String> hobbies;
    private String courseAppliedFor;
    private List<Qualification> qualification;

    public Student(String firstName, String lastName, String datePfBirth, String email, String phoneNumber, String gender, String address, String pinCode, String state, String country, List<String> hobbies, String courseAppliedFor, List<Qualification> qualification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.datePfBirth = datePfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
        this.hobbies = hobbies;
        this.courseAppliedFor = courseAppliedFor;
        this.qualification = qualification;
    }

    public Student() {
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

    public String getDatePfBirth() {
        return datePfBirth;
    }

    public void setDatePfBirth(String datePfBirth) {
        this.datePfBirth = datePfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getCourseAppliedFor() {
        return courseAppliedFor;
    }

    public void setCourseAppliedFor(String courseAppliedFor) {
        this.courseAppliedFor = courseAppliedFor;
    }

    public List<Qualification> getQualification() {
        return qualification;
    }

    public void setQualification(List<Qualification> qualification) {
        this.qualification = qualification;
    }

}
