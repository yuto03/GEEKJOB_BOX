<%-- 
    Document   : cahlleng_while
    Created on : 2017/03/13, 13:14:30
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
int i=1000;
while(i > 100){    //while(条件文)がtrueのときループを実行
 out.println(i); i =i/2;
 
}

char key = 'A';
while (key != 'D'){
    switch(key){
    case'A':
    out.print("Geekjob");key = 'B';break;
                        //geekjob表示後　変数keyの中身をBに変更
    case'B':
    out.print("programing");key = 'C';break;
                        //programing表示後　変数keyの中身をCに変更
    case'C':
    out.print("camp");key = 'D';break;
                        //camp表示後　変数keyの中身をDに変更
    //caseDの条件がないのでループを終了する
}
}


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
