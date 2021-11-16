package com.softserveinc.ita.dkrutenko.pageobjects.softserve.models.repo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String phone;
    private String message;
    private String expectedCategory;
}
