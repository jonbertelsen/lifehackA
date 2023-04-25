<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="true" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        <style>
            body {
                background-image: linear-gradient(pink, #a56f61);
            }
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

        <p style="color: #000185 !important; font-size: 50px">Lotto!</p>



    </jsp:attribute>

    <jsp:attribute name="footer">
        Lotto!
    </jsp:attribute>

    <jsp:body>

        <section id="services">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="text-uppercase section-heading" style="color: #000185 !important;">How it works:</h2>
                        <h3 class="fs-1 text-muted section-subheading">3 simple things to do.</h3>
                    </div>
                </div>
                <div class="row text-center">
                    <div class="col-md-4"><span class="fa-stack fa-4x"><i
                            class="fa fa-circle fa-stack-2x text-primary"></i><i
                            class="fa fa-shopping-cart fa-stack-1x fa-inverse"></i> <img
                            src="https://cdn-media-2.freecodecamp.org/w1280/5f9c9819740569d1a4ca1826.jpg"
                            style="height: 250px; width: 250px; border-radius: 125px"></span>
                        <h4 class="section-heading">Generating numbers</h4>
                        <p >Win the lottery by generating random numbers and trying to get a match.
                            You can choose certain numbers you want in and have us do the rest!</p>
                    </div>
                    <div class="col-md-4"><span class="fa-stack fa-4x"><i
                            class="fa fa-circle fa-stack-2x text-primary"></i><i
                            class="fa fa-laptop fa-stack-1x fa-inverse"></i> <img
                            src="https://media.vanityfair.com/photos/56279183d475a5ce0f58f7c8/master/w_2560%2Cc_limit/drake-hotline-bling-jacket-moncler.png"
                            style="height: 250px; width: 250px; border-radius: 125px"> </span>
                        <h4 class="section-heading">Unwanted numbers</h4>
                        <p >Any numbers you would commit hate-crime against? Have them removed! Just
                            tell us which numbers shouldnt be up for generation, and we'll have it your way!</p>
                    </div>
                    <div class="col-md-4"><span class="fa-stack fa-4x"><i
                            class="fa fa-circle fa-stack-2x text-primary"></i><i
                            class="fa fa-lock fa-stack-1x fa-inverse"></i> <img
                            src="https://pbs.twimg.com/profile_images/1439951764732715015/oEz1_R_p_400x400.png"
                            style="height: 250px; width: 250px; border-radius: 125px"> </span>
                        <h4 class="section-heading">Feeling clairvoyant?</h4>
                        <p >Do you have any favorite numbers? If so, you should see a doctor. Alas, we
                            do not descriminate (at least not in public). The numbers you like, shall be added as you
                            please! </p>
                    </div>
                </div>
            </div>
        </section>

        <br> <br> <br> <br>

        <a class="btn btn-primary col-md-12 text-center" href="#services" style="align-self: center; background-color: #000185 !important; color: #D1AF15"> Take me to the lottery! </a>

        <br> <br> <br> <br>


        <div class="row">
            <div class="col-5" style="border: 5px solid #382E00; border-width: thick; padding: 20px; background-color: #a96b70; border-radius: 25px">
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

                    <button formaction="unwanted-numbers" formmethod="post" formtarget="iframe" type="submit">Exclude numbers
                    </button>

                    <br> <br>
                    <button class="btn btn-primary" type="submit"> Generate</button>
                </form>
            </div>

            <div class="col-1"></div>
            <div class="col-5" style="border: 5px solid #382E00; border-width: thick; background-color: ; padding: 20px; border-radius: 25px">
                <br>
                <p>Your chosen number of numbers: ${sessionScope.lottoCoupon.numberCount}</p>
                <p>The minimal interval you chose is: ${sessionScope.lottoCoupon.numberIntervalMin}</p>
                <p>The max interval you chose is: ${sessionScope.lottoCoupon.numberIntervalMax}</p>
                <p>You have ordered ${sessionScope.lottoCoupon.ticketCount} tickets</p>
                <p class="exclusion">Unwanted numbers: ${sessionScope.lottoCoupon.unwantedNumbers}</p>



                <iframe name="iframe" id="iframe" sandbox="allow-forms" src="unwanted-numbers"></iframe>
            </div>

        </div>

        <br> <br> <br> <br>

        <c:if test="${sessionScope.lottoCoupon != null}">
            <div class="row">
                <div class="col-12">
                    <div>
                        <table id="ipi-table" class="table table-striped table-bordered table-hover" style="background-color: #a58a97">
                            <thead style="background-color: #615159" >
                            <tr>
                                <th>Ticket</th>
                                <c:forEach begin="1" end="${sessionScope.lottoCoupon.numberCount}" var="i">
                                    <th>Number ${i}</th>
                                </c:forEach>


                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${sessionScope.lottoCoupon.generateCoupon().rows}" var="row">
                                <tr>
                                    <td>${row.key}.</td>
                                    <c:forEach items="${row.value}" var="number">
                                        <td>${number.getNumber()}</td>
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