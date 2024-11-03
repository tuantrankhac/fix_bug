package pageUIs.web.general;

public class DangNhapPageUI {
    public static final String VAI_TRO_LOGIN_DROPDOWN = "//p[contains(text(),'Đăng nhập với vai trò')]/following-sibling::mat-form-field//mat-select";
    public static final String OPTION_LOGIN_DROPDOWN = "//mat-option/span";
    public static final String USER_TEXTBOX = "//p[contains(text(),'Số điện thoại')]/following-sibling::mat-form-field//input";
    public static final String QTV_TEXTBOX = "//p[contains(text(),'Tên đăng nhập')]/following-sibling::mat-form-field//input";
    public static final String MAT_KHAU_TEXTBOX = "//span[contains(text(),'Mật khẩu')]/parent::div/following-sibling::mat-form-field//input";
    public static final String DANG_NHAP_BUTTON = "//button[@type='button']";
}
