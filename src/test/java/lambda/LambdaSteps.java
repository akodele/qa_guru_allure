package lambda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaSteps {
    @Test
    @DisplayName("Тест с использованием Allure Lambda Steps")
    void testLambda(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу github.com",()->{
            open("https://github.com");
        });
        step("Нажимаем на поле ввода поиска",()->{
            $(".header-search-input").click();
        });
        step("Вводим значение akodele/qa_guru_allure",()->{
            $(".header-search-input").sendKeys("akodele/qa_guru_allure");
        });
        step("Производим поиск",()->{
            $(".header-search-input").submit();
        });
        step("Открываем ссылку akodele/qa_guru_allure",()->{
            $(linkText("akodele/qa_guru_allure")).click();
        });
        step("Нажимаем на вкладку Issue",()->{
            $("#issues-tab").click();
        });
        step("Проверяем наличие элемента с текстом Issue",()->{
            $(withText("Issue")).should(Condition.exist);
        });

    }
}
