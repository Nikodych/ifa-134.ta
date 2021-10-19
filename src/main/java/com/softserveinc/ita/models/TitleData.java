package com.softserveinc.ita.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TitleData {

    private String firstTitle;
    private String secondTitle;
    private String thirdTitle;
    private String fourthTitle;

}

