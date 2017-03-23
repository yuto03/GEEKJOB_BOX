<%-- 
    Document   : fortuneTellingResult.jsp
    Created on : 2017/03/21, 22:13:48
    Author     : osakayuto
--%>
<%@page import="org.camp.servlet.ResultData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
         ResultData data = (ResultData)request.getAttribute("DATA");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (data != null) {
                out.print("<h1>あなたの"+data.getD()+"の運勢"+data.getLuck()+"です!</h1>");
            }
        %>
        <h1>Hello World!</h1>
    </body>
</html>
