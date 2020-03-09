package PresentationLayer;

import DBAccess.DataMapper;
import FunctionLayer.Book;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class SearchBook extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        ArrayList<Book> bookList = LogicFacade.bookList();
        ArrayList<String> newBookList = new ArrayList();
        String title = request.getParameter("title").toLowerCase();
        CharSequence seq = title;

        HttpSession session =request.getSession();

        for (Book book : bookList) {
            if(book.getTitle().toLowerCase().contains(seq)) {
                String foundBook = book.toString();
                newBookList.add(foundBook);
                session.setAttribute("newBookList", newBookList);
            }
        }

        return "searchpage";

    }

}
