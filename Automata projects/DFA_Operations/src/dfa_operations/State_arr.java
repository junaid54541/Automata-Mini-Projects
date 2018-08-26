/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_operations;

import java.util.ArrayList;

/**
 *
 * @author Junaid
 */
public class State_arr {
    
    int x;
    ArrayList<Integer> y;

    public State_arr() {
    }

    public State_arr(int x, ArrayList<Integer> y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public ArrayList<Integer> getY() {
        return y;
    }

    public void setY(ArrayList<Integer> y) {
        this.y = y;
    }
    
    public boolean equal1(State_arr s){
    int si=0;
    boolean check=false;
    if(s.y.size()==this.y.size())
        check=false;
        
    
    if(check!=false && this.x==s.x){
        for (int i = 0; i < si; i++) {
            if(this.y.get(i)==s.y.get(i))
                check=true;
            else
                check=false;
        }
    }
    return check;
    }

    @Override
    public String toString() {
        return "State_arr{" + "x=" + x + ", y=" + y + '}';
    }
    
    
    
}
