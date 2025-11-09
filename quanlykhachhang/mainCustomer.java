package quanlykhachhang;
import java.util.*;
public class mainCustomer {
    public static void main(String[] args) {
        quanlydanhsachkhachhang qlds = new quanlydanhsachkhachhang();
        
        int choice;
        Scanner scanner = new Scanner(System.in);
        qlds.docdulieu();
        

        do{
            System.out.println((".___________________________________________________."));
            System.out.println(("|                Menu Quan Ly Khach Hang            |"));
            System.out.println(("|___________________________________________________|"));
            System.out.println(("| 1. Hien thi danh sach khach hang                  |"));
            System.out.println(("| 2. Them khach hang                                |"));
            System.out.println("| 3. Xoa khach hang                                 |");
            System.out.println("| 4. Chinh sua thong tin khach hang                 |");
            System.out.println("| 5. Tim kiem khach hang                            |");
            System.out.println(("| 6. Kiem tra tong so khach hang                    |"));
            System.out.println(("| 7. Ve lai menu tong                               |"));
            System.out.println(("|___________________________________________________|"));
            System.out.print(("Nhap lua chon: "));
            
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so! Vui long nhap lai.");
                choice = -1; // Gán giá trị không hợp lệ để lặp lại
                continue;
            }

            switch(choice){
                case 1:
                    qlds.hiendanhsach();
                break;
                case 2:
                    qlds.them();
                break;
                case 3:
                    qlds.xoa();
                break;
                case 4:
                    qlds.sua();
                break;
                case 5:
                    qlds.timkiemkhachhang();
                break;
                case 6:
                    qlds.hientongkhachhang();
                break;
                case 7:
                break;
                default:
                    System.out.println("Lua chon khong hop le");
                break;
            }
        }while(choice != 7);
    }
    
}
