<%@page import="jums.UserDataBeans"%>
<%@page import="java.util.Enumeration"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    HttpSession value_empty = request.getSession();
    UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <%/*
       巨大なソース修正１　課題タスク4
　　　　　if(!hs.getAttribute("name").equals(""))でif条件分岐を行うとinsert.jspから受け取ったnameの値が入っていれば他の要素が未入力でも通過してしまいます。
　　　　　if条件としてセッションvalue_emptyの要素の有無により分岐させています。
　　　　　.セッションvalue_emptyに要素がなければ登録確認画面へ
        .セッションvalue_emptyに要素があれば入力が不完全な部分を表示し指摘しています。
    */%>

    <h1>登録確認</h1>
    <% if(value_empty.getAttribute("value_empty") == null){ %>
            
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>

        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>"><!--不正アクセス防止用セッションの取得-->
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        
        <h1>入力が不完全です</h1>
        <%if(udb.getName().equals("")){%>
        <p>お名前を入力してください。</p>
        <%}%>
        
        <%if(udb.getStYear().equals("")){%>
        <p>生年月日：年を入力してください。</p>
        <%}%>
        
        <%if(udb.getStMonth().equals("")){%>
        <p>生年月日：月を入力してください。</p>
        <%}%>
        
        <%if(udb.getStDay().equals("")){%>
        <p>生年月日：日を入力してください。</p>
        <%}%>
        
        <%if(udb.getType().equals("")){%>
        <p>職種を入力してください。</p>
        <%}%>
        
        <%if(udb.getTell().equals("")){%>
        <p>電話番号を入力してください。</p>
        <%}%>
        
        <%if(udb.getComment().equals("")){%>
        <p>コメントを入力してください。</p>
        <%}%>
            

    <% } %>

        <form action="insert" method="POST">
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="no" value="登録画面に戻る">
        </form>
<!--        巨大なソース修正　開発タスク１修正-->
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
