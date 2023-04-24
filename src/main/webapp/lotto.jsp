<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="true" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Lotto!
    </jsp:attribute>

    <jsp:attribute name="footer">
        Lotto!
    </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-12">
                <div>
                    <table id="ipi-table" class="table table tablesorter">
                        <thead class="thead-dark">
                        <tr>
                            <th>Ticket</th>
                            <c:forEach begin="1" end="${requestScope.lottoCoupon.getNumberIntervalMax()}" var="i">
                                <th>Number ${i}</th>
                            </c:forEach>


                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Cell 1</td>
                        </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </jsp:body>
</t:pagetemplate>