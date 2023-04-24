package dat.backend.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AlcoholServlet", value = "/alcoholservlet")
public class AlcoholServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gender = request.getParameter("gender");
        float weight = Float.parseFloat(request.getParameter("weight"));
        float units = Float.parseFloat(request.getParameter("units"));
        int hours = Integer.parseInt(request.getParameter("hours"));
        int minutes = Integer.parseInt(request.getParameter("minutes"));
        float time = hours + (minutes/60);
        float bal = balCalc(weight, gender, time, units);


        request.setAttribute("bal", bal);
        request.getRequestDispatcher("alcoholCalculator.jsp").forward(request, response);

    }
    private float balCalc(float weight, String gender, float time, float units){

        if (gender.equalsIgnoreCase("male")) {
            return balCalcMale(weight, time, units);
        }
        else if(gender.equalsIgnoreCase("female")){
            return balCalcFemale(weight, time, units);
        }
        return 100000;
    }

    private float balCalcMale(float weight, float time, float units){
        float bal = (float) (units * 12 / (weight *0.7) - (0.15 * time));
        return bal;
    }
    private float balCalcFemale(float weight, float time, float units){
        float bal = (float) (units * 12 / (weight *0.6) - (0.15 * time));
        return bal;
    }

}