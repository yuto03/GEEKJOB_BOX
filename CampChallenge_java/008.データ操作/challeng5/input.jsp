<%-- 
    Document   : input
    Created on : 2017/04/09, 0:12:51
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
        <h1>入力ページ</h1>
        <!--action= "output.java" まで入れるとnotfoundエラー-->
        <form action="output" method="post"><br>
            名前:<br><input type="text" name="名前"><br>
            男性:<input type="radio" name="性別" value="男性"><br>
            女性:<input type="radio" name="性別" value="女性"><br>
            趣味:<br><textarea name="趣味"></textarea>　<br>
                <input type="submit" name="送信"><br>
        </form>
    </body>
</html>
