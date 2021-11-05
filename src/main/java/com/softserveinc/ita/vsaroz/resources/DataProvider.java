package com.softserveinc.ita.vsaroz.resources;

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
    protected String firstName = "UsersFirstName";
    protected String lastName = "YourLastName";
    protected String email = "test.testadmin@gmail.com";
    protected String userName = "YourUserName";
    protected String password = "987654321";
}
