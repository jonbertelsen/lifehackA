<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<html>
<head>
    <title>Guru Input</title>
</head>
<body>
<h1>Guru Input</h1>
<form id="guru-form" method="POST" action="guru">
    <label for="text-input">Enter text:</label>
    <br>
    <textarea class="form-control" id="text-input" name="text" rows="5" cols="50"></textarea>
    <br><br>
    <input type="submit" class="btn btn-primary" value="Submit" maxlength="50">
</form>
<br>
<br>
<br>
<h1>Guru Output</h1>
<span>
    ${sessionScope.answer}
</span>
<script>
    window.onload = function() {
        var iframe = parent.document.getElementById("guru-iframe");
        var innerDoc = iframe.contentDocument || iframe.contentWindow.document;
        iframe.style.height = innerDoc.body.scrollHeight + "px";
    }
</script>

</body>
</html>