<%@page import="java.util.ArrayList"
        import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    /*
    巨大なソース修正2
    ArrayList<UserDataDTO> uddの中身がなければ該当するデータ
    */
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>)request.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <%
            if(udd.size()==0){
                out.print("該当するデータは存在しません");
            }  
        %>
        
            <table border=1>
        <tr>
            <th>名前</th>
            <th>生年</th>
            <th>種別</th>
            <th>登録日時</th>
        </tr>

        
        <%
        if(udd.size()!=0){
        int i = 0;
        for(i = 0; i < udd.size(); i++){ 
        %>
        <tr>
        <td>名前:<a href="ResultDetail?id=<%= udd.get(i).getUserID()%>"><%=udd.get(i).getName()%></a></td>
        <td>生年月日:<%= udd.get(i).getBirthday()%></td>
        <td>種別:<%= jh.exTypenum(udd.get(i).getType())%></td>
        <td>登録日時:<%= udd.get(i).getNewDate()%></td>
        </tr>
        <%}%>
        <%}%>
        
        </table>
         
    </body>
    
    <br>
    <%=jh.home()%>
</html>
