<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
    </jsp:attribute>


    <jsp:body>
        <div class="row mb-4">
            <div class="d-flex justify-content-center col-12">
                <div class="frontpageTitle">
                    <h1>Lifehacks</h1>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="d-flex justify-content-center col-lg-4">
                <img src="${pageContext.request.contextPath}/images/lifehack-logo.png" width="200px;" height="210px;" alt="logo">
            </div>
            <div class="col-lg-4">
                     <h5 class="frontpageUnderTitle">Et lifehack er betegnelsen for en smart genvej,  der øger produktiviteten og effektiviteten i alle dele af livet. <br>
                     <br>
                    Ordet er en sammentrækning af life (liv) og hack (hacking) –  og kan derved ses som en måde, at hacke dit liv på for at blive mere effektiv
                    <br><br> Se vores spændende lifehacks nedenfor. God fornøjelse!
                     </h5>
            </div>
            <div class="d-flex justify-content-center col-lg-4">
                <img src="${pageContext.request.contextPath}/images/lifehack-logo.png" width="200px;" height="210px;" alt="logo">
            </div>
        </div>

        <br>
        <br>

        <div class="row" >
             <div class="d-flex justify-content-around col-sm-12 col-md-6 col-lg-6 mb-sm-4">
                <form action="alcoholCalculator.jsp">
                    <button type="submit" class="btn">Promille måler</button>
                </form>
                 <form action="lotto" method="get">
                     <button type="submit" class="btn">Lotto</button>
                 </form>
                 <form action="smoking" method="get">
                     <button type="submit" class="btn">Rygestop hjælper</button>
                 </form>
                 <form action="unitConverter" method="post">
                     <button type="submit" class="btn">Unit converter</button>
                 </form>
             </div>

             <div class="d-flex justify-content-around col-sm-12 col-md-6 col-lg-6">
                 <form action="runningCalc.jsp">
                     <button type="submit" class="btn">Running speed calculator</button>
                 </form>
                 <form action="guru.jsp">
                     <button type="submit" class="btn d-flex flex-wrap">Guru</button>
                 </form>
                 <form action="#">
                     <button type="submit" class="btn">Bmi beregner</button>
                 </form>
                 <form action="sodaIntake.jsp">
                     <button type="submit" class="btn">Sodavands indtag</button>
                 </form>
             </div>
         </div>

    </jsp:body>

</t:pagetemplate>