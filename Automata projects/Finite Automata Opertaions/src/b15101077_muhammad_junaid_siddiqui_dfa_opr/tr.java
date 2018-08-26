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
public class tr {
 char ch;
         int state;
        public tr(int state,char ch)
        {
            this.ch = ch;
            this.state = state;
        }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "tr{" + "ch=" + ch + ", state=" + state + '}';
    }
          
}
