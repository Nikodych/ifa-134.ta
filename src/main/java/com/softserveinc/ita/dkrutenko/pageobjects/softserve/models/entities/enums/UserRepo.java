package com.softserveinc.ita.dkrutenko.pageobjects.softserve.models.entities.enums;

public final class UserRepo {

    public static User getContactUsUser() {
        return User.builder()
                .firstName("Dmytro")
                .lastName("Krutenko")
                .email("dospecwork@gmail.com")
                .company("SoftServe Academy")
                .phone("+380957125027")
                .message("test ''contact us'' page")
                .expectedCategory("4")
                .build();
    }
}
