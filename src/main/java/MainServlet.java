import command.CommandExecutor;
import command.ICommand;
import command.IGetServletConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ICommand command = CommandExecutor.getByName(request.getParameter("command"));
        if (command instanceof IGetServletConfig)
            ((IGetServletConfig)command).setServletConfig(getServletConfig());
        command.execute(request, response);
    }
}
