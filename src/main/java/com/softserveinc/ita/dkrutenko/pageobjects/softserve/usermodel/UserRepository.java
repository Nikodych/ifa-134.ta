package com.softserveinc.ita.dkrutenko.pageobjects.softserve.usermodel;

public final class UserRepository {

    public User getContactUsUser() {
        return new User("Dmytro", "Krutenko",
                "dospecwork@gmail.com", "SoftServe Academy", "+380957125027",
                "test ''contact us'' page", "4");
    }
}
