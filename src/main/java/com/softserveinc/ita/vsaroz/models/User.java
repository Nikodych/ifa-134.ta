package com.softserveinc.ita.vsaroz.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
}

