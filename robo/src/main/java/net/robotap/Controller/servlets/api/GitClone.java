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

@WebServlet(name = "GetClone", urlPatterns = { "/api/clone" })
public class GitClone extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * API endpoint to git clone repo. will pass HTTPS url to git repo to start the process of cloning to client folder
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("url");
        System.out.println(url);
        ObjectMapper objectMapper = new ObjectMapper();
        BashCommands commands = new BashCommands();
        BashResponse response = commands.gitClone(url);
        String result = objectMapper.writeValueAsString(response);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(200);
        out.print(result);
        out.flush();
        
    }
}