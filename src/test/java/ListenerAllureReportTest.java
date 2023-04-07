import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ListenerAllureReportTest {
    private static final String REPOSITORY = "AdelKurysheva/qa.guru_hw4";
    private static final int numberISSUE = 2;

    @BeforeEach
    void beforeEach() {
        Configuration.browser = "edge";
    }

    @Test
    public void testListenerAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".js-site-search-focus").setValue(REPOSITORY).pressEnter();
        $(".repo-list .v-align-middle").click();
        $("#issues-tab").click();
        $(withText("#" + numberISSUE)).should(Condition.visible);

    }
}
