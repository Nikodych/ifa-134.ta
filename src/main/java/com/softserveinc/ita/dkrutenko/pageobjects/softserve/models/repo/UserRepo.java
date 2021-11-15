package com.softserveinc.ita.dkrutenko.pageobjects.softserve.models.repo;

import com.softserveinc.ita.dkrutenko.pageobjects.softserve.models.User;

public final class UserRepo {

    public static User getContactUsUser() {
        return new User("Dmytro", "Krutenko",
                "dospecwork@gmail.com", "SoftServe Academy", "+380957125027",
                "test ''contact us'' page", "4");
    }
}
