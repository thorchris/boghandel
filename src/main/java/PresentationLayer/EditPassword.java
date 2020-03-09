package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditPassword extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        LogicFacade.EditPassword(request.getParameter("email"), request.getParameter("password"));
        new CostumerList().execute(request, response);
        return "oversigt";
    }
}
