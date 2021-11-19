package com.softserveinc.ita.vsaroz.repo;

import com.softserveinc.ita.vsaroz.models.User;

public final class UserRepo {

    public static User getUsersContacts() {
        return User.builder()
                .firstName("Vitalik")
                .lastName("Saroz")
                .email("saroz@mkt.uz.ua")
                .userName("sarozv")
                .password("testlogin00")
                .build();
        }
}