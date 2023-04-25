<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="true" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

You have chosen to exclude:
<c:forEach items="${sessionScope.lottoCoupon.getUnwantedNumbers()}" var="unwantedNumber">

    <c:if test="${sessionScope.lottoCoupon.unwantedNumbers.size() < 1}">
        ${unwantedNumber}
    </c:if>

    ${unwantedNumber},
</c:forEach>


</body>
</html>
