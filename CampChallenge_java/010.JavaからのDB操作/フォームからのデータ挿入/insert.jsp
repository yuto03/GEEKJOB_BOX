<%-- 
    Document   : insert
    Created on : 2017/04/14, 23:53:53
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>追加登録ページ</title>
    </head>
    <body>
        <h1>追加登録ページ</h1>
        <form action="processRequest9" method="post" required>必須
            userID<input type="text" name="userID" required>必須<br>
            名前：<input type="text" name="name"required>必須<br>
            電話番号：<input type="text" name="tell" value="000-0000-0000"required>必須<br>
            年齢：<input type="text" name="age" min="0" max="120" value="0"required>必須<br>
            誕生日<input type="date" name="birthday" value="2012-02-16"required>必須<br>
            departmentID<input type="text" name="dID" min="1" max="3" required>必須<br>
            stationID<input type="text" name="sID" min="1" max="5" required>必須<br>
            
            
            <input type="submit" name="追加"><br>
            
        </form>
</html>
