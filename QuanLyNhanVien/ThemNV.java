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
                if (tuoi > 0 && tuoi <= 100) {
                    break;
                } else {
                    System.out.println("Tuoi khong hop le! Vui long nhap tuoi trong khoang 1-100.");
                }
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
        String sdt;
        while(true){
            System.out.println("nhap so dien thoai: ");
            sdt = sc.nextLine();
            if(sdt.matches("\\d{10}")){
                break;
            } else {
                System.out.println("So dien thoai khong hop le. Vui long nhap lai (10 chu so).");
            }
        }
        String email;
        while(true){
            System.out.println("nhap email: ");
            email = sc.nextLine();
            //---bieu thuc chinh quy kiem tra dinh dang email @gmail.com
            if(email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")){
                break;
            } else {
                System.out.println("Email khong hop le. Vui long nhap lai (vi du: ten@gmail.com).");
            }
        }

        NhanVien nv = new NhanVien(hoTen, tuoi, luong, congViec, maNV, sdt, email);
        System.out.println("Da them nhan vien moi.");
        return nv;
    }
}
