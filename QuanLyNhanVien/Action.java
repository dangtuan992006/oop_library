package QuanLyNhanVien;

import java.util.*;

public interface Action{
    void them(ArrayList<NhanVien> ds);
    void xoa(ArrayList<NhanVien> ds, Scanner sc);
    void sua(ArrayList<NhanVien> ds, Scanner sc);
    void tim(ArrayList<NhanVien> ds, Scanner sc);
    void hienThi(ArrayList<NhanVien> ds);
    void docFile(String filename, ArrayList<NhanVien> ds);
    void ghiFile(String filename, ArrayList<NhanVien> ds);
    void tinhLuong(ArrayList<NhanVien> ds, Scanner sc);
}
