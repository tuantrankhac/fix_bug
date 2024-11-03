package testSuites.web.user;

import commons.web.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.web.general.DangNhapPO;
import pageObjects.web.general.PageGenerator;
import pageObjects.web.user.PheDuyetPO;

public class
Tao_Ban_Nhap_Phe_Duyet_Email extends BaseTest {

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        log.info("Pre-Condition: Step 01: Open Browser: " + browserName + ", URL: " + appUrl);
        driver = getBrowserDriver(browserName, appUrl);

        dangNhapPO = PageGenerator.getDangNhapPage(driver);

        log.info("Chọn đăng nhập với vai trò Nhân viên");
        dangNhapPO.selectVaiTroDangNhapByName("Nhân viên");
        log.info("Nhập số điện thoại hoặc email");
        dangNhapPO.enterToSDTTextbox("0342992929");
        log.info("Nhập vào mật khẩu");
        dangNhapPO.enterToMatKhauTextbox("abc123");
        log.info("Click vào nút Đăng nhập");
        pheDuyetPO = dangNhapPO.clickToDangNhapButtonUser();
    }

    @Test (description = "Tạo bản nháp không nhập vào các trường bắt buộc")
    public void Auto_Web_PD165_Luu_Ban_Nhap_Trong_Cac_Truong_Bat_Buoc() {
        log.info("Click vào nút + để thêm mới phê duyệt");

        log.info("Verify popup Thêm phê duyệt hiển thị");

        log.info("Click vào THÊM PHÊ DUYỆT EMAIL");

        log.info("Click vào nút Lưu nháp");

        log.info("Verify message bắt buộc hiển thị");

    }

    @Test (description = "Lưu thành công bản nháp với các trường được nhập")
    public void Auto_Web_PD166_Luu_Ban_Nhap_Thanh_Cong() {
        log.info("Nhập vào tất cả các trường");

        log.info("Verify message tạo bản nháp thành công");

        log.info("Click vào mục Bản nháp");

        log.info("Verify bản bản nháp vừa tạo được hiển thị");

        log.info("Verify data đã nhập khi lưu nháp");

    }

    @Test (description = "Cập nhật bản nháp")
    public void Auto_Web_PD167_Huy_Chinh_Sua_Ban_Nhap() {
        log.info("Chỉnh sửa data tại các trường");

        log.info("Click vào nút Hủy");

        log.info("Click bản bản nháp vừa sửa data");

        log.info("Verify data đã nhập khi lưu nháp có bị thay đổi không");

    }

    @Test (description = "Cập nhật bản nháp")
    public void Auto_Web_PD168_Chinh_Sua_Ban_Nhap_Thanh_Cong() {
        log.info("Chỉnh sửa data tại các trường");

        log.info("Click vào nút Lưu nháp");

        log.info("Click bản bản nháp vừa lưu");

        log.info("Verify data mới sửa");
    }

    @Test (description = "Gửi bản nháp")
    public void Auto_Web_PD169_Gui_Ban_Nhap_De_Trong_Truong_Bat_Buoc() {
        log.info("Xóa data đã nhập tại các trường bắt buộc");

        log.info("Click vào nút Gửi");

        log.info("Verify message hiển thị");
    }

    @Test (description = "Gửi bản nháp")
    public void Auto_Web_PD170_Gui_Ban_Nhap_Thanh_Cong() {
        log.info("Click vào nút Gửi");

        log.info("Verify message hiển thị");

        log.info("Kiểm tra bản nháp hiển thị tại mục Bản nháp");

        log.info("Kiểm tra bản nháp hiển thị tại mục Đã gửi");

    }

    @Test (description = "Xóa bản nháp")
    public void Auto_Web_PD171_Huy_Xoa_Ban_Nhap() {
        log.info("Tạo mới bản nháp");

        log.info("Mở mục Bản nháp");

        log.info("Verify icon Thùng rác (xóa) được hiển thị trên bản nháp");

        log.info("Click vào nút Thùng rác");

        log.info("Click vào nút Hủy");

        log.info("Kiểm tra bản nháp vẫn được hiển thị");
    }

    @Test (description = "Xóa bản nháp")
    public void Auto_Web_PD172_Xoa_Ban_Nhap_Thanh_Cong() {
        log.info("Click vào nút Thùng rác");

        log.info("Click vào nút Xóa");

        log.info("Kiểm tra bản nháp đã được xóa");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        cleanBrowserAndDriver();
    }

    WebDriver driver;
    DangNhapPO dangNhapPO;
    PheDuyetPO pheDuyetPO;

}
