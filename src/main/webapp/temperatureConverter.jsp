<%--
  Created by IntelliJ IDEA.
  User: Salar Salim
  Date: 24-04-2023
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Temperature Converter
    </jsp:attribute>

    <jsp:attribute name="footer">
            Temperature Converter
    </jsp:attribute>

    <jsp:body>
        <form style="border: 5px; color: #382E00" action="temperatureconverterservlet" method="post" >
            <input type="text" name="temperature" placeholder="Enter Celcius">
            <input type="hidden" value="celcius" id="temperaturetype" name="temperaturetype">
            <button style="background-color: #000185; color: #D1AF15; border-radius: 25px" type="submit">Convert</button>
            <br>
            <c:if test="${requestScope.temperaturecelcius != null}">
                  <p>Temperature in fahrenheit: ${requestScope.temperaturecelcius}</p>
            </c:if>
        </form>
        <br>
        <form action="temperatureconverterservlet" method="post" >
            <input type="text" name="temperature" placeholder="Enter Fahrenheit">
            <input type="hidden" value="fahrenheit" name="temperaturetype">
            <button style="background-color: #000185; color: #D1AF15; border-radius: 25px" type="submit">Convert</button>
            <br>
            <c:if test="${requestScope.temperaturefahrenheit != null}">
                <p>Temperature in celcius: ${requestScope.temperaturefahrenheit}</p>
            </c:if>
        </form>
        ${requestScope.error}
        <br>
        <br>
        <img src="images/temperatureconverter/thermometerconverter.png">

    </jsp:body>
</t:pagetemplate>
