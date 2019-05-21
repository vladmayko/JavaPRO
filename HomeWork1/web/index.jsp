<%--
  Created by IntelliJ IDEA.
  User: MacUser
  Date: 20.05.19
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Questioning</title>
  </head>
  <body>
    <form action="/questioning" method="POST">
      Name: <input type="text" name="name"><br>
      Surname: <input type="text" name="surname"><br>
      Age: <input type="text" name="age"><br>
      <p><b>What programming languages do you know?</b></p>
      <p><input type="checkbox" name="cPlus">С++<br>
        <input type="checkbox" name="java">Java<br>
        <input type="checkbox" name="cSharp">C#<br>
        <input type="checkbox" name="js">JS</p>
      <p><input type="button" value="Submit" onclick="this.form.submit(); this.form.reset()"></p>

    </form>
  </body>
</html>
