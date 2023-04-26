<%--
  Created by IntelliJ IDEA.
  User: city
  Date: 25/04/2023
  Time: 12.34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Running Calculator
    </jsp:attribute>

    <jsp:attribute name="footer">
            Running Calculator
    </jsp:attribute>

<jsp:body>

    <img src="images/Runner.jpeg" alt="Runner" width="800" height="600" style="float: right ;">



    <h2 style="color: #000185; font-family: sans-serif" > Calculate total running time</h2>

    <br>

<p style="color: #000038; font-family: sans-serif"> Enter your pace pr. kilometer </p>

<form style="border: 5px; color: #382E00" action="RunningCalc" method="post">
    <input type="hidden" name="formType" value="calcTime">

    <label for="minutes">Minutes:</label>
    <input type="number" id="minutes" name="minutes" min="0" max="59" required>

    <label for="seconds">Seconds:</label>
    <input type="number" id="seconds" name="seconds" min="0" max="59" required>

<br>
<br>

<p style="color: #000038; font-family: sans-serif"> Enter your distance </p>

    <label label for="distance">Distance:</label>
    <input type="number" id="distance" name="distance"  required>

    <button style="border-radius: 23px" type="submit">Calculate</button>

    <c:if test="${requestScope.totalTime != null}">
        <p>Total time: ${requestScope.totalTime}</p>
    </c:if>

</form>

    <br>

    <h2 style="color: #000185; font-family: sans-serif">Calculate your pace</h2>

    <br>

    <form action="RunningCalc" method="post">
        <input type="hidden" name="formType" value="calcPace">

        <p style="color: #000038; font-family: sans-serif"> Enter your total run time: </p>


        <br>

        <label for="pHours">Hours:</label>
        <input type="number" id="pHours" name="pHours" min="0" max="59" required>

        <label for="pMinutes">Minutes:</label>
        <input type="number" id="pMinutes" name="pMinutes" min="0" max="59" required>

        <label for="pSeconds">Seconds:</label>
        <input type="number" id="pSeconds" name="pSeconds" min="0" max="59" required>

        <br>
        <br>

        <p style="color: #000038; font-family: sans-serif"> Enter your total distance </p>

        <br>

        <label for="pDistance">Distance:</label>
        <input type="number" id="pDistance" name="pDistance" min="0" required>


        <button style="border-radius: 23px" type="submit">Calculate</button>

        <c:if test="${requestScope.totalPace != null}">
            <p>Total pace(km) pr.min : ${requestScope.totalPace}</p>
        </c:if>

    </form>

<br>
<br>


<a style="color: #000038; font-family: sans-serif" href="https://www.calculatorsoup.com/calculators/health/pace-calculator.php" > Link to calculation methods</a>

</jsp:body>



</t:pagetemplate>
