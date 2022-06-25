package command.commands;

import command.ICommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CityCommand implements ICommand {
    private String key = "a0b7ddc84eb9ea09371b738461cc2e0f";

    public String getJsonCity(String name) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=" + key;
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        return response.getBody();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String jsonString = "";

        String cityName = req.getParameter("cityName");

        jsonString = getJsonCity(cityName);

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(jsonString);
        out.flush();
    }
}
