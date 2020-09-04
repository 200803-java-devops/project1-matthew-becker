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

@WebServlet(name = "Signout", urlPatterns = { "/signout" })
public class Signout extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        GitHubSingleton gitUser = GitHubSingleton.user();
        String status = gitUser.logout();
        System.out.println(status);
        req.setAttribute("p", "loginForm");
        RequestDispatcher view = req.getRequestDispatcher("pages/index.jsp");
        view.forward(req, resp);
    }
}