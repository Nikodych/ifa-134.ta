package com.softserveinc.ita.deprecated.vsaroz.repo;

import com.softserveinc.ita.deprecated.vsaroz.models.User;

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