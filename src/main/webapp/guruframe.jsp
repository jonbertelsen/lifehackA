<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Guru Input</title>
</head>
<body>
<h1>Guru Input</h1>
<form id="guru-form" method="POST" action="guru">
    <label for="text-input">Enter text:</label>
    <br>
    <textarea id="text-input" name="text" rows="10" cols="50"></textarea>
    <br><br>
    <input type="submit" value="Submit">
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