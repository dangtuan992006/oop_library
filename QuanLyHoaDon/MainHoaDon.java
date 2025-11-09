package QuanLyHoaDon;

import java.util.Scanner;

import QuanLySach.QuanLySach;
import quanlykhachhang.quanlydanhsachkhachhang;

public class MainHoaDon {
    public static void main(String[] args) {
        QuanLyHoaDon qlHoaDon = new QuanLyHoaDon();
        QuanLySach qlNhaSach = new QuanLySach();
        quanlydanhsachkhachhang qlKhachHang = new quanlydanhsachkhachhang();

        qlHoaDon.DocFile();
        qlNhaSach.docFile();
        qlKhachHang.docdulieu();

        Scanner scanner = new Scanner(System.in);
        int chon;

        do {
            System.out.println(".____________________________________________________.");
            System.out.println("|                 MENU QUAN LY HOA DON               |");
            System.out.println("|____________________________________________________|");
            System.out.println("| 1. Them hoa don moi                                |");
            System.out.println("| 2. Sua hoa don                                     |");
            System.out.println("| 3. Xoa hoa don theo ID                             |");
            System.out.println("| 4. Hien danh sach hoa don                          |");
            System.out.println("| 5. Tim kiem hoa don theo ID                        |");
            System.out.println("| 6. Quay lai menu tong                              |");
            System.out.println("| 0. Thoat chuong trinh                              |");
            System.out.println("|____________________________________________________|");
            System.out.print("Nhap lua chon: ");

            try {
                chon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so! Vui long nhap lai.");
                chon = -1; // Gán giá trị không hợp lệ để lặp lại
                continue;
            }

            switch (chon) {
                case 1:
                    qlHoaDon.them(qlNhaSach, qlKhachHang);
                    break;
                case 2:
                    qlHoaDon.sua();
                    break;
                case 3:
                    qlHoaDon.xoa();
                    break;
                case 4:
                    qlHoaDon.hiendanhsach();
                    break;
                case 5:
                    qlHoaDon.timkiem();
                    break;
                case 6:
                    System.out.println("Quay lai menu tong...");
                    return; //dung chuong trinh con, quan ly menu chinh
                case 0:
                    System.out.println("Tam biet!");
                    System.exit(0); //thoat hoan toan
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap tu 0 - 6.");
                    break;
            }
        } while (true);
    }
}
