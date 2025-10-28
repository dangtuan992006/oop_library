package QL_NhanVien;

import java.util.*;

public class TinhLuong{
    public static void tinhLuong(ArrayList<NhanVien> ds){
        if(ds.isEmpty()){
            System.out.println("Danh sach trong.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("===Tinh luong nhan vien===");
        System.out.print("Nhap ma nhan vien can tinh luong: ");
        String ma = sc.nextLine().trim();
        boolean found = false;
        for(NhanVien nv : ds){
            if(nv.getMaNV().equalsIgnoreCase(ma)){
                found = true;
                System.out.println("Nhan vien tìm thay: ");
                nv.xuat();
            }
            System.out.print("Nhap so ngay lam viec trong thang: ");
            int soNgayLam = Integer.parseInt(sc.nextLine());
            double luongCoBan = 2000000;
            double tongLuong = luongCoBan + (soNgayLam * 200000); //---200000 la luong moi ngay lam viec
            nv.setLuong(tongLuong);
            System.out.printf("Tong luong cua nhan vien %s la: %.2f VND%n", nv.getHoTen(), tongLuong);
            WriteFile.writeFile("nhanvien.txt", ds);
            break;
        }
        if(!found){
        System.out.println("Khong tim thay nhan vien co ma: " + ma);
        }
    }
}