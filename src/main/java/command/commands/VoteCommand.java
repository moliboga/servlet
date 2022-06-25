package command.commands;

import command.ICommand;
import command.IGetServletConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VoteCommand implements ICommand, IGetServletConfig {
    private ServletConfig config;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int age = Integer.parseInt(req.getParameter("page"));

        req.setAttribute("name", req.getParameter("pname"));
        req.setAttribute("common", config.getInitParameter("commonTextColor"));
        req.setAttribute("error", config.getInitParameter("errorTextColor"));
        req.setAttribute("welcome", config.getInitParameter("welcomeTextColor"));
        req.setAttribute("yearsTo18", 18 - age);

        RequestDispatcher requestDispatcher;

        if (age < 18){
            requestDispatcher = req.getRequestDispatcher("voteCheckerBad.jsp");
        } else {
            requestDispatcher = req.getRequestDispatcher("voteCheckerGood.jsp");
        }

        requestDispatcher.forward(req, res);
    }

    @Override
    public void setServletConfig(ServletConfig config) {
        this.config = config;
    }
}
