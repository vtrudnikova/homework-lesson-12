package tests;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.ru.ozon.pages.OzonMainPage;

import java.util.Date;

public class OzonTests extends TestBase {
    OzonMainPage startPage = new OzonMainPage();
    public String nameProduct = "Метро 2033";
    static Faker faker = new Faker();
    public String emailAddress = faker.internet().emailAddress();
    public String from = "Москва";
    public String to = "Пунта-Кана";
    Date currentDate = new Date();

    @Test()
    @DisplayName("Проверка страницы Войти")
    void openPageLogin() {
        startPage.openPage();
       // startPage.openPageLogin();
      //  startPage.checkTitle();
    }
/*
    @Test()
    @DisplayName("Поиск товаров")
    void searchProducts() {
        startPage.openPage();
        startPage.searchProducts(nameProduct);
        startPage.pressSearch();
        startPage.checkSearchResults();
    }

    @Test()
    @DisplayName("Перейти на старицу с корзиной")
    void checkBasket() {
        startPage.openPage();
        startPage.checkBasket();
        startPage.goToPageWithBasket();
    }

    @Test()
    @DisplayName("Невозможность логина в лк по незарегистрированному email")
    void notLoginWithUnregisteredEmail() {
        startPage.openPage();
        startPage.openPageLogin();
        startPage.pressGoToEmail();
        startPage.enterEmail(emailAddress);
        startPage.pressEnterGetCode();
        startPage.checkMessage();
    }

    @Test()
    @DisplayName("Поиск билетоа на Ozon.Travel")
    void searchTickets() {
        startPage.openPage();
        startPage.goToTravelPage();
        startPage.enterValue(from, to);

        startPage.openCalendar();
        startPage.chooseDay(currentDate.getDate() + 1);
        startPage.pressButtonSearch();
        startPage.checkResultsSearch();

        Selenide.sleep(5000);
    }*/
}