package dat.backend.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "sodaintakeservlet", value = "/sodaintakeservlet")
public class SodaIntakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            double weeklyIntake = Double.parseDouble(request.getParameter("weeklyIntake"));
            double pricePerLiter = Double.parseDouble(request.getParameter("pricePerLiter"));

            if (weeklyIntake < 0 || pricePerLiter < 0) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Input must pe positive");
                return;
            }
            double dailyIntake = weeklyIntake / 7;
            double monthlyIntake = dailyIntake * 30;
            double yearlyIntake = dailyIntake * 365;

            double dailySaving10 = dailyIntake * 0.10 * pricePerLiter;
            double dailySaving20 = dailyIntake * 0.20 * pricePerLiter;
            double dailySaving50 = dailyIntake * 0.50 * pricePerLiter;
            double dailySaving100 = dailyIntake * 1.0 * pricePerLiter;

            double intakeReduction10 = weeklyIntake * 0.1 / 7;
            double intakeReduction20 = weeklyIntake * 0.2 / 7;
            double intakeReduction50 = weeklyIntake * 0.5 / 7;
            double intakeReduction100 = weeklyIntake / 7;

            request.setAttribute("dailyIntake", dailyIntake);
            request.setAttribute("weeklyIntake", weeklyIntake);
            request.setAttribute("monthlyIntake", monthlyIntake);
            request.setAttribute("yearlyIntake", yearlyIntake);

            request.setAttribute("dailySaving10", dailySaving10);
            request.setAttribute("dailySaving20", dailySaving20);
            request.setAttribute("dailySaving50", dailySaving50);
            request.setAttribute("dailySaving100", dailySaving100);

            request.setAttribute("intakeReduction10", intakeReduction10);
            request.setAttribute("intakeReduction20", intakeReduction20);
            request.setAttribute("intakeReduction50", intakeReduction50);
            request.setAttribute("intakeReduction100", intakeReduction100);

            RequestDispatcher dispatcher = request.getRequestDispatcher("sodaIntake.jsp");
            dispatcher.forward(request, response);

        } catch (NumberFormatException e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format");
        }
    }
}
