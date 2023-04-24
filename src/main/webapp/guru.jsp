<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Guru
    </jsp:attribute>

    <jsp:attribute name="footer">
            Guru
    </jsp:attribute>

    <jsp:body>
        <iframe id="guru-iframe" src="${pageContext.request.contextPath}/guruframe.jsp" width="100%" height="200"></iframe>
    </jsp:body>
</t:pagetemplate>