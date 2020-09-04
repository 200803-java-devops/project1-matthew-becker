package net.robotap.controller.servlets.api;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.robotap.controller.BashCommands;
import net.robotap.model.BashResponse;

@WebServlet(name = "Build", urlPatterns = { "/api/build" })
public class BuildImage extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String project = req.getParameter("project");
        System.out.println(project);
        ObjectMapper objectMapper = new ObjectMapper();

        BashCommands commands = new BashCommands();
        BashResponse response = commands.build(project);

        String result = objectMapper.writeValueAsString(response);
        
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(200);
        out.print(result);
        out.flush();
    }
}