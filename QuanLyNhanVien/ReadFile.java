package QuanLyNhanVien;

import java.io.*;
import java.util.*;

public class ReadFile {
    public ArrayList<NhanVien> readFile(String filename){
        ArrayList<NhanVien> ds = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length == 7){
                    String hoTen = parts[0];
                    int tuoi = Integer.parseInt(parts[1]);
                    double luong = Double.parseDouble(parts[2]);
                    String congViec = parts[3];
                    String maNV = parts[4];
                    String sdt = parts[5];
                    String email = parts[6];
                    NhanVien nv = new NhanVien(hoTen, tuoi, luong, congViec, maNV, sdt, email);
                    ds.add(nv);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ds;
    }
}
