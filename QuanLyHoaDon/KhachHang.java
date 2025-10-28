package QuanLyHoaDon;

public class KhachHang extends Nguoi {
    private String diaChi;

    public KhachHang(String id, String ten, String sdt, String diaChi) {
        super(id, ten, sdt);
        this.diaChi = diaChi;
    }

    public String getDiaChi() { return diaChi; }

    @Override
    public void hienThiThongTin() {
        System.out.println("KH[ID=" + id + ", Ten=" + ten + ", SDT=" + sdt + ", DiaChi=" + diaChi + "]");
    }
}
