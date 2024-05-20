package web.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.service.LoginService;

/**
 * HTTP end-point to handle login service.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {
        System.out.println("[LoginServlet] GET");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {
        System.out.println("[LoginServlet] POST");

        String username = req.getParameter("username");
        String password = req.getParameter("password");  // Ensure form field name is "password"
        String dob = req.getParameter("dob");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("DoB: " + dob);

        String loginStatus = "fail";

        LoginService loginService = new LoginService();
        if (loginService.login(username, password, dob)) {
            loginStatus = "success";
        }

        String htmlResponse = "<html>";
        htmlResponse += "<head><title>" + loginStatus + "</title></head>";
        htmlResponse += "<body><h2>Login status: " + loginStatus + "</h2></body>";
        htmlResponse += "</html>";

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(htmlResponse);
        writer.flush();
        writer.close();
    }
}
