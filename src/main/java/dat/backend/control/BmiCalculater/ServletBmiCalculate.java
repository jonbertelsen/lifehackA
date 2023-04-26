package dat.backend.control.BmiCalculater;

import dat.backend.model.entities.BMICalculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.io.IOException;

@WebServlet(name = "servletBmiCalculate", value = "/servletBmiCalculate")
/**
 *Purpose when user has made input and presses submit, it takes the inputs and calculates BMI and then sends the user back to the jsp page with the BMI displayed.
 * User is users
 */
public class ServletBmiCalculate extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double height = Double.parseDouble((request.getParameter("height")));
        double weight = Double.parseDouble((request.getParameter("weight")));


        BMICalculator bmiCalculator = new BMICalculator();
        double BMI = bmiCalculator.calculateBMI(weight, height);

        // Create a new Label object and set its text to the calculated BMI value
        Label bmiLabel = new Label();
        Label bmAssessment = new Label();

        bmiLabel.setText(String.format("Your BMI is: %.2f",  BMI));

        if(BMI < 18.5) {
            bmAssessment.setText("According to your BMI, you might be underweight.");
        } else if(BMI >= 18.5 && BMI <= 24.9 ) {
            bmAssessment.setText("According to your BMI, you might be a normal weight.");
        } else if(BMI >= 25 && BMI <= 29.9) {
            bmAssessment.setText("According to your BMI, you might be overweight.");
        } else if(BMI >= 30 && BMI <= 34.9) {
            bmAssessment.setText("According to your BMI, you might be obese.");
        } else {
            bmAssessment.setText("According to your BMI, you might be morbidly/extremely obese.");
        }
        // Set the bmiLabel as an attribute of the request object
        request.setAttribute("bmiLabel", bmiLabel);
        request.setAttribute("bmiAssessment", bmAssessment);

        request.getRequestDispatcher("bmiCalculator.jsp").forward(request, response);
    }
}
