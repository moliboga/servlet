package command.commands;

import command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SexCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String age = req.getParameter("18");
        String agreement = req.getParameter("sexAddiction");

        if (age == null || agreement == null){
            res.sendRedirect(req.getContextPath() + "/noSex.jsp");
        }
        else {
            res.sendRedirect(req.getContextPath() + "/yesSex.jsp");
        }
    }
}
