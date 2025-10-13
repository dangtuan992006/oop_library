package QuanLySach;
public abstract class Book {
    protected String id, title, author;
    protected double price;
    protected int quantity;
    protected static int count = 0;

    public Book(String title, String author, double price, int quantity) {
        this.id = "BK" + String.format("%03d", ++count);
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public Book(String id, String title, String author, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        try {
            int num = Integer.parseInt(id.substring(2));
            if (num > count) count = num;
        } catch (Exception e) {}
    }

    //GET
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    //SET
    public void setID(String id) { this.id = id; }
    public void setTitle(String tilte) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPrice(double price ) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public abstract String getType(); // trả về loại sách

    public void display() {
        System.out.printf("%-8s %-20s %-20s %-10.2f %-5d %-15s%n",
                id, title, author, price, quantity, getType());
    }
}
