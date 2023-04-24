package dat.backend.control;

import dat.backend.model.entities.BMICalculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.io.IOException;

@WebServlet(name = "ServletBmiCalculate", value = "/ServletBmiCalculate")
public class ServletBmiCalculate extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            double height = Double.parseDouble(request.getParameter("height"));
            double weight = Double.parseDouble(request.getParameter("weight"));

            BMICalculator bmiCalculator = new BMICalculator();
            double BMI = bmiCalculator.calculateBMI(weight, height);

            // Create a new Label object and set its text to the calculated BMI value
            Label bmiLabel = new Label();
            bmiLabel.setText("Your BMI is: " + BMI);

            // Set the bmiLabel as an attribute of the request object
            request.setAttribute("bmiLabel", bmiLabel);

            request.getRequestDispatcher("bmiCalculator.jsp").forward(request, response);
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
