package QuanLyNhanVien;

import java.util.*;

public class ThemNV {
    public NhanVien nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ho ten: ");
        String hoTen = sc.nextLine();
        int tuoi;
        while(true){
            System.out.println("nhap tuoi: ");
            try{
                tuoi = Integer.parseInt(sc.nextLine());
                break;
            } catch(NumberFormatException e){
                System.out.println("Tuoi khong hop le! Vui long nhap lai mot so.");
            }
        }
        double luong;
        while(true){
            System.out.println("nhap luong: ");
            try{
                luong = Double.parseDouble(sc.nextLine());
                break;
            } catch(NumberFormatException e){
                System.out.println("Luong khong hop le! Vui long nhap lai mot so.");
            }
        }
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
