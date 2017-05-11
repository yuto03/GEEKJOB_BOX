/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author osakayuto
 */
/*
巨大なソース修正１課題 タスク６
入力された生年月日の情報を正しく格納するため。
public Date getBirthday();メソッドを作っています。
・insertConfirmで格納した
    private int year;
    private int month;
    private int day;
をCalendarオブジェクトにsetしDate型で出力しています。
*/
public class UserDataBeans implements Serializable {

    private String name;
    private int year;
    private int month;
    private int day;
    private String styear;
    private String stmonth;
    private String stday;
    private String tell;
    private String type;
    private String comment;
    private Timestamp newDate;
    private Date birthday;
    
    

    public UserDataBeans(){}
     
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public int getYear(){
        return this.year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getMonth(){
        return this.month;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public int getDay(){
        return this.day;
    }
    public void setDay(int day){
        this.day = day;
    }    
    
    public String getStYear(){
        return this.styear;
    }
    public void setStYear(String styear){
        this.styear = styear;
    }
    
    public String getStMonth(){
        return this.stmonth;
    }
    public void setStMonth(String stmonth){
        this.stmonth = stmonth;
    }

    public String getStDay(){
        return this.stday;
    }
    public void setStDay(String stday){
        this.stday = stday;
    }    
    public String getTell(){
        return this.tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
    
    public String getComment(){
        return this.comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
        public Timestamp getNewDate() {
        return this.newDate;
    }
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }
    
    public Date getBirthday(){
        Calendar birthday = Calendar.getInstance();
        birthday.set(this.year, this.month - 1 , this.day);
        this.birthday = birthday.getTime();    
        return this.birthday;
    }
    

    
    


}
