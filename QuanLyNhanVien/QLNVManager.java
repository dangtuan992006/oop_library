package QuanLyNhanVien;

import java.util.*;

public class QLNVManager implements Action {
    private final ThemNV themNV = new ThemNV();
    private final XoaNV xoaNV = new XoaNV();
    private final SuaThongTinNV suaNV = new SuaThongTinNV();
    private final TimNV timNV = new TimNV();
    private final ReadFile reader = new ReadFile();

    @Override
    public void them(ArrayList<NhanVien> ds) {
        NhanVien nv = themNV.nhap();
        ds.add(nv);
        WriteFile.writeFile("database/nhanvien.txt", ds);
    }
    @Override
    public void xoa(ArrayList<NhanVien> ds, Scanner sc){
        boolean changed = xoaNV.xoaTheoMA(ds, sc);
        if(changed){
            WriteFile.writeFile("database/nhanvien.txt", ds);
        }
    }
    @Override
    public void sua(ArrayList<NhanVien> ds, Scanner sc){
        suaNV.suaThongTin(ds, sc);
        WriteFile.writeFile("database/nhanvien.txt", ds);
    }
    @Override
    public void tim(ArrayList<NhanVien> ds, Scanner sc){
        timNV.timNV(ds);
    }
    @Override
    public void hienThi(ArrayList<NhanVien> ds){
        if(ds == null || ds.isEmpty()){
            System.out.println("Danh sach trong.");
            return;
        }
        System.out.println("===Danh sach nhan vien====");
        for(NhanVien nv : ds){
            System.out.println(nv.toString());
        }
        System.out.println("=========================");
    }
    @Override
    public void docFile(String filename, ArrayList<NhanVien> ds){
        ArrayList<NhanVien> result = reader.readFile(filename);
        ds.clear();
        if(result != null){
            ds.addAll(result);
        }
    }
    @Override
    public void ghiFile(String filename, ArrayList<NhanVien> ds){
        WriteFile.writeFile(filename, ds);
    }
    @Override
    public void tinhLuong(ArrayList<NhanVien> ds){
        TinhLuong.tinhLuong(ds, new Scanner(System.in));
        WriteFile.writeFile("database/nhanvien.txt", ds);
    }
}
