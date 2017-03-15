<%-- 
    Document   : challeng_array
    Created on : 2017/03/13, 15:48:52
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<String> al = new ArrayList<String>();
al.add("10");
al.add("100");
al.add("soeda");
al.add("hayaashi");
al.add("-20");
al.add("118");
al.add("END");

al.remove(2);
al.set(2, "33");

//--------------------------------------------
//al.remove(0);0番目の要素を削除
//al.get(1); 1番目の要素を参照
//al.set(4,"ああああ");4番目に新要素を追加する
//al.remove(3);
//   3番目の要素が削除され{"10","100","soeda","-20","118","END"}に

//al.size();　要素数の確認

out.println(al.toString());
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
