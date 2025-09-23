package model;

public class KhachHang {
    String maKhachHang;
    String tenKhachHang;
    String soDienThoai;
    String diaChi;
    public KhachHang(String a , String b , String c ,String d){
        maKhachHang = a;
        tenKhachHang = b;
        soDienThoai = c;
        diaChi = d;
    }
    public KhachHang(){
        maKhachHang ="";
        tenKhachHang ="";
        soDienThoai ="";
        diaChi ="";
    }
    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    public String getMaKhachHang() {
        return maKhachHang;
    }
    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
    public String getTenKhachHang() {
        return tenKhachHang;
    }
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getDiaChi() {
        return diaChi;
    }
}
