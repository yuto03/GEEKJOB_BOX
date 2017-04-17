<%-- 
    Document   : search
    Created on : 2017/04/16, 17:00:26
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
                       <h1>複合検索</h1>
        <form action="processRequest12" method="post">

            名前：<input type="text" name="name"><br>
            年齢：<input type="text" name="age" min="0" max="120" value="0"><br>
            誕生日<input type="text" name="birthday" value="2012-02-16"><br>

            <input type="submit" name="検索"><br>
            
        </form>
    </body>
</html>
