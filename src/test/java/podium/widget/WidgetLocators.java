package podium.widget;

import org.openqa.selenium.By;

public class WidgetLocators {
    public static final By WIDGET_MODAL = By.cssSelector(".Modal--widgetLauncherShown");
    public static final By SEARCH_INPUT = By.name("Search Locations") ;
    public static final By CLEAR_SEARCH_INPUT = By.cssSelector("#iron > [x='0']");
    public static final By SEARCHRESULT1 = By.cssSelector(".StaggerFadeIn3");
    public static final By SEARCHRESULT2 = By.cssSelector(".StaggerFadeIn4");
    public static final By SEARCHRESULT3 = By.cssSelector(".StaggerFadeIn5");
    public static final By CONTACT_FORM = By.cssSelector(".SendSmsPage__FormContainer");
    public static final By CONTACT_FORM_HEADER = By.cssSelector(".SendSmsPage__HeaderContainer");
    public static final By CONTACT_FORM_GO_BACK_ARROW = By.cssSelector(".SendSmsPage__ArrowIcon");
    public static final By CONTACT_FORM_NAME = By.id("Name");
    public static final By CONTACT_FORM_MOBILE = By.id("Mobile Phone");
    public static final By CONTACT_FORM_MESSAGE = By.id("Message");
    public static final By LEGAL_TEXT = By.cssSelector(".Legal__text");
    public static final By TERMS_OF_USE_LINK = By.xpath("//div[@id='ComposeMessage']//a[.='use is subject to terms']");
    public static final By TERMS_OF_USE_PAGE_LOCATOR = By.id("contract-nav-168939");
    public static final By SEND_BUTTON = By.cssSelector(".SendButton");
    public static final By NAME_VALIDATION_CHECK_MARK = By.cssSelector(".SendSmsPage__FormContent > div:nth-of-type(1) .checkmark__check") ;
    public static final By NAME_MOBILE_PHONE_CHECK_MARK = By.cssSelector(".TextInput--tel .checkmark__check");
    public static By HI = By.cssSelector("h1");
    public static By CLOSED_WIDGET = By.cssSelector(".ContactBubble__IconContainer");
    public static By CLOSE_WIDGET_X = By.cssSelector("polygon");
    public static By EXPANDED_WIDGET = By.cssSelector(".Modal__Body");
}
