<%-- 
    Document   : challeng6
    Created on : 2017/03/06, 15:56:09
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String sougaku = request.getParameter("total");
String kosuu = request.getParameter("number");
String syubetu = request.getParameter("another");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(syubetu.equals("1")){
                
                out.println("雑貨");
                
            }else if(syubetu.equals("2")){
                
                out.println("生鮮食品");
                
            }else if(syubetu.equals("3")){
                
                out.println("その他");
            }
            int sougaku2 = Integer.parseInt(sougaku);
            int kosuu2 = Integer.parseInt(kosuu);
            out.println(sougaku2/kosuu2);
            int buukomi = sougaku2/kosuu2;
            if(buukomi > 5000){
                out.println(buukomi+buukomi*0.05);
            }else if(buukomi > 3000){
                out.println(buukomi+buukomi*0.04);
            }else if(buukomi > 1000){
                out.println(buukomi + 10);
            }else{
                out.println(buukomi);
            }
        %>
        
            
            
          
    </body>
</html>
