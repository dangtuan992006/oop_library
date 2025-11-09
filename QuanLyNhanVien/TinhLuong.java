package QuanLyNhanVien;

import java.util.*;

public class TinhLuong{
    public static void tinhLuong(ArrayList<NhanVien> ds, Scanner sc){
        if(ds.isEmpty()){
            System.out.println("Danh sach trong.");
            return;
        }
        System.out.println("===Tinh luong nhan vien===");
        System.out.print("Nhap ma nhan vien can tinh luong: ");
        String ma = sc.nextLine().trim();
        boolean found = false;
        for(NhanVien nv : ds){
            if(nv.getMaNV().equalsIgnoreCase(ma)){
                found = true;
                System.out.println("Nhan vien tim thay: ");
                nv.xuat();
                int soNgayLam;
                while(true){
                    System.out.print("Nhap so ngay lam viec trong thang: ");
                    try{
                        soNgayLam = Integer.parseInt(sc.nextLine());
                        break;
                    } catch(NumberFormatException e){
                        System.out.println("So ngay lam khong hop le! Vui long nhap lai mot so.");
                    }
                }
                double luongCoBan = 2000000;
                double tongLuong = luongCoBan + (soNgayLam * 200000); //---200000 la luong moi ngay lam viec
                nv.setLuong(tongLuong);
                System.out.printf("Tong luong cua nhan vien %s la: %.2f VND%n", nv.getHoTen(), tongLuong);
                break; // Thoat khoi vong lap sau khi tim thay va xu ly
            }
        }
        if(!found){
        System.out.println("Khong tim thay nhan vien co ma: " + ma);
        }
    }
}