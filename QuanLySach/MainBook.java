package QuanLySach;

import java.util.Scanner;

public class MainBook {

    public static void pause(Scanner sc) {
        System.out.print("\nNhấn 0 để tiếp tục... ");
        while (true) {
            String input = sc.nextLine().trim();
            if (input.equals("0")) break;
            System.out.print("Vui lòng nhấn phím 0 để tiếp tục: ");
        }
    }

    public static void main(String[] args)
    {

        QuanLySach quanLySach = new QuanLySach();

        quanLySach.docFile();

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println(".__________________________________________.");
            System.out.println("|              Menu Quan Ly Sach           |");
            System.out.println("|__________________________________________|");
            System.out.println("| 1. Hien thi danh sach sach               |");
            System.out.println("| 2. Them sach moi                         |");
            System.out.println("| 3. Xoa sach theo id                      |");
            System.out.println("| 4. Chinh sua sach theo id                |");
            System.out.println("| 5. Tim kiem sach theo id                 |");
            System.out.println("| 6. Kiem tra so mau cua moi loai sach     |");
            System.out.println("| 7. Quay lai menu tong                    |");
            System.out.println("|__________________________________________|");
            System.out.print("Chon mot lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    System.out.println("Danh Sach Sach");
                    quanLySach.hienDanhSach();
                    pause(sc);
                    break;
                case 2:
                    quanLySach.them();
                    pause(sc);
                    break;
                case 3:
                    quanLySach.xoa();
                    pause(sc);
                    break;
                case 4:
                    quanLySach.sua();
                    pause(sc);
                    break;
                case 5:
                    quanLySach.timkiem();
                    pause(sc);
                    break;
                case 6:
                    quanLySach.demHangTon(quanLySach, "CM");
                    quanLySach.demHangTon(quanLySach, "NV");
                    quanLySach.demHangTon(quanLySach, "RF");
                    quanLySach.demHangTon(quanLySach, "TB");
                    pause(sc);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Không hợp lệ");
                    break;
            }
        } while ( choice != 7 );
    }
}