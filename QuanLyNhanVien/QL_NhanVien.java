package QuanLyNhanVien;

import java.util.*;

//---main cua chuong trinh quan ly nhan vien:
public class QL_NhanVien {
    public static void main(String[] args){
        ArrayList<NhanVien> ds = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        //---khoi tao cac lop chuc nang:
        Menu menu = new Menu();

        Action quanLy = new QLNVManager();

        //---doc du lieu tu file:
        quanLy.docFile("nhanvien.txt", ds);
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
                    quanLy.them(ds);
                    break;
                case 2: //---xoa NV:
                    quanLy.xoa(ds, sc);
                    break;
                case 3: //---sua NV:
                    quanLy.sua(ds, sc);
                    break;
                case 4: //---tim NV:
                    quanLy.tim(ds, sc);
                    break;
                case 5: //---tinh luong NV:
                    quanLy.tinhLuong(ds, sc);
                    break;
                case 6: //---thoat:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while(choice != 6);
        sc.close();
    }
}