package net.robotap.controller.servlets;

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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.PagedIterable;

import net.robotap.controller.GitHubSingleton;
import net.robotap.model.Repo;

@WebServlet(name="GetRepos", urlPatterns = { "/api/repos" })
public class GetRepos extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        GitHubSingleton gitUser = GitHubSingleton.user();
        // JsonNode result;
        String result;
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> reposObj = new ArrayList<>();
      
        
        //this is setting a session.user variable if user logs in successfully 
        if(session.getAttribute("user") != null){
            PagedIterable<GHRepository> repos = gitUser.listRepos();

            for (GHRepository repo : repos) {
                System.out.println(repo.getHttpTransportUrl());
                reposObj.add(repo.getHttpTransportUrl());
            }
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            result = objectMapper.writeValueAsString(reposObj);
        } else {
            String json = "{ \"error\":\"not signed in\"}";
            // result = objectMapper.readTree(json);
            result = json;
        }
        
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(result);
        out.flush();
    }
}