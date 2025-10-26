package QL_NhanVien;

public class NhanVien {
    private String hoTen;
    private int tuoi;
    private double luong;
    private String congViec;
    private String maNV;
    private String sdt;
    private String email;

    public NhanVien(){}

    public NhanVien(String hoTen, int tuoi, double luong, String congViec, String maNV, String sdt, String email) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.luong = luong;
        this.congViec = congViec;
        this.maNV = maNV;
        this.sdt = sdt;
        this.email = email;
    }

    //---get&set:
    public String getHoTen(){
        return hoTen;
    }
    public void setHoTen(String hoTen){
        this.hoTen = hoTen;
    }
    public int getTuoi(){
        return tuoi;
    }
    public void setTuoi(int tuoi){
        this.tuoi = tuoi;
    }
    public double getLuong(){
        return luong;
    }
    public void setLuong(double luong){
        this.luong = luong;
    }
    public String getCongViec(){
        return congViec;
    }
    public void setCongViec(String congViec){
        this.congViec= congViec;
    }
    public String getMaNV(){
        return maNV;
    }
    public void setMaNV(String maNV){
        this.maNV = maNV;
    }
    public String getSdt(){
        return sdt;
    }
    public void setSdt(String sdt){
        this.sdt = sdt;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    //---hien thi thong tin:
    public void xuat(){
        System.out.printf("==========Thong tin nhan vien==========\n");
        System.out.printf("Ho ten: %s\n", hoTen);
        System.out.printf("Tuoi: %d\n", tuoi);
        System.out.printf("Luong: %.2f\n", luong);
        System.out.printf("Cong viec: %s\n", congViec);
        System.out.printf("Ma nhan vien: %s\n", maNV);
        System.out.printf("So dien thoai: %s\n", sdt);
        System.out.printf("Email: %s\n", email);
        System.out.printf("=======================================\n");
    }

    public String toDataString(){
        return hoTen + "," + tuoi + "," + luong + "," + congViec + "," + maNV + "," + sdt + "," + email;
    }
    @Override
    public String toString(){
        return maNV + " - " + hoTen + " - " + congViec;
    }
}