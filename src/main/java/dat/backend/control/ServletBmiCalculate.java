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
            int height = Integer.parseInt((request.getParameter("height")));
            int weight = Integer.parseInt((request.getParameter("weight")));

            BMICalculator bmiCalculator = new BMICalculator();
            int BMI = bmiCalculator.calculateBMI(weight, height);

            // Create a new Label object and set its text to the calculated BMI value
            Label bmiLabel = new Label();
            Label bmAssessment = new Label();
            bmiLabel.setText("Your BMI is: " + BMI);
            if(BMI<18.5) {
                bmAssessment.setText("According to your BMI, you might be underweight.");
            }
            if(BMI<24.9) {
                bmAssessment.setText("According to your BMI, you might be a normal weight.");
            }
            if(BMI<29.9) {
                bmAssessment.setText("According to your BMI, you might be overweight.");
            }
            if(BMI<34.9) {
                bmAssessment.setText("According to your BMI, you might be obese.");
            }
            if(BMI>35) {
                bmAssessment.setText("According to your BMI, you might be morbidly/extremely obese.");
            }
            // Set the bmiLabel as an attribute of the request object
            request.setAttribute("bmiLabel", bmiLabel);
            request.setAttribute("bmiAssessment", bmAssessment);

            request.getRequestDispatcher("bmiCalculator.jsp").forward(request, response);
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
