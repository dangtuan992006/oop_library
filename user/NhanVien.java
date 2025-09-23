package user;

import java.util.Scanner;

public class NhanVien extends TaiKhoan {
    public NhanVien ( String username , String password ){
        super(username , password);
    }
    @Override
    public void hienThiMenu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----- Menu Nhân viên -----");
            System.out.println("1. Bán sách / lập hóa đơn");
            System.out.println("0. Đăng xuất");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Chức năng bán sách / lập hóa đơn...");
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
