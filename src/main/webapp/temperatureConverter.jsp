<%--
  Created by IntelliJ IDEA.
  User: Salar Salim
  Date: 24-04-2023
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <h1 style="color: #000185; font-family: Arial, sans-serif">Temperature Converter</h1>
    <form style="border: 5px; color: #382E00" action="temperatureconverterservlet" method="post" >
        <input type="text" name="temperature" placeholder="Enter Celcius">
        <input type="hidden" value="celcius" id="temperaturetype" name="temperaturetype">
        <button style="background-color: #000185; color: #D1AF15; border-radius: 25px" type="submit">Convert</button>
    </form>
    ${requestScope.temperature}
    <form action="temperatureconverterservlet" method="post" >
        <input type="text" name="temperature" placeholder="Enter Fahrenheit">
        <input type="hidden" value="fahrenheit" name="temperaturetype">
        <button style="background-color: #000185; color: #D1AF15; border-radius: 25px" type="submit">Convert</button>
    </form>
    ${requestScope.error}
    <img src="images/temperatureconverter/thermometer.png">
</head>
<body>

</body>
</html>
