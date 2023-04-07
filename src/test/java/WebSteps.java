import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    private static final int numberISSUE = 2;

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".js-site-search-focus").setValue("AdelKurysheva/qa.guru_hw4").pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(".repo-list .v-align-middle").click();
    }

    @Step("Открываем Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue #" + numberISSUE)
    public void shouldSeeIssueWithNumber() {
        $(withText("#" + numberISSUE)).should(Condition.visible);
    }
}
