package QL_NhanVien;

import java.util.*;

//main cua chuong trinh quan ly nhan vien
public class QL_NhanVien {
    public static void main(String[] args){
        ArrayList<NhanVien> ds = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        ThemNV them = new ThemNV();
        XoaNV xoa = new XoaNV();
        SuaThongTinNV sua = new SuaThongTinNV();
        TimNV tim = new TimNV();
        ReadFile reader = new ReadFile();
        WriteFile writer = new WriteFile();
        ds = reader.readFile("data.txt");
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
                case 1:
                    NhanVien nvMoi = them.nhap();
                    ds.add(nvMoi);
                    writer.writeFile("data.txt", ds);
                    break;
                case 2:
                    if(xoa.xoaTheoMA(ds, sc)){
                        writer.writeFile("data.txt", ds);
                    }
                    break;
                case 3:
                    sua.suaThongTin(ds, sc);
                    writer.writeFile("data.txt", ds);
                    break;
                case 4:
                    tim.timNV(ds);
                    break;
                case 5:
                    TinhLuong.tinhLuong(ds);
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while(choice != 6);
    }
}