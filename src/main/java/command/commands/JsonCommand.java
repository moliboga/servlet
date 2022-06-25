package command.commands;

import com.google.gson.Gson;
import command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse res) throws IOException {
        List<String> stringList = new ArrayList<>();
        stringList.add("first string");
        stringList.add("second string");
        String employeeJsonString = new Gson().toJson(stringList);

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();
    }
}
