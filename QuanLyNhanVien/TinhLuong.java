package QuanLyNhanVien;

import java.util.*;

public class TinhLuong{
    public static void tinhLuong(ArrayList<NhanVien> ds){
        if(ds.isEmpty()){
            System.out.println("Danh sach trong.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("===Tinh luong nhan vien====");
        System.out.print("Nhap ma nhan vien can tinh luong: ");
        String ma = sc.nextLine().trim();
        boolean found = false;
        for(NhanVien nv : ds){
            if(nv.getMaNV().equalsIgnoreCase(ma)){
                found = true;
                System.out.println("Nhan vien tim thay: ");
                nv.xuat();
            }
            int soNgayLam;
            while(true){
                try{
                    System.out.print("Nhap so ngay lam viec trong thang: ");
                    soNgayLam = Integer.parseInt(sc.nextLine());
                    if(soNgayLam >= 1 && soNgayLam <= 31){
                        break;
                    }else{
                        System.out.println("So ngay lam viec khong hop le. Vui long nhap lai.");
                    }
                }catch (NumberFormatException e){
                    System.out.println("Vui long nhap mot so nguyen cho so ngay lam.");
                }
            }
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