<%-- 
    Document   : challeng2-2
    Created on : 2017/03/08, 13:58:43
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String eng ="A"; 
    String message = " ";
    switch (eng){
        case "A":
            message.equals("英語です");
            break;
        case "あ":
            message.equals("日本語です");
            break;
        
        default:
            message.equals("");
          break;
            
            
    }
    out.println(message);
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
