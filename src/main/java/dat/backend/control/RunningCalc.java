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

        /**
         * formType gets the value from runningCalc.jsp to determine which calculations will be made in the  servlet
         */
        String formType = request.getParameter("formType");

        /**
         * If the user uses the form with value "calcTime", this code will  run
         */
        if(formType.equals("calcTime")) {
            int minutes = Integer.parseInt(request.getParameter("minutes"));
            int seconds = Integer.parseInt(request.getParameter("seconds"));
            int distance = Integer.parseInt(request.getParameter("distance"));


            int totalSeconds = distance * ((minutes * 60) + seconds);

            int tHours = totalSeconds / 3600;
            int tMinutes = (totalSeconds % 3600) / 60;
            int tSeconds = totalSeconds % 60;

            /**
             * totalTime formats  the String with the arguments tHours,tMinutes and paceSec, and display it in a time format that is xx hours xx minutes and xx seconds
             */
            String totalTime = String.format(" %d hours, %d minutes, %d seconds", tHours, tMinutes, tSeconds);

            request.setAttribute("totalTime", totalTime);
        }
        /**
         * if the formType is "calcPace", this code would run
         */
        else if(formType.equals("calcPace")) {


            int pHours = Integer.parseInt(request.getParameter("pHours"));
            int pMinutes = Integer.parseInt(request.getParameter("pMinutes"));
            int pSeconds = Integer.parseInt(request.getParameter("pSeconds"));
            int pDistance = Integer.parseInt(request.getParameter("pDistance"));

            int totalPSeconds = pHours * 3600 + pMinutes * 60 + pSeconds;

            int pace =  totalPSeconds/pDistance;
            int paceMin =  pace/60;
            int paceSec =  pace%60;

            /**
             * totalPace formats a String that takes in paceMin and paceSec, and display it in xx minutes and xx seconds
             */
            String totalPace = String.format(" %d minutes, %d seconds",paceMin, paceSec);

            request.setAttribute("totalPace", totalPace);
        }

       request.getRequestDispatcher("runningCalc.jsp").forward(request,response);

    }
}


