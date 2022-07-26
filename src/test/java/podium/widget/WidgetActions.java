package podium.widget;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Set;

public class WidgetActions extends UIInteractionSteps {

    private final Duration duration = Duration.ofSeconds(30);
    private final Duration pollingEvery = Duration.ofSeconds(3);
    private EnvironmentVariables environmentVariables;

    public void initializeWidget() {
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.presenceOfElementLocated(WidgetLocators.HI));
        switchIntoFrame("podium-bubble");
        $(WidgetLocators.CLOSED_WIDGET).click();
        getDriver().switchTo().defaultContent();
    }

    private void switchIntoFrame(String frameId){
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
    }

    public void assertWidgetIsLoaded() {
        switchIntoFrame("podium-modal");
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.SEARCH_INPUT));
        Assert.assertTrue($(WidgetLocators.EXPANDED_WIDGET).isDisplayed());
        Assert.assertTrue($(WidgetLocators.SEARCH_INPUT).isDisplayed());
    }

    public void closeWidget() {
        getDriver().switchTo().defaultContent();
        switchIntoFrame("podium-bubble");
        $(WidgetLocators.CLOSE_WIDGET_X).click();
    }

    public void assertWidgetIsClosed() {
        Assert.assertFalse(getDriver().getPageSource().contains("podium-modal"));
    }

    public void searchForZipcode(String zipcode) {
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.SEARCH_INPUT));
        $(WidgetLocators.SEARCH_INPUT).type(zipcode);
    }

    public void clearSearchInputField() {
        $(WidgetLocators.CLEAR_SEARCH_INPUT).click();
    }

    public void assertThreeSearchResultsVisibleClickable() {
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.SEARCHRESULT1));
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.SEARCHRESULT2));
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.SEARCHRESULT3));

        Assert.assertTrue($(WidgetLocators.SEARCHRESULT1).isClickable());
        Assert.assertTrue($(WidgetLocators.SEARCHRESULT2).isClickable());
        Assert.assertTrue($(WidgetLocators.SEARCHRESULT3).isClickable());

    }

    public void clickOnFirstSearchResult() {
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.SEARCHRESULT1));
        String searchResult = getDriver().findElement(WidgetLocators.SEARCHRESULT1).getText();
        Serenity.setSessionVariable("search_result_1").to(searchResult);
        $(WidgetLocators.SEARCHRESULT1).click();
    }

    public void assertFormIsDisplayed() {
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.CONTACT_FORM));
        Assert.assertTrue($(WidgetLocators.CONTACT_FORM).isDisplayed());
    }

    public void clickSendButton() {
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.SEND_BUTTON));
        $(WidgetLocators.SEND_BUTTON).click();
    }

    public void assertValidationMessage(String validationMessage) {
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='"+validationMessage+"']")));
        String message = getDriver().findElement(By.xpath("//div[.='"+validationMessage+"']")).getText();
        Assert.assertTrue(validationMessage.equalsIgnoreCase(message));
    }

    public void assertHeaderTextIsVisible() {
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.CONTACT_FORM_HEADER));
        //Retrieving saved search text from search results and asserting they are equal to header text on the contact form.
        String searchResultText = Serenity.sessionVariableCalled("search_result_1").toString();
        String headerText = $(WidgetLocators.CONTACT_FORM_HEADER).getText();
        Assert.assertTrue(searchResultText.equalsIgnoreCase(headerText));
        Assert.assertTrue($(WidgetLocators.CONTACT_FORM_HEADER).isDisplayed());
    }

    public void assertBackArrowIsVisibleClickable() {
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.CONTACT_FORM_GO_BACK_ARROW));
        Assert.assertTrue($(WidgetLocators.CONTACT_FORM_GO_BACK_ARROW).isDisplayed());
        Assert.assertTrue($(WidgetLocators.CONTACT_FORM_GO_BACK_ARROW).isClickable());
    }

    public void assertFooterTextIsVisible() {
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.LEGAL_TEXT));
        Assert.assertTrue($(WidgetLocators.LEGAL_TEXT).isDisplayed());
    }

    public void assertTermsOfUseVisibleClickable() {
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.TERMS_OF_USE_LINK));
        Assert.assertTrue($(WidgetLocators.TERMS_OF_USE_LINK).isDisplayed());
        Assert.assertTrue($(WidgetLocators.TERMS_OF_USE_LINK).isClickable());
    }

    public void clickUseIsSubjectToTermsLink() {
        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.TERMS_OF_USE_LINK));
        $(WidgetLocators.TERMS_OF_USE_LINK).click();
    }

    public void assertTermsOfUsePageLoads(String url) {
        String parentWindow = getDriver().getWindowHandle();
        Set<String> allWindows = getDriver().getWindowHandles();
        for(String curWindow : allWindows){
            getDriver().switchTo().window(curWindow);
        }

        waitForCondition().withTimeout(duration).pollingEvery(pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(WidgetLocators.TERMS_OF_USE_PAGE_LOCATOR));
        Assert.assertTrue(getDriver().getCurrentUrl().equalsIgnoreCase(url));
        getDriver().switchTo().window(parentWindow);

    }
}
