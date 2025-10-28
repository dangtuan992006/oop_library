package quanlykhachhang;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class quanlydanhsachkhachhang implements action {
    
    ArrayList<customer> customerList = new ArrayList<>();

    @Override
    public void them(){
        Scanner sc = new Scanner(System.in);

        String ma, ten, diachi, sdt, loai;
        System.out.print("Nhap ma khach hang: ");
        ma = sc.nextLine();
        System.out.print("Nhap ten khach hang: ");
        ten = sc.nextLine();
        System.out.print("Nhap dia chi khach hang: ");
        diachi = sc.nextLine();
        System.out.print("Nhap so dien thoai khach hang: ");
        sdt = sc.nextLine();
        System.out.print("Nhap loai khach hang: ");
        loai = sc.nextLine();

        for (customer kh : customerList) {
            if (kh.makhachhang.equals(ma)) {
                System.out.println("Ma khach hang da ton tai!");
                stop();
                return;
            }
        }
        switch (loai) {
            case "diamond":
                if (ma.charAt(0) != 'D') {
                    System.out.println("ma khach hang khong hop le! (ghi hoa chu cai dau)");
                    System.out.println("nhap lai?[co(0)/khong(1)]: ");
                    int choice = sc.nextInt();
                    if (choice == 0) {
                        them();
                    } else {
                        return;
                    }
                    return;
                }
                customerList.add(new diamond(ma, ten, diachi, sdt));
                break;
            case "gold":
                if (ma.charAt(0) != 'G') {
                    System.out.println("ma khach hang khong hop le! (ghi hoa chu cai dau)");
                    System.out.println("nhap lai?[co(0)/khong(1)]: ");
                    int choice = sc.nextInt();
                    if (choice == 0) {
                        them();
                    } else {
                        return;
                    }
                    return;
                }
                customerList.add(new gold(ma, ten, diachi, sdt));
                break;
            case "silver":
                if (ma.charAt(0) != 'S') {
                    System.out.println("ma khach hang khong hop le! (ghi hoa chu cai dau)");
                    System.out.println("nhap lai?[co(0)/khong(1)]: ");
                    int choice = sc.nextInt();
                    if (choice == 0) {
                        them();
                    } else {
                        return;
                    }
                    return;
                }
                customerList.add(new silver(ma, ten, diachi, sdt));
                break;
            default:
                System.out.println("Loai khach hang khong hop le!");
                System.out.println("nhap lai?[co(0)/khong(1)]: ");
                int choice = sc.nextInt();
                if (choice == 0) {
                    them();
                } else {
                    return;
                }
                break;
        }
        customer.tongkhachhang++;
        ghidulieu();
    }


    @Override
    public void sua(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma khach hang can sua: ");
        String ma = sc.nextLine();

        for (customer kh : customerList) {
            if (kh.makhachhang.equals(ma)) {
                System.out.println("Nhap ten khach hang: ");
                kh.name = sc.nextLine();
                System.out.println("Nhap dia chi khach hang: ");
                kh.diachi = sc.nextLine();
                System.out.println("Nhap so dien thoai khach hang: ");
                kh.sodienthoai = sc.nextLine();
                System.out.println("Nhap loai khach hang: ");
                kh.loaikhachhang = sc.nextLine();
                ghidulieu();
                System.out.println("Sua thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay khach hang!");
        sc.close();
        stop();
    }
    @Override
    public void xoa(){
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        System.out.println("nhap ma khach hang can xoa: ");
        String ma = sc.nextLine();

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).makhachhang.equals(ma)) {
                customerList.remove(i);
                System.out.println("Xoa thanh cong!");
                check = true;
                ghidulieu();
                break;
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay khach hang!");
        }
        stop();
    }
    @Override
    public void hiendanhsach(){
        System.out.println(".___________________________________________________________________________________________________________________________.");
        System.out.printf("| %-7s | %-20s | %-60s | %-13s | %-9s |\n", "MA","TEN KHACH HANG","DIA CHI","SO DIEN THOAI","LOAI");
        System.out.println("|---------------------------------------------------------------------------------------------------------------------------|");
        for (customer kh : customerList) {
            System.out.printf("| %-7s | %-20s | %-60s | %-13s | %-9s |\n",kh.getMakhachhang(),kh.getName(),kh.getDiachi(),kh.getSodienthoai(),kh.getLoaikhachhang());
        }
        System.out.println("|___________________________________________________________________________________________________________________________|");
        stop();
    }

    @Override
    public void docdulieu() {
        try (BufferedReader input = new BufferedReader(new FileReader("../database/database/khachhang.txt")))
        {
            String line;
            while ((line = input.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                String ma = parts[0].trim();
                String ten = parts[1].trim();
                String diachi = parts[2].trim();
                String sdt = parts[3].trim();
                String loai = parts[4].trim();

                switch (loai) {
                    case "diamond":
                        customerList.add(new diamond(ma, ten, diachi, sdt));
                        break;
                    case "gold":
                        customerList.add(new gold(ma, ten, diachi, sdt));
                        break;
                    case "silver":
                        customerList.add(new silver(ma, ten, diachi, sdt));
                        break;
                    default:
                        System.out.println("Loai khach hang khong hop le: " + loai);
                        break;
                }
                customer.tongkhachhang++;
            }
            input.close();
            System.out.println("doc du lieu thanh cong!");
        } catch (Exception e) {
            System.out.println("loi doc du lieu: " + e.getMessage());
        }
    }

    @Override
    public void ghidulieu(){
        try {
            FileWriter output = new FileWriter("database/khachhang.txt");
            for (customer kh : customerList){
                output.write(kh.makhachhang + "," + kh.name + "," + kh.diachi + "," + kh.sodienthoai + "," + kh.loaikhachhang + "\n");
            }
            output.close();
            // System.out.println("Ghi du lieu thanh cong!");
        } catch (Exception e) {
            System.out.println("loi ghi du lieu: " + e.getMessage());
        }
    }

    @Override
    public void hientongkhachhang(){
        customer.intong();
        stop();
    }

    @Override
    public void timkiemkhachhang(){
        Scanner sc = new Scanner(System.in);
        Boolean check = false;
        System.out.print("Nhap ma khach hang can tim: ");
        String ma = sc.nextLine();
        for (customer kh : customerList){
            if (kh.makhachhang.equals(ma)) {
                kh.hienthongtin();
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay khach hang!");
        }
        stop();
    }

    private void stop(){
        System.out.println("bam phim bat ki de tiep tuc!");
        try {
            System.in.read();
            while (System.in.available() > 0){
                System.in.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}