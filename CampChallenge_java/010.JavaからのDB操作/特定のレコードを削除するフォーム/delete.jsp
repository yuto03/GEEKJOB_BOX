<%-- 
    Document   : delete
    Created on : 2017/04/16, 2:26:12
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>削除ページ</h1>
        <form action="processRequest10" method="post" required>
            userID<input type="number" name="userID" required>必須<br>
           
            <input type="submit" name="削除"><br>
            
        </form>
    </body>
</html>
