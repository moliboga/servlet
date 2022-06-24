import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VoteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int age = Integer.parseInt(req.getParameter("page"));

        req.setAttribute("name", req.getParameter("pname"));
        req.setAttribute("common", getServletConfig().getInitParameter("commonTextColor"));
        req.setAttribute("error", getServletConfig().getInitParameter("errorTextColor"));
        req.setAttribute("welcome", getServletConfig().getInitParameter("welcomeTextColor"));
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
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
       doPost(req, res);
    }
}
