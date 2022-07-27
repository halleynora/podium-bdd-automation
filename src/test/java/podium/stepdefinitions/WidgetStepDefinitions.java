package podium.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import podium.navigation.NavigateTo;
import podium.widget.WidgetActions;

import java.net.MalformedURLException;

public class WidgetStepDefinitions {

    @Steps
    NavigateTo navigateTo;

    @Steps
    WidgetActions widgetActions;

    @Given("Podium widget page is loaded")
    public void podiumWidgetPageIsLoaded() throws MalformedURLException {
        navigateTo.podiumWidgetHomePageIsLoaded();
    }

    @And("click widget on bottom right corner of page")
    public void clickWidgetOnBottomRightCornerOfPage() {
        widgetActions.initializeWidget();
    }


    @Then("assert widget is loaded")
    public void assertWidgetIsLoaded() {
        widgetActions.assertWidgetIsLoaded();
    }

    @And("click wiget X close button")
    public void clickWigetXCloseButton() {
        widgetActions.closeWidget();
    }

    @Then("assert widget is closed")
    public void assertWidgetIsClosed() {
        widgetActions.assertWidgetIsClosed();
    }

    @And("search for {word}")
    public void searchForZipcode(String zipcode) {
        widgetActions.searchForZipcode(zipcode);
    }

    @Then("assert 3 search results are displayed and clickable")
    public void assertSearchResultsAreDisplayedAndClickable() {
        widgetActions.assertThreeSearchResultsVisibleClickable();
    }

    @Then("clear search input field")
    public void clearSearchInputField() {
        widgetActions.clearSearchInputField();
    }

    @And("click on first search result")
    public void clickOnFirstSearchResult() {
        widgetActions.clickOnFirstSearchResult();
    }

    @Then("assert form is displayed")
    public void assertFormIsDisplayed() {
        widgetActions.assertFormIsDisplayed();
    }

    @And("click SEND button")
    public void clickSENDButton() {
        widgetActions.clickSendButton();
    }

    @Then("assert validation message {string} is displayed")
    public void assertValidationMessageIsDisplayed(String validationMessage) {
        widgetActions.assertValidationMessage(validationMessage);
    }

    @Then("assert Header text is visible")
    public void assertHeaderTextIsVisible() {
        widgetActions.assertHeaderTextIsVisible();
    }

    @Then("assert back arrow is visible and clickable")
    public void assertBackArrowIsVisibleAndClickable() {
        widgetActions.assertBackArrowIsVisibleClickable();
    }

    @Then("assert Footer text is visible")
    public void assertFooterTextIsVisible() {
        widgetActions.assertFooterTextIsVisible();
    }

    @Then("assert Terms of Use link is visible and clickable")
    public void assertTermsOfUseLinkIsVisibleClickable() {
        widgetActions.assertTermsOfUseVisibleClickable();
    }

    @And("click link Use is subject to terms")
    public void clickLinkUseIsSubjectToTerms() {
        widgetActions.clickUseIsSubjectToTermsLink();
    }

    @Then("assert a new web page is opened and url is {string}")
    public void assertANewWebPageIsOpenedAndUrlIs(String url) {
        widgetActions.assertTermsOfUsePageLoads(url);
    }

    @And("enter Name Mobile and Message")
    public void enterNameMobileAndMessage() {
        widgetActions.enterFormSubmissionDetails();
    }

    @Then("assert validation checks marks are present to SUBMIT form")
    public void assertValidationChecksAreGreenToSUBMITForm() {
        widgetActions.assertGreenChecksToSubmitForm();
    }
}
