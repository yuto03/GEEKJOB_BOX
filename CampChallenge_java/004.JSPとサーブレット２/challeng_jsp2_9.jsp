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
    
    String ProfA[] =  {"南　波奈","11月12日","東京"};
    String ProfB[] =  {"北木　瀧太","9月12日","横浜"};
    String ProfC[] =  {"木崎　咲","月12日",null};
    String[] profile = {};
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
    
        Integer limit = 2;
        for(int i = 0; i<limit; i++){
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
