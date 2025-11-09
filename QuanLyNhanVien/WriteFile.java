package QuanLyNhanVien;

import java.io.*;
import java.util.*;

public class WriteFile{
    public static void writeFile(String filename, ArrayList<NhanVien> ds){
        try(FileWriter fw = new FileWriter(filename)){
            for(NhanVien nv : ds){
                fw.write(nv.getHoTen() + "," + nv.getTuoi() + "," + nv.getLuong() + "," +
                         nv.getCongViec() + "," + nv.getMaNV() + "," + nv.getSdt() + "," +
                         nv.getEmail() + "\n");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}