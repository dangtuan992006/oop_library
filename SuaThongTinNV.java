package QL_NhanVien;

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
                System.out.print("Tuoi moi: ");
                String tuoiMoi = sc.nextLine();
                if(!tuoiMoi.isEmpty()){
                    nv.setTuoi(Integer.parseInt(tuoiMoi));
                }
                System.out.print("Luong moi: ");
                String luongMoi = sc.nextLine();
                if(!luongMoi.isEmpty()){
                    nv.setLuong(Double.parseDouble(luongMoi));
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
