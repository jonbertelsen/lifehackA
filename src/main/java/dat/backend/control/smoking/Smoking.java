package dat.backend.control.smoking;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "smoking", value = "/smoking")
public class Smoking extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("smokingCessation.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reduction = 0;
        int amount = Integer.parseInt(request.getParameter("amount"));
        double price = Double.parseDouble(request.getParameter("price"));
        reduction = Integer.parseInt(request.getParameter("reduction"));
        System.out.println(reduction);
        if (amount < 1 || price < 1){
            request.setAttribute("invalidInput", "Please only use valid numbers.");
            request.getRequestDispatcher("smokingCessation.jsp").forward(request, response);
        }
        request.setAttribute("percentage", reduction);
        request.setAttribute("amountOfCig", amount);
        request.setAttribute("reducedAmountOfCig", calculatedCigarettes(reduction, amount));

        request.setAttribute("dailySavings", String.format("%.02f", calculatePerDay(amount, price)));
        request.setAttribute("monthlySavings", String.format("%.02f", calculatePerMonth(amount, price)));
        request.setAttribute("yearlySavings", String.format("%.02f", calculatePerYear(amount, price)));

        request.setAttribute("dailyPercentage", String.format("%.02f", calculatePercentagePerDay(reduction, amount, price)));
        request.setAttribute("monthlyPercentage", String.format("%.02f", calculatePercentagePerMonth(reduction, amount, price)));
        request.setAttribute("yearlyPercentage", String.format("%.02f", calculatePercentagePerYear(reduction, amount, price)));


        request.getRequestDispatcher("smokingCessation.jsp").forward(request, response);

    }



    public double calculatePerDay(int amount, double price){
        //assuming there are 20 cigarettes in a pack.
        return (amount/20.0)*price;
    }

    public double calculatePerMonth(int amount, double price){
        return calculatePerDay(amount, price) * 30;
    }

    public double calculatePerYear(int amount, double price){
        return calculatePerDay(amount, price) * 365;
    }

    public double calculatePercentagePerDay(double percentage, int amount, double price){
        double dailySavings = calculatePerDay(amount, price);
        double percentageCalc = percentage/100;
        return dailySavings * percentageCalc;
    }
    public double calculatePercentagePerMonth(double percentage, int amount, double price){
        double monthlySavings = calculatePerMonth(amount, price);
        double percentageCalc = percentage/100;
        return monthlySavings * percentageCalc;
    }
    public double calculatePercentagePerYear(double percentage, int amount, double price){
        double yearlySavings = calculatePerYear(amount, price);
        double percentageCalc = percentage/100;
        return yearlySavings * percentageCalc;
    }

    public int calculatedCigarettes(double percentage, int amount){
        return (int) (amount*(100-percentage)/100);
    }

}
