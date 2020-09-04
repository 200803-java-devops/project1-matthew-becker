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
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.PagedIterable;

import net.robotap.controller.GitHubSingleton;
import net.robotap.model.Repo;

@WebServlet(name="GetRepos", urlPatterns = { "/api/repos" })
public class GetRepos extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * API endpoint to get all signed in users github repos, will return array of JSON objects 
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        GitHubSingleton gitUser = GitHubSingleton.user();
        String result; // JsonNode result;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Repo> reposEntitys = new ArrayList<>();
        
        //checking if user is signed in then getting all github repos then respoding with JSON
        if(session.getAttribute("user") != null){
            PagedIterable<GHRepository> repos = gitUser.listRepos();
            for (GHRepository repo : repos) {
                Repo repoEntity = new Repo(repo.getHttpTransportUrl(), repo.getOwnerName(), repo.getNodeId());
                reposEntitys.add(repoEntity);
            }
            result = objectMapper.writeValueAsString(reposEntitys);
        } else {
            String json = "{ \"error\":\"not signed in\"}";
            result = json;
        }
        
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(200);
        out.print(result);
        out.flush();
    }
}