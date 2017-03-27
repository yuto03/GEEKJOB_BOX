<%-- 
    Document   : challeng_jsp2_6
    Created on : 2017/03/26, 23:12:46
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%!
    //ユーザー定義メソッド作成　フィールド

String getProfile(int getid){
    
    if(getid == 1){
         return ("神奈川太郎"+"1月1日"+"神奈川県");
    }else{
        return("このIDは登録されていません");
    }
    
   
}
   %>
<!DOCTYPE html>

<%
//戻り値2課題


String display = getProfile(1);
out.println(display);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
