<%@page import="org.joda.time.DateTime"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper" %>
<%
    /*巨大なソース修正2　
    html requiredを設定入力がなければその場でポップアップエラー表示します。safari未対応です
    */
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)session.getAttribute("resultData");
    DateTime date = new DateTime(udd.getBirthday());
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
         
    <form action="UpdateResult?id=<%= udd.getUserID()%>" method="POST">

        名前:
        <input type="text" name="name" value="<%if(!udd.getName().equals("")){out.print(udd.getName());}%>" required="">
        <br><br>

        生年月日:　
        <select name="year" required="">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <%if(date.getYear() == i){out.print("selected = \"selected\"");}%>><%=i%></option>
            <% } %>
        </select>年
        <select name="month" required="">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"<%if(date.getMonthOfYear() == i){out.print("selected = \"selected\"");}%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day" required="">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"<%if(date.getDayOfMonth() == i){out.print("selected = \"selected\"");}%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input required type="radio" name="type" value="<%=i%>"<%if(udd.getType() == i){out.print("checked = \"checked\"");}%>><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<% if(udd.getTell()!=null){out.print(udd.getTell());}%>" required="">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" required=""><% if(udd.getComment()!=null){out.print(udd.getComment());}%></textarea><br><br>
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        
        <input type="submit" name="btnSubmit" value="更新を確定する">
    </form>
        <br>
        <%=jh.search()%>
        <br>
        <%=jh.home()%>
    </body>
</html>
