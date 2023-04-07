import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaAllureReportTest {
    private static final String REPOSITORY = "AdelKurysheva/qa.guru_hw4";
    private static final int numberISSUE = 2;

    @BeforeEach
    void beforeEach() {
        Configuration.browser = "edge";
    }

    @Test
    public void testLambdaAllure() {
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".js-site-search-focus").setValue(REPOSITORY).pressEnter();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(".repo-list .v-align-middle").click();
        });
        step("Открываем Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue #" + numberISSUE, () -> {
            $(withText("#" + numberISSUE)).should(Condition.visible);
        });

    }
}
