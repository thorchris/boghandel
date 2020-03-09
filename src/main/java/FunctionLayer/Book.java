package FunctionLayer;


public class Book{
    private int id;
    private final String title;
    private final String author;
    private double price;
    private int qty;

    public Book(String title, String author, double price, int qty) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setId (int id) {this.id = id;}

    @Override
    public String toString() {
        return title + " Forfatter: " + author + " Pris: " + price + " Antal på lager: " + qty;
    }


}