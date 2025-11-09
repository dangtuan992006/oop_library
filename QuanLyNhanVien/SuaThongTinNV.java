package QuanLyNhanVien;

import java.util.*;

public class SuaThongTinNV{
    public void suaThongTin(ArrayList<NhanVien> ds, Scanner sc){
        System.out.print("Nhap ma NV muon sua: ");
        String maSua = sc.nextLine();
        boolean found = false;
        for(NhanVien nv : ds){
            if(nv.getMaNV().equalsIgnoreCase(maSua)){
                found = true;
                System.out.println("==========Thong tin nhan vien hien tai==========");
                nv.xuat();
                System.out.println("Nhap thong tin moi(de trong neu khong can thiet sua):");
                System.out.print("Ho ten moi: ");
                String hoTenMoi = sc.nextLine();
                if(!hoTenMoi.isEmpty()){
                    nv.setHoTen(hoTenMoi);
                }
                while(true){
                    System.out.print("Tuoi moi: ");
                    String tuoiMoiStr = sc.nextLine();
                    if(tuoiMoiStr.isEmpty()){
                        break; // Bo qua neu khong nhap
                    }
                    try{
                        nv.setTuoi(Integer.parseInt(tuoiMoiStr));
                        break; // Nhap hop le, thoat vong lap
                    } catch(NumberFormatException e){
                        System.out.println("Tuoi khong hop le! Vui long nhap lai mot so.");
                    }
                }
                while(true){
                    System.out.print("Luong moi: ");
                    String luongMoiStr = sc.nextLine();
                    if(luongMoiStr.isEmpty()){
                        break; // Bo qua neu khong nhap
                    }
                    try{
                        nv.setLuong(Double.parseDouble(luongMoiStr));
                        break; // Nhap hop le, thoat vong lap
                    } catch(NumberFormatException e){
                        System.out.println("Luong khong hop le! Vui long nhap lai mot so.");
                    }
                }
                System.out.print("Cong viec moi: ");
                String congViecMoi = sc.nextLine();
                if(!congViecMoi.isEmpty()){
                    nv.setCongViec(congViecMoi);
                }
                System.out.print("So dien thoai moi: ");
                String sdtMoi = sc.nextLine();
                if(!sdtMoi.isEmpty()){
                    nv.setSdt(sdtMoi);
                }
                System.out.print("Email moi: ");
                String emailMoi = sc.nextLine();
                if(!emailMoi.isEmpty()){
                    nv.setEmail(emailMoi);
                }
                System.out.println("Da cap nhat thong tin nhan vien.");
                System.out.println("==========Thong tin nhan vien sau khi sua==========");
                nv.xuat();
                break;
            }
        }
        if(!found){
            System.out.println("Khong tim thay nhan vien co ma: " + maSua);
        }
    }
}
