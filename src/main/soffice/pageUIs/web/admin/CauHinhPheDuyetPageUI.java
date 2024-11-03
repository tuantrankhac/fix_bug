package pageUIs.web.admin;

public class CauHinhPheDuyetPageUI {
    public static final String TRANG_THAI_BUTTON = "//input[@type='checkbox']/parent::div";
    public static final String TEN_PHE_DUYET_TEXTBOX = "//label[contains(text(),'Tên phê duyệt')]/following-sibling::mat-form-field//input";
    public static final String MO_TA_TEXTAREA = "//label[contains(text(),'Mô tả')]/following-sibling::mat-form-field//textarea";
    public static final String DROPDOWN_LOAI_PHE_DUYET = "//label[contains(text(),'Loại phê duyệt')]/following-sibling::select-search//mat-select";
    public static final String PHONG_BAN_DROPDOWN = "//label[contains(text(),'Phòng ban áp dụng')]/following-sibling::app-department-select//mat-select";
    public static final String X_BUTTON = "//mat-select/following-sibling::button";
    public static final String SEARCH_PHONG_BAN_TEXTBOX = "//input[@placeholder='Nhập để tìm kiếm']";
    public static final String CHECKBOX_PHONG_BAN_BY_NAME = "//span[text()='P00001 - Tập đoàn KH']/preceding-sibling::mat-checkbox//input";
    public static final String LIST_PHONG_BAN = "//input/parent::span/parent::label/parent::mat-checkbox/following-sibling::span";
    public static final String OUTSITE = "//div[contains(@class,'cdk-overlay-backdrop')]";

    public static final String DYNAMIC_TEN_POPUP = "//span[text()='%s']";
    public static final String DYNAMIC_FIELD_IN_CAU_HINH = "//span[text()='%s']//parent::button";
    public static final String DYNAMIC_BUTON_BY_NAME = "//button[contains(text(),'%s')]";
    public static final String MESSAGE_BAT_BUOC_TEXT = "//simple-snack-bar/span";

    public static final String TEXTBOX_IN_CAU_HINH_BY_NAME = "//label[contains(text(),'%s')]/following-sibling::mat-form-field//input";
    public static final String TOGGLE_IN_CAU_HINH_BY_NAME = "//input[@value='%s']/parent::div/following-sibling::div//input/parent::div";
    public static final String DYNAMIC_BUTON_IN_CAU_HINH_BY_NAME = "//mat-dialog-container//button[contains(text(),'%s')]";

    public static final String DROPDOWN_LOAI_DANH_SACH = "//label[contains(text(),'Loại danh sách')]/following-sibling::mat-form-field//mat-select";
    public static final String OPTION_LOAI_DANH_SACH = "//mat-option/span";
    public static final String NHAP_DANH_SACH_TEXTBOX = "//label[contains(text(),'Danh sách lựa chọn')]/following-sibling::mat-form-field//input";
    public static final String FIELD_CREATED_IN_CAU_HINH = "//div/span[text()='%s']";


    public static final String OPTION_PHE_DUYET = "//span[contains(text(),'%s')]/parent::label/parent::mat-radio-button";
    public static final String DROPDOWN_NGUOI_PHE_DUYET = "//span[text()='Chọn người phê duyệt']/parent::div/parent::div/parent::mat-select";
    public static final String SEARCH_NGUOI_PHE_DUYET_TEXTBOX = "//input[@placeholder='Nhập để tìm kiếm']";
    public static final String NGUOI_PHE_DUYET = "//mat-option/span[contains(text(),'&option')]";

    public static final String DROPDOWN_NGUOI_NHAN_TB = "//label[contains(text(),'Người nhận thông báo')]/following-sibling::mat-form-field";
    public static final String SEARCH_NGUOI_NHAN_TB_TEXTBOX = "//input[@placeholder='Nhập tên tìm kiếm']";
    public static final String LIST_NGUOI_NHAN_TB = "//input[@placeholder='Nhập tên tìm kiếm']";





}
