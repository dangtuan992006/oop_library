package QuanLyHoaDon;
import QuanLySach.QuanLySach;
import quanlykhachhang.quanlydanhsachkhachhang;
public interface Action {
    void them(QuanLySach quanLySach, quanlydanhsachkhachhang qlKhachHang);
    void sua();
    void xoa();
    void timkiem();
    void hiendanhsach();
    void DocFile();
    void ghidulieu();
}
