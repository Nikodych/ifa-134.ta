package com.softserveinc.ita.dkrutenko.pageobjects.softserve.models;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

    private String firstname;
    private String lastname;
    private String email;
    private String company;
    private String phone;
    private String message;
    private String expectedCategory;

    @Builder
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
}

