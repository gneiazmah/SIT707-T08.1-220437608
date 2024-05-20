package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import web.handler.LoginServlet;
import web.handler.RegistrationServlet;
import web.handler.WelcomeServlet;

/**
 * HTTP server. Starts server and registers Java Servlets to URL routes.
 */
public class MyServer {

    private static int PORT = 8082;

    public void start() throws Exception {
        // HTTP server listening on port 8082.
        Server server = new Server(PORT);

        // URL routing/mapping handler
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        handler.setResourceBase("src/main/resources/webapp"); // Serve static files from this directory
        handler.addServlet(DefaultServlet.class, "/");

        // Register /login URL path to end-point LoginServlet.
        handler.addServlet(WelcomeServlet.class, "/");

        // Register /login URL path to end-point LoginServlet.
        handler.addServlet(LoginServlet.class, "/login");

        // Register /reg URL path to end-point RegistrationServlet.
        handler.addServlet(RegistrationServlet.class, "/reg");

        System.out.println("Server started!");
        server.setHandler(handler);
        server.start();
        server.join();
    }

    public static void main(String[] args) throws Exception {
        new MyServer().start();
    }
}
