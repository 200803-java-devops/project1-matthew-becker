package net.robotap.controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.robotap.controller.GitHubSingleton;

@WebServlet(name="GitLoginAction", urlPatterns = "/gitlogin.do")
public class GitLoginAction extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("user");
        String pass = req.getParameter("pass");

        System.out.println("info from form: " + user + " " + pass);

        GitHubSingleton gitUser = GitHubSingleton.user();
        Boolean status = gitUser.login(user, pass);
        HttpSession session = req.getSession();
        
        if(status){
            session.setAttribute("user", user);
            // PagedIterable<GHRepository> repos = gitUser.listRepos();
            req.setAttribute("p", "dashboard");
            RequestDispatcher view = req.getRequestDispatcher("index.jsp");
            view.forward(req, resp);
        } else {
            req.setAttribute("p", "login");
            RequestDispatcher view = req.getRequestDispatcher("index.jsp");
            view.forward(req, resp);
        }
    }
}