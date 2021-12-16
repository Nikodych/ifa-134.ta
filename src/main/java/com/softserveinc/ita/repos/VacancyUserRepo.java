package com.softserveinc.ita.repos;

import com.softserveinc.ita.pageobjects.modals.UserModal;

public class VacancyUserRepo {
    public static UserModal getVacancyUser() {
        return UserModal.builder()
                .firstName("Дмитро")
                .lastName("Крутенко")
                .phone("+380957125027")
                .email("dospecwork@gmail.com")
                .categoryValue("45")
                .departamentValue("17")
                .build();
    }
}
