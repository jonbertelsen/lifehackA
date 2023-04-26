package dat.backend.control.lotto;

import dat.backend.model.entities.lotto.LottoCoupon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The purpose of this servlet is to handle the {@link LottoCoupon}.
 * @author Peter
 */
@WebServlet(name = "lotto", urlPatterns = {"/lotto"})
public class Lotto extends HttpServlet {

    /**
     * The purpose of this method is to redirect to the lotto.jsp page.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("lotto.jsp");
    }

    /**
     * The purpose of this method is to generate a lotto coupon and redirect to the lotto.jsp page.
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LottoCoupon lottoCoupon = (LottoCoupon) request.getSession().getAttribute("lottoCoupon");
        if (lottoCoupon == null) {
            lottoCoupon = new LottoCoupon();
        }

        String numberCount = request.getParameter("numberCount");
        if (numberCount != null && !numberCount.isEmpty()) {
            lottoCoupon.setNumberCount(Integer.parseInt(numberCount));
        }

        String numberIntervalMin = request.getParameter("numberIntervalMin");
        if (numberIntervalMin != null && !numberIntervalMin.isEmpty()) {
            lottoCoupon.setNumberIntervalMin(Integer.parseInt(numberIntervalMin));
        }

        String numberIntervalMax = request.getParameter("numberIntervalMax");
        if (numberIntervalMax != null && !numberIntervalMax.isEmpty()) {
            lottoCoupon.setNumberIntervalMax(Integer.parseInt(numberIntervalMax));
        }

        String ticketCount = request.getParameter("ticketCount");
        if (ticketCount != null && !ticketCount.isEmpty()) {
            lottoCoupon.setTicketCount(Integer.parseInt(ticketCount));
        }

        if (lottoCoupon.getNumberIntervalMin() > lottoCoupon.getNumberIntervalMax()) {
            request.setAttribute("error", "Minimum number must be smaller than maximum number");
        }

        request.getSession().setAttribute("lottoCoupon", lottoCoupon);
        request.getRequestDispatcher("lotto.jsp").forward(request, response);
    }
}