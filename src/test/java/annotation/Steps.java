package annotation;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Steps {

    @Step("Открываем страницу github.com")
    public void openPage(){
        open("https://github.com");
    }

    @Step("Производим поиск по тексту akodele/qa_guru_allure")
    public void search(){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("akodele/qa_guru_allure");
        $(".header-search-input").submit();
    }

    @Step("Открываем ссылку akodele/qa_guru_allure")
    public void openLink(){
        $(linkText("akodele/qa_guru_allure")).click();
    }

    @Step("Нажимаем на вкладку Issue")
    public void openTab(){
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие элемента с текстом Issue")
    public void checkExisting(){
        $(withText("Issue")).should(Condition.exist);
    }
}
