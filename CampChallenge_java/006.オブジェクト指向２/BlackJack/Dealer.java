package org.pack;


import static java.lang.System.out;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author osakayuto
 */
public class Dealer extends Human {
    //カードをセット
    Dealer(){
    for(int o = 0; o<4; o++){
    for(int i = 1; i<14; i++){
    if(i<10){
    cards.add(i); 
    }else{
    cards.add(10); 
    } 
    }
    }
    }
    //cards2へランダムに2つ数値を返す
    public ArrayList<Integer> deal(){
        ArrayList<Integer> cards2 = new ArrayList<Integer>();
        Collections.shuffle(cards);
        Integer result = cards.get(0);
        cards2.add(result);
        Integer result2 = cards.get(1);
        cards2.add(result2);
        return cards2;
          
    }
    //cards2へランダムに2つ数値を返す
        public ArrayList<Integer> hit(){
        ArrayList<Integer> cards2 = new ArrayList<Integer>();
        Collections.shuffle(cards);
        Integer result = cards.get(0);
        cards2.add(result);
        return cards2;
  
    }
    //ランダムで受け取った要素をmyCardsに追加
    public void setCard(ArrayList<Integer> cards2){
    for(int i = 0; i<cards2.size(); i++){
    myCards.add(cards2.get(i));
    }
    }
    //open()の合計値を判定
    public boolean checkSum(){
      int sum = open();
      if(sum < 15){
      return true;
      }else{
      return false;
      }
  }
  //myCardsの合計
   public Integer open(){
    int open = 0;
    for(int i =0; i<myCards.size(); i++){
    open = open + myCards.get(i) ;
    }
    return open;
    }





//    @Override
//    void Open() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

  
}


    


    
      

    


    

