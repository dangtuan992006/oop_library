package QuanLyHoaDon;

import java.util.Scanner;
import QuanLySach.QuanLySach;

public class MainHoaDon {
    public static void main(String[] args) {
        QuanLyHoaDon qlHoaDon = new QuanLyHoaDon();
        QuanLySach qlNhaSach = new QuanLySach();

        qlHoaDon.DocFile();
        qlNhaSach.docFile();

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

            // Kiểm tra nhập sai kiểu
            while (!scanner.hasNextInt()) {
                System.out.print("Vui long nhap so nguyen: ");
                scanner.next();
            }
            chon = scanner.nextInt();
            scanner.nextLine(); //doc bo dong trong

            switch (chon) {
                case 1:
                    qlHoaDon.them(qlNhaSach);
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
