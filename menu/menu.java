package menu;
import java.util.Scanner;

public class menu {

    public static void PrintMenu(){
        System.out.println(".____________________________________.");
        System.out.println("|             LIBRARY                |");    
        System.out.println("|____________________________________|");
        System.out.println("| 1. Quan Ly Sach                    |");
        System.out.println("| 2. Quan Ly Hoa Don                 |");
        System.out.println("| 3. Quan Ly Nhan Vien               |");
        System.out.println("| 4. Quan Ly Khach Hang              |");
        System.out.println("| 5. Thoat Chuong Trinh              |");
        System.out.println("|____________________________________|");
    
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        int chosen = 0;

        while (chosen != 5) {
            PrintMenu();
            System.out.print("nhap chuc nang: ");
            chosen = sc.nextInt();
            switch (chosen) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    return;
                default:
                    System.out.println("chuc nang khong co trong chuong trinh!");
                    System.out.println("ban co muon tiep tuc khong? (yes: 1, no: 0)");
                    chosen = sc.nextInt();
                    if (chosen == 0) {
                        return;
                    }
                    break;
            }
        }


        sc.close();
    }
}

