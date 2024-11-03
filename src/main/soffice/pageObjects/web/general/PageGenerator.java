package pageObjects.web.general;

import org.openqa.selenium.WebDriver;
import pageObjects.web.admin.CauHinhPheDuyetPO;
import pageObjects.web.admin.LuongPheDuyetPO;
import pageObjects.web.user.PheDuyetPO;

public class PageGenerator {
	public static DangNhapPO getDangNhapPage(WebDriver driver){
		return new DangNhapPO(driver);
	}

	public static TrangChuPO getTrangChuPage(WebDriver driver){
		return new TrangChuPO(driver);
	}

	public static LuongPheDuyetPO getLuongPheDuyetPage(WebDriver driver){
		return new LuongPheDuyetPO(driver);
	}

	public static CauHinhPheDuyetPO getTaoMoiPheDuyetPage(WebDriver driver){
		return new CauHinhPheDuyetPO(driver);
	}

	public static PheDuyetPO getPheDuyetPage(WebDriver driver){
		return new PheDuyetPO(driver);
	}
}

