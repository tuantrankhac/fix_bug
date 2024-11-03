package pageObjects.web.general;

import commons.web.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.web.user.PheDuyetPO;
import pageUIs.web.general.DangNhapPageUI;

import java.util.List;

public class DangNhapPO extends BasePage {
    WebDriver driver;

    public DangNhapPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean vaiTroDangNhapOptionsIsDisplayed() {
        waitForElementVisible(driver, DangNhapPageUI.VAI_TRO_LOGIN_DROPDOWN);
        return isElementDisplayed(driver, DangNhapPageUI.VAI_TRO_LOGIN_DROPDOWN);
    }

    public boolean nhapSoDienThoaiTextboxIsdisplay() {
        waitForElementVisible(driver, DangNhapPageUI.USER_TEXTBOX);
        return isElementDisplayed(driver, DangNhapPageUI.USER_TEXTBOX);
    }

    public boolean nhapMatKhauTextboxIsDisplayed() {
        waitForElementVisible(driver, DangNhapPageUI.MAT_KHAU_TEXTBOX);
        return isElementDisplayed(driver, DangNhapPageUI.MAT_KHAU_TEXTBOX);

    }

    public boolean dangNhapButtonIsDisplayed() {
        waitForElementVisible(driver, DangNhapPageUI.DANG_NHAP_BUTTON);
        return isElementDisplayed(driver, DangNhapPageUI.DANG_NHAP_BUTTON);
    }

    public void selectVaiTroDangNhapByName(String optionName) {
        waitForElementClickable(driver, DangNhapPageUI.VAI_TRO_LOGIN_DROPDOWN);
        clickToElement(driver, DangNhapPageUI.VAI_TRO_LOGIN_DROPDOWN);
        List<WebElement> options = getListWebElement(driver, DangNhapPageUI.OPTION_LOGIN_DROPDOWN);
        for (WebElement option: options){
            if(option.getText().contains(optionName)){
                option.click();
                break;
            }
        }
    }



    public void enterToTenDNTextbox(String userName) {
        waitForElementVisible(driver, DangNhapPageUI.QTV_TEXTBOX);
        sendkeyToElement(driver, DangNhapPageUI.QTV_TEXTBOX, userName);
    }

    public void enterToSDTTextbox(String userName) {
        waitForElementVisible(driver, DangNhapPageUI.USER_TEXTBOX);
        sendkeyToElement(driver, DangNhapPageUI.USER_TEXTBOX, userName);
    }

    public void enterToMatKhauTextbox(String password) {
        waitForElementVisible(driver, DangNhapPageUI.MAT_KHAU_TEXTBOX);
        sendkeyToElement(driver, DangNhapPageUI.MAT_KHAU_TEXTBOX, password);
    }

    public TrangChuPO clickToDangNhapButton() {
        waitForElementClickable(driver, DangNhapPageUI.DANG_NHAP_BUTTON);
        clickToElement(driver, DangNhapPageUI.DANG_NHAP_BUTTON);
        return PageGenerator.getTrangChuPage(driver);
    }

    public PheDuyetPO clickToDangNhapButtonUser() {
        waitForElementClickable(driver, DangNhapPageUI.DANG_NHAP_BUTTON);
        clickToElement(driver, DangNhapPageUI.DANG_NHAP_BUTTON);
        return PageGenerator.getPheDuyetPage(driver);
    }
}