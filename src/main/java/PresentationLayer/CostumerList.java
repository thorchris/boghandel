package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CostumerList extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ArrayList<User> customerList = UserMapper.getCustomerList();
        HttpSession session = request.getSession();
        int count = customerList.size();
        session.setAttribute("customerList", customerList);
        session.setAttribute("antalKunder", count );
        return "oversigt";
    }
}
