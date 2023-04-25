<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Unit-Converter
    </jsp:attribute>

    <jsp:attribute name="footer">
            Unit-Converter
    </jsp:attribute>

    <jsp:body>
        <h3>Convert your units:</h3>
        <%--Type in your number for converting--%>
        <form action="unitconverter" method="post">
            <label for="input" style="width: 60px">Input:</label>
            <input type="number" id="input" name="input" value="${param.input != null ? param.input : ''}" style="width: 140px"/>

                <%--Select your input unit--%>
            <label for="inputUnit"></label>
            <select name="inputUnit" id="inputUnit">
                <option value="mm" ${param.inputUnit == 'mm' ? 'selected' : ''}>mm</option>
                <option value="cm" ${param.inputUnit == 'cm' ? 'selected' : ''}>cm</option>
                <option value="inches" ${param.inputUnit == 'inches' ? 'selected' : ''}>inches</option>
                <option value="feet" ${param.inputUnit == 'feet' ? 'selected' : ''}>feet</option>
                <option value="yards" ${param.inputUnit == 'yards' ? 'selected' : ''}>yards</option>
                <option value="meter" ${param.inputUnit == 'meter' ? 'selected' : ''}>meter</option>
                <option value="km" ${param.inputUnit == 'km' ? 'selected' : ''}>km</option>
                <option value="miles" ${param.inputUnit == 'miles' ? 'selected' : ''}>miles</option>
            </select>

            <br>

                <%--Returns the input as converted--%>
            <label for="output" style="width: 60px">Output:</label>
            <input type="number" id="output" name="output" READONLY value="${output}" style="width: 140px"/>
                <%--Select your output unit--%>
            <label for="outputUnit"></label>
            <select name="outputUnit" id="outputUnit">
                <option value="mm" ${param.outputUnit == 'mm' ? 'selected' : ''}>mm</option>
                <option value="cm" ${param.outputUnit == 'cm' ? 'selected' : ''}>cm</option>
                <option value="inches" ${param.outputUnit == 'inches' ? 'selected' : ''}>inches</option>
                <option value="feet" ${param.outputUnit == 'feet' ? 'selected' : ''}>feet</option>
                <option value="yards" ${param.outputUnit == 'yards' ? 'selected' : ''}>yards</option>
                <option value="meter" ${param.outputUnit == 'meter' ? 'selected' : ''}>meter</option>
                <option value="km" ${param.outputUnit == 'km' ? 'selected' : ''}>km</option>
                <option value="miles" ${param.outputUnit == 'miles' ? 'selected' : ''}>miles</option>
            </select>

            <br><br>

            <button class="btn">Convert</button>

            <br><br>

            <marquee  behavior="scroll" direction="left" scrollamount="40">
                <img src="images/unitConverter/hest.jpg"
                     alt="slidingLogo">
            </marquee>

            <marquee  behavior="alternate" direction="right" scrollamount="25">
                <img src="images/unitConverter/gomichi.jpg"
                     alt="slidingLogo1">
            </marquee>

        </form>
    </jsp:body>
</t:pagetemplate>