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

@WebServlet(name = "MavenInstall", urlPatterns = { "/api/maveninstall" })
public class MavenInstall extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * API endpoint to start the process of maven packaging to generate the .jar file, will return JSON with status of completion or failure
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println(name);
        ObjectMapper objectMapper = new ObjectMapper();

        BashCommands commands = new BashCommands();
        BashResponse response = commands.runMavenInstall(name);

        String result = objectMapper.writeValueAsString(response);
        
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(200);
        out.print(result);
        out.flush();
    }
}