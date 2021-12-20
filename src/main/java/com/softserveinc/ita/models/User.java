package com.softserveinc.ita.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String categoryValue;
    private String departamentValue;
}
