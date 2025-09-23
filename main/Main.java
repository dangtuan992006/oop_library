package Main;

import user.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TaiKhoan ad = new Admin("admin", "admin123");
        TaiKhoan nv = new NhanVien("nv01", "123456");

        while (true) {
            System.out.println("===== ĐĂNG NHẬP HỆ THỐNG =====");
            System.out.println("1. Đăng nhập");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int option = sc.nextInt();
            sc.nextLine(); // bỏ ký tự xuống dòng

            if (option == 0) {
                System.out.println(">> Thoát chương trình!");
                break;
            }

            System.out.print("Username: ");
            String u = sc.nextLine();
            System.out.print("Password: ");
            String p = sc.nextLine();

            TaiKhoan currentUser = null;

            // Kiểm tra đăng nhập
            if (u.equals(ad.getUsername()) && p.equals(ad.getPassword())) {
                currentUser = ad;
                System.out.println(">> Đăng nhập thành công với quyền Admin!");
            } else if (u.equals(nv.getUsername()) && p.equals(nv.getPassword())) {
                currentUser = nv;
                System.out.println(">> Đăng nhập thành công với quyền Nhân viên!");
            } else {
                System.out.println(">> Sai tài khoản hoặc mật khẩu!");
            }

            // Nếu đăng nhập thành công thì vào menu
            if (currentUser != null) {
                currentUser.hienThiMenu();
            }
        }
        sc.close();
    }
}
