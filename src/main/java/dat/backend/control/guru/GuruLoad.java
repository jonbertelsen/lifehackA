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

@WebServlet(name = "guru", urlPatterns = {"/guru"} )
public class GuruLoad extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        request.getRequestDispatcher("WEB-INF/guru.jsp").forward(request, response);
    }

    // Handles HTTP POST requests from the client
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Retrieves the text prompt from the HTTP POST request
        String text = request.getParameter("text");

        // URL of the OpenAI API
        String url = "https://api.openai.com/v1/completions";
        String apikey = null;

        // Sends an HTTP POST request to the OpenAI API
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + apikey);

        // Constructs a JSON object with the text prompt and other parameters
        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", text);
        data.put("max_tokens", 4000);
        data.put("temperature", 1.0);

        // Sends the JSON object as the request body of the HTTP POST request
        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        // Reads the response from the OpenAI API and retrieves the generated text
        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                .reduce((a, b) -> a + b).get();
        String answer = new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text");
    }
}