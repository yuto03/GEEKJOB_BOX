<%@page import="java.util.ArrayList"
        import="jums.JumsHelper"
        import="jums.UserDataDTO"%>
<%
    /*
    巨大なソース修正2
    検索結果の表示とUpdate並びDeleteへのリンクの設定
    */
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)request.getAttribute("resultData");
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        <table border=1>
        <tr>
        <th>名前</th>
        <th>生年</th>
        <th>種別</th>
        <th>電話番号</th>
        <th>コメント</th>
        <th>登録日時</th>
        </tr>
        
        <tr>
        <td>名前:<%=udd.getName()%></a></td>
        <td>生年月日:<%=udd.getBirthday()%></td>
        <td>種別:<%=jh.exTypenum(udd.getType())%></td>
        <td>電話番号:<%=udd.getTell()%></td>
        <td>コメント:<%=udd.getComment()%></td>
        <td>登録日時:<%= udd.getNewDate()%></td>
        </tr>
        </table>
        <form action="Update" method="POST">
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="hidden" value="<%hs.setAttribute("resultData",udd);%>"><!--hs.setAttribute(udd)をupdete送る-->
        <input type="submit" name="update" value="変更設定ページへ"style="width:100px">
        </form>
        <form action="Delete" method="POST">
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="hidden" value="<%hs.setAttribute("resultData",udd);%>"><!--hs.setAttribute(udd)をDelete送る-->
        <input type="submit" name="delete" value="削除確認ページへ"style="width:100px">
        </form>
        <%=jh.home()%>
    </body>
</html>
