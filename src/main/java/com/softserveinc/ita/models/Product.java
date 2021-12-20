package com.softserveinc.ita.models;

import lombok.Builder;

@Builder
public class Product {

    private String name;
    private int price;
    private int priceBeforeDiscount;
}
