<%--
  Created by IntelliJ IDEA.
  User: thc19
  Date: 24-04-2023
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>
<html>
<head>
    <title>Soda intake calculator</title>
    <link rel="stylesheet" href="css/sodaIntake.css">
    <fmt:setLocale value="da_DK"/>
</head>
<body>
    <t:pagetemplate>
        <jsp:attribute name="footer">
            Sodavandsindtag beregner
        </jsp:attribute>
        <jsp:body>
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-9">
                        <img style="display:block; margin: auto;" src="images/soda.jpeg">
                        <h1 class="cph-title">Sodavandsindtag beregner</h1>
                        <p class="cph-text">
                            Udfra dit ugentlige forbrug, kan vi beregne hvor meget du kan spare, henholdsvis dagligt, ugentligt, månedligt og årligt, hvis du nedsætter dit forbrug, med enten 10%, 20%, 50% eller 100%.
                        </p>
                        <p class="cph-text">
                            Indtast dit ugentlige forbrug nedenunder, og se hvad du kan spare.
                        </p>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-9">
                        <c:if test="${requestScope.weeklyIntake == null}">
                            <form action="sodaintakeservlet" class="cph-input-form" method="post">
                                <label class="cph-form-item cph-form-label" for="weeklyIntake">Ugentligt forbrug:</label>
                                <input type="text" name="weeklyIntake" id="weeklyIntake" class="cph-form-item cph-form-input" placeholder="Forbrug i liter">
                                <input type="hidden" name="pricePerLiter" value="25">
                                <input type="submit" class="cph-form-btn cph-form-item" value="Beregn">
                            </form>
                        </c:if>
                        <c:if test="${requestScope.weeklyIntake != null}">
                            <h3 class="cph-title">Dit ugentlige indtag: ${requestScope.weeklyIntake}</h3>
                            <table class="cph-result-table">
                                <tr>
                                    <th></th>
                                    <th>10%</th>
                                    <th>20%</th>
                                    <th>50%</th>
                                    <th>100%</th>
                                </tr>
                                <tr>
                                    <td>
                                        Dagligt indtag:<br>
                                        <fmt:formatNumber maxFractionDigits="1" value="${requestScope.dailyIntake}"/> L
                                    </td>
                                    <td>
                                        Du sparer: <fmt:formatNumber type="currency" value="${requestScope.dailySaving10}"/><br>
                                        Du kan stadig drikke: <fmt:formatNumber maxFractionDigits="1" value="${requestScope.dailyIntake - requestScope.intakeReduction10}"/> L
                                    </td>
                                    <td>
                                        Du sparer: <fmt:formatNumber type="currency" value="${requestScope.dailySaving20}"/><br>
                                        Du kan stadig drikke: <fmt:formatNumber maxFractionDigits="1" value="${requestScope.dailyIntake - requestScope.intakeReduction20}"/> L
                                    </td>
                                    <td>
                                        Du sparer: <fmt:formatNumber type="currency" value="${requestScope.dailySaving50}"/><br>
                                        Du kan stadig drikke: <fmt:formatNumber maxFractionDigits="1" value="${requestScope.dailyIntake - requestScope.intakeReduction50}"/> L
                                    </td>
                                    <td>
                                        Du sparer: <fmt:formatNumber type="currency" value="${requestScope.dailySaving100}"/><br>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Ugentligt indtag:<br>
                                        <fmt:formatNumber maxFractionDigits="1" value="${requestScope.weeklyIntake}"/> L
                                    </td>
                                    <td>
                                        <c:set var="weeklySaving10" value="${requestScope.dailySaving10 * 7}"/>
                                        <c:set var="weeklyIntakeReduction10" value="${requestScope.intakeReduction10 * 7}"/>
                                        Du sparer: <fmt:formatNumber type="currency" value="${weeklySaving10}"/><br>
                                        Du kan stadig drikke: <fmt:formatNumber maxFractionDigits="1" value="${requestScope.weeklyIntake - weeklyIntakeReduction10}"/> L
                                    </td>
                                    <td>
                                        <c:set var="weeklySaving20" value="${requestScope.dailySaving20 * 7}"/>
                                        <c:set var="weeklyIntakeReduction20" value="${requestScope.intakeReduction20 * 7}"/>
                                        Du sparer: <fmt:formatNumber type="currency" value="${weeklySaving20}"/><br>
                                        Du kan stadig drikke: <fmt:formatNumber maxFractionDigits="1" value="${requestScope.weeklyIntake - weeklyIntakeReduction20}"/> L
                                    </td>
                                    <td>
                                        <c:set var="weeklySaving50" value="${requestScope.dailySaving50 * 7}"/>
                                        <c:set var="weeklyIntakeReduction50" value="${requestScope.intakeReduction50 * 7}"/>
                                        Du sparer: <fmt:formatNumber type="currency" value="${weeklySaving50}"/><br>
                                        Du kan stadig drikke: <fmt:formatNumber maxFractionDigits="1" value="${requestScope.weeklyIntake - weeklyIntakeReduction50}"/> L
                                    </td>
                                    <td>
                                        <c:set var="weeklySaving100" value="${requestScope.dailySaving100 * 7}"/>
                                        Du sparer: <fmt:formatNumber type="currency" value="${weeklySaving100}"/><br>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Månedlig indtag:<br>
                                        <fmt:formatNumber maxFractionDigits="1" value="${requestScope.monthlyIntake}"/> L
                                    </td>
                                    <td>
                                        <c:set var="monthlySaving10" value="${requestScope.dailySaving10 * 30}"/>
                                        <c:set var="monthlyIntakeReduction10" value="${requestScope.intakeReduction10 * 30}"/>
                                        Du sparer: <fmt:formatNumber type="currency" value="${monthlySaving10}"/><br>
                                        Du kan stadig drikke: <fmt:formatNumber maxFractionDigits="1" value="${requestScope.monthlyIntake - monthlyIntakeReduction10}"/> L
                                    </td>
                                    <td>
                                        <c:set var="monthlySaving20" value="${requestScope.dailySaving20 * 30}"/>
                                        <c:set var="monthlyIntakeReduction20" value="${requestScope.intakeReduction20 * 30}"/>
                                        Du sparer: <fmt:formatNumber type="currency" value="${monthlySaving20}"/><br>
                                        Du kan stadig drikke: <fmt:formatNumber maxFractionDigits="1" value="${requestScope.monthlyIntake - monthlyIntakeReduction20}"/> L
                                    </td>
                                    <td>
                                        <c:set var="monthlySaving50" value="${requestScope.dailySaving50 * 30}"/>
                                        <c:set var="monthlyIntakeReduction50" value="${requestScope.intakeReduction50 * 30}"/>
                                        Du sparer: <fmt:formatNumber type="currency" value="${monthlySaving50}"/><br>
                                        Du kan stadig drikke: <fmt:formatNumber maxFractionDigits="1" value="${requestScope.monthlyIntake - monthlyIntakeReduction50}"/> L
                                    </td>
                                    <td>
                                        <c:set var="monthlySaving100" value="${requestScope.dailySaving100 * 30}"/>
                                        Du sparer: <fmt:formatNumber type="currency" value="${monthlySaving100}"/><br>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Årligt indtag:<br>
                                        <fmt:formatNumber maxFractionDigits="1" value="${requestScope.yearlyIntake}"/> L
                                    </td>
                                    <td>
                                        <c:set var="yearlySaving10" value="${requestScope.dailySaving10 * 365}"/>
                                        <c:set var="yearlyIntakeReduction10" value="${requestScope.intakeReduction10 * 365}"/>
                                        Du sparer: <fmt:formatNumber type="currency" value="${yearlySaving10}"/><br>
                                        Du kan stadig drikke: <fmt:formatNumber maxFractionDigits="1" value="${requestScope.yearlyIntake - yearlyIntakeReduction10}"/> L
                                    </td>
                                    <td>
                                        <c:set var="yearlySaving20" value="${requestScope.dailySaving20 * 365}"/>
                                        <c:set var="yearlyIntakeReduction20" value="${requestScope.intakeReduction20 * 365}"/>
                                        Du sparer: <fmt:formatNumber type="currency" value="${yearlySaving20}"/><br>
                                        Du kan stadig drikke: <fmt:formatNumber maxFractionDigits="1" value="${requestScope.yearlyIntake - yearlyIntakeReduction20}"/> L
                                    </td>
                                    <td>
                                        <c:set var="yearlySaving50" value="${requestScope.dailySaving50 * 365}"/>
                                        <c:set var="yearlyIntakeReduction50" value="${requestScope.intakeReduction50 * 365}"/>
                                        Du sparer: <fmt:formatNumber type="currency" value="${yearlySaving50}"/><br>
                                        Du kan stadig drikke: <fmt:formatNumber maxFractionDigits="1" value="${requestScope.yearlyIntake - yearlyIntakeReduction50}"/> L
                                    </td>
                                    <td>
                                        <c:set var="yearlySaving100" value="${requestScope.dailySaving100 * 365}"/>
                                        Du sparer: <fmt:formatNumber type="currency" value="${yearlySaving100}"/><br>
                                    </td>
                                </tr>
                            </table>
                    </c:if>
                    </div>
                </div>
            </div>
        </jsp:body>
    </t:pagetemplate>
</body>
</html>
