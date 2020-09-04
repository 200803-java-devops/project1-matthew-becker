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
import net.robotap.model.Health;

@WebServlet(name = "GetHealth", urlPatterns = { "/api/health" })
public class GetHealth extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        BashCommands commands = new BashCommands();
        
        //run command to ls clietns directory
        BashResponse response = commands.getHealth("robo");

        //create entities 
        Health heathStat = new Health(response.getResponse());
        String result = objectMapper.writeValueAsString(response);
        PrintWriter out = resp.getWriter();

        //return 
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(200);
        out.print(result);
        out.flush();
    }
}