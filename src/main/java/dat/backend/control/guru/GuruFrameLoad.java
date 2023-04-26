package dat.backend.control.guru;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "guruframeload", urlPatterns = {"/guruframeload"} )
public class GuruFrameLoad extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        try {
            request.getRequestDispatcher("WEB-INF/guru/guruframe.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
