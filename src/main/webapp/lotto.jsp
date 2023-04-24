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
            <div class="col-6">
                <h1>Lotto</h1>
                <form action="lotto" method="post">

                    <label for="numberCount">Number of tickets</label> <br>
                    <input id="numberCount" name="numberCount" type="number"
                           placeholder="write the amount of numbers you want generated">
                    <br> <br>

                    <label for="numberIntervalMin">Minimum number pullable</label> <br>
                    <input id="numberIntervalMin" min="1" name="numberIntervalMin" type="number"
                           placeholder="write the minimum number pullables"> <br> <br>

                    <label for="numberIntervalMax">Maximum number pullable</label> <br>
                    <input id="numberIntervalMax" name="numberIntervalMax" type="number"
                           placeholder="write the maximum number pullables"> <br> <br>

                    <label for="ticketCount">number of tickets in play</label> <br>
                    <input id="ticketCount" name="ticketCount" type="number" placeholder="Number of entries">
                    
                    <br> <br>
                    <button class="btn btn-primary" type="submit"> submit</button>
                </form>
            </div>
            <div class="col-6">
                <p>Your chosen number of numbers: ${requestScope.lottoCoupon.numberCount}</p>
                <p>${requestScope.lottoCoupon.numberIntervalMin}</p>
                <p>${requestScope.lottoCoupon.numberIntervalMax}</p>
                <p>${requestScope.lottoCoupon.ticketCount}</p>
            </div>


        </div>
        <c:if test="${requestScope.lottoCoupon != null}">

            <div class="row">
                <div class="col-12">
                    <div>
                        <table id="ipi-table" class="table table tablesorter">
                            <thead class="thead-dark">
                            <tr>
                                <th>Ticket</th>
                                <c:forEach begin="1" end="${requestScope.lottoCoupon.numberCount}" var="i">
                                    <th>Number ${i}</th>
                                </c:forEach>


                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.lottoCoupon.generateTickets()}" var="ticket">
                                <tr>
                                    <td>${ticket.key}.</td>
                                    <c:forEach items="${ticket.value}" var="number">
                                        <td>${number}</td>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </c:if>


    </jsp:body>
</t:pagetemplate>