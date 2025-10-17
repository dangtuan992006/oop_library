package quanlykhachhang;

// import quanlykhachhang.quanlydanhsach;
import java.util.Scanner;

public class maincustomer {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;
        quanlydanhsachkhachhang qlds = new quanlydanhsachkhachhang();


        do {
            System.out.println(".___________________________________________________.");
            System.out.println("|                Menu Quan Ly Khach Hang            |");
            System.out.println("|___________________________________________________|");
            System.out.println("| 1. Hien thi danh sach khach hang                  |");
            System.out.println("| 2. Them khach hang                                |");
            System.out.println("| 3. Xoa khach hang                                 |");
            System.out.println("| 4. Chinh sua thong tin khach hang                 |");
            System.out.println("| 5. Tim kiem khach hang                            |");
            System.out.println("| 6. Kiem tra tong so khach hang                    |");
            System.out.println("| 7. Ve lai menu tong                               |");
            System.out.println("|___________________________________________________|");
            System.out.println();
            System.out.print("nhap lua chon: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // qlds.hiendanhsach();
                    qlds.docdulieu();
                break;
                case 2:
                    qlds.them();
                    break;
                case 3:
                    qlds.xoa();
                    break;
                case 4:
                    qlds.chinhsuathongtinkhachhang();
                    break;
                case 5:
                    qlds.timkiemkhachhang();
                    break;
                case 6:
                    qlds.hientongkhachhang();
                    break;
                case 7:
                    return;
                default:
                System.out.println("Lua chon khong hop le");
                    break;
            }

        } while (choice != 7);

        sc.close();
    }
}