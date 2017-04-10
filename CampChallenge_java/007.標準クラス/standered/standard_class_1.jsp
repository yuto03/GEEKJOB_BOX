<%-- 
    Document   : standard_class
    Created on : 2017/04/05, 17:39:36
    Author     : osakayuto
--%>

<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.File"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //日付書き込み用date
   Date date = new Date();
   SimpleDateFormat sdf = new
   SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒");
   String sdate = sdf.format(date);
   String edate = sdf.format(date);
   ArrayList list = new ArrayList();
   
   
//   //logfileファイル生成
   File logfile = new File(application.getRealPath("file_class/test.txt"));
//   FileWriter fwa = new FileWriter(logfile,true);
//   sdate 日付を書き込む
   FileWriter fw = new FileWriter(logfile);
   BufferedWriter bw = new BufferedWriter(fw);
   for (int i = 0; i<=10; i++){
   bw.write("カウント"+i);
   }
   bw.close();
   //ファイル読み込みモード
   FileReader fr = new FileReader(logfile);
   BufferedReader br = new BufferedReader(fr);
   String str;
   out.print(sdate + "開始"+"<br>");
   while((str = br.readLine()) !=null){
    out.print(str);
    }
    out.print(edate + "終了"+"<br>");
    br.close();

 
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
