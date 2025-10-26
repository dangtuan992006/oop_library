package QuanLyHoaDon;
import java.util.*;
import QuanLyNhaSach.QuanLyNhaSach;
public class MainHoaDon
{
    public static void main(String[] args) {
    QuanLyHoaDon QuanLyHoaDon = new QuanLyHoaDon();
    QuanLyNhaSach QuanLyNhaSach = new QuanLyNhaSach();
        QuanLyHoaDon.DocFile();
        QuanLyNhaSach.DocFile();

        int chon;
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("._____________________________________________________.");
            System.out.println("|                 Menu Quan Ly Hoa Don                |");
            System.out.println("|_____________________________________________________|");
            System.out.println("| 1. Them hoa don moi                                 |");
            System.out.println("| 2. Sua hoa don                                      |");
            System.out.println("| 3. Xoa hoa don theo id                              |");
            System.out.println("| 4. Hien danh sach hoa don khach hang  theo id       |");
            System.out.println("| 5. Tim kiem hoa don theo id                         |");
            System.out.println("| 6. Quay lai menu tong                               |");
            System.out.println("| 0. Thoat                                            |");
            System.out.println("|_____________________________________________________|");
            System.out.print("Chon mot lua chon: ");
            chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    QuanLyHoaDon.them(QuanLyNhaSach);
                    break;
                 case 2:
                    QuanLyHoaDon.sua();
                    break;
                case 3:
                    QuanLyHoaDon.xoa();
                    break;
                 case 4:
                    QuanLyHoaDon.hiendanhsach();
                    break;
                case 5:
                    QuanLyHoaDon.timkiem();
                    break;
                case 6:
                    return;
                 case 0:
                     System.out.println("Tạm biệt!");
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        } while (chon != 7);
    }
}

