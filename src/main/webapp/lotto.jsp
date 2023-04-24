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
        <a href="#services">How it works</a>

        <div class="row">
            <div class="col-6">
                <form action="lotto" method="post">

                    <label for="numberCount">Number of numbers</label> <br>
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

                    <label for="unwantedNumbers">Unwanted numbers</label> <br>
                    <input id="unwantedNumbers" name="unwantedNumbers" type="number" placeholder="Unwanted numbers">

                    <button formaction="unwantedServlet" formmethod="post" formtarget="iframe" type="submit">Submit
                    </button>

                    <br> <br>
                    <button class="btn btn-primary" type="submit"> submit</button>
                </form>


            </div>
            <div class="col-6" style="background-color: darkgray">
                <p>Your chosen number of numbers: ${sessionScope.lottoCoupon.numberCount}</p>
                <p>The minimal interval you chose is: ${sessionScope.lottoCoupon.numberIntervalMin}</p>
                <p>The max interval you chose is: ${sessionScope.lottoCoupon.numberIntervalMax}</p>
                <p>You have ordered ${sessionScope.lottoCoupon.ticketCount} tickets</p>
                <p>Unwanted numbers: ${sessionScope.lottoCoupon.unwantedNumbers}</p>


                <iframe name="iframe" id="iframe" sandbox="allow-forms" src="unwantedServlet"></iframe>
            </div>


        </div>
        <c:if test="${sessionScope.lottoCoupon != null}">
            <div class="row">
                <div class="col-12">
                    <div>
                        <table id="ipi-table" class="table table tablesorter">
                            <thead class="thead-dark">
                            <tr>
                                <th>Ticket</th>
                                <c:forEach begin="1" end="${sessionScope.lottoCoupon.numberCount}" var="i">
                                    <th>Number ${i}</th>
                                </c:forEach>


                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${sessionScope.lottoCoupon.generateTickets()}" var="ticket">
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

        <br> <br> <br> <br>
        <section id="services">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="text-uppercase section-heading">How it works:</h2>
                        <h3 class="fs-1 text-muted section-subheading">3 simple things to do.</h3>
                    </div>
                </div>
                <div class="row text-center">
                    <div class="col-md-4"><span class="fa-stack fa-4x"><i
                            class="fa fa-circle fa-stack-2x text-primary"></i><i
                            class="fa fa-shopping-cart fa-stack-1x fa-inverse"></i> <img
                            src="https://cdn-media-2.freecodecamp.org/w1280/5f9c9819740569d1a4ca1826.jpg"
                            style="height: 200px; width: 200px; border-radius: 100px"></span>
                        <h4 class="section-heading">Generating numbers</h4>
                        <p class="text-muted">Win the lottery by generating random numbers and trying to get a match.
                            You can choose certain numbers you want in and have us do the rest!</p>
                    </div>
                    <div class="col-md-4"><span class="fa-stack fa-4x"><i
                            class="fa fa-circle fa-stack-2x text-primary"></i><i
                            class="fa fa-laptop fa-stack-1x fa-inverse"></i> <img
                            src="https://media.vanityfair.com/photos/56279183d475a5ce0f58f7c8/master/w_2560%2Cc_limit/drake-hotline-bling-jacket-moncler.png"
                            style="height: 200px; width: 200px; border-radius: 100px"> </span>
                        <h4 class="section-heading">Unwanted numbers</h4>
                        <p class="text-muted">Any numbers you would commit hate-crime against? Have them removed! Just
                            tell us which numbers shouldnt be up for generation, and we'll have it your way!</p>
                    </div>
                    <div class="col-md-4"><span class="fa-stack fa-4x"><i
                            class="fa fa-circle fa-stack-2x text-primary"></i><i
                            class="fa fa-lock fa-stack-1x fa-inverse"></i> <img
                            src="https://pbs.twimg.com/profile_images/1439951764732715015/oEz1_R_p_400x400.png"
                            style="height: 200px; width: 200px; border-radius: 100px"> </span>
                        <h4 class="section-heading">Web Security</h4>
                        <p class="text-muted">Do you have any favorite numbers? If so, you should see a doctor. Alas, we
                            do not descriminate (at least not in public). The numbers you like, shall be added as you
                            please! </p>
                    </div>
                </div>
            </div>
        </section>


    </jsp:body>
</t:pagetemplate>