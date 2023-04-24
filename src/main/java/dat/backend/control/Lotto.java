package dat.backend.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        String numberCount = request.getParameter("numberCount");
        if (numberCount != null && !numberCount.isEmpty()) {
            lottoCoupon.setNumberCount(Integer.parseInt(request.getParameter("numberCount")));
        }

        String numberIntervalMin = request.getParameter("numberIntervalMin");
        if (numberIntervalMin != null && !numberIntervalMin.isEmpty()) {
            lottoCoupon.setNumberIntervalMin(Integer.parseInt(request.getParameter("numberIntervalMin")));
        }

        String numberIntervalMax = request.getParameter("numberIntervalMax");
        if (numberIntervalMax != null && !numberIntervalMax.isEmpty()) {
            lottoCoupon.setNumberIntervalMax(Integer.parseInt(request.getParameter("numberIntervalMax")));
        }

        String ticketCount = request.getParameter("ticketCount");
        if (ticketCount != null && !ticketCount.isEmpty()) {
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

        public Map<Integer, List<Integer>> generateTickets() {
            Map<Integer, List<Integer>> tickets = new HashMap<>();
            for (int i = 1; i <= this.ticketCount; i++) {
                tickets.put(i, this.generateNumbers());
            }
            return tickets;
        }

        private List<Integer> generateNumbers() {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < this.numberCount; i++) {
                numbers.add((int) (Math.random() * (this.numberIntervalMax - this.numberIntervalMin + 1)) + this.numberIntervalMin);
            }
            return numbers;
        }
    }
}