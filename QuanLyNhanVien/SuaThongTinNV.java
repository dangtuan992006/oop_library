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

                String tuoiMoi;
                while(true){
                    System.out.print("Tuoi moi: ");
                    try{
                        tuoiMoi = sc.nextLine();
                        if(!tuoiMoi.isEmpty()){
                            nv.setTuoi(Integer.parseInt(tuoiMoi));
                        }
                        if(Integer.parseInt(tuoiMoi) > 0 && Integer.parseInt(tuoiMoi) < 100){
                            nv.setTuoi(Integer.parseInt(tuoiMoi));
                            break;
                        } else {
                            System.out.println("Tuoi khong hop le. Vui long nhap lai.");
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Vui long nhap mot so nguyen cho tuoi.");
                    }
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

                String sdtMoi;
                while(true){
                    System.out.print("So dien thoai moi: ");
                    sdtMoi = sc.nextLine();
                    if(!sdtMoi.isEmpty()){
                        nv.setSdt(sdtMoi);
                    }
                    if(sdtMoi.matches("\\d{10}")){
                        nv.setSdt(sdtMoi);
                        break;
                    }else{
                        System.out.println("So dien thoai khong hop le. Vui long nhap lai.");
                    }
                }

                String emailMoi;
                while(true){
                    System.out.print("Email moi: ");
                    emailMoi = sc.nextLine();
                    if(!emailMoi.isEmpty()){
                        nv.setEmail(emailMoi);
                    }
                    if(emailMoi.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")){
                        nv.setEmail(emailMoi);
                        break;
                    }else{
                        System.out.println("Email khong hop le. Vui long nhap lai.");
                    }
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
