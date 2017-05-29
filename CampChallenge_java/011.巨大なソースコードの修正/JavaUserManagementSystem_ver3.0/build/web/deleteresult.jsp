
<%@page import="jums.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    JumsHelper jh = new JumsHelper();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    <p>削除しました。<p><br>
    <%=jh.home()%><br>
    <%=jh.search()%><br>
    
    </body>
    
</html>
