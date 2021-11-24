package com.softserveinc.ita.repos;

import com.softserveinc.ita.models.CustomerOrderData;

public class CustomerOrderDataRepo {

    public static CustomerOrderData getCustomerOrderData() {
        return CustomerOrderData
                .builder()
                .surname("Пупкін")
                .name("Вася")
                .phone("099 123 98 76")
                .city("Львів")
                .build();
    }
}
