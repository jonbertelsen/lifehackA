package dat.backend.control.lotto;

import dat.backend.model.entities.lotto.LottoCoupon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "unwanted-numbers", value = "/unwanted-numbers")
public class UnwantedNumbers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if(request.getParameter("removeUnwantedNumber") == null) {
            return;
        }

        LottoCoupon lottoCoupon = (LottoCoupon) request.getSession().getAttribute("lottoCoupon");



        if (lottoCoupon == null) {
            lottoCoupon = new LottoCoupon();
        }

        int removeUnwantedNumber = Integer.parseInt(request.getParameter("removeUnwantedNumber"));

        lottoCoupon.removeUnwantedNumber(removeUnwantedNumber);

        request.getSession().setAttribute("lottoCoupon", lottoCoupon);
        request.getRequestDispatcher("lottoUnwantedNumbers.jsp").forward(request, response);



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
        request.getRequestDispatcher("lottoUnwantedNumbers.jsp").forward(request, response);
    }
}