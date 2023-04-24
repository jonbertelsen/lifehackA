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
        LottoCouponInformation information = (LottoCouponInformation) request.getAttribute("lottoCoupon");
        if (information == null) {
            information = new LottoCouponInformation();
        }

        if (request.getParameter("numberCount") != null) {
            information.setNumberCount(Integer.parseInt(request.getParameter("numberCount")));
        }

        if (request.getParameter("numberIntervalMin") != null) {
            information.setNumberIntervalMin(Integer.parseInt(request.getParameter("numberIntervalMin")));
        }

        if (request.getParameter("numberIntervalMax") != null) {
            information.setNumberIntervalMax(Integer.parseInt(request.getParameter("numberIntervalMax")));
        }

        if (request.getParameter("ticketCount") != null) {
            information.setTicketCount(Integer.parseInt(request.getParameter("ticketCount")));
        }

        if (information.getNumberIntervalMin() > information.getNumberIntervalMax()) {
            request.setAttribute("error", "Minimum number must be smaller than maximum number");
        }

        request.setAttribute("lottoCoupon", information);
        request.getRequestDispatcher("lotto.jsp").forward(request, response);
    }

    public static class LottoCouponInformation {

        private int numberCount = 7;
        private int numberIntervalMin = 1;
        private int numberIntervalMax = 36;
        private int ticketCount = 10;

        public LottoCouponInformation() { }

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