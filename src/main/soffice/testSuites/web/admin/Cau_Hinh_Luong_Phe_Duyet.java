package testSuites.web.admin;

import commons.web.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.web.admin.CauHinhPheDuyetPO;
import pageObjects.web.admin.LuongPheDuyetPO;
import pageObjects.web.general.TrangChuPO;
import pageObjects.web.general.DangNhapPO;
import pageObjects.web.general.PageGenerator;

public class
Cau_Hinh_Luong_Phe_Duyet extends BaseTest {
    String tenPheDuyet, moTa;
    String traLoiNgan_BatBuoc, traLoiNgan_0BatBuoc, goiY;
    String thoiGian_BatBuoc_ChonQK, thoiGian_BatBuoc_0ChonQK, thoiGian_0BatBuoc_ChonQK, thoiGian_0BatBuoc_0ChonQK;
    String danhSach_Chon1_BatBuoc, danhSach_Chon1_0BatBuoc, danhSach_ChonNhieu_BatBuoc, danhSach_ChonNhieu_0BatBuoc;
    String doanVan_BatBuoc, doanVan_0BatBuoc;
    String soanThao_BatBuoc, soanThao_0BatBuoc;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        log.info("Pre-Condition: Step 01: Open Browser: " + browserName + ", URL: " + appUrl);
        driver = getBrowserDriver(browserName, appUrl);

        tenPheDuyet = "Phê duyệt thông thường" + generateNumber();
        moTa = "Mô tả chi tiết";
        traLoiNgan_BatBuoc = "Trường trả lời ngắn bắt buộc";
        traLoiNgan_0BatBuoc = "Trường trả lời ngắn không bắt buộc";
        thoiGian_0BatBuoc_ChonQK = "Thời gian - Không bắt buộc - Chọn QK";
        thoiGian_0BatBuoc_0ChonQK = "Thời gian - Không bắt buộc - Không chọn QK";
        thoiGian_BatBuoc_0ChonQK = "Thời gian - Bắt buộc - Không chọn QK";
        thoiGian_BatBuoc_ChonQK = "Thời gian - Bắt buộc - Chọn QK";
        danhSach_Chon1_BatBuoc = "Danh sách chọn 1 - Bắt buộc";
        danhSach_Chon1_0BatBuoc = "Danh sách chọn 1 - Không bắt buộc";
        danhSach_ChonNhieu_BatBuoc = "Danh sách chọn nhiều - Bắt buộc";
        danhSach_ChonNhieu_0BatBuoc = "Danh sách chọn nhiều - Không bắt buộc";
        doanVan_BatBuoc = "Đoạn văn - Bắt buộc";
        doanVan_0BatBuoc = "Đoạn văn - Không bắt buộc";
        soanThao_BatBuoc = "Soạn thảo - Bắt buộc";
        soanThao_0BatBuoc = "Soạn thảo - Không bắt buộc";

        goiY = "Gợi ý";

        dangNhapPO = PageGenerator.getDangNhapPage(driver);

        log.info("Step 02: Kiem tra cac thanh phan hien thi");
        verifyTrue(dangNhapPO.vaiTroDangNhapOptionsIsDisplayed());
        verifyTrue(dangNhapPO.nhapSoDienThoaiTextboxIsdisplay());
        verifyTrue(dangNhapPO.nhapMatKhauTextboxIsDisplayed());
        verifyTrue(dangNhapPO.dangNhapButtonIsDisplayed());
        log.info("Step 03: Chon dang nhap voi vai tro Quan tri vien");
        dangNhapPO.selectVaiTroDangNhapByName("Quản trị viên");
        log.info("Step 04: Nhap so dien thoai hoac email");
        dangNhapPO.enterToTenDNTextbox("office.admin@smarthiz.vn");
        log.info("Step 05: Nhap vao mat khau");
        dangNhapPO.enterToMatKhauTextbox("Nothing@123");
        log.info("Step 06: Click vao nut Dang nhap");
        trangChuPO = dangNhapPO.clickToDangNhapButton();
        log.info("Step 07: Kiem tra dang nhap thanh cong");
        verifyEquals(trangChuPO.userNameText(), "OFFICE-SRT-S-ADMIN");
        log.info("Step 08: Mở submenu Luong phe duỵet");
        luongPheDuyetPO = trangChuPO.clickToSubmenuInVanPhong();
    }

    @Test
    public void Auto_Web_PD11_Button_Them_Moi() {
        log.info("Click vao button '+ Thêm mới'");
        cauHinhPheDuyetPO = luongPheDuyetPO.clickToThemMoiButton();
    }

//    @Test
    public void Auto_Web_PD15_Man_Them_Moi() {
        log.info("Kiểm tra các trường tại phần thông tin cơ bản");
        verifyTrue(cauHinhPheDuyetPO.trangThaiButtonIsDisplayed());
        verifyTrue(cauHinhPheDuyetPO.tenPheDuyetTextboxIsDisplayed());
        verifyTrue(cauHinhPheDuyetPO.moTaTextareaIsDisplayed());
        verifyTrue(cauHinhPheDuyetPO.loaiPheDuyetSelectboxIsDisplayed());
        verifyTrue(cauHinhPheDuyetPO.phongBanSelectboxIsDisplayed());
        log.info("Kiểm tra các trường tại phần thông Cấu hình");
        verifyTrue(cauHinhPheDuyetPO.filedIsDisplayByName("Trả lời ngắn"));
        verifyTrue(cauHinhPheDuyetPO.filedIsDisplayByName("Thời gian"));
        verifyTrue(cauHinhPheDuyetPO.filedIsDisplayByName("Danh sách"));
        verifyTrue(cauHinhPheDuyetPO.filedIsDisplayByName("Đoạn văn"));
        verifyTrue(cauHinhPheDuyetPO.filedIsDisplayByName("Soạn thảo"));
        log.info("Kiểm tra các trường tại phần Luồng phê duyệt");
        verifyTrue(cauHinhPheDuyetPO.filedIsDisplayByName("Người phê duyệt"));
        verifyTrue(cauHinhPheDuyetPO.filedIsDisplayByName("Người nhận thông báo"));
        log.info("Click vào nút Lưu với tất cả các trường trống");
        cauHinhPheDuyetPO.clickToButtonByName("Lưu");
        log.info("Kiểm tra message bắt buộc hiển thị");
        verifyEquals(cauHinhPheDuyetPO.messageRequireTextIsDisplayed(), "Trường bắt buộc không được trống");
    }

//    @Test
    public void Auto_Web_PD16_Validate_Ten_Phe_Duyet() {
        log.info("Bỏ trống trường 'Tên phê duyệt'");
        cauHinhPheDuyetPO.deleteDataEnteredToTenPheDuyet();
        log.info("Nhập vào các trường bắt buộc còn lại");
        cauHinhPheDuyetPO.enterToMoTaTextbox(moTa);
        cauHinhPheDuyetPO.selectPhongBanApDungByName("Tập đoàn KH","P00001 - Tập đoàn KH");
        cauHinhPheDuyetPO.closePopupChonPhongBan();
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonByName("Lưu");
        log.info("Kiểm tra message bắt buộc hiển thị");
        verifyEquals(cauHinhPheDuyetPO.messageRequireTextIsDisplayed(), "Trường bắt buộc không được trống");

    }

//    @Test
    public void Auto_Web_PD17_Button_Trang_Thai() {
        log.info("Click vào toggle để tắt trạng thái");
        cauHinhPheDuyetPO.clickToToggleTrangThai();
        log.info("Click vào toggle để bật trạng thái");
        cauHinhPheDuyetPO.clickToToggleTrangThai();
    }

//    @Test
    public void Auto_Web_PD18_Validate_Truong_Mo_Ta() {
        log.info("Bỏ trống trường 'Mô tả'");
        cauHinhPheDuyetPO.deleteDataEnteredToMoTa();
        log.info("Nhập vào các trường bắt buộc còn lại");
        cauHinhPheDuyetPO.enterToTenPheDuyetTextbox(tenPheDuyet);
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonByName("Lưu");
        log.info("Kiểm tra message bắt buộc hiển thị");
        verifyEquals(cauHinhPheDuyetPO.messageRequireTextIsDisplayed(), "Trường bắt buộc không được trống");
    }

//    @Test
    public void Auto_Web_PD20_Validate_Truong_Phong_Ban() {
        log.info("Bỏ trống trường 'Phòng ban'");
        cauHinhPheDuyetPO.deleteOptionInPhongBan();
        cauHinhPheDuyetPO.closePopupChonPhongBan();
        log.info("Nhập vào các trường bắt buộc còn lại");
        cauHinhPheDuyetPO.enterToTenPheDuyetTextbox(tenPheDuyet);
        cauHinhPheDuyetPO.enterToMoTaTextbox(moTa);
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonByName("Lưu");
        log.info("Kiểm tra message bắt buộc hiển thị");
        verifyEquals(cauHinhPheDuyetPO.messageRequireTextIsDisplayed(), "Trường bắt buộc không được trống");
    }

//    @Test
    public void Auto_Web_PD21_Ktra_Cau_Hinh_Truong_Tra_Loi_Ngan() {
        log.info("Click vào nút cấu hình thêm trường Trả lời ngắn");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Trả lời ngắn");
        log.info("Kiểm tra tên popup hiển thị");
        verifyTrue(cauHinhPheDuyetPO.tenPopupIsDisplayedByName("Thêm trường văn bản"));
        log.info("Kiểm tra các trường hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldsIsDisplayedByName("Tên trường"));
        verifyTrue(cauHinhPheDuyetPO.fieldsIsDisplayedByName("Gợi ý nội dung"));
        verifyTrue(cauHinhPheDuyetPO.toggleIsDisplayedByName("Bắt buộc"));
    }

//    @Test
    public void Auto_Web_PD22_Truong_Ten_Truong_Tren_Popup() {
        log.info("Click vào nút Lưu mà không nhập vào các trường");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra message bắt buộc hiển thị");
        verifyEquals(cauHinhPheDuyetPO.messageRequireTextIsDisplayed(), "Trường bắt buộc không được trống");
    }

//    @Test
    public void Auto_Web_PD24_01_Them_Moi_Tra_Loi_Ngan_0_Bat_Buoc() {
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường",traLoiNgan_0BatBuoc);
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Gợi ý nội dung", goiY);
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(traLoiNgan_0BatBuoc));
    }

//    @Test
    public void Auto_Web_PD24_02_Them_Moi_Tra_Loi_Ngan_Co_Bat_Buoc() {
        log.info("Click vào nút cấu hình thêm trường Trả lời ngắn");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Trả lời ngắn");
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường", traLoiNgan_BatBuoc);
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Gợi ý nội dung", goiY);
        log.info("Click vào toggle bắt buộc");
        cauHinhPheDuyetPO.clickToToggleByName("Bắt buộc");
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(traLoiNgan_BatBuoc));
    }


//    @Test
    public void Auto_Web_PD26_Ktr_Cau_Hinh_Truong_Thoi_Gian() {
        log.info("Click vào nút cấu hình thêm trường Thời gian");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Thời gian");
        log.info("Kiểm tra tên popup hiển thị");
        verifyTrue(cauHinhPheDuyetPO.tenPopupIsDisplayedByName("Thêm trường thời gian"));
        log.info("Kiểm tra các trường hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldsIsDisplayedByName("Tên trường"));
        verifyTrue(cauHinhPheDuyetPO.toggleIsDisplayedByName("Cho phép chọn thời điểm quá khứ"));
        verifyTrue(cauHinhPheDuyetPO.toggleIsDisplayedByName("Bắt buộc"));
    }

//    @Test
    public void Auto_Web_PD27_Ktra_Truong_Ten_Truong() {
        log.info("Click vào nút Lưu mà không nhập vào các trường");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra message bắt buộc hiển thị");
        verifyEquals(cauHinhPheDuyetPO.messageRequireTextIsDisplayed(), "Trường bắt buộc không được trống");
    }

//    @Test
    public void Auto_Web_PD28_01_Them_Moi_Truong_Thoi_Gian_O_Bat_Buoc_Cho_Chon_Qua_Khu() {
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường", thoiGian_0BatBuoc_ChonQK);
        cauHinhPheDuyetPO.clickToToggleByName("Cho phép chọn thời điểm quá khứ");
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(thoiGian_0BatBuoc_ChonQK));
    }

//    @Test
    public void Auto_Web_PD28_02_Them_Moi_Truong_Thoi_Gian_0_Bat_Buoc_Khong_Chon_Qua_Khu() {
        log.info("Click vào nút cấu hình thêm trường Thời gian");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Thời gian");
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường", thoiGian_0BatBuoc_0ChonQK);
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(thoiGian_0BatBuoc_0ChonQK));
    }

//    @Test
    public void Auto_Web_PD28_03_Them_Moi_Truong_Thoi_Gian_Co_Bat_Buoc_Cho_Chon_Qua_Khu() {
        log.info("Click vào nút cấu hình thêm trường Thời gian");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Thời gian");
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường", thoiGian_BatBuoc_ChonQK);
        cauHinhPheDuyetPO.clickToToggleByName("Cho phép chọn thời điểm quá khứ");
        cauHinhPheDuyetPO.clickToToggleByName("Bắt buộc");
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(thoiGian_BatBuoc_ChonQK));
    }

//    @Test
    public void Auto_Web_PD28_04_Them_Moi_Truong_Thoi_Gian_Co_Bat_Buoc_Khong_Chon_Qua_Khu() {
        log.info("Click vào nút cấu hình thêm trường Thời gian");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Thời gian");
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường", thoiGian_BatBuoc_0ChonQK);
        cauHinhPheDuyetPO.clickToToggleByName("Bắt buộc");
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(thoiGian_BatBuoc_0ChonQK));
    }

//    @Test
    public void Auto_Web_PD32_Ktra_Cau_Hinh_Truong_Danh_Sach() {
        log.info("Click vào nút cấu hình thêm trường Danh sách");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Danh sách");
        log.info("Kiểm tra tên popup hiển thị");
        verifyTrue(cauHinhPheDuyetPO.tenPopupIsDisplayedByName("Thêm trường danh sách"));
        log.info("Kiểm tra các trường hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldsIsDisplayedByName("Tên trường"));
        verifyTrue(cauHinhPheDuyetPO.loaiDanhSachIsDisplayed());
        verifyTrue(cauHinhPheDuyetPO.fieldsIsDisplayedByName("Danh sách lựa chọn"));
        verifyTrue(cauHinhPheDuyetPO.toggleIsDisplayedByName("Bắt buộc"));
    }

//    @Test
    public void Auto_Web_PD33_Ktra_Cac_Truong_Bat_Buoc() {
        log.info("Click vào nút Lưu mà không nhập vào các trường");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra message bắt buộc hiển thị");
        verifyEquals(cauHinhPheDuyetPO.messageRequireTextIsDisplayed(), "Trường bắt buộc không được trống");
    }

//    @Test
    public void Auto_Web_PD36_01_Them_Moi_Truong_Danh_Sach_Chon_1_0_Bat_Buoc() {
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường", danhSach_Chon1_0BatBuoc);
        cauHinhPheDuyetPO.chonLoaiDanhSachByName("Danh sách 1 chọn");
        cauHinhPheDuyetPO.enterDanhSachToTextbox("option1, option2, option3");
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(danhSach_Chon1_0BatBuoc));
    }

//    @Test
    public void Auto_Web_PD36_02_Them_Moi_Truong_Danh_Sach_Chon_1_Co_Bat_Buoc() {
        log.info("Click vào nút cấu hình thêm trường Danh sách");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Danh sách");
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường", danhSach_Chon1_BatBuoc);
        cauHinhPheDuyetPO.chonLoaiDanhSachByName("Danh sách 1 chọn");
        cauHinhPheDuyetPO.enterDanhSachToTextbox("option1, option2, option3");
        log.info("Click vào toggle bắt buộc");
        cauHinhPheDuyetPO.clickToToggleByName("Bắt buộc");
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(danhSach_Chon1_BatBuoc));
    }

//    @Test
    public void Auto_Web_PD36_03_Them_Moi_Truong_Danh_Sach_Chon_Nhieu_0_Bat_Buoc() {
        log.info("Click vào nút cấu hình thêm trường Danh sách");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Danh sách");
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường", danhSach_ChonNhieu_0BatBuoc);
        cauHinhPheDuyetPO.chonLoaiDanhSachByName("Danh sách nhiều chọn");
        cauHinhPheDuyetPO.enterDanhSachToTextbox("option1, option2, option3");
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(danhSach_ChonNhieu_0BatBuoc));
    }

//    @Test
    public void Auto_Web_PD36_04_Them_Moi_Truong_Danh_Sach_Chon_Nhieu_Co_Bat_Buoc() {
        log.info("Click vào nút cấu hình thêm trường Danh sách");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Danh sách");
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường", danhSach_ChonNhieu_BatBuoc);
        cauHinhPheDuyetPO.chonLoaiDanhSachByName("Danh sách nhiều chọn");
        cauHinhPheDuyetPO.enterDanhSachToTextbox("option1, option2, option3");
        log.info("Click vào toggle bắt buộc");
        cauHinhPheDuyetPO.clickToToggleByName("Bắt buộc");
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(danhSach_ChonNhieu_BatBuoc));
    }

//    @Test
    public void Auto_Web_PD37_Ktra_Cau_Hinh_Truong_Doan_Van() {
        log.info("Click vào nút cấu hình thêm trường Đoạn văn");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Đoạn văn");
        log.info("Kiểm tra tên popup hiển thị");
        verifyTrue(cauHinhPheDuyetPO.tenPopupIsDisplayedByName("Thêm đoạn văn"));
        log.info("Kiểm tra các trường hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldsIsDisplayedByName("Tên trường"));
        verifyTrue(cauHinhPheDuyetPO.fieldsIsDisplayedByName("Gợi ý nội dung"));
        verifyTrue(cauHinhPheDuyetPO.toggleIsDisplayedByName("Bắt buộc"));
    }

//    @Test
    public void Auto_Web_PD38_Ktra_Cac_Truong_Bat_Buoc() {
        log.info("Click vào nút Lưu mà không nhập vào các trường");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra message bắt buộc hiển thị");
        verifyEquals(cauHinhPheDuyetPO.messageRequireTextIsDisplayed(), "Trường bắt buộc không được trống");
    }

//    @Test
    public void Auto_Web_PD41_01_Them_Moi_Truong_Doan_Van_0_Bat_Buoc() {
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường",doanVan_0BatBuoc);
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Gợi ý nội dung", goiY);
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(doanVan_0BatBuoc));
    }

//    @Test
    public void Auto_Web_PD42_02_Them_Moi_Truong_Doan_Van_Co_Bat_Buoc() {
        log.info("Click vào nút cấu hình thêm trường Đoạn văn");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Đoạn văn");
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường", doanVan_BatBuoc);
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Gợi ý nội dung", goiY);
        log.info("Click vào toggle bắt buộc");
        cauHinhPheDuyetPO.clickToToggleByName("Bắt buộc");
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(doanVan_BatBuoc));
    }

//    @Test
    public void Auto_Web_PD42_Ktra_Cau_Hinh_Truong_Soan_Thao() {
        log.info("Click vào nút cấu hình thêm trường Soạn thảo");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Soạn thảo");
        log.info("Kiểm tra tên popup hiển thị");
        verifyTrue(cauHinhPheDuyetPO.tenPopupIsDisplayedByName("Thêm soạn thảo văn bản"));
        log.info("Kiểm tra các trường hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldsIsDisplayedByName("Tên trường"));
        verifyTrue(cauHinhPheDuyetPO.toggleIsDisplayedByName("Bắt buộc"));
    }

//    @Test
    public void Auto_Web_PD43_Ktra_Cac_Truong_Bat_Buoc() {
        log.info("Click vào nút Lưu mà không nhập vào các trường");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra message bắt buộc hiển thị");
        verifyEquals(cauHinhPheDuyetPO.messageRequireTextIsDisplayed(), "Trường bắt buộc không được trống");
    }

//    @Test
    public void Auto_Web_PD46_01_Them_Moi_Truong_Soan_Thao_0_Bat_Buoc() {
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường", soanThao_0BatBuoc);
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(soanThao_0BatBuoc));
    }

//    @Test
    public void Auto_Web_PD46_02_Them_Moi_Truong_Soan_Thao_Co_Bat_Buoc() {
        log.info("Click vào nút cấu hình thêm trường Soạn thảo");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Soạn thảo");
        log.info("Nhập dữ liệu vào trường Tên trường");
        cauHinhPheDuyetPO.enterToTextboxInCauHinhByName("Tên trường", soanThao_BatBuoc);
        log.info("Click vào toggle bắt buộc");
        cauHinhPheDuyetPO.clickToToggleByName("Bắt buộc");
        log.info("Click vào nút Lưu");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra trường vừa thêm được hiển thị");
        verifyTrue(cauHinhPheDuyetPO.fieldCreatedIsDisplayedByName(soanThao_BatBuoc));
    }

    @Test
    public void Auto_Web_PD47_Kiem_Tra_Cau_Hinh_Nguoi_Phe_Duyet() {
        log.info("Click vào nút Người phê duyệt");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Người phê duyệt");
        log.info("Kiểm tra tên popup hiển thị");
        verifyTrue(cauHinhPheDuyetPO.tenPopupIsDisplayedByName("Thêm người phê duyệt"));
        log.info("Kiểm tra các thông tin hiển thị");
        verifyTrue(cauHinhPheDuyetPO.optionPheDuyetIsDisplayedByName("Phê duyệt theo quản lý trực tiếp"));
        verifyTrue(cauHinhPheDuyetPO.optionPheDuyetIsDisplayedByName("Phê duyệt theo đơn vị của người tạo tờ trình"));
        verifyTrue(cauHinhPheDuyetPO.optionPheDuyetIsDisplayedByName("Người phê duyệt"));
        verifyTrue(cauHinhPheDuyetPO.optionPheDuyetIsDisplayedByName("Bộ phận phê duyệt"));

        log.info("Click to Lưu button");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm tra message bắt buộc hiển thị");
        verifyEquals(cauHinhPheDuyetPO.messageRequireTextIsDisplayed(), "Trường bắt buộc không được trống");
    }

    @Test
    public void Auto_Web_PD55_Them_Nguoi_Phe_Duyet() {
        log.info("Tìm kiếm và chọn Người phê duyệt");
        cauHinhPheDuyetPO.seachAndSelectNguoiPheDuyetByName("Mẽ","Nguyễn Thùy Mẽ");
        log.info("Click vào Lưu button");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
    }

    @Test
    public void Auto_Web_PD56_Kiem_Tra_Cau_Hinh_Nguoi_Nhan_Thong_Bao() {
        log.info("Click vào nút Người nhận thông báo");
        cauHinhPheDuyetPO.clickToFieldInCauHinhByName("Người nhận thông báo");
        log.info("Kiểm tra tên popup hiển thị");
        verifyTrue(cauHinhPheDuyetPO.tenPopupIsDisplayedByName("Thêm người nhận thông báo"));
        log.info("Kiểm tra các thông tin hiển thị");
        verifyTrue(cauHinhPheDuyetPO.nguoiNhanThongBaoIsDisplayed());
        log.info("Click to Lưu button");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
        log.info("Kiểm message bắt buộc hiển thị");
        verifyEquals(cauHinhPheDuyetPO.messageRequireTextIsDisplayed(), "Trường bắt buộc không được trống");
    }

    @Test
    public void Auto_Web_PD57_Them_Nguoi_Nhan_Thong_Bao() {
        log.info("Chọn option Người nhận thông báo");
        cauHinhPheDuyetPO.searchAndSelectNguoiNhanThongBaoByName("Nguyễn Văn ABC","Nguyễn Văn ABC");
        log.info("Click vào Lưu button");
        cauHinhPheDuyetPO.clickToButtonInCauHinhByName("Lưu");
    }

//    @Test
    public void Auto_Web_PD59_Luu_Luong_Phe_Duyet() {
        log.info("Click vào Lưu button");
        cauHinhPheDuyetPO.clickToButtonByName("Lưu");
        luongPheDuyetPO = PageGenerator.getLuongPheDuyetPage(driver);
        log.info("Tạo phê duyệt" + tenPheDuyet + " thành công");
        verifyEquals(luongPheDuyetPO.pheDuyetNewlyIsDisplayedInListByName(),tenPheDuyet);
    }

    //@AfterClass(alwaysRun = true)
    //public void afterClass() {
    //    cleanBrowserAndDriver();
    //}

    WebDriver driver;
    DangNhapPO dangNhapPO;
    TrangChuPO trangChuPO;
    LuongPheDuyetPO luongPheDuyetPO;
    CauHinhPheDuyetPO cauHinhPheDuyetPO;
}
