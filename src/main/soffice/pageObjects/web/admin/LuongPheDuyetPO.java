package pageObjects.web.admin;

import commons.web.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.web.general.PageGenerator;
import pageUIs.web.admin.PheDuyetPageUI;

public class LuongPheDuyetPO extends BasePage {
    WebDriver driver;

    public LuongPheDuyetPO(WebDriver driver) {
        this.driver = driver;
    }

    public CauHinhPheDuyetPO clickToThemMoiButton() {
        waitForElementClickable(driver, PheDuyetPageUI.THEM_MOI_BUTTON);
        clickToElement(driver, PheDuyetPageUI.THEM_MOI_BUTTON);
        sleepInSecond(2);
        return PageGenerator.getTaoMoiPheDuyetPage(driver);
    }

    public String pheDuyetNewlyIsDisplayedInListByName() {
        waitForElementVisible(driver, PheDuyetPageUI.BAN_GHI_VUA_TAO_ROW_1);
        return getElementText(driver, PheDuyetPageUI.BAN_GHI_VUA_TAO_ROW_1);
    }
}