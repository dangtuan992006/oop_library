package QuanLySach;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySach implements Action {
    public ArrayList<Book> ListSach;

    // ✅ Constructor
    public QuanLySach() {
        ListSach = new ArrayList<>();
    }

    // ✅ Đọc dữ liệu từ file Books.txt
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
                    } else if (id.startsWith("CM")) {
                        book = new ComicBook(id, title, author, price, quantity);
                    } else if (id.startsWith("NV")) {
                        book = new Novel(id, title, author, price, quantity);
                    } else if (id.startsWith("TB")) {
                        book = new TextBook(id, title, author, price, quantity);
                    } else {
                        System.out.println("⚠️ Mã sách không hợp lệ: " + id);
                    }

                    if (book != null) ListSach.add(book);
                } else {
                    System.out.println("⚠️ Dữ liệu không hợp lệ: " + line);
                }
            }
            System.out.println("✅ Đọc file Books.txt thành công!");
        } catch (IOException e) {
            System.out.println("❌ Lỗi khi đọc file: " + e.getMessage());
        }
    }

    // ✅ Ghi dữ liệu vào file Books.txt
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
            System.out.println("✅ Ghi dữ liệu thành công vào Books.txt!");
        } catch (IOException e) {
            System.out.println("❌ Lỗi khi ghi file: " + e.getMessage());
        }
    }

    // ✅ Thêm sách
    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);

        String name;
        do {
            System.out.print("Nhập tên sách: ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Tên không được để trống!");
            }
        } while (name.isEmpty());

        double price = 0;
        boolean validPrice = false;
        while (!validPrice) {
            System.out.print("Nhập giá sách: ");
            try {
                price = Double.parseDouble(sc.nextLine().trim());
                validPrice = true;
            } catch (NumberFormatException e) {
                System.out.println("Giá sách không hợp lệ! Vui lòng nhập lại.");
            }
        }

        String author;
        do {
            System.out.print("Nhập tên tác giả: ");
            author = sc.nextLine().trim();
            if (author.isEmpty()) {
                System.out.println("Tên tác giả không được để trống!");
            }
        } while (author.isEmpty());

        int quantity = 0;
        boolean validQuantity = false;
        while (!validQuantity) {
            System.out.print("Nhập số lượng: ");
            try {
                quantity = Integer.parseInt(sc.nextLine().trim());
                validQuantity = true;
            } catch (NumberFormatException e) {
                System.out.println("Số lượng không hợp lệ! Vui lòng nhập lại.");
            }
        }

        System.out.println("Chọn thể loại sách: ");
        System.out.println("1. Truyện tranh");
        System.out.println("2. Tiểu thuyết");
        System.out.println("3. Sách giáo khoa");
        System.out.println("4. Sách tham khảo");
        System.out.print("Lựa chọn của bạn: ");
        int choice = Integer.parseInt(sc.nextLine().trim());

        Book newBook =
                null;

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
                System.out.println("❌ Thể loại không hợp lệ!");
                return;
        }

        if (newBook != null) {
            ListSach.add(newBook);
            ghiFile();
            System.out.println("✅ Đã thêm sách mới với ID: " + newBook.getId());
        }
    }

    // ✅ Sửa thông tin sách
    @Override
    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID sách cần sửa: ");
        String id = sc.nextLine().trim();

        boolean found = false;
        for (Book book : ListSach) {
            if (book.getId().equalsIgnoreCase(id)) {
                found = true;

                System.out.print("Nhập tên sách mới (bỏ trống để giữ nguyên): ");
                String newName = sc.nextLine().trim();
                if (!newName.isEmpty()) book.setTitle(newName);

                System.out.print("Nhập giá mới (bỏ trống để giữ nguyên): ");
                String newPriceStr = sc.nextLine().trim();
                if (!newPriceStr.isEmpty()) {
                    try {
                        double newPrice = Double.parseDouble(newPriceStr);
                        book.setPrice(newPrice);
                    } catch (NumberFormatException e) {
                        System.out.println("Giá không hợp lệ, giữ nguyên giá cũ.");
                    }
                }

                System.out.print("Nhập tên tác giả mới (bỏ trống để giữ nguyên): ");
                String newAuthor = sc.nextLine().trim();
                if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);

                System.out.print("Nhập số lượng mới (bỏ trống để giữ nguyên): ");
                String newQuantityStr = sc.nextLine().trim();
                if (!newQuantityStr.isEmpty()) {
                    try {
                        int newQuantity = Integer.parseInt(newQuantityStr);
                        book.setQuantity(newQuantity);
                    } catch (NumberFormatException e) {
                        System.out.println("Số lượng không hợp lệ, giữ nguyên.");
                    }
                }

                ghiFile();
                System.out.println("✅ Đã sửa thông tin sách có ID: " + id);
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Không tìm thấy sách có ID: " + id);
        }
    }

    //XÓA SÁCH
    @Override
    public void xoa()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập id sách cần xóa: ");
        String id = sc.nextLine().trim();

        boolean found = false;
        for ( int i = 0 ; i < ListSach.size() ; i++)
        {
            if ( ListSach.get(i).getId().equalsIgnoreCase(id))
            {
                ListSach.remove(i);
                found = true;
                System.out.println("Đã xóa thành công sách có id: " + id + " thành công ");
                break;
            }
        }
        if (!found)
        {
            System.out.println("Không tìm thấy sách có id tương tự: " + id );
        }
        ghiFile();
    }

    //TỈM KIẾM SÁCH
    @Override
    public void timkiem()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập id sách để tìm kiếm ");
        String id = sc.nextLine().trim();
        boolean found = false;
        for ( Book book : ListSach )
        {
            if ( book.getId().equalsIgnoreCase(id))
            {
                book.display();
                found = true;
                break;
            }
        }
        if (!found)
        {
            System.out.println("Không tìm thấy sách có id tương tự: " + id);
        }
    }

    public Book taoHoaDon(String id)
    {
        boolean found = false;
        for ( Book book : ListSach )
        {
            if ( book.getId().equalsIgnoreCase(id))
            {
                System.out.println("Đã tìm thấy sách có id tương tự: " + id );
                found = true;
                book.display();
                return book;
            }
        }
        if (!found)
        {
            System.out.println("Không tìm thấy sách có id tương tự: " + id);
        }
        System.out.println("Danh sách sách: ");
        hienDanhSach();
        return null;
    }

    //HIỆN DANH SÁCH
    @Override
    public void hienDanhSach()
    {
        System.out.println("================================================================================================================");
        System.out.printf("| %-8s | %-40s | %-20s | %-12s | %-10s |%n",
                "ID", "TEN SACH", "TAC GIA", "GIA", "SO LUONG");
        System.out.println("--------------------------------------------------------    --------------------------------------------------------");
        for (Book book : ListSach) {
            System.out.printf("| %-8s | %-40s | %-20s | %-12.2f | %-10d |%n",
                    book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getQuantity());
        }
        System.out.println("================================================================================================================");
    }

    //ĐẾM HÀNG TỒN
    public static void demHangTon(QuanLySach quanLySach, String bookType)
    {
        int total = 0;
        for ( Book book : quanLySach.ListSach)
        {
            if ( book.getId().startsWith(bookType))
            {
                total++;
            }
        }
        System.out.println("Số hàng tồn của: " + bookType + " là: " + total);
    }
}
