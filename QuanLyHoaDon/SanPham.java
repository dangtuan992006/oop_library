package QuanLyHoaDon;

public abstract class SanPham {
    protected String idSanPham;
    protected String tenSanPham;
    protected double giaSanPham;
    protected int soLuong;
    private static int demSanPham = 0;

    public SanPham(String idSanPham, String tenSanPham, double giaSanPham, int soLuong) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.soLuong = soLuong;
        demSanPham++;
    }

    public static int getTongSanPham() { return demSanPham; }

    public String getIdSanPham() { return idSanPham; }
    public String getTenSanPham() { return tenSanPham; }
    public double getGiaSanPham() { return giaSanPham; }
    public int getSoLuong() { return soLuong; }

    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public abstract double thanhTien();



    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{id='" + idSanPham + "', ten='" + tenSanPham + "', gia=" + giaSanPham +
                ", soLuong=" + soLuong + ", thanhTien=" + thanhTien() + "}";
    }
}
