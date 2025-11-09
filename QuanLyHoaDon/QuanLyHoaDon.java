package QuanLyHoaDon;

import java.io.*;
import java.util.*;
import quanlykhachhang.customer;
import quanlykhachhang.quanlydanhsachkhachhang;
import QuanLySach.Book;
import QuanLySach.QuanLySach;

public class QuanLyHoaDon implements Action {
    private final List<HoaDon> danhSachHoaDon = new ArrayList<>();
    private static final String FILE = "database/HoaDon.txt";
    private final Scanner scanner = new Scanner(System.in);

    // doc du lieu tu file
    @Override
    public void DocFile() {
        danhSachHoaDon.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",", 6);
                if (parts.length < 5) continue;

                HoaDon hd = new HoaDon(parts[0], parts[1], parts[2], parts[3], parts[4]);

                // doc danh sach san pham neu co
                if (parts.length == 6 && !parts[5].isEmpty()) {
                    for (String sp : parts[5].split(";")) {
                        String[] info = sp.split(",");
                        if (info.length >= 5) {
                            try {
                                Sach sanPham = new Sach(
                                        info[0].trim(), // id
                                        info[1].trim(), // ten
                                        Double.parseDouble(info[2].trim()), // gia
                                        Integer.parseInt(info[3].trim()),   // so luong
                                        info[4].trim()  // tac gia
                                );
                                hd.themSanPham(sanPham);
                            } catch (Exception ignore) {}
                        }
                    }
                }

                danhSachHoaDon.add(hd);
            }
            System.out.println("Doc du lieu thanh cong tu file " + FILE);
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    // ghi du lieu ra file
    @Override
    public void ghidulieu() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (HoaDon hd : danhSachHoaDon) {
                StringBuilder data = new StringBuilder();
                data.append(hd.getIdHoaDon()).append(",")
                        .append(hd.getIdKhachHang()).append(",")
                        .append(hd.getTenKhachHang()).append(",")
                        .append(hd.getDiachiGiao()).append(",")
                        .append(hd.getSdt()).append(",");

                StringBuilder spData = new StringBuilder();
                for (SanPham sp : hd.getDanhSachSanPham()) {
                    if (sp instanceof Sach s) {
                        if (spData.length() > 0) spData.append(";");
                        spData.append(s.getIdSanPham()).append(",")
                                .append(s.getTenSanPham()).append(",")
                                .append(s.getGiaSanPham()).append(",")
                                .append(s.getSoLuong()).append(",")
                                .append(s.getTacGia());
                    }
                }
                data.append(spData);
                bw.write(data.toString());
                bw.newLine();
            }
            System.out.println("Ghi du lieu thanh cong vao file " + FILE);
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    private boolean tonTaiId(String idHoaDon) {
        return danhSachHoaDon.stream().anyMatch(hd -> hd.getIdHoaDon().equalsIgnoreCase(idHoaDon));
    }

    private HoaDon timHoaDonTheoId(String idHoaDon) {
        return danhSachHoaDon.stream()
                .filter(hd -> hd.getIdHoaDon().equalsIgnoreCase(idHoaDon))
                .findFirst().orElse(null);
    }

    // them hoa don
    @Override
    public void them(QuanLySach quanLySach, quanlydanhsachkhachhang qlKhachHang) {
        String idHoaDon;
        do {
            System.out.print("Nhap ID Hoa Don: ");
            idHoaDon = scanner.nextLine().trim();
            if (tonTaiId(idHoaDon)) {
                System.out.println("ID nay da ton tai, vui long nhap ID khac!");
                idHoaDon = "";
            }
        } while (idHoaDon.isEmpty());

        System.out.print("Nhap ID Khach Hang: ");
        String idKhachHang = scanner.nextLine().trim();
        customer kh = qlKhachHang.timKhachHangTheoMa(idKhachHang);

        String tenKhachHang, diaChiGiao, sdt;

        if (kh != null) {
            tenKhachHang = kh.getName();
            diaChiGiao = kh.getDiachi();
            sdt = kh.getSodienthoai();
        } else {
            System.out.print("Nhap Ten Khach Hang: ");
            tenKhachHang = scanner.nextLine().trim();
            System.out.print("Nhap Dia Chi Giao: ");
            diaChiGiao = scanner.nextLine().trim();
            System.out.print("Nhap SDT: ");
            sdt = scanner.nextLine().trim();
        }

        HoaDon hoaDon = new HoaDon(idHoaDon, idKhachHang, tenKhachHang, diaChiGiao, sdt);

        while (true) {
            System.out.print("Nhap Ma Sach: ");
            String idSach = scanner.nextLine().trim();
            Book book = quanLySach.searchForBill(idSach);
            if (book != null) {
                int soLuong;
                while (true) {
                    System.out.print("Nhap So Luong: ");
                    try {
                        soLuong = Integer.parseInt(scanner.nextLine().trim());
                        if (soLuong > 0) break;
                        System.out.println("So luong phai lon hon 0.");
                    } catch (NumberFormatException e) {
                        System.out.println("So luong khong hop le! Vui long nhap lai mot so.");
                    }
                }

                if (book.getQuantity() >= soLuong) {
                    Sach sanPham = new Sach(book.getId(), book.getTitle(), book.getPrice(), soLuong, book.getAuthor());
                    hoaDon.themSanPham(sanPham);
                    book.setQuantity(book.getQuantity() - soLuong);
                    System.out.println("Sach da duoc them vao hoa don!");
                } else {
                    System.out.println("So luong sach trong kho khong du!");
                }
            } else {
                System.out.println("Khong tim thay sach voi ID: " + idSach);
            }

            System.out.print("Ban co muon them san pham khac? (Y/N): ");
            if (!scanner.nextLine().trim().equalsIgnoreCase("Y")) break;
        }

        danhSachHoaDon.add(hoaDon);
        ghidulieu();
        quanLySach.ghiFile();
        System.out.println("Them hoa don thanh cong!");
    }

    // @Override
    // public void them(QuanLySach quanLySach) {
    //     System.out.println("Loi: Chuc nang nay can duoc cung cap them thong tin khach hang.");
    // }

    // sua hoa don
    @Override
    public void sua() {
        System.out.print("Nhap ID Hoa Don can sua: ");
        String id = scanner.nextLine().trim();
        HoaDon hd = timHoaDonTheoId(id);
        if (hd == null) {
            System.out.println("Khong tim thay hoa don!");
            return;
        }

        System.out.print("Nhap Ten Khach Hang moi: ");
        hd.setTenKhachHang(scanner.nextLine().trim());
        System.out.print("Nhap Dia Chi Giao moi: ");
        hd.setDiachiGiao(scanner.nextLine().trim());
        System.out.print("Nhap SDT moi: ");
        hd.setSdt(scanner.nextLine().trim());

        ghidulieu();
        System.out.println("Cap nhat hoa don thanh cong!");
    }

    // xoa hoa don
    @Override
    public void xoa() {
        System.out.print("Nhap ID Hoa Don can xoa: ");
        String id = scanner.nextLine().trim();

        HoaDon hd = timHoaDonTheoId(id);
        if (hd != null) {
            danhSachHoaDon.remove(hd);
            ghidulieu();
            System.out.println("Da xoa hoa don!");
        } else {
            System.out.println("Khong tim thay hoa don!");
        }
    }

    // hien danh sach hoa don (xuat dep hon)
    @Override
    public void hiendanhsach() {
        if (danhSachHoaDon.isEmpty()) {
            System.out.println("Khong co hoa don nao trong danh sach!");
            return;
        }

        System.out.println("====================================================================================================================");
        System.out.printf("%-8s | %-10s | %-20s | %-20s | %-12s | %-15s%n",
                "MaHD", "MaKH", "Ten Khach Hang", "Dia Chi Giao", "SDT", "Tong Tien");
        System.out.println("====================================================================================================================");

        for (HoaDon hd : danhSachHoaDon) {
            double tong = hd.tinhTongTien();
            System.out.printf("%-8s | %-10s | %-20s | %-20s | %-12s | %-15.2f%n",
                    hd.getIdHoaDon(), hd.getIdKhachHang(), hd.getTenKhachHang(),
                    hd.getDiachiGiao(), hd.getSdt(), tong);
        }

        System.out.println("====================================================================================================================");
    }

    // tim kiem hoa don
    @Override
    public void timkiem() {
        System.out.print("Nhap ID Hoa Don can tim: ");
        String id = scanner.nextLine().trim();
        HoaDon hd = timHoaDonTheoId(id);
        if (hd == null) {
            System.out.println("Khong tim thay hoa don!");
            return;
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Ma hoa don: " + hd.getIdHoaDon());
        System.out.println("Ma khach hang: " + hd.getIdKhachHang());
        System.out.println("Ten khach hang: " + hd.getTenKhachHang());
        System.out.println("Dia chi giao: " + hd.getDiachiGiao());
        System.out.println("So dien thoai: " + hd.getSdt());
        System.out.println("San pham trong hoa don:");

        System.out.printf("%-8s | %-25s | %-10s | %-8s | %-15s%n",
                "MaSach", "Ten Sach", "Gia", "SL", "Tac Gia");
        System.out.println("--------------------------------------------------------------------------");

        for (SanPham sp : hd.getDanhSachSanPham()) {
            if (sp instanceof Sach s) {
                System.out.printf("%-8s | %-25s | %-10.2f | %-8d | %-15s%n",
                        s.getIdSanPham(), s.getTenSanPham(), s.getGiaSanPham(),
                        s.getSoLuong(), s.getTacGia());
            }
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("Tong tien: %.2f VND%n", hd.tinhTongTien());
        System.out.println("----------------------------------------------------");
    }
}
