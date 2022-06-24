import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // set content type
        res.setContentType("text/html");

        // get PrintWriter object
        PrintWriter pw = res.getWriter();

        // get form data (from req parameter)
        String name = req.getParameter("pname");
        int age = Integer.parseInt(req.getParameter("page"));

        // check age
        pw.println("<h1 style='text-align: center; color:"
                + getServletConfig().getInitParameter("commonTextColor")
                +"'>"
                + "Hello "+ name + "</h1>");
        if(age < 18) {
            pw.println("<h2 style='text-align: center; color:"
                    + getServletConfig().getInitParameter("errorTextColor") +
                    "'>"
                    +"You are not eligible for voting.</h2>"
                    +"<h3 style='text-align: center; color:"
                    + getServletConfig().getInitParameter("commonTextColor")
                    +"'>"
                    +"Please wait for more " + (18-age) + " years.<br>"
                    +" Thank You.<h3>"
            );
        } else  {
            pw.println("<h2 style='text-align: center; color:"
                    + getServletConfig().getInitParameter("welcomeTextColor")
                    +"'>"
                    +"You are eligible for voting.</h2>"
                    +"<h3 style='text-align: center; color: "
                    + getServletConfig().getInitParameter("commonTextColor")
                    +"'>"
                    +"Thank You.<h3>"
            );
        }

        // close stream
        pw.close();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // call doPost() method
        doPost(req, res);
    }
}
