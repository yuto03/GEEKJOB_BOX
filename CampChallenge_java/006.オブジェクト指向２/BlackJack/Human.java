package org.pack;


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


abstract class Human{
    public ArrayList<Integer> myCards = new ArrayList<Integer>();
    public ArrayList<Integer> hitcards = new ArrayList<Integer>();
    public ArrayList<Integer> cards = new ArrayList<Integer>();
    abstract public Integer open();
    abstract void setCard(ArrayList<Integer>cards2);
    abstract boolean checkSum();

}

