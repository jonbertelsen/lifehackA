<%--
  Created by IntelliJ IDEA.
  User: sanderroust
  Date: 25/04/2023
  Time: 09.55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>
<t:pagetemplate>
<head>
    <title>Smoking Cessation</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <h1 style="text-align: center; color: #000185">Smoking Cessation Calculator</h1>
    <h3 style="text-align: center; color: #000185">${requestScope.invalidInput}</h3>
    <div class="container w-100 p-4" style="display: flex; justify-content: center; text-align: center; color: #000038">

    <br/>

    <form action="smoking" method="post">
        <label for="amount">Consumed cigarettes per day</label>
        <input type="number" id="amount" name="amount" required="required" style="margin: 15px 10px; border: solid 5px #382E00"/>
        <label for="price">Price per pack: </label>
        <input type="number" id="price" name="price" required="required" style="margin: 15px 10px; border: solid 5px #382E00"/>
        <p>How much do you want to reduce your use by? (in %)</p>
        <input type="radio" id="10%" name="reduction" value="10"/>
        <label for="10%">10%</label>
        <input type="radio" id="20%" name="reduction" value="20"/>
        <label for="20%">20%</label>
        <input type="radio" id="30%" name="reduction" value="30"/>
        <label for="30%">30%</label>
        <input type="radio" id="40%" name="reduction" value="40"/>
        <label for="40%">40%</label>
        <input type="radio" id="50%" name="reduction" value="50"/>
        <label for="50%">50%</label>
        <input type="radio" id="75%" name="reduction" value="75"/>
        <label for="75%">75%</label>
        <input type="radio" id="100%" name="reduction" value="100" checked="checked"/>
        <label for="100%">100% (Quit)</label>
        <br>
        <input type="submit" value="Calculate" style="background: #000185; color: #D1AF15; font-size: 20px; border-radius: 25px; margin: 20px; padding: 10px 50px">
        <div>
        <img src="images/avoidcigarettes.png" alt="avoid cigarettes" style="height: 304px; width: 540px">
        </div>

    <div class="container" style="padding: 2em; border: solid 5px #000038; color: #000038; text-align: left">
    <h2>You are currently spending the following: </h2>
    <h5>Daily: ${requestScope.dailySavings}</h5>
    <h5>Monthly: ${requestScope.monthlySavings}</h5>
    <h5>Yearly: ${requestScope.yearlySavings}</h5>

    <h2>If you reduced your use by ${requestScope.percentage}%, you would save:</h2>
    <p>(The numbers below apply if you smoke ${requestScope.reducedAmountOfCig} cigarettes instead of ${requestScope.amountOfCig}.)</p>
    <h5>Daily Savings: ${requestScope.dailyPercentage}</h5>
    <h5>Monthly Savings: ${requestScope.monthlyPercentage}</h5>
    <h5>Yearly Savings: ${requestScope.yearlyPercentage}</h5>
    </div>
    </form>
    </div>

</body>
</t:pagetemplate>
