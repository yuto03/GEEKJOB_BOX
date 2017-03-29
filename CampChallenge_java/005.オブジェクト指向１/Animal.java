/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author osakayuto
 */

public class Animal{
    public String name ="";
    public String type ="";
    public Integer age = 0 ;

    public void SetAnimal(String n,String t,Integer a){
        n=this.name;  
        t=this.type;  
        a=this.age; 
    }
    public String showName(){
        return this.name;
    }
    public String showType(){
        return this.type;
    }
    public Integer showAge(){
        return this.age;
    }
}
