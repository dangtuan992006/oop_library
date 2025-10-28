package QuanLyHoaDon;

abstract class Nguoi {
    protected String id;
    protected String ten;
    protected String sdt;

    public Nguoi(String id, String ten, String sdt) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
    }

    public abstract void hienThiThongTin();
}
