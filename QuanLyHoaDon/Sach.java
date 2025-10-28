package QuanLyHoaDon;

public class Sach extends SanPham {
    private String tacGia;

    public Sach(String idSanPham, String tenSanPham, double giaSanPham, int soLuong, String tacGia) {
        super(idSanPham, tenSanPham, giaSanPham, soLuong);
        this.tacGia = tacGia;
    }

    public String getTacGia() { return tacGia; }

    @Override
    public double thanhTien() {
        double tong = giaSanPham * soLuong;
        return Math.round(tong * 95) / 100.0; // giảm 5%
    }

    @Override
    public String toString() {
        return super.toString() + " (TacGia='" + tacGia + "')";
    }
}
