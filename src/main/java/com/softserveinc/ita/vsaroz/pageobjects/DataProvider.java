package com.softserveinc.ita.vsaroz.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
public class DataProvider {
    protected String getUrl = "https://unsplash.com/login";
    protected String firstName = "name";
    protected String lastName = "lastname";
    protected String email = "admin.admin@gmail.com";
    protected String userName = "username";
    protected String password = "012345678";
}
