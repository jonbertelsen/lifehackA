package dat.backend.control.lotto;

import dat.backend.model.entities.LottoCoupon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "unwantedServlet", value = "/unwantedServlet")
public class unwantedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LottoCoupon lottoCoupon = (LottoCoupon) request.getSession().getAttribute("lottoCoupon");
        if (lottoCoupon == null) {
            lottoCoupon = new LottoCoupon();
        }

        int unwantedNumber = Integer.parseInt(request.getParameter("unwantedNumbers"));
        lottoCoupon.addUnwantedNumber(unwantedNumber);




        request.getSession().setAttribute("lottoCoupon", lottoCoupon);
        request.getRequestDispatcher("unwantedNumbers.jsp").forward(request, response);


    }
}
