package com.softserveinc.ita.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerOrderData {

    private String surname;
    private String name;
    private String phone;
    private String city;
}
