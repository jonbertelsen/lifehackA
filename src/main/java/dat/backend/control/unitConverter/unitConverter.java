package dat.backend.control.unitConverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "unitconverter", value = "/unitconverter")
public class unitConverter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("input") == ""){
            request.getRequestDispatcher("unitConverter.jsp").forward(request,response);
        }
        double input = Integer.parseInt(request.getParameter("input"));
        String inputUnit = request.getParameter("inputUnit");
        String outputUnit = request.getParameter("outputUnit");
        converterCalc converter = new converterCalc();


        try {
            double result = converter.calcuate(input,inputUnit,outputUnit);

            request.setAttribute("output",result);
            request.setAttribute("input", input);
            request.setAttribute("inputUnit",inputUnit);
            request.setAttribute("outputUnit",outputUnit);
            request.getRequestDispatcher("unitConverter.jsp").forward(request,response);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}