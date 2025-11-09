package QuanLyNhanVien;

import java.util.*;

public class XoaNV {
    public boolean xoaTheoMA(ArrayList<NhanVien> ds, Scanner sc){
        System.out.print("Nhap ma nhan vien can xoa: ");
        String maCanXoa = sc.nextLine();
        if(maCanXoa.isEmpty()){
            System.out.print("Ma nhan vien khong duoc de trong.");
            return false;
        }
        Iterator<NhanVien> it = ds.iterator();
        while(it.hasNext()){
            NhanVien nv = it.next();
            if(nv.getMaNV().equalsIgnoreCase(maCanXoa)){
                System.out.println("Da tim thay nhan vien can xoa, co chac muon xoa (Y/N)?");
                String confirm = sc.nextLine();
                if(confirm.equalsIgnoreCase("Y")){
                    it.remove();
                    System.out.println("Da xoa nhan vien co ma: " + maCanXoa);
                    return true;
                }
                else{
                    System.out.println("Huy xoa nhan vien.");
                    return false;
                }
            }
        }
        System.out.println("Khong tim thay nhan vien co ma: " + maCanXoa);
        return false;
    }
}
