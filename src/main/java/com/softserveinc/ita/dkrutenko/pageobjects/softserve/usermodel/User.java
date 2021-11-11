package com.softserveinc.ita.dkrutenko.pageobjects.softserve.usermodel;

public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String company;
    private String phone;
    private String message;
    private String expectedCategory;

    public User(String firstname, String lastname, String email, String company,
                String phone, String message, String expectedCategory) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.company = company;
        this.phone = phone;
        this.message = message;
        this.expectedCategory = expectedCategory;
    }

    public User() {}

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getMessage() {
        return message;
    }

    public String getExpectedCategory() {
        return expectedCategory;
    }

    @Override
    public String toString() {
        return "Firstname: " + getFirstname()
                + " Lastname: " + getLastname()
                + " Email: " + getEmail()
                + " Company: " + getCompany()
                + " Phone: " + getPhone()
                + " Message: " + getMessage()
                + " ExpectedCategory: " + getExpectedCategory();
    }
}
