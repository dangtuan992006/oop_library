package QuanLyNhanVien;

import java.util.*;

public class ThemNV {
    public NhanVien nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ho ten: ");
        String hoTen = sc.nextLine();
        System.out.println("nhap tuoi: ");
        int tuoi = Integer.parseInt(sc.nextLine());
        System.out.println("nhap luong: ");
        double luong = Double.parseDouble(sc.nextLine());
        System.out.println("nhap cong viec: ");
        String congViec = sc.nextLine();
        System.out.println("nhap ma nhan vien: ");
        String maNV = sc.nextLine();
        System.out.println("nhap so dien thoai: ");
        String sdt = sc.nextLine();
        System.out.println("nhap email: ");
        String email = sc.nextLine();

        NhanVien nv = new NhanVien(hoTen, tuoi, luong, congViec, maNV, sdt, email);
        System.out.println("Da them nhan vien moi.");
        return nv;
    }
}
