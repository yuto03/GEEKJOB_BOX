<%-- 
    Document   : challeng_jsp2_3
    Created on : 2017/03/23, 14:52:25
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    
    String getName(){
    return getName("ゆうと");//デフォルト値
}
    String getName(String namae){
    return namae+"さん";
}
    
    String getHikisuu(int a){
        if(a%2==0){
            return"偶数";
        }else{
            return"奇数";
        }
    } 


    %>
    
    <%
     String myname = getName();
     out.println(myname);
     
     String hikisuu = getHikisuu(60);
     out.println(hikisuu);

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
