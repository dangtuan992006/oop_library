package QL_NhanVien;

import java.util.*;

//---main cua chuong trinh quan ly nhan vien:
public class QL_NhanVien {
    public static void main(String[] args){
        ArrayList<NhanVien> ds = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        //---khoi tao cac lop chuc nang:
        Menu menu = new Menu();
        ThemNV them = new ThemNV();
        XoaNV xoa = new XoaNV();
        SuaThongTinNV sua = new SuaThongTinNV();
        TimNV tim = new TimNV();
        ReadFile reader = new ReadFile();
        WriteFile writer = new WriteFile();
        //---doc du lieu tu file:
        ds = reader.readFile("database/nhanvien.txt");
        int choice = 0;
        do{
            menu.hienThiMenu();
            System.out.print("Nhap lua chon cua ban: ");
            try{
                choice = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e){
                System.out.println("Vui long nhap so hop le!");
                continue;
            }
            switch(choice){
                case 1: //---them NV:
                    NhanVien nvMoi = them.nhap();
                    ds.add(nvMoi);
                    writer.writeFile("database/nhanvien.txt", ds);
                    break;
                case 2: //---xoa NV:
                    if(xoa.xoaTheoMA(ds, sc)){
                        writer.writeFile("database/nhanvien.txt", ds);
                    }
                    break;
                case 3: //---sua NV:
                    sua.suaThongTin(ds, sc);
                    writer.writeFile("database/nhanvien.txt", ds);
                    break;
                case 4: //---tim NV:
                    tim.timNV(ds);
                    break;
                case 5: //---tinh luong NV:
                    TinhLuong.tinhLuong(ds);
                    break;
                case 6: //---thoat:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while(choice != 6);
    }
}