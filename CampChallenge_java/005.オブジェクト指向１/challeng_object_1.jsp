<%-- 
    Document   : challeng_object_1
    Created on : 2017/03/27, 23:39:11
    Author     : osakayuto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    //抽象化２
public class Animal{
    public String name ="";
    public String type ="";
    public Integer age = 0 ;

    public void setAnimal(String n,String t,Integer a){
        n=this.name;  
        t=this.type;  
        a=this.age; 
    }
    public void showName(){
        System.out.println(this.name);
    }
    public void showType(){
        System.out.println(this.type);
    }
    public void showAge(){
        System.out.println(this.age);
    }
%>
<!DOCTYPE html>
<%
        Animal s =new Animal();
        s.setAnimal("風太","レッサーパンダ",3);
        
        s.showName();
        s.showType();
        s.showAge();
        
        s.name = "クマ";
        s.type = "ぷー";
        s.age = 2;
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
