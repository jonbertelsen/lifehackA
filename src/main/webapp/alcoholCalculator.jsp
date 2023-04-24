<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Blood alcohol level calculator
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <form action="alcoholservlet" method="post">

                <%--Units--%>
            <label for="units">Antal genstande drukket:
                <input type="number" id="units" name="units" min="0" value="0">
            </label><br>
                <%--Bodyweight--%>
            <label for="weight">Din kropsvægt i kg:
                <input type="number" step="0.1" min="1" id="weight" name="weight">
            </label>
            <br>
                <%--Gender--%>
            <p>Gender:</p>
            <label for="female">Female
                <input type="radio" id="female" name="gender" value="female">
            </label><br>
            <label for="male">Male
                <input type="radio" id="male" name="gender" value="male">
            </label><br>
                <%--Time since start--%>
            <label for="hours">Antal timer du har drukket:
                <input type="number" name="hours" id="hours" min="0" placeholder="timer">
            </label>
            <label for="minutes">
                <input type="number" name="minutes" id="minutes" min="0" max="59" placeholder="minutter" value="0">
            </label>
            <button type="submit">Beregn</button>
        </form>
        <br><br>

        <c:if test="${requestScope.bal != null}">
            <h4>
                Din promille er lige nu:
            </h4>
            <p>${requestScope.bal}</p>
        </c:if>

    </jsp:body>

</t:pagetemplate>