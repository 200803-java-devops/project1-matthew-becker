package net.robotap.controller.servlets.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.robotap.controller.BashCommands;
import net.robotap.model.BashResponse;
import net.robotap.model.Projects;

@WebServlet(name = "GetProjects", urlPatterns = { "/api/projects" })
public class GetProjects extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        BashCommands commands = new BashCommands();
        
        //run command to ls clietns directory
        BashResponse response = commands.getClientProjects();

        //create entities 
        List<Projects> projects = cleanString(response.getResponse());
        String result = objectMapper.writeValueAsString(projects);
        PrintWriter out = resp.getWriter();

        //return 
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(200);
        out.print(result);
        out.flush();
    }

    private List<Projects> cleanString(String input) {
        List<Projects> projects = new ArrayList<>();
        String lines[] = input.split("\\r?\\n");
        for (String name : lines) {
            if(!(name.equals("Dockerfile") || name.equals("entrypoint.sh") || name.equals("start.sh"))){
                Projects project = new Projects(name);
                projects.add(project);
            }
        }
        return projects;
    }
}
