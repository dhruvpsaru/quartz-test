package servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dhruv on 21/3/17.
 */




@WebServlet(
        name = "AnnotatedServlet",
        description = "A sample annotated servlet",
        urlPatterns = {"/test"}
)
public class AppServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("------------------------in servlet-------------------");

        PrintWriter writer = resp.getWriter();
        writer.println("<html>Hello, I am a Java servlet!</html>");
        writer.flush();
    }
}
