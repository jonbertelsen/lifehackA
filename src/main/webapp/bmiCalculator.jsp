<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <title>Title</title>
</head>
<body>
<div>
    <h1 class="designtext">
        BMI Calculator - Insert your height and weight to calculate your BMI!
    </h1>
</div>

    <form action="ServletBmiCalculate" id="heightweightSubmit" method="post">
        <input type="number" id="height" name="height" placeholder="Height" required="required"><br>
        <input type="number" id="weight" name="weight" placeholder="Weight" required="required"><br><br>
        <input type="submit" id="submit" value="Submit">
    </form>


<c:if test="${not empty bmiLabel}">

    <div class="bmi-label">
        <label id="bmiLabel" name="bmiLabel">${bmiLabel.text}</label>
    </div>
    <div class="bmi-label">
        <label id="bmiAssessment" name="bmiAssessment">${bmiAssessment.text}</label>
    </div>

</c:if>

</body>
</html>
