package QuanLyHoaDon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import QuanLyNhaSach.Book;
import QuanLyNhaSach.QuanLyNhaSach;

public class QuanLyHoaDon implements Action {
    private final List<HoaDon> danhSachHoaDon = new ArrayList<>();
    private static final String FILE = "HoaDon.txt";
    private final Scanner scanner = new Scanner(System.in);

    // doc du lieu 
    @Override
public void DocFile() {
    danhSachHoaDon.clear();
    try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split(",", 6);
            if (parts.length < 5) continue;

            HoaDon hd = new HoaDon(
                parts[0].trim(), // idHoaDon
                parts[1].trim(), // idKhachHang
                parts[2].trim(), // tenKhachHang
                parts[3].trim(), // diaChiGiao
                parts[4].trim()  // sdt
            );

            if (parts.length == 6 && !parts[5].isEmpty()) {
                for (String sp : parts[5].split(";")) {
                    String[] info = sp.split(",");
                    if (info.length == 3) {
                        try {
                            hd.themSanPham(new SanPham(
                                info[0].trim(),
                                Double.parseDouble(info[1].trim()),
                                Integer.parseInt(info[2].trim())
                            ));
                        } catch (Exception ignore) {}
                    }
                }
            }

            danhSachHoaDon.add(hd);
        }
        System.out.println(" Đọc dữ liệu thành công từ file " + FILE);
    } catch (IOException e) {
        System.out.println(" Lỗi khi đọc file: " + e.getMessage());
    }
}


    // ghi du lieu 
    public void ghidulieu() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
        for (HoaDon hd : danhSachHoaDon) {
            String data = hd.getIdHoaDon() + "," +
                          hd.getIdKhachHang() + "," +
                          hd.getTenKhachHang() + "," +
                          hd.getDiachiGiao() + "," +
                          hd.getSdt();

            String sanPhamData = "";
            for (SanPham sp : hd.getDanhSachSanPham()) {
                if (!sanPhamData.isEmpty()) sanPhamData += ";";
                sanPhamData += sp.getLoaiSanPham() + "," + sp.getGiaSanPham() + "," + sp.getSoLuong();
            }

            // noi tiep san pham ke cuoi 
            if (!sanPhamData.isEmpty()) {
                data += "," + sanPhamData;
            }

            bw.write(data);
            bw.newLine();
        }

        System.out.println(" Ghi dữ liệu thành công vào file " + FILE);
    } catch (IOException e) {
        System.out.println(" Lỗi khi ghi dữ liệu: " + e.getMessage());
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
    public void them(QuanLyNhaSach quanLyNhaSach) {
        String idHoaDon;
        do {
            System.out.print("Nhap ID Hoa Don: ");
            idHoaDon = scanner.nextLine().trim();
            if (tonTaiId(idHoaDon)) {
                System.out.println("ID nay da ton tai. Vui long nhap ID khac.");
                idHoaDon = null;
            }
        } while (idHoaDon == null || idHoaDon.isEmpty());

        System.out.print("Nhap ID Khach Hang: ");
        String idKhachHang = scanner.nextLine().trim();

        System.out.print("Nhap Ten Khach Hang: ");
        String tenKhachHang = scanner.nextLine().trim();

        System.out.print("Nhap Dia Chi Giao: ");
        String diaChiGiao = scanner.nextLine().trim();

        System.out.print("Nhap SDT: ");
        String sdt = scanner.nextLine().trim();

        HoaDon hoaDon = new HoaDon(idHoaDon, idKhachHang, tenKhachHang, diaChiGiao, sdt);

        // them sach vao bill 
        while (true) {
            System.out.print("Nhap ID Sach: ");
            String idSach = scanner.nextLine().trim();

            // tim sach theo id

        HoaDon hoaDon = new HoaDon(idHoaDon, idKhachHang, tenKhachHang, diaChiGiao, sdt);
        boolean themSanPham = true;
        while (themSanPham) {
        System.out.print("Nhap Ma Sach: ");
        Scanner scanner = new Scanner(System.in);
        String idSach = scanner.nextLine().trim();

        Book book = quanLyNhaSach.searchForBill(idSach);
        if (book != null) {
        System.out.print("Nhap So Luong: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        if (book.getQuantity() >= soLuong) {
            SanPham sanPham = new SanPham(book.getId(), book.getPrice(), soLuong);
            hoaDon.themSanPham(sanPham);

            book.setQuantity(book.getQuantity() - soLuong);
            System.out.println("Sach da duoc them vao hoa don.");
        } else {
            System.out.println("So luong sach trong kho khong du.");
        }
    } else {
        System.out.println("Khong tim thay sach voi ID: " + idSach);
    }

    System.out.print("Ban co muon them san pham khac? (Y/N): ");
    String themKhac = scanner.nextLine().trim();
    if (!themKhac.equalsIgnoreCase("Y")) {
        themSanPham = false;
    }
}


        danhSachHoaDon.add(hoaDon);
        ghidulieu();
        System.out.println("Them hoa don thanh cong.");
        quanLyNhaSach.ghidulieu();


    // sua info hoa don 
    @Override
    public void sua() {
        System.out.print("Nhap ID Hoa Don can sua: ");
        String id = scanner.nextLine().trim();
        HoaDon hd = timHoaDonTheoId(id);
        if (hd == null) {
            System.out.println("Khong tim thay hoa don voi ID: " + id);
            return;
        }

        System.out.print("Nhap Ten Khach Hang moi: ");
        hd.setTenKhachHang(scanner.nextLine().trim());

        System.out.print("Nhap Dia Chi Giao moi: ");    
        hd.setDiachiGiao(scanner.nextLine().trim());

        System.out.print("Nhap SDT moi: ");
        hd.setSdt(scanner.nextLine().trim());

        ghidulieu();
        System.out.println("Da cap nhat thong tin hoa don.");
    }

    // xoa hoa don 
    @Override
    public void xoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ID Hoa Don can xoa: ");
        String idHoaDon = scanner.nextLine().trim();

        boolean found = false;
        for (int i = 0; i < danhSachHoaDon.size(); i++) {
            if (danhSachHoaDon.get(i).getIdHoaDon().equalsIgnoreCase(idHoaDon)) {
                danhSachHoaDon.remove(i);
                ghidulieu();
                System.out.println("Da xoa hoa don voi ID: " + idHoaDon);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay hoa don voi ID: " + idHoaDon);
        }
    }


    // hien danh sach
    @Override
    public void hiendanhsach() {
        if (danhSachHoaDon.isEmpty()) {
            System.out.println("Khong co hoa don nao trong danh sach.");
            return;
        }
        System.out.println("=== DANH SACH HOA DON ===");
        for (HoaDon hd : danhSachHoaDon) {
            System.out.println(hd);
            System.out.println("-------------------------");
        }
    }
}

    // tim kiem hoa don 
    @Override
    public void timkiem() {
        System.out.print("Nhap ID Hoa Don can tim: ");
        String id = scanner.nextLine().trim();
        HoaDon hd = timHoaDonTheoId(id);
        if (hd == null) {
            System.out.println("Khong tim thay hoa don voi ID: " + id);
            return;
        }
        System.out.println(" ------------------------------------------------------------ ");
        System.out.println(hd);
        System.out.println(" ------------------------------------------------------------ ");
    }

    
