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
        boolean isMaValid;

        do {
            System.out.print("Nhap loai khach hang (diamond, gold, silver): ");
            loai = sc.nextLine().trim().toLowerCase();
            if (!loai.equals("diamond") && !loai.equals("gold") && !loai.equals("silver")) {
                System.out.println("Loai khach hang khong hop le. Vui long nhap lai.");
            } else {
                break;
            }
        } while (true);

        do {
            System.out.print("Nhap ma khach hang: ");
            ma = sc.nextLine().trim();
            isMaValid = true;

            for (customer kh : customerList) {
                if (kh.makhachhang.equalsIgnoreCase(ma)) {
                    System.out.println("Ma khach hang da ton tai!");
                    isMaValid = false;
                    break;
                }
            }

            if ((loai.equals("diamond") && ma.indexOf("D") != 0) ||
                (loai.equals("gold") && ma.indexOf("G") != 0) ||
                (loai.equals("silver") && ma.indexOf("S") != 0)) {
                System.out.println("Ma khach hang khong hop le! (viet hoa chu cai dau tien)");
                isMaValid = false;
            }

        } while (!isMaValid);

        System.out.print("Nhap ten khach hang: ");
        ten = sc.nextLine().trim();
        System.out.print("Nhap dia chi khach hang: ");
        diachi = sc.nextLine().trim();

        do {
            System.out.print("Nhap so dien thoai khach hang: ");
            sdt = sc.nextLine().trim();
            if (!sdt.matches("[0-9]+")) {
                System.out.println("So dien thoai khong hop le (chi duoc chua so). Vui long nhap lai.");
            } else {
                break;
            }
        } while (true);

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
        }
        ghidulieu();
        System.out.println("Them khach hang thanh cong!");
        stop();
    }


    @Override
    public void sua(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma khach hang can sua: ");
        String ma = sc.nextLine().trim();

        for (customer kh : customerList) {
            if (kh.makhachhang.equalsIgnoreCase(ma)) {
                System.out.println("Tim thay khach hang. Nhap thong tin moi (de trong neu khong muon thay doi).");
                
                System.out.println("Nhap ten khach hang: ");
                String tenMoi = sc.nextLine().trim();
                if (!tenMoi.isEmpty()) kh.setName(tenMoi);

                System.out.println("Nhap dia chi khach hang: ");
                String diaChiMoi = sc.nextLine().trim();
                if (!diaChiMoi.isEmpty()) kh.setDiachi(diaChiMoi);

                String sdtMoi;
                do {
                    System.out.println("Nhap so dien thoai khach hang: ");
                    sdtMoi = sc.nextLine().trim();
                    if (sdtMoi.isEmpty()) {
                        break; // Khong thay doi
                    }
                    if (!sdtMoi.matches("[0-9]+")) {
                        System.out.println("So dien thoai khong hop le (chi duoc chua so). Vui long nhap lai.");
                    } else {
                        kh.setSodienthoai(sdtMoi);
                        break;
                    }
                } while (true);

                // Khong cho phep sua loai khach hang de dam bao tinh nhat quan voi ma khach hang
                System.out.println("Loai khach hang ('" + kh.getLoaikhachhang() + "') khong the thay doi.");

                ghidulieu();
                System.out.println("Sua thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay khach hang!");
        stop();
    }
    @Override
    public void xoa(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ma khach hang can xoa: ");
        String ma = sc.nextLine().trim();

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).makhachhang.equalsIgnoreCase(ma)) {
                customerList.remove(i);
                System.out.print("Ban co chac chan muon xoa khach hang nay? (Y/N): ");
                String confirm = sc.nextLine().trim();
                if (confirm.equalsIgnoreCase("Y")) {
                    customerList.remove(i);
                    System.out.println("Xoa thanh cong!");
                    ghidulieu();
                } else {
                    System.out.println("Da huy thao tac xoa.");
                }
                ghidulieu();
                return;
            }
        }
        System.out.println("Khong tim thay khach hang!");
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
        try (BufferedReader input = new BufferedReader(new FileReader("database/khachhang.txt")))
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
        String ma = sc.nextLine().trim();
        for (customer kh : customerList){
            if (kh.makhachhang.equalsIgnoreCase(ma)) {
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

    public customer timKhachHangTheoMa(String ma) {
        for (customer kh : customerList) {
            if (kh.getMakhachhang().equalsIgnoreCase(ma)) {
                return kh;
            }
        }
        return null;
    }
}