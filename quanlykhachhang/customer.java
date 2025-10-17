package quanlykhachhang;

public abstract class customer {

    String makhachhang;
    String name;
    String diachi;
    String sodienthoai;
    String loaikhachhang;
    static int soluong = 0;     

    public customer(){
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
    
}