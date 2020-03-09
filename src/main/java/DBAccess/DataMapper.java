package DBAccess;

import FunctionLayer.Book;
import FunctionLayer.LoginSampleException;

import java.sql.*;
import java.util.ArrayList;

public class DataMapper {

    public static ArrayList<Book> getBookList() {
        ArrayList<Book> bookList = new ArrayList();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM boghandel.bøger";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                int qty = rs.getInt("qty");
                int id = rs.getInt("id");
                Book book = new Book(title,author,price,qty);
                book.setId(id);
                bookList.add(book);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return bookList;
    }

}



