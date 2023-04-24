<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Guru Input</title>
</head>
<body>
<form id="guru-form" method="POST" action="guru">
    <label for="text-input">Enter text:</label>
    <br>
    <textarea id="text-input" name="text" rows="10" cols="50"></textarea>
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>