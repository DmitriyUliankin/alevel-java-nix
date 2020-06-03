package jeebox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "servlet", urlPatterns = "/get-ip")
public class Servlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(Servlet.class);

    @Override
    public void init() {
        log.info("servlet initialization complete");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ConcurrentHashMap<String, String> remotes = new ConcurrentHashMap<>();
        PrintWriter responseBody = resp.getWriter();
        String header = "User-Agent";
        remotes.put(req.getRemoteHost(), req.getHeader(header));
        resp.setContentType("text/html");
        responseBody.println("<h1 align=\"center\">Here is info about users below: </h1>");
        responseBody.println("<h2 align=\"center\"> List:" + " </h2>");
        responseBody.println(remotes.entrySet());
    }

    @Override
    public void destroy() {
        log.info("destroying servlet complete");
    }

}
