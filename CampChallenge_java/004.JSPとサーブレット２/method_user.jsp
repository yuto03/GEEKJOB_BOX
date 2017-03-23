<%-- 
    Document   : method_user
    Created on : 2017/03/23, 14:01:50
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    //ユーザー定義メソッド作成　フィールド
   String getMyprofile(){
        return"大坂"+"<br>"+"19xx年 x月x日"+"<br>"+"よろしくお願いします"+"<br>";
}
%>
<%//結果の表示
String profile = getMyprofile();
for(int i =0; i<10; i++){
out.print(profile);
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
    </body>
</html>
