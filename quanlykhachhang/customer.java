package quanlykhachhang;

public abstract class customer{
    
    String makhachhang;
    String name;
    String diachi;
    String sodienthoai;
    String loaikhachhang;
    static int tongkhachhang = 0;

    public customer(){
        tongkhachhang++;
        makhachhang = "";
        name = "";
        diachi = "";
        sodienthoai = "";
        loaikhachhang = "";
    }
    public customer(String makhachhang, String name, String diachi, String sodienthoai, String loaikhachhang){
        this.makhachhang = makhachhang;
        this.name = name;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.loaikhachhang = loaikhachhang;
    }


    public String getMakhachhang() {return makhachhang;}
    public String getName() {return name;}
    public String getDiachi() {return diachi;}
    public String getSodienthoai() {return sodienthoai;}
    public String getLoaikhachhang() {return loaikhachhang;}

    public void setMakhachhang(String makhachhang) {this.makhachhang = makhachhang;}
    public void setName(String name) {this.name = name;}
    public void setDiachi(String diachi) {this.diachi = diachi;}
    public void setSodienthoai(String sodienthoai) {this.sodienthoai = sodienthoai;}
    public void setLoaikhachhang(String loaikhachhang) {this.loaikhachhang = loaikhachhang;}
    
    public static void intong(){
        System.out.println("Tong so khach hang: " + tongkhachhang);
    }

    public abstract void hienthongtin();
}
