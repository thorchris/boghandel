package PresentationLayer;

import DBAccess.DataMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class BookList extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        ArrayList bookList = DataMapper.getBookList();

        HttpSession session = request.getSession();

        session.setAttribute("booklist", bookList);

        return "customerpage";

    }
}
