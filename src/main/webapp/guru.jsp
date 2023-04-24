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
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="embed-responsive embed-responsive-16by9">
                                <iframe id="guru-iframe" src="${pageContext.request.contextPath}/guruframe.jsp" style="height: 500px;" width="100%"></iframe>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</t:pagetemplate>