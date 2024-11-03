package pageObjects.web.general;

import commons.web.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.web.admin.LuongPheDuyetPO;
import pageUIs.web.general.TrangChuPageUI;

public class TrangChuPO extends BasePage {
    WebDriver driver;

    public TrangChuPO(WebDriver driver) {
        this.driver = driver;
    }

    public String userNameText() {
        waitForElementVisible(driver, TrangChuPageUI.NAME_USER_LOGGED_IN);
        return getElementText(driver, TrangChuPageUI.NAME_USER_LOGGED_IN);
    }

    public LuongPheDuyetPO clickToSubmenuInVanPhong() {
        String menu = getElementAttribute(driver, TrangChuPageUI.MENU_VAN_PHONG, "class");
        WebElement submenu = driver.findElement(By.xpath(TrangChuPageUI.SUBMENU_IN_VAN_PHONG_BY_NAME));
        if(menu == "hidden"){
            clickToElement(driver, TrangChuPageUI.MENU_VAN_PHONG);
            waitForElementClickable(driver, TrangChuPageUI.SUBMENU_IN_VAN_PHONG_BY_NAME);
            submenu.click();
            sleepInSecond(4);
        }else {
            waitForElementClickable(driver, TrangChuPageUI.SUBMENU_IN_VAN_PHONG_BY_NAME);
            submenu.click();
            sleepInSecond(4);
        }
        return PageGenerator.getLuongPheDuyetPage(driver);
    }
}