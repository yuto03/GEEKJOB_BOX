
<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    HttpSession value_empty = request.getSession();
    value_empty.removeAttribute("value_empty");
    UserDataBeans udb =(UserDataBeans)hs.getAttribute("udb");

    
/*
    巨大なソース修正１課題　タスク5 
    incetconfirmからinsert戻ってきた際値を保持するためそれぞれのフォーム内容にif条件をつけています。
    udb.getName()に値が入っていた場合にはvalueにgetAttribute()メソッドでセッション内要素を表示しています。
*/
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>

        <h1>JUMS登録画面</h1>

    <form action="insertconfirm" method="POST">
        名前:
        <% if(udb.getName()==null){ %>
        <input type="text" name="name" value="">
        <% } else{ %>
        <input type="text" name="name" value="<%=udb.getName()%>">
        <% } %>
        <br><br>
        
        生年月日:　
        <% if(udb.getStYear()==null){ %>
            <select name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"><%=i%> </option>
            <% } %>
            </select>年
            
        
         <% } else{ %>
            <select name="year">
            <option value="<%=udb.getYear()%>"><%=udb.getYear()%></option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"><%=i%> </option>
            <% } %>
            </select>年
        <% } %>
        
        <% if(udb.getStMonth()==null){ %>
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <% } else{ %>
            <select name="month">
            <option value="<%=udb.getMonth()%>"><%=udb.getMonth()%></option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
            </select>月
        <% } %>
        
        <% if(udb.getStDay()==null){ %>
        <select name="day" >
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日        

        <% } else{ %>
            <select name="day" >
            <option value="<%=udb.getDay()%>"><%=udb.getDay()%></option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
            </select>日
        <% } %>
        <br><br>

        種別:
        <br>
        
        <% if(udb.getType()==null){ %>
        <input type="radio" name="type" value="1" checked>エンジニア<br>
        <input type="radio" name="type" value="2">営業<br>
        <input type="radio" name="type" value="3">その他<br>
        <%}%>
        
        <% if(udb.getType()!=null){ %>
        <% if(udb.getType().equals("1")){ %>
        <input type="radio" name="type" value="1" checked="true">エンジニア<br>
        <input type="radio" name="type" value="2">営業<br>
        <input type="radio" name="type" value="3">その他<br>
        
        <% } else if(udb.getType().equals("2")){ %>
        <input type="radio" name="type" value="1">営業<br>
        <input type="radio" name="type" value="2" checked="true">営業<br>
        <input type="radio" name="type" value="3">その他<br>
        
        <% } else if(udb.getType().equals("3")){ %>
        <input type="radio" name="type" value="1">その他<br>
        <input type="radio" name="type" value="2">営業<br>
        <input type="radio" name="type" value="3" checked="true">その他<br>
        <%}%>
        <%}%>
        <br>
        
        
        電話番号:
        <% if(udb.getTell()==null){ %>
        <input type="text" name="tell" value="">
        
        <% } else{ %>
        <input type="text" name="tell" value="<%=udb.getTell()%>">
        <%}%>
        
        <br><br>

        自己紹介文
        <br>
        <% if(udb.getComment()==null){ %>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" ></textarea><br><br>
        
        <% } else{ %>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" ><%=udb.getComment()%></textarea><br><br>
        <%}%>
        <!--ここでvalueでセッションにacという値を取得 insertconfirmに-->
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <!--        巨大なソース修正　開発タスク１修正-->
      <%=JumsHelper.getInstance().home()%>
    </body>
</html>
