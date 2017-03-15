<%-- 
    Document   : challeng_querystring
    Created on : 2017/03/13, 17:24:59
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%
    String pool = request.getParameter("x");
    out.println("元の値"+pool);
    

    ArrayList<Integer>sosu = new ArrayList();
    sosu.add(2);
    sosu.add(3);
    sosu.add(5);
    sosu.add(7);
    
    int pools = Integer.parseInt(pool);
    
    for(int i=0; i<sosu.size(); i++){
        
        while(pools%sosu.get(i)==0){
        pools=pools/sosu.get(i);  
//            if(pools%sosu.get(i)!=0){   "pools内が0"でなければbreakしなければループ処理を抜けないので処理が思うように動かない
//            break;  
//            }
        if(pools != 1){
         out.println(pools);
        }
        }
        
    }
    if(pools==1){
        out.println("あまり0");
    }else{
    out.println("あまり"+pools);
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
