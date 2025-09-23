package model;

public class Sach {
    String maSach;
    String tenSach;
    String tacGia;
    String theLoai;
    double giaBan;
    int soLuong;
    public Sach(){
        maSach ="";
        tenSach="";
        tacGia="";
        theLoai="";
        giaBan =0;
        soLuong =0;
    }
    public Sach(String a , String b, String c , String d, double e , int f){
        maSach = a;
        tenSach = b;
        tacGia = c;
        theLoai = d;
        giaBan = e;
        soLuong = f;
    }
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    public String getMaSach() {
        return maSach;
    }
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    public double getGiaBan() {
        return giaBan;
    }
    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    public String getTheLoai() {
        return theLoai;
    }
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    public String getTenSach() {
        return tenSach;
    }
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
    public String getTacGia() {
        return tacGia;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public int getSoLuong() {
        return soLuong;
    }
}
