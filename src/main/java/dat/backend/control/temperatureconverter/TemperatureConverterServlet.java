package dat.backend.control.temperatureconverter;

import dat.backend.model.entities.temperatureconverter.TemperatureConverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TemperatureConverterServlet", value = "/temperatureconverterservlet")
public class TemperatureConverterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("temperatureConverter.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temperatureType = request.getParameter("temperaturetype");
        TemperatureConverter tempConverter = new TemperatureConverter();
        if (temperatureType.equals("celcius")) {
            try {
                double temperature = Double.parseDouble((request.getParameter("temperature")));
                temperature = tempConverter.temperatureConverterForCelciusToFahrenheit(temperature);
                request.setAttribute("temperaturecelcius", temperature);
            }
            catch (IllegalArgumentException e) {
                request.setAttribute("error","Wrong input type");
            }
        }
        if (temperatureType.equals("fahrenheit")) {
            try {
                double temperature = Double.parseDouble((request.getParameter("temperature")));
                temperature = tempConverter.temperatureConverterForFahrenheitToCelcius(temperature);
                request.setAttribute("temperaturefahrenheit", temperature);
            }
            catch (IllegalArgumentException e) {
                request.setAttribute("error","Wrong input type");
            }
        }
        request.getRequestDispatcher("temperatureConverter.jsp").forward(request, response);


    }
}
