package dat.backend.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "lotto", urlPatterns = {"/lotto"})
public class Lotto extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("lotto.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LottoCoupon lottoCoupon = (LottoCoupon) request.getAttribute("lottoCoupon");
        if (lottoCoupon == null) {
            lottoCoupon = new LottoCoupon();
        }

        if (request.getParameter("numberCount") != null) {
            lottoCoupon.setNumberCount(Integer.parseInt(request.getParameter("numberCount")));
        }

        if (request.getParameter("numberIntervalMin") != null) {
            lottoCoupon.setNumberIntervalMin(Integer.parseInt(request.getParameter("numberIntervalMin")));
        }

        if (request.getParameter("numberIntervalMax") != null) {
            lottoCoupon.setNumberIntervalMax(Integer.parseInt(request.getParameter("numberIntervalMax")));
        }

        if (request.getParameter("ticketCount") != null) {
            lottoCoupon.setTicketCount(Integer.parseInt(request.getParameter("ticketCount")));
        }

        if (lottoCoupon.getNumberIntervalMin() > lottoCoupon.getNumberIntervalMax()) {
            request.setAttribute("error", "Minimum number must be smaller than maximum number");
        }

        request.setAttribute("lottoCoupon", lottoCoupon);
        request.getRequestDispatcher("lotto.jsp").forward(request, response);
    }

    public static class LottoCoupon {

        private int numberCount = 7;
        private int numberIntervalMin = 1;
        private int numberIntervalMax = 36;
        private int ticketCount = 10;

        public LottoCoupon() { }

        public int getNumberCount() {
            return this.numberCount;
        }

        public void setNumberCount(int numberCount) {
            this.numberCount = numberCount;
        }

        public int getNumberIntervalMin() {
            return this.numberIntervalMin;
        }

        public void setNumberIntervalMin(int numberIntervalMin) {
            this.numberIntervalMin = numberIntervalMin;
        }

        public int getNumberIntervalMax() {
            return this.numberIntervalMax;
        }

        public void setNumberIntervalMax(int numberIntervalMax) {
            this.numberIntervalMax = numberIntervalMax;
        }

        public int getTicketCount() {
            return this.ticketCount;
        }

        public void setTicketCount(int ticketCount) {
            this.ticketCount = ticketCount;
        }

        public int[][] generateTickets() {
            int[][] tickets = new int[this.ticketCount][this.numberCount];
            for (int i = 0; i < this.ticketCount; i++) {
                for (int j = 0; j < this.numberCount; j++) {
                    tickets[i][j] = (int) (Math.random() * (this.numberIntervalMax - this.numberIntervalMin + 1)) + this.numberIntervalMin;
                }
            }
            return tickets;
        }
    }
}