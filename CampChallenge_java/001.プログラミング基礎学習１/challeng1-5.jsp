<%-- 
    Document   : challeng1-5
    Created on : 2017/03/03, 13:00:12
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //if文の処理
    int param = 1;
    if(param == 1){
        out.println("1です!");
    }else if(param==2){
        out.println("プログラミングキャンプ！");
    }else{
        out.println("その他");
    
    }
    //2のときの処理
 int param2 = 2;
    if(param2 == 1){
        out.println("1です!");
    }else if(param2==2){
        out.println("プログラミングキャンプ！");
    }else{
        out.println("その他");
    
    }

     //1,2以外のときの処理
 int paramxxx = 777;
    if(paramxxx == 1){
        out.println("1です!");
    }else if(paramxxx==2){
        out.println("プログラミングキャンプ！");
    }else{
        out.println("それ以外");
    
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
