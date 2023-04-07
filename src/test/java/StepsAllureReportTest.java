import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StepsAllureReportTest {
    private static final String REPOSITORY = "AdelKurysheva/qa.guru_hw4";

    @BeforeEach
    void beforeEach() {
        Configuration.browser = "edge";
    }

    @Test
    public void testStepsAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber();
    }
}
