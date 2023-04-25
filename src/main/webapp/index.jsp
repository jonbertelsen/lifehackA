<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
    </jsp:attribute>


    <jsp:body>
        <div class="d-flex justify-content-center">
        <div class="frontpageTitle">
        <h1>Lifehacks</h1>
        </div>
        </div>
        <div class="d-flex justify-content-between">
            <img src="${pageContext.request.contextPath}/images/lifehack-logo.png" width="200px;" alt="logo">
            <div class="d-flex align-items-center">
        <h5 class="frontpageUnderTitle">Et lifehack er betegnelsen for en smart genvej,  der øger produktiviteten og effektiviteten i alle dele af livet. <br>
            <br>

            Ordet er en sammentrækning af life (liv) og hack (hacking) –  og kan derved ses som en måde, at hacke dit liv på for at blive mere effektiv
            <br><br> Se vores spændende lifehacks nedenfor. God fornøjelse!
        </h5>
            </div>
            <img src="${pageContext.request.contextPath}/images/lifehack-logo.png" width="200px;" alt="logo">
        </div>

        <br>
        <br>

     <div class="d-flex justify-content-around" >

        <form action="alcoholCalculator.jsp">
            <button type="submit" class="btn">Promille måler</button>
        </form>

         <form action="lotto" method="get">
             <button type="submit" class="btn">Lotto</button>
         </form>

         <form action="guru.jsp">
             <button type="submit" class="btn d-flex flex-wrap">Guru</button>
         </form>

         <form action="unitConverter" method="post">
             <button type="submit" class="btn">Unit converter</button>
         </form>

         <form action="runningCalc.jsp">
             <button type="submit" class="btn">Running speed calculator</button>
         </form>
         <form action="smoking" method="get">
             <button type="submit" class="btn">Rygestop hjælper</button>
         </form>
         <form action="#">
             <button type="submit" class="btn">Bmi beregner</button>
         </form>
         <form action="#">
             <button type="submit" class="btn">Sodavands indtag</button>
         </form>
     </div>








    </jsp:body>

</t:pagetemplate>