/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b15101077_muhammad_junaid_siddiqui;

/**
 *
 * @author Junaid
 */
public class Transition {
    
    String str;
         int state;
        public Transition(int state,String str)
        {
            this.str = str;
            this.state = state;
        }
        public void setString(String s)
        {
            this.str = s;
        }
        public String getString()
        {
            return this.str;
        }
        public void setState(int st)
        {
            this.state = st;
        }
        public int getState()
        {
            return this.state;
        }
        public String toString()
        {
           String Strng="State :"+this.state+" String :"+this.str;
           return Strng;
        }
}
