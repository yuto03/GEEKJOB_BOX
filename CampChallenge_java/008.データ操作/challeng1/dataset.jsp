<%-- 
    Document   : dataset
    Created on : 2017/04/08, 10:43:48
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
        <h1>Hello World!</h1>
        <form action="deta_operation1" method="post">
        名前：<input type="text"  name="名前"><br>
        男性：<input type="radio" name="性別"　value="男性"><br>
        女性：<input type="radio" name="性別"　value="女性"><br>
        趣味：<textarea name="趣味"></textarea><br>
        送信：<input type="submit" name="送信"><br>


        </from>
            

    </body>
</html>
