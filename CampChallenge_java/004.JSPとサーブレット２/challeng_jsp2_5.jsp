<%-- 
    Document   : challeng_jsp2_5
    Created on : 2017/03/26, 19:38:34
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%!
    //ユーザー定義メソッド作成　フィールド
   boolean Type(){
   boolean typeList[] ={true,false};
   Random rand =new Random();
   Integer index = rand.nextInt(typeList.length);
   return typeList[index];
}
   %>
<!DOCTYPE html>

<%
//戻り値1課題
Boolean judge =Type();
if( judge ==true){
    out.println("この処理は正しく処理されました。");
}else{
    out.println("この処理は正しく処理されませんでした。");
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
