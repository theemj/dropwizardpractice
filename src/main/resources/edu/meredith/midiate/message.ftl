<#-- @ftlvariable name="" type="edu.meredith.midiate.MessageOfDayView" -->
<html>
<body>
<!-- calls getMessage() and sanitizes it -->
<h1>Hello, ${message?html}!</h1>
<form action="/motd" method="post">
    Message:<br>
    <input type="text" name="message"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>