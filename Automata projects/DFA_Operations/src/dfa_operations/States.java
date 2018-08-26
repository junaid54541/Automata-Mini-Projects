/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_operations;

/**
 *
 * @author Junaid
 */
public class States {
    
    int x;
    int y;

    public States() {
        
    }

    public States(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "State{" + "x=" + x + ", y=" + y + '}';
    }
    public boolean equal1(States s){
    return ((this.x==s.x)&&(this.y==s.y));
    
    }
    
    
}
