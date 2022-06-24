import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String age = req.getParameter("18");
        String agreement = req.getParameter("sexAddiction");

        RequestDispatcher requestDispatcher;

        if (age == null || agreement == null){
            requestDispatcher = req.getRequestDispatcher("NoSex.jsp");
        } else {
            requestDispatcher = req.getRequestDispatcher("YesSex.jsp");
        }

        requestDispatcher.forward(req, res);
    }
}