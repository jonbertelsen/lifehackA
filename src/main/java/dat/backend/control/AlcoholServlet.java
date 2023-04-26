package dat.backend.control;

import dat.backend.model.entities.AlcoholCalculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AlcoholServlet", value = "/alcoholservlet")
public class AlcoholServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    /**
     * The doPost method is called when the user submits the form.
     * The method gets the values/parameters (gender, weight, units, hours, minutes, time) from the form in alcoholCalculator.jsp.
     * The method then creates a new AlcoholCalculator object and calls the balCalc method.
     * The balCalc method returns a float value which is then set as an attribute in the request.
     * The method then forwards the request to the alcoholCalculator.jsp page.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String gender;
        float weight;
        float units;
        float hours;
        float minutes;
        float time;

        try {
            gender = request.getParameter("gender");
            weight = Float.parseFloat(request.getParameter("weight"));
            units = Float.parseFloat(request.getParameter("units"));
            hours = Integer.parseInt(request.getParameter("hours"));
            minutes = Integer.parseInt(request.getParameter("minutes"));
            time = hours + (minutes / 60);

            AlcoholCalculator calculator = new AlcoholCalculator();
            float bal = calculator.balCalc(weight, gender, time, units);
            if(bal < 0)
            {
                bal = 0;
            }
            if(bal > 0.5)
            {
                request.setAttribute("worningMsg", "Din promille er over den lovlige alkoholgrænse for bilkørsel (0,5)");
            }

            request.setAttribute("bal", bal);
            request.getRequestDispatcher("alcoholCalculator.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("msg", "Please input all values");
            request.getRequestDispatcher("alcoholCalculator.jsp").forward(request, response);
        }
    }
}
