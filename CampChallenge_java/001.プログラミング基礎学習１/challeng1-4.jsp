<%-- 
    Document   : challeng1-4
    Created on : 2017/03/03, 12:38:30
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int tasi=1+1;
    int hiki=11-1;
    int wari=20/2;
    int kake=5*2;
    int amari=65%11;
    out.println(tasi);
    out.println(hiki);
    out.println(wari);
    out.println(kake);
    out.println(amari);
    
    int a= 1;
    out.println(a);
    //a++ ++aの注意
    out.println(++a);//先に加算処理を行って表示される
    
    out.println(a++);//この時点ではまだブラウザの表示は１のまま
    //↑の処理が抜けた後に１が加算される
    out.println(a);//ここで加算された3が表示
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
