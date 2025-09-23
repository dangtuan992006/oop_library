package user;

import java.util.Scanner;

public class Admin extends TaiKhoan {
    public Admin(String username , String password){
        super(username , password);
    }
    public void hienThiMenu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----- Menu Admin -----");
            System.out.println("1. Quản lý sách");
            System.out.println("2. Quản lý khách hàng");
            System.out.println("3. Quản lý hóa đơn");
            System.out.println("4. Thống kê");
            System.out.println("0. Đăng xuất");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Chức năng quản lý sách...");
                    break;
                case 2:
                    System.out.println("Chức năng quản lý khách hàng...");
                    break;
                case 3:
                    System.out.println("Chức năng quản lý hóa đơn...");
                    break;
                case 4:
                    System.out.println("Chức năng thống kê...");
                    break;
                case 0:
                    System.out.println("Đăng xuất!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while(choice != 0);
    }
}
