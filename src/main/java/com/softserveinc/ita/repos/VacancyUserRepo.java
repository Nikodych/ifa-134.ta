package com.softserveinc.ita.repos;

import com.softserveinc.ita.models.User;

public class VacancyUserRepo {
    public static User getVacancyUser() {
        return User.builder()
                .firstName("Дмитро")
                .lastName("Крутенко")
                .phone("957125027")
                .email("dospecwork@gmail.com")
                .categoryValue("45")
                .departamentValue("17")
                .build();
    }
}
