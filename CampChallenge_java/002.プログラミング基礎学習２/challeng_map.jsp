<%-- 
    Document   : challeng_map
    Created on : 2017/03/13, 17:03:27
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%
    //Mapクラスでは、指定型をキーに要素管理が可能
    //              ⇅違い
    //ArratListは各要素を番号管理をしている
HashMap<String,String>hMap = new HashMap<String,String>();
hMap.put("1","AAA");
hMap.put("hello","World");
hMap.put("soeda","33");
hMap.put("20","20");

out.println(hMap);

HashMap<String,Integer>a = new HashMap<String,Integer>();
a.put("AAA",100);
a.put("AAA",10);
a.put("AAA",1);
out.println(a);

//キーが同じで要素が違う場合一番の要素が表示される
//-----------------------------
//HashMap<String,String>hMap = new HashMap<String,String>();
// a.put("AAA","1");　要素の追加
// a.get("AAA"); 参照
// a.remove("AAA","1");要素の削除
// a.size();　要素の取得

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
