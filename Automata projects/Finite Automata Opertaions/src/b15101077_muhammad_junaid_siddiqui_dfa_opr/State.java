/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b15101077_muhammad_junaid_siddiqui_dfa_opr;

/**
 *
 * @author Junaid
 */
public class State {
    int x;
    int y;

    public State() {
        
    }

    public State(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return  x+""+y;
    }
    
    
}
