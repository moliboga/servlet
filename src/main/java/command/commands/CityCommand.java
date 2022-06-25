package command.commands;

import command.Command;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CityCommand implements Command {
    private static final String key = "&appid=a0b7ddc84eb9ea09371b738461cc2e0f";
    private static final String urlPart = "https://api.openweathermap.org/data/2.5/weather?q=";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect( urlPart + req.getParameter("name") + key);
    }
}
