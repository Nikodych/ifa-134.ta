package com.softserveinc.ita.vsaroz.repo;

import com.softserveinc.ita.vsaroz.models.User;

public final class UserRepo {
        public static User getUsersContacts() {
            return User.builder()
                    .firstName("vitalii1")
                    .lastName("saroz1")
                    .email("admintestloginform@gmail.com")
                    .userName("vsaroz11")
                    .password("testlogin00")
                    .build();
        }
}