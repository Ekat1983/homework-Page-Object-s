package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
  private final SelenideElement heading = $("[data-test-id='dashboard']");
  private final SelenideElement transferAmount = $("[data-test-id='amount'] input");
  private final SelenideElement transferFrom = $("[data-test-id='from'] input");
  private final SelenideElement transferButton = $("[data-test-id='action-transfer'].button");
  private final SelenideElement errorMassage = $("[data-test-id='error-notification'] .notification__content");

  public TransferPage() {
    heading.shouldBe(Condition.visible);
  }

  public void transferPageErrorMassage() {
    errorMassage.shouldHave(exactText("Ошибка!"))
            .shouldBe(Condition.visible);
  }

  public DashboardPage transferMoney(String cardFrom, int sum) {
    transferAmount.sendKeys(Keys.LEFT_CONTROL + "A");
    transferAmount.sendKeys(Keys.BACK_SPACE);
    transferAmount.setValue(String.valueOf(sum));
    transferFrom.sendKeys(Keys.LEFT_CONTROL + "A");
    transferFrom.sendKeys(Keys.BACK_SPACE);
    transferFrom.setValue(cardFrom);
    transferButton.click();
    return new DashboardPage();
  }
}