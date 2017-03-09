<%-- 
    Document   : challeng2-1
    Created on : 2017/03/08, 13:39:34
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  //switch文
int num = 1; String message = "";
switch(num){
    case 1: 
        message = "one";
        break;
       
    case 2:
         message = "two";
         break;
         
    default:
        message = "それ意外です";
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
        
    </body>
</html>
