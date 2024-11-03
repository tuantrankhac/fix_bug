package pageObjects.web.user;

import commons.web.BasePage;
import constant.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageObjects.web.admin.CauHinhPheDuyetPO;
import pageObjects.web.general.PageGenerator;
import pageUIs.web.admin.PheDuyetPageUI;

public class PheDuyetPO extends BasePage {
    WebDriver driver;

    public PheDuyetPO(WebDriver driver) {
        this.driver = driver;
    }


    public void uploadFile(WebDriver driver, String xpathLocator, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_FILE_FOLDER;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getWebElement(driver, xpathLocator).sendKeys(fullFileName);
    }
}