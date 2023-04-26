<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>

<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="header"/></title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Our CSS stylesheet -->
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">
                <img src="${pageContext.request.contextPath}/images/frontpage/lifehack-logo.png" width="100px;" alt="logo" class="img-fluid"/>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/alcoholCalculator.jsp">Promille måler</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/temperatureConverter.jsp">Temperature Converter</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/lotto">Lotto</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/guru.jsp">Guru</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/unitConverter.jsp">Unit Converter</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/runningCalc.jsp">Løbe måler</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/smoking">Rygestop hjælper</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/">BMI beregner</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/sodaIntake.jsp">Sodavands indtag</a>
                </div>
            </div>
        </div>
    </nav>
</header>

<div id="body" class="container mt-4" style="min-height: 400px;">
    <h1><jsp:invoke fragment="header"/></h1>
    <jsp:doBody/>
</div>


</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>