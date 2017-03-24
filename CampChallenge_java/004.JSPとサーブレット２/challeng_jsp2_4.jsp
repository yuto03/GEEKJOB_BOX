<%-- 
    Document   : challeng_jsp2_4
    Created on : 2017/03/23, 16:09:44
    Author     : osakayuto
--%>
<%@page import ="java.util.ArrayList"%>
<%@page import ="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!

//typeデフォルト値
boolean Type(){
    //ランダムでtrue false選択
    Boolean typeList[] ={true,false};
    Random rand = new Random();
     Integer index = rand.nextInt(typeList.length);
    return typeList[index];
    
    //boolean type = false;//boolean の中身にfalse か　trueを入れる  ：falseでそのまま表示　trueで2乗する
    //return type; //Mainの引数にtypeを返す
}
//mainのメソッド
int Main(int AAA,int BBB){
    return AAA*BBB;
}
%>
<%
boolean boo=Type();//typeメソッドを変数に入れる
int a = Main(6,5);
if(boo==false){
    out.println(a);  
}else{
    out.println(a*a);
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
