package QuanLyNhanVien;

import java.util.*;

public class TimNV{
    public void timNV(ArrayList<NhanVien> ds){
        if(ds.isEmpty()){
            System.out.println("Danh sach trong.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("===Tim kiem nhan vien====");
        System.out.print("Nhap ma hoac ten NV: ");
        String key = sc.nextLine().trim().toLowerCase();
        boolean found = false;
        for(NhanVien nv : ds){
            if(nv.getMaNV().toLowerCase().equals(key) || nv.getHoTen().toLowerCase().contains(key)){
                nv.xuat();
                found = true;
            }
        }
        if(!found){
            System.out.println("Khong tim thay nhan vien phu hop voi thong tin da nhap.");
        }
    }
}
