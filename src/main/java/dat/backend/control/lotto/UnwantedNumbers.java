package dat.backend.control.lotto;

import dat.backend.model.entities.lotto.LottoCoupon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * The purpose of this whole servlet is to handle the user's unwanted numbers, that are to be excluded from the lottery generation
 *
 */

@WebServlet(name = "unwanted-numbers", value = "/unwanted-numbers")
public class UnwantedNumbers extends HttpServlet {


    /**
     * Incase the user regret a decision or accidentally typed the wrong number to exclude from the lottery,
     * this get-method will remove the number from the list of {@link LottoCoupon}'s unwanted numbers.
     *
     * @author Yusuf
     */

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

    /**
     * This post-method's purpose is to load in the {@link LottoCoupon}-object and add the unwanted numbers the user inputted on the prior page
     * to the unwanted numbers list. This list then will be loaded on the iframe on said page.
     * @author Yusuf
     */

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