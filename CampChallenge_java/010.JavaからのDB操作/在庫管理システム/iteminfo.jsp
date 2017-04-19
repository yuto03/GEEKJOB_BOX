<%-- 
    Document   : iteminfo
    Created on : 2017/04/17, 15:54:40
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbaccess.Logout"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ようこそ</h1>
        <h2>商品情報を登録してください</h2>
        <form action="processRequest13_2" method="post">
            登録番号:<input type="number" name="itemID"></br>
            商品名:<input type="text" name="name"></br>
            個数:<input type="number" name="num"></br>
            価格:<input type="number" name="price"></br>
            <input type="submit" name="登録"><br>
             <p><a href="Logout">ログアウト</a></p>
             <p><a href="processRequest13_3">商品一覧</a></p>
    </body>
   
</html>
