package QuanLySach;
public class Novel extends Book{

    private static int count = 0;

    public static void updateCount(String id )
    {
        try
        {
            int num = Integer.parseInt(id.substring(2));
            if ( num > count ) count = num;
        } catch (NumberFormatException e) {}
    }

    public Novel(String title, String author , double price, int quantity){
        super("NV" + String.format("%03d", ++count),title, author, price, quantity);
    }
    public Novel(String id, String title, String author , double price, int quantity){
        super(id, title, author, price, quantity);
    }

    public static void resetCount(){
        count = 0;
    }

    @Override
    public String getType(){
        return "TieuThuyet";
    }

    @Override
    public void display()
    {
        System.out.printf("| ID: %s | Title: %s | Author: %s | Price: %.2f | Quantity:  %d |\n",
                getId(), getTitle(), getAuthor(), getPrice(), getQuantity());
    }
}