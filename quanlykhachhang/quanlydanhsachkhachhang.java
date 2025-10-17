package quanlykhachhang;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class quanlydanhsachkhachhang {

    ArrayList<customer> listkhachhang;

    //constructor
    public quanlydanhsachkhachhang() {
        listkhachhang = new ArrayList<>();
    }

    public void them() {}
    public void sua() {}
    public void xoa() {}


    public void hiendanhsach() {
        System.out.println(".___________________________________________________________________________________________________________________________.");
        System.out.printf("| %-7s | %-20s | %-60s | %-13s | %-9s |\n", "MA","TEN KHACH HANG","DIA CHI","SO DIEN THOAI","LOAI");
        System.out.println("|---------------------------------------------------------------------------------------------------------------------------|");
        for (customer kh : listkhachhang) {
            System.out.printf("| %-7s | %-20s | %-60s | %-13s | %-9s |\n",kh.makhachhang , kh.name , kh.diachi , kh.sodienthoai , kh.loaikhachhang);
        }
        System.out.println("|___________________________________________________________________________________________________________________________|");
    }

    public void docdulieu() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("../khachhang.txt"));
            String line;
            while ((line = input.readLine()) != null ) {
                System.out.println(line);
            }
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ghidulieu() {}
    public void hientongkhachhang() {}
    public void timkiemkhachhang() {}
    public void chinhsuathongtinkhachhang() {}
}
