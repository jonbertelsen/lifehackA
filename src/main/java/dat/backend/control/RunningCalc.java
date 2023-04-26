package dat.backend.control;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "runningCalc" , value = "/RunningCalc")
public class RunningCalc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String formType = request.getParameter("formType");

        //gets parameter from form "runnng time"
        if(formType.equals("calcTime")) {
            int minutes = Integer.parseInt(request.getParameter("minutes"));
            int seconds = Integer.parseInt(request.getParameter("seconds"));
            int distance = Integer.parseInt(request.getParameter("distance"));

            //calculate total second to hours, minutes and second
            int totalSeconds = distance * ((minutes * 60) + seconds);

            int tHours = totalSeconds / 3600;
            int tMinutes = (totalSeconds % 3600) / 60;
            int tSeconds = totalSeconds % 60;

            //format the variables to display a time format in HH:MM:SS
            String totalTime = String.format(" %d hours, %d minutes, %d seconds", tHours, tMinutes, tSeconds);

            request.setAttribute("totalTime", totalTime);
        }

        else if(formType.equals("calcPace")) {


            int pHours = Integer.parseInt(request.getParameter("pHours"));
            int pMinutes = Integer.parseInt(request.getParameter("pMinutes"));
            int pSeconds = Integer.parseInt(request.getParameter("pSeconds"));
            int pDistance = Integer.parseInt(request.getParameter("pDistance"));

            int totalPSeconds = pHours * 3600 + pMinutes * 60 + pSeconds;

            int pace =  totalPSeconds/pDistance;
            int paceMin =  pace/60;
            int paceSec =  pace%60;

            String totalPace = String.format(" %d minutes, %d seconds",paceMin, paceSec);

            request.setAttribute("totalPace", totalPace);
        }

       request.getRequestDispatcher("runningCalc.jsp").forward(request,response);

    }
}


