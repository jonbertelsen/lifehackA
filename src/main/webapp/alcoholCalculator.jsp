<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Blood alcohol level calculator
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <div class="text-danger">
            <c:if test="${requestScope.msg != null}">
                <p>${requestScope.msg}</p>
            </c:if>
        </div>

        <form action="alcoholservlet" method="post">

                <%--Units--%>
            <label for="units">Amount of alcoholic units:
                <input type="number" id="units" name="units" min="0">
            </label><br><br>
                <%--Bodyweight--%>
            <label for="weight">Bodyweight in kg:
                <input type="number" step="0.1" min="1" id="weight" name="weight">
            </label>
            <br><br>
                <%--Gender--%>
            <p>Gender:</p>
            <label for="female">Female
                <input type="radio" id="female" name="gender" value="female" checked>
            </label><br>
            <label for="male">Male
                <input type="radio" id="male" name="gender" value="male">
            </label><br><br>
                <%--Time since start--%>
            <label for="hours">Amount of time you've been drinking:
                <input type="number" name="hours" id="hours" min="0" placeholder="hours">
            </label>
            <label for="minutes">
                <input type="number" name="minutes" id="minutes" min="0" max="59" placeholder="minutes">
            </label>
            <button type="submit">Calculate</button>
        </form>
        <br><br>

        <c:if test="${requestScope.bal != null}">
            <h4>
                Your blood alcohol content is:
            </h4>
            <p>${requestScope.bal}</p>

            <div class="text-danger">
                <p>${requestScope.worningMsg}</p>
            </div>
        </c:if>

    </jsp:body>

</t:pagetemplate>