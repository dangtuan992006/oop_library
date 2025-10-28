package QuanLyHoaDon;

import java.util.ArrayList;

public class HoaDon {
    private String idHoaDon;
    private String idKhachHang;
    private String tenKhachHang;
    private String diachiGiao;
    private String sdt;
    private ArrayList<SanPham> danhSachSanPham = new ArrayList<>();

    public HoaDon(String idHoaDon, String idKhachHang, String tenKhachHang, String diachiGiao, String sdt) {
        this.idHoaDon = idHoaDon;
        this.idKhachHang = idKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.diachiGiao = diachiGiao;
        this.sdt = sdt;
    }

    public void themSanPham(SanPham sanPham) {
        danhSachSanPham.add(sanPham);
    }

    public ArrayList<SanPham> getDanhSachSanPham() { return danhSachSanPham; }

    public String getIdHoaDon() { return idHoaDon; }
    public String getIdKhachHang() { return idKhachHang; }
    public String getTenKhachHang() { return tenKhachHang; }
    public String getDiachiGiao() { return diachiGiao; }
    public String getSdt() { return sdt; }

    public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; }
    public void setDiachiGiao(String diachiGiao) { this.diachiGiao = diachiGiao; }
    public void setSdt(String sdt) { this.sdt = sdt; }

    public double tinhTongTien() {
        double tong = 0;
        for (SanPham sp : danhSachSanPham) {
            tong += sp.thanhTien();
        }
        return tong;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HoaDon [ID=").append(idHoaDon)
                .append(", KhachHang=").append(tenKhachHang)
                .append(", SDT=").append(sdt)
                .append(", DiaChiGiao=").append(diachiGiao)
                .append("]\nDanhSachSanPham:\n");
        for (SanPham sp : danhSachSanPham) {
            sb.append("  ").append(sp).append("\n");
        }
        return sb.toString();
    }
}
