<%-- 
    Document   : challeng_jsp2_7
    Created on : 2017/03/27, 0:22:37
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%!
    


    String[] Profile_array(int x ){
    
    String ProfA[] =  {"かさ","11月12日","東京"};
    String ProfB[] =  {"かた","9月12日","横浜"};
    String ProfC[] =  {"叩き","月12日",null};
    
    if(x == 0){
        return ProfA;
    }else if(x == 1){
        return ProfB;
    }else{
        return ProfC;
    }
  //スコープ範囲
 
}

   %>
<!DOCTYPE html>

<%
    
    
        for(int i = 0; i<3; i++){
        String[] id = Profile_array(i);
        
        out.println(id[0]);
        out.println(id[1]);
       
        if(id[2]==null){
            continue;
        }else{
            out.println(id[2]);
        }
     
        }




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
