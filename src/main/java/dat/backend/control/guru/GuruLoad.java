package dat.backend.control.guru;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This class handles the HTTP GET and POST requests from the client and handles the communication with the OpenAI API
 * @author <a href="https://github.com/MagKon">Magkon</a> and <a href="https://github.com/Skainsmate">Skainsmate</a>
 * @version 1.0
 * @since 1.0
 * @see HttpServlet
 * @see WebServlet
 * @see HttpServletRequest
 * @see HttpServletResponse
 */
@WebServlet(name = "guru", urlPatterns = {"/guru"} )
public class GuruLoad extends HttpServlet {
    String  servletUrl = "http://64.226.103.200:8080/APIAccess-1.0-SNAPSHOT/apikey";
    String apiKey = "";

    /**
     * This method handles the HTTP GET request from the client and forwards the request to the guru.jsp file
     * @param request the HTTP GET request
     * @param response the HTTP response
     * @throws IOException if the request fails
     * @throws ServletException if the request fails
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        request.getRequestDispatcher("WEB-INF/guru.jsp").forward(request, response);
    }

    /**
     * This method handles the HTTP POST request from the client
     * @param request the HTTP POST request
     * @param response the HTTP response
     * @throws IOException if the request fails
     * @throws ServletException if the request fails
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Retrieves the text prompt from the HTTP POST request
        String text = request.getParameter("text");
        try {
            getKeyFromDroplet();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // URL of the OpenAI API
        String url = "https://api.openai.com/v1/completions";

        if (text != "" && text.length() <= 50) {
            // Constructs a JSON object with the text prompt and other parameters
            JSONObject data = new JSONObject();
            data.put("model", "text-davinci-003");
            data.put("prompt", text);
            data.put("max_tokens", 1000);
            data.put("temperature", 1.0);

            // Sends an HTTP POST request to the OpenAI API
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + apiKey);

            // Sends the JSON object as the request body of the HTTP POST request
            con.setDoOutput(true);
            con.getOutputStream().write(data.toString().getBytes());

            // Reads the response from the OpenAI API and retrieves the generated text
            String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                    .reduce((a, b) -> a + b).get();
            String answer = new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text");

            request.getSession().setAttribute("answer", answer);
        } else {
            // Generates a default answer if the text prompt is too long or null
            String answer = "Skriv en tekst på max 50 tegn";

            request.getSession().setAttribute("answer", answer);
        }

        request.getRequestDispatcher("WEB-INF/guru/guruframe.jsp").forward(request, response);
    }

    /**
     * This method gets the API key from the droplet and sets it to the apiKey variable
     * @throws Exception if the connection fails
     */
    private void getKeyFromDroplet() throws Exception {
        URL surl = new URL(servletUrl);

        // open the connection
        HttpURLConnection conn = (HttpURLConnection) surl.openConnection();

        // set the request method
        conn.setRequestMethod("GET");

        // set the API key as a request header
        conn.setRequestProperty("X-Api-Key", apiKey);

        // read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String response = in.readLine();

        // do something with the response
        System.out.println(response);

        apiKey = response;

        // close the connection
        conn.disconnect();
    }
}