package pageObjects.web.admin;

import commons.web.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.web.admin.CauHinhPheDuyetPageUI;
import utilities.StringUtil;

import java.util.List;

import static utilities.StringUtil.parseStringToObject;

public class CauHinhPheDuyetPO extends BasePage {
    WebDriver driver;

    public CauHinhPheDuyetPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean tenPheDuyetTextboxIsDisplayed() {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.TEN_PHE_DUYET_TEXTBOX);
        return isElementDisplayed(driver, CauHinhPheDuyetPageUI.TEN_PHE_DUYET_TEXTBOX);
    }

    public boolean trangThaiButtonIsDisplayed() {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.TRANG_THAI_BUTTON);
        return isElementDisplayed(driver, CauHinhPheDuyetPageUI.TRANG_THAI_BUTTON);
    }
    public boolean moTaTextareaIsDisplayed() {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.MO_TA_TEXTAREA);
        return isElementDisplayed(driver, CauHinhPheDuyetPageUI.MO_TA_TEXTAREA);
    }


    public boolean loaiPheDuyetSelectboxIsDisplayed() {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.DROPDOWN_LOAI_PHE_DUYET);
        return isElementDisplayed(driver, CauHinhPheDuyetPageUI.DROPDOWN_LOAI_PHE_DUYET);
    }

    public boolean phongBanSelectboxIsDisplayed() {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.PHONG_BAN_DROPDOWN);
        return isElementDisplayed(driver, CauHinhPheDuyetPageUI.PHONG_BAN_DROPDOWN);
    }

    public boolean filedIsDisplayByName(String nameField) {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.DYNAMIC_FIELD_IN_CAU_HINH, nameField);
        return isElementDisplayed(driver, CauHinhPheDuyetPageUI.DYNAMIC_FIELD_IN_CAU_HINH, nameField);
    }

    public void clickToButtonByName(String nameButton) {
        waitForElementClickable(driver, CauHinhPheDuyetPageUI.DYNAMIC_BUTON_BY_NAME,nameButton);
        clickToElement(driver, CauHinhPheDuyetPageUI.DYNAMIC_BUTON_BY_NAME, nameButton);
    }

    public String messageRequireTextIsDisplayed() {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.MESSAGE_BAT_BUOC_TEXT);
        return getElementText(driver, CauHinhPheDuyetPageUI.MESSAGE_BAT_BUOC_TEXT);
    }

    public void deleteDataEnteredToTenPheDuyet() {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.TEN_PHE_DUYET_TEXTBOX);
        cleaDateEnteredToTextbox(driver, CauHinhPheDuyetPageUI.TEN_PHE_DUYET_TEXTBOX);
    }


    public void enterToMoTaTextbox(String value) {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.MO_TA_TEXTAREA);
        sendkeyToElement(driver, CauHinhPheDuyetPageUI.MO_TA_TEXTAREA,value);
    }

    public void selectPhongBanApDungByName(String textSearch, String namePhongBan) {
        namePhongBan = namePhongBan.trim();
        waitForElementClickable(driver, CauHinhPheDuyetPageUI.PHONG_BAN_DROPDOWN);
        clickToElement(driver, CauHinhPheDuyetPageUI.PHONG_BAN_DROPDOWN);
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.SEARCH_PHONG_BAN_TEXTBOX);
        sendkeyToElement(driver, CauHinhPheDuyetPageUI.SEARCH_PHONG_BAN_TEXTBOX, textSearch);
        List<WebElement> pbs = getListWebElement(driver, CauHinhPheDuyetPageUI.LIST_PHONG_BAN);
        for (WebElement pb:pbs){
            if(pb.getText().equals(namePhongBan)){
                WebElement checkbox = pb.findElement(By.xpath(CauHinhPheDuyetPageUI.CHECKBOX_PHONG_BAN_BY_NAME));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", checkbox);
                break;
            }
        }
    }

    public void clickToToggleTrangThai() {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.TRANG_THAI_BUTTON);
        clickToElement(driver, CauHinhPheDuyetPageUI.TRANG_THAI_BUTTON);
    }

    public void deleteDataEnteredToMoTa() {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.MO_TA_TEXTAREA);
        cleaDateEnteredToTextbox(driver, CauHinhPheDuyetPageUI.MO_TA_TEXTAREA);
    }

    public void enterToTenPheDuyetTextbox(String value) {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.TEN_PHE_DUYET_TEXTBOX);
        sendkeyToElement(driver, CauHinhPheDuyetPageUI.TEN_PHE_DUYET_TEXTBOX,value);
    }

    public void deleteOptionInPhongBan() {
        waitForElementClickable(driver, CauHinhPheDuyetPageUI.X_BUTTON);
        clickToElement(driver, CauHinhPheDuyetPageUI.X_BUTTON);
    }

    public void clickToFieldInCauHinhByName(String nameField) {
        waitForElementClickable(driver, CauHinhPheDuyetPageUI.DYNAMIC_FIELD_IN_CAU_HINH,nameField);
        clickToElement(driver, CauHinhPheDuyetPageUI.DYNAMIC_FIELD_IN_CAU_HINH, nameField);
    }

    public boolean fieldsIsDisplayedByName(String nameField) {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.TEXTBOX_IN_CAU_HINH_BY_NAME, nameField);
        return isElementDisplayed(driver, CauHinhPheDuyetPageUI.TEXTBOX_IN_CAU_HINH_BY_NAME, nameField);
    }

    public boolean loaiDanhSachIsDisplayed() {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.DROPDOWN_LOAI_DANH_SACH);
        return isElementDisplayed(driver, CauHinhPheDuyetPageUI.DROPDOWN_LOAI_DANH_SACH);
    }

    public boolean toggleIsDisplayedByName(String nameToggle) {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.TOGGLE_IN_CAU_HINH_BY_NAME,nameToggle);
        return isElementDisplayed(driver, CauHinhPheDuyetPageUI.TOGGLE_IN_CAU_HINH_BY_NAME,nameToggle);
    }

    public void clickToButtonInCauHinhByName(String nameButton) {
        waitForElementClickable(driver, CauHinhPheDuyetPageUI.DYNAMIC_BUTON_IN_CAU_HINH_BY_NAME,nameButton);
        clickToElement(driver, CauHinhPheDuyetPageUI.DYNAMIC_BUTON_IN_CAU_HINH_BY_NAME, nameButton);
        sleepInSecond(2);
    }

    public boolean tenPopupIsDisplayedByName(String namePopup) {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.DYNAMIC_TEN_POPUP,namePopup);
        return isElementDisplayed(driver, CauHinhPheDuyetPageUI.DYNAMIC_TEN_POPUP, namePopup);
    }

    public void enterToTextboxInCauHinhByName(String nameField, String value) {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.TEXTBOX_IN_CAU_HINH_BY_NAME, nameField);
        sendkeyToElement(driver, CauHinhPheDuyetPageUI.TEXTBOX_IN_CAU_HINH_BY_NAME, value,nameField);
    }

    public boolean fieldCreatedIsDisplayedByName(String tenTruong) {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.FIELD_CREATED_IN_CAU_HINH, tenTruong);
        return isElementDisplayed(driver, CauHinhPheDuyetPageUI.FIELD_CREATED_IN_CAU_HINH, tenTruong);
    }

    public void clickToToggleByName(String nameToggle) {
        waitForElementClickable(driver, CauHinhPheDuyetPageUI.TOGGLE_IN_CAU_HINH_BY_NAME,nameToggle);
        clickToElement(driver, CauHinhPheDuyetPageUI.TOGGLE_IN_CAU_HINH_BY_NAME,nameToggle);
    }

    public void chonLoaiDanhSachByName(String nameOption) {
        waitForElementClickable(driver, CauHinhPheDuyetPageUI.DROPDOWN_LOAI_DANH_SACH);
        clickToElement(driver, CauHinhPheDuyetPageUI.DROPDOWN_LOAI_DANH_SACH);
        List<WebElement> options = getListWebElement(driver, CauHinhPheDuyetPageUI.OPTION_LOAI_DANH_SACH);
        for (WebElement option : options){
            if (option.getText().contains(nameOption)){
                option.click();
                break;
            }
        }
    }

    public void enterDanhSachToTextbox(String value) {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.NHAP_DANH_SACH_TEXTBOX);
        sendkeyToElement(driver, CauHinhPheDuyetPageUI.NHAP_DANH_SACH_TEXTBOX, value);
    }

    public boolean optionPheDuyetIsDisplayedByName(String nameOption) {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.OPTION_PHE_DUYET, nameOption);
        return isElementDisplayed(driver, CauHinhPheDuyetPageUI.OPTION_PHE_DUYET, nameOption);
    }

    public void clickToOptionPheDuyetByName(String nameOption) {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.OPTION_PHE_DUYET, nameOption);
        clickToElement(driver, CauHinhPheDuyetPageUI.OPTION_PHE_DUYET, nameOption);
    }

    public void seachAndSelectNguoiPheDuyetByName(String textSearch, String nameNguoiPheDuyet) {
        waitForElementClickable(driver, CauHinhPheDuyetPageUI.DROPDOWN_NGUOI_PHE_DUYET);
        clickToElement(driver, CauHinhPheDuyetPageUI.DROPDOWN_NGUOI_PHE_DUYET);
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.SEARCH_NGUOI_PHE_DUYET_TEXTBOX);
        sendkeyToElement(driver, CauHinhPheDuyetPageUI.SEARCH_NGUOI_PHE_DUYET_TEXTBOX, textSearch);

        parseStringToObject(CauHinhPheDuyetPageUI.NGUOI_PHE_DUYET,nameNguoiPheDuyet);
        clickToElement(driver, parseStringToObject(CauHinhPheDuyetPageUI.NGUOI_PHE_DUYET,nameNguoiPheDuyet));
    }

    public boolean nguoiNhanThongBaoIsDisplayed() {
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.DROPDOWN_NGUOI_NHAN_TB);
        return isElementDisplayed(driver, CauHinhPheDuyetPageUI.DROPDOWN_NGUOI_NHAN_TB);
    }

    public void searchAndSelectNguoiNhanThongBaoByName(String textSearch, String nameUser) {
        nameUser = nameUser.trim();
        waitForElementClickable(driver, CauHinhPheDuyetPageUI.DROPDOWN_NGUOI_NHAN_TB);
        clickToElement(driver, CauHinhPheDuyetPageUI.DROPDOWN_NGUOI_NHAN_TB);
        waitForElementVisible(driver, CauHinhPheDuyetPageUI.SEARCH_NGUOI_NHAN_TB_TEXTBOX);
        sendkeyToElement(driver, CauHinhPheDuyetPageUI.SEARCH_NGUOI_NHAN_TB_TEXTBOX, textSearch);
//       // List<WebElement> users = getListWebElement(driver, CauHinhPheDuyetPageUI.LIST_NGUOI_PHE_DUYET);
//        for (WebElement user:users){
//            if(user.getText().equals(nameUser)){
//                JavascriptExecutor js = (JavascriptExecutor) driver;
//                js.executeScript("arguments[0].click();", user);
//                break;
//            }
//        }
    }

    public void closePopupChonPhongBan() {
        clickOutside(driver, CauHinhPheDuyetPageUI.OUTSITE);
    }

}