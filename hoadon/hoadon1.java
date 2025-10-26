package QuanLyHoaDon;
import java.util.ArrayList;

abstract class Nguoi {
    protected String id;
    protected String ten;
    protected String sdt;

 public Nguoi(String id, String ten, String sdt) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
    }
}
class KhachHang extends Nguoi {
    private String diaChi;

    public KhachHang(String id, String ten, String sdt, String diaChi) {
        super(id, ten, sdt);
        this.diaChi = diaChi;
    }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    @Override
    public void hienThiThongTin() {
        System.out.println("KH[ID=" + id + ", Tên=" + ten + ", SĐT=" + sdt + ", Đ/c=" + diaChi + "]");
    }
}

 abstract class SanPham {
    private String idSanPham;
    private String tenSanPham;
    private double giaSanPham;
    private int soLuong;
    private static int demSanPham = 0;


    public SanPham(String idSanPham, String tenSanPham, double giaSanPham, int soLuong) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.soLuong = soLuong;
        demSanPham++;
    }
     public static int getTongSanPham() {
        return demSanPham;
    }
    public String getIdSanPham() { 
        return idSanPham; 
    }
    public String getTenSanPham() { 
        return tenSanPham;  
    }
    public double getGiaSanPham() { 
        return giaSanPham;
    }
    public int getSoLuong() {
         return soLuong; 
    }

    public void setIdSanPham(String idSanPham) {
         this.idSanPham = idSanPham; 
    }
    public void setTenSanPham(String tenSanPham) {
         this.tenSanPham = tenSanPham;
    }
    public void setGiaSanPham(double giaSanPham) { 
        this.giaSanPham = giaSanPham;
    }
    public void setSoLuong(int soLuong) {
         this.soLuong = soLuong; 
    }
     public abstract double thanhTien();
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id='" + idSanPham + "', ten='" + tenSanPham + "', gia=" + giaSanPham
                + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien() + "}";
    }
}

    @Override
    public String toString() {
        return "SanPham{" +
                "id='" + idSanPham + '\'' +
                ", ten='" + tenSanPham + '\'' +
                ", gia=" + giaSanPham +
                ", soLuong=" + soLuong +
                ", thanhTien=" + (giaSanPham * soLuong) +
                '}';
    }
    class Sach extends SanPham {
    private String tacGia;

    public Sach(String idSanPham, String tenSanPham, double giaSanPham, int soLuong, String tacGia) {
        super(idSanPham, tenSanPham, giaSanPham, soLuong);
        this.tacGia = tacGia;
    }
    public String getTacGia() { return tacGia; }
        
    public double thanhTien() {
        double h = giaSanPham * soLuong;
        return Math.h(h * 0.95 * 100.0) / 100.0; // chiet khau 5%
    }

    @Override
    public String toString() {
        return super.toString() + " (tacGia='" + tacGia + "')";
    }
}
public class HoaDon {
    private String idHoaDon;
    private String idKhachHang;
    private String tenKhachHang;
    private String diachiGiao;
    private String sdt;
    private ArrayList<SanPham> danhSachSanPham; 

    public HoaDon(String idHoaDon, String idKhachHang, String tenKhachHang, String diachiGiao, String sdt) {
        this.idHoaDon = idHoaDon;
        this.idKhachHang = idKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.diachiGiao = diachiGiao;
        this.sdt = sdt;
        this.danhSachSanPham = new ArrayList<>();
    }

    public void themSanPham(SanPham sanPham) {
        danhSachSanPham.add(sanPham);
    }

    public double tinhTongTien()
    {
        double tongTien = 0;
        for (SanPham sanPham : danhSachSanPham)
        {
            tongTien += sanPham.getGiaSanPham() * sanPham.getSoLuong();
        }
        return tongTien;
    }

    
    public String getIdHoaDon() { 
        return idHoaDon; 
    }
    public String getIdKhachHang() { 
        return idKhachHang;
    }
    public String getTenKhachHang() { 
        return tenKhachHang; 
    }
    public String getDiachiGiao() { 
        return diachiGiao; 
    }
    public String getSdt() { 
        return sdt; 
    }
    public ArrayList<SanPham> getDanhSachSanPham() {
         return danhSachSanPham; 
    }

    
    public void setIdHoaDon(String idHoaDon) { 
        this.idHoaDon = idHoaDon;
    }
    public void setIdKhachHang(String idKhachHang) {
         this.idKhachHang = idKhachHang; 
    }
    public void setTenKhachHang(String tenKhachHang) {
         this.tenKhachHang = tenKhachHang; 
    }
    public void setDiachiGiao(String diachiGiao) {
         this.diachiGiao = diachiGiao;
    }
    public void setSdt(String sdt) {
         this.sdt = sdt;
    }
    public void setDanhSachSanPham(ArrayList<SanPham> danhSachSanPham) { 
        this.danhSachSanPham = danhSachSanPham; 
    }

    public void displayInfo()
    {
        System.out.println("ID Hoa Don: " + idHoaDon);
        System.out.println("ID Khach Hang: " + idKhachHang);
        System.out.println("Ten Khach Hang: " + tenKhachHang);
        System.out.println("Dia Chi Giao: " + diachiGiao);
        System.out.println("SDT: " + sdt);
        System.out.println("Danh Sach San Pham:");
        for (SanPham sanPham : danhSachSanPham)
        {
            sanPham.displayInfo();
        }
        System.out.println("Tong Tien: " + tinhTongTien());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hoa Don: ID: ").append(idHoaDon)
          .append("\nKhach Hang: ").append(tenKhachHang)
          .append("\nDia Chi: ").append(diachiGiao)
          .append("\nSDT: ").append(sdt)
          .append("\nDanh Sach San Pham:\n");

        for (SanPham sanPham : danhSachSanPham) {
            sb.append(sanPham.toString()).append("\n");
        }
        sb.append("Tong Tien: ").append(tinhTongTien());
        return sb.toString();
    }
}
