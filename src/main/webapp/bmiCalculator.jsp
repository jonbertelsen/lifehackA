<%--
  Created by IntelliJ IDEA.
  User: Julius
  Date: 24/04/2023
  Time: 14.56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="ServletBmiCalculate" method="get">
    <input type="text" id="height" name="height" placeholder="Height"><br>
    <input type="text" id="weight" name="weight" placeholder="Weight"><br><br>
    <input type="submit" value="Submit">
</form>

<c:if test="${not empty bmiLabel}">
    <label id="bmiLabel" name="bmiLabel">${bmiLabel.text}</label>
</c:if>

</body>
</html>
