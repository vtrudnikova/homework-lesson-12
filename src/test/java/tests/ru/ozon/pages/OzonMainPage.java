package tests.ru.ozon.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class OzonMainPage {
    @Step("Открыть главную страницу сайта")
    public void openPage() {
        open("https://www.jetbrains.com/");
    }

    @Step("Перейти на вкладку Войти")
    public void openPageLogin() {
        $(byXpath("//*[@data-widget = 'profileMenuAnonymous']//*[text() = 'Войти']")).click();
    }

    @Step("Проверить что есть текст Войдите или зарегистрируйтесь, чтобы продолжить")
    public void checkTitle() {
        Selenide.switchTo().frame("authFrame");
        $x("//div[@id='layoutPage']/div//*[contains(text(),'Войдите или зарегистрируйтесь, чтобы продолжить')]")
                .shouldBe(visible);
    }

    @Step("Ввести в стороку поиска имя товара")
    public void searchProducts(String nameProduct) {
        $(byXpath("//input[@placeholder = 'Искать на Ozon']")).setValue(nameProduct);
    }

    @Step("Нажать поиск")
    public void pressSearch() {
        $(byXpath("//*[@type= 'submit']")).click();
    }

    @Step("Проверить результаты поиска")
    public void checkSearchResults() {
        $$x("//div[@data-widget ='searchResultsV2']//a[starts-with(@href,'/product')]").should(CollectionCondition.sizeNotEqual(0));
    }

    @Step("Проверить что на странице старта есть корзина")
    public void checkBasket() {
        $(byXpath("//a[@data-widget= 'headerIcon']//*[text()='Корзина']")).shouldHave(text("Корзина"));
    }

    @Step("Перейти на вкладку с корзиной")
    public void goToPageWithBasket() {
        $(byXpath("//a[@data-widget= 'headerIcon']//*[text()='Корзина']")).click();
    }

    @Step("Нажать Войти по почте ")
    public void pressGoToEmail() {
        Selenide.switchTo().frame("authFrame");
        $(byXpath("//div[@data-widget = 'loginOrRegistration']//*[text()='Войти по почте']")).click();
    }
    @Step("Ввести email")
    public void enterEmail(String email) {
        $(byName("email")).setValue(email);
    }
    @Step("Нажать кнопку Получить код")
    public void pressEnterGetCode() {
        $x("//*[@type='submit']//*[text()='Получить код']").click();
    }

    @Step("Проверить сообщение")
    public void checkMessage() {
        $x("//*[@qa-id='errorMessage']").shouldBe(text("Пользователь с указанным email не найден\n" +
                "\n" +
                "\n"));
    }
    @Step("Перейти на вкладку Travel")
    public void goToTravelPage() {
        $x("//*[@data-widget= 'horizontalMenu']//*[text()='Ozon Travel']").click();
    }
    @Step("Ввести значения from to")
    public void enterValue(String from, String to) {
        $x("//*[@data-widget= 'horizontalMenu']//*[text()='Ozon Travel']").click();
        $x(" //div[@data-widget='container']//*[@data-widget='searchForm']//*[@name = 'travelSearchFrom']").setValue(from);
        $x("//*[@class ='vue-portal-target']//div[@role ='option']/div/span[text()='"+ from +"']").click();
        $x(" //div[@data-widget='container']//*[@data-widget='searchForm']//*[@name = 'travelSearchTo']").setValue(to);
        $x("//*[@class ='vue-portal-target']//div[@role ='option']/div/span[text()='"+ to +"']").click();
    }
    @Step("Открыть календарь")
    public void openCalendar(){
        $x(" //*[@data-widget='searchForm']//div[4]").click();
    }
    @Step("Выбрать дату")
    public void chooseDay(Integer dayOfMonth){
        String dayText= String.format("\n" +
                "    %d\n" +
                "  ", dayOfMonth);
        $x(String.format("//div[text()='%s']", dayText)).click();
    }
    @Step("Нажать кнопку найти")
    public void pressButtonSearch(){
        $x("//*[@data-widget='searchForm']//div[6]//*[text()='Найти билеты']").click();
    }
    @Step("Проверить, что в результате поиска найдены билеты")
    public void checkResultsSearch(){
        $x("//*[@id=\"layoutPage\"]/div[1]/div[3]/div[1]/div/div/p").shouldHave(exactText("Получаем расписание рейсов"));
        sleep(10000);
        Selenide.switchTo().frame("frame");
        $$x("//*[@id=\"__next\"]/div/div[2]/div/div[4]/div[2]/div[1]").should(CollectionCondition.sizeNotEqual(0));
    }


}
