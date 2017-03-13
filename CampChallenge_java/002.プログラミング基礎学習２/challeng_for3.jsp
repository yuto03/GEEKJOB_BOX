<%-- 
    Document   : challeng_for3
    Created on : 2017/03/09, 17:48:45
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%


int sum1 = 0;
int sum2 = 0;
for(int count=0; count < 100; count++ ){
    sum1++; 
    sum2 += sum1;
    out.println(sum2);
}

out.println(sum2);


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
