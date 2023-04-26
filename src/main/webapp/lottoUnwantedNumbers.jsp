<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="true" %>

<html>
<head>
    <title>Title</title>

    <style>
        p {
            font-size: 20px;
            color: #000038;
        }
        .exclusion {
            color: beige;
        }
        .section-heading {
            color: #000185 !important;
        }
        input {
            font-size: 20px;
            color: #000038;
        }
        label {
            font-size: 20px;
            color: #000038;
        }

    </style>
</head>
<body>

<p>You have chosen to exclude:

<c:forEach items="${sessionScope.lottoCoupon.unwantedNumbers}" var="unwantedNumber">

    <c:if test="${sessionScope.lottoCoupon.unwantedNumbers.size() < 1}">
        ${unwantedNumber}
    <td> <form action="unwanted-numbers" method="get">
            <input type="hidden" name="removeUnwantedNumber" value="${unwantedNumber}">
            <input class="btn btn-primary" type="submit" value="Remove">
</form>
</td>
    </c:if>

    ${unwantedNumber} <form action="unwanted-numbers" method="get">
    <input type="hidden" name="removeUnwantedNumber" value="${unwantedNumber}">
    <input class="btn btn-primary" type="submit" value="Remove">
</form>,

</c:forEach>
</p>

</body>
</html>
