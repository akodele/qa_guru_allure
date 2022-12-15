package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SimpleAllure {
    @Test
    @DisplayName("Простой тест с использованием Allure")
    void test(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("akodele/qa_guru_allure");
        $(".header-search-input").submit();

        $(linkText("akodele/qa_guru_allure")).click();
        $("#issues-tab").click();
        $(withText("Issue")).should(Condition.exist);
    }
}
