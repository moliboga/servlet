import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CityServlet extends HttpServlet {

    private String key = "a0b7ddc84eb9ea09371b738461cc2e0f";

    public Double getTemp(String name) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=" + key;
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        String kelvins = (new JSONObject((new JSONObject(response.getBody())).get("main").toString())).get("temp").toString();
        return Math.ceil(Double.parseDouble(kelvins) - 273.15);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String jsonString = "";

        String cityName = req.getParameter("cityName");
        Double temp = getTemp(cityName);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(cityName, temp);

        jsonString = jsonObject.toString();

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(jsonString);
        out.flush();
    }
}
