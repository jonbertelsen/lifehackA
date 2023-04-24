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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gender = request.getParameter("gender");
        float weight = Float.parseFloat(request.getParameter("weight"));
        float units = Float.parseFloat(request.getParameter("units"));
        int hours = Integer.parseInt(request.getParameter("hours"));
        int minutes = Integer.parseInt(request.getParameter("minutes"));
        float time = hours + (minutes/60);
        AlcoholCalculator calculator = new AlcoholCalculator();
        float bal = calculator.balCalc(weight, gender, time, units);


        request.setAttribute("bal", bal);
        request.getRequestDispatcher("alcoholCalculator.jsp").forward(request, response);

    }

}
