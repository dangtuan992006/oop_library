package QuanLySach;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySach implements Action {
    public ArrayList<Book> ListSach;

    // Constructor
    public QuanLySach() {
        ListSach = new ArrayList<>();
    }

    // Doc du lieu tu file Books.txt
    @Override
    public void docFile() {
        ComicBook.resetCount();
        Novel.resetCount();
        ReferenceBook.resetCount();
        TextBook.resetCount();

        try (Scanner sc = new Scanner(new File("Books.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String id = parts[0].trim();
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    int quantity = Integer.parseInt(parts[4].trim());

                    Book book = null;

                    if (id.startsWith("RF")) {
                        book = new ReferenceBook(id, title, author, price, quantity);
                        ReferenceBook.updateCount(id);
                    } else if (id.startsWith("CM")) {
                        book = new ComicBook(id, title, author, price, quantity);
                        ComicBook.updateCount(id);
                    } else if (id.startsWith("NV")) {
                        book = new Novel(id, title, author, price, quantity);
                        Novel.updateCount(id);
                    } else if (id.startsWith("TB")) {
                        book = new TextBook(id, title, author, price, quantity);
                        TextBook.updateCount(id);
                    } else {
                        System.out.println("Ma sach khong hop le: " + id);
                    }

                    if (book != null) ListSach.add(book);
                } else {
                    System.out.println("Du lieu khong hop le: " + line);
                }
            }
            System.out.println("Doc file Books.txt thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    // Ghi du lieu vao file Books.txt
    @Override
    public void ghiFile() {
        try (FileWriter fw = new FileWriter("Books.txt")) {
            for (Book book : ListSach) {
                fw.write(
                        book.getId() + "," +
                                book.getTitle() + "," +
                                book.getAuthor() + "," +
                                book.getPrice() + "," +
                                book.getQuantity() + "\n"
                );
            }
            System.out.println("Ghi du lieu thanh cong vao file Books.txt");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    // Them sach
    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);

        String name;
        do {
            System.out.print("Nhap ten sach: ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Ten khong duoc de trong!");
            }
        } while (name.isEmpty());

        String author;
        do {
            System.out.print("Nhap ten tac gia: ");
            author = sc.nextLine().trim();
            if (author.isEmpty()) {
                System.out.println("Ten tac gia khong duoc de trong!");
            }
        } while (author.isEmpty());

        double price = 0;
        boolean validPrice = false;
        while (!validPrice) {
            System.out.print("Nhap gia sach: ");
            try {
                price = Double.parseDouble(sc.nextLine().trim());
                validPrice = true;
            } catch (NumberFormatException e) {
                System.out.println("Gia sach khong hop le! Vui long nhap lai");
            }
        }

        int quantity = 0;
        boolean validQuantity = false;
        while (!validQuantity) {
            System.out.print("Nhap so luong: ");
            try {
                quantity = Integer.parseInt(sc.nextLine().trim());
                validQuantity = true;
            } catch (NumberFormatException e) {
                System.out.println("So luong khong hop le! Vui long nhap lai");
            }
        }

        System.out.println("Chon the loai sach: ");
        System.out.println("1. Truyen tranh");
        System.out.println("2. Tieu thuyet");
        System.out.println("3. Sach giao khoa");
        System.out.println("4. Sach tham khao");
        System.out.print("Lua chon cua ban: ");
        int choice = Integer.parseInt(sc.nextLine().trim());

        Book newBook = null;

        switch (choice) {
            case 1:
                newBook = new ComicBook(name, author, price, quantity);
                break;
            case 2:
                newBook = new Novel(name, author, price, quantity);
                break;
            case 3:
                newBook = new TextBook(name, author, price, quantity);
                break;
            case 4:
                newBook = new ReferenceBook(name, author, price, quantity);
                break;
            default:
                System.out.println("The loai khong hop le!");
                return;
        }

        if (newBook != null) {
            ListSach.add(newBook);
            ghiFile();
            System.out.println("Da them sach moi voi ID: " + newBook.getId());
        }
    }

    // Sua thong tin sach
    @Override
    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ID sach can sua: ");
        String id = sc.nextLine().trim();

        boolean found = false;
        for (Book book : ListSach) {
            if (book.getId().equalsIgnoreCase(id)) {
                found = true;
                int choice;
                String decision;
                do {
                    System.out.println(".__________________________________________.");
                    System.out.println("|              Menu Sua Sach               |");
                    System.out.println("|__________________________________________|");
                    System.out.println("| 1. Sua ten sach                          |");
                    System.out.println("| 2. Sua ten tac gia                       |");
                    System.out.println("| 3. Sua gia                               |");
                    System.out.println("| 4. Sua so luong ton kho                  |");
                    System.out.println("| 5. Thoat                                 |");
                    System.out.println("|__________________________________________|");
                    System.out.print("Chon mot lua chon: ");

                    choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Nhap ten sach moi: ");
                            String newName = sc.nextLine().trim();
                            if (newName.isEmpty()) {
                                System.out.println("Ten khong duoc de trong!");
                                break;
                            }
                            System.out.println("Xac nhan doi tu " + book.getTitle() + " thanh " + newName);
                            System.out.print("An Y de xac nhan, N de huy: ");
                            decision = sc.nextLine().trim();
                            if (decision.equalsIgnoreCase("Y")) {
                                book.setTitle(newName);
                                ghiFile();
                                System.out.println("Sua ten sach thanh cong!");
                            } else System.out.println("Huy doi ten.");
                            break;

                        case 2:
                            System.out.print("Nhap ten tac gia moi: ");
                            String newAuthor = sc.nextLine().trim();
                            System.out.println("Xac nhan doi tu " + book.getAuthor() + " thanh " + newAuthor);
                            System.out.print("An Y de xac nhan, N de huy: ");
                            decision = sc.nextLine().trim();
                            if (decision.equalsIgnoreCase("Y")) {
                                book.setAuthor(newAuthor);
                                ghiFile();
                                System.out.println("Doi ten tac gia thanh cong!");
                            } else System.out.println("Huy doi ten tac gia.");
                            break;

                        case 3:
                            System.out.print("Nhap gia moi: ");
                            String priceStr = sc.nextLine().trim();
                            try {
                                double newPrice = Double.parseDouble(priceStr);
                                System.out.println("Xac nhan doi tu " + book.getPrice() + " thanh " + newPrice);
                                System.out.print("An Y de xac nhan, N de huy: ");
                                decision = sc.nextLine().trim();
                                if (decision.equalsIgnoreCase("Y")) {
                                    book.setPrice(newPrice);
                                    ghiFile();
                                    System.out.println("Sua gia thanh cong!");
                                } else System.out.println("Huy sua gia.");
                            } catch (NumberFormatException e) {
                                System.out.println("Gia khong hop le!");
                            }
                            break;

                        case 4:
                            System.out.print("Nhap so luong ton kho moi: ");
                            String quantityStr = sc.nextLine().trim();
                            try {
                                int newQuantity = Integer.parseInt(quantityStr);
                                System.out.println("Xac nhan doi tu " + book.getQuantity() + " thanh " + newQuantity);
                                System.out.print("An Y de xac nhan, N de huy: ");
                                decision = sc.nextLine().trim();
                                if (decision.equalsIgnoreCase("Y")) {
                                    book.setQuantity(newQuantity);
                                    ghiFile();
                                    System.out.println("Sua so luong thanh cong!");
                                } else System.out.println("Huy sua so luong.");
                            } catch (NumberFormatException e) {
                                System.out.println("So luong khong hop le!");
                            }
                            break;

                        case 5:
                            System.out.println("Tro ve menu chinh...");
                            return;

                        default:
                            System.out.println("Khong hop le! Chon lai.");
                    }
                } while (choice != 5);
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sach co ID: " + id);
        }
    }

    // Xoa sach
    @Override
    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id sach can xoa: ");
        String id = sc.nextLine().trim();

        boolean found = false;
        for (int i = 0; i < ListSach.size(); i++) {
            if (ListSach.get(i).getId().equalsIgnoreCase(id)) {
                found = true;
                System.out.print("Ban co chac muon xoa sach nay? (Y/N): ");
                String confirm = sc.nextLine().trim();
                if (confirm.equalsIgnoreCase("Y")) {
                    ListSach.remove(i);
                    System.out.println("Da xoa thanh cong sach co id: " + id);
                } else {
                    System.out.println("Huy xoa sach.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sach co id: " + id);
        }
        ghiFile();
    }

    // Tim kiem sach
    @Override
    public void timkiem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id sach de tim kiem: ");
        String id = sc.nextLine().trim();
        boolean found = false;
        for (Book book : ListSach) {
            if (book.getId().equalsIgnoreCase(id)) {
                book.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sach co id: " + id);
        }
    }

    public Book taoHoaDon(String id) {
        boolean found = false;
        for (Book book : ListSach) {
            if (book.getId().equalsIgnoreCase(id)) {
                System.out.println("Da tim thay sach co id: " + id);
                found = true;
                book.display();
                return book;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sach co id: " + id);
        }
        System.out.println("Danh sach sach:");
        hienDanhSach();
        return null;
    }

    // Hien danh sach
    @Override
    public void hienDanhSach() {
        System.out.println("================================================================================================================");
        System.out.printf("| %-8s | %-40s | %-20s | %-12s | %-10s |%n",
                "ID", "TEN SACH", "TAC GIA", "GIA", "SO LUONG");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        for (Book book : ListSach) {
            System.out.printf("| %-8s | %-40s | %-20s | %-12.2f | %-10d |%n",
                    book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getQuantity());
        }
        System.out.println("================================================================================================================");
    }

    // Dem hang ton
    public static void demHangTon(QuanLySach quanLySach, String bookType) {
        int total = 0;
        for (Book book : quanLySach.ListSach) {
            if (book.getId().startsWith(bookType)) {
                total++;
            }
        }
        System.out.println("So hang ton cua " + bookType + " la: " + total);
    }
}
