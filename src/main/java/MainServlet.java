import command.CommandExecutor;
import command.Command;
import command.GetServletConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestUri = request.getRequestURI();
        String commandStr = requestUri.substring(requestUri.lastIndexOf('/')+1);
        Command command = CommandExecutor.getByName(commandStr);
        if (command instanceof GetServletConfig)
            ((GetServletConfig)command).setServletConfig(getServletConfig());
        command.execute(request, response);
    }
}
