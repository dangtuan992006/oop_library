package QuanLyNhanVien;

import java.util.*;

public class XuatDSNV{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanVien> ds = new ArrayList<>();
        Action quanLy = new QLNVManager();
        quanLy.docFile("nhanvien.txt", ds);
        if(ds.isEmpty()){
            System.out.println("Danh sach nhan vien trong.");
        } else {
            quanLy.hienThi(ds);
        }
        sc.close();
    }
}