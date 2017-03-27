<%-- 
    Document   : challeng_jsp2_7
    Created on : 2017/03/27, 0:22:37
    Author     : osakayuto
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>


<%!
    //ユーザー定義メソッド作成　フィールド
String getProfile(int getid){
    String a = ("ナカメ太郎"+"<br>"+"1999/12/19"+"<br>"+"神奈川県"+"<br>");
    String b = ("南　波奈"+"<br>"+"1980/06/07"+"<br>"+"新潟県"+"<br>");
    String c = ("喜田木　瀧太"+"<br>"+"1999/12/19"+"<br>"+"神奈川県"+"<br>");
    String profile = "";
    
    switch(getid){
        case 1:
        profile=a; break;
        
        case 2:
        profile=b; break;
        
        case 3:   
        profile=c; break;
        
        default:
            break;
}
 return profile;
   
}
   %>
<!DOCTYPE html>

<%
//引数と戻り値1課題
String display = getProfile(2);
out.println(display) ;

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
