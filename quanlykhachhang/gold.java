package quanlykhachhang;

public class gold extends customer{
    
    public gold(){
        super();
        loaikhachhang = "gold";
    }
    public gold(String makhachhang, String name, String diachi, String sodienthoai){
        super(makhachhang ,name, diachi, sodienthoai, "gold");
    }

    @Override
    public void hienthongtin() {
        System.out.println(".___________________________________________________________________________________________________________________________.");
        System.out.printf("| %-7s | %-20s | %-60s | %-13s | %-9s |\n", "MA","TEN KHACH HANG","DIA CHI","SO DIEN THOAI","LOAI");
        System.out.println("|---------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("| %-7s | %-20s | %-60s | %-13s | %-9s |\n",getMakhachhang(),getName(),getDiachi(),getSodienthoai(),getLoaikhachhang());
        System.out.println("|___________________________________________________________________________________________________________________________|");
    }
}
