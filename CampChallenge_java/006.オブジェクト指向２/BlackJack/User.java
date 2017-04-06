package org.pack;


import static java.lang.System.out;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author osakayuto
 */
public class User extends Dealer{
   
    public void setCard(ArrayList<Integer> cards2){
    for(int i = 0; i<cards2.size(); i++){
    myCards.add(cards2.get(i));
    }
    }
      
    public boolean checkSum(){
    int sum = open();
    if( sum <= 15){
    return true;
    }else{
    return false;
    }
    }
   
    public Integer open(){
    int open = 0;
    for(int i =0; i<myCards.size(); i++){
    open = open + myCards.get(i) ;
    }
    return open;
    }
    }
