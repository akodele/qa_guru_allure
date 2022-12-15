package annotation;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Annotation {
    @Test
    @DisplayName("Простой тест с использованием Allure аннотации Steps")
    void testAnnotation() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Steps steps=new Steps();
        steps.openPage();
        steps.search();
        steps.openLink();
        steps.checkExisting();

    }
}
