import java.util.Scanner;
import java.time.LocalDate; // thu vien ngay


// lớp đối tượng 
class book{
    int bid; // book id
    String bname; // book name
    String genre; // thể loại
    int quantity; //số lượng
    int cost; // giá sách
}
class customer{
    int cusid; // id customer
    String cusname; // customer mame
}

class hoadon{
    int hdid; // bill id
    int bid;
    int buyQuantity; // số lượng sách mua
    int cusid;
    LocalDate payDate; // cach gán giá trị cho payDate = LocalDate.of(nam,thang,ngay);
    float totalPay; // số tiền trả
}


//main
public class library{
    public static void main(String[] args) {
        
    }
}


/*
                        _ooOoo_
                       o8888888o
                       88" . "88
                       (| -_- |)
                       O\  =  /O
                    ____/`---'\____
                  .'  \\|     |//  `.
                 /  \\|||  :  |||//  \
                /  _||||| -:- |||||_  \
                |   | \\\  -  /'| |   |
                | \_|  `\`---'//  |_/ |
                \  .-\__ `-. -'__/-.  /
              ___`. .'  /--.--\  `. .'___
           ."" '<  `.___\_<|>_/___.' _> \"".
          | | :  `- \`. ;`. _/; .'/ /  .' ; |
          \  \ `-.   \_\_`. _.'_/_/  -' _.' /
===========`-.`___`-.__\ \___  /__.-'_.'_.-'================
                        `=--=-'    
          ___  _   _   _      __  __  //\  _   _ 
         / _ \| | | | / \    |  \/  ||/_\|| \ | |
        | | | | | | |/ _ \   | |\/| |/ _ \|  \| |
        | |_| | |_| / ___ \  | |  | | |_| | |\  |
         \__\_\\___/_/   \_\ |_|  |_|\___/|_| \_|
*/
