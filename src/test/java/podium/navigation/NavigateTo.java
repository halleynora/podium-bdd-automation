package podium.navigation;

import net.thucydides.core.annotations.Step;

import java.net.MalformedURLException;

public class NavigateTo {

    PodiumWidgetHomePage podiumWidgetHomePage;
    @Step("Acquire client home page is loaded")
    public void podiumWidgetHomePageIsLoaded() throws MalformedURLException {
        podiumWidgetHomePage.getDriver().manage().deleteAllCookies();
        podiumWidgetHomePage.open();
        podiumWidgetHomePage.getDriver().manage().window().maximize();
    }
}
