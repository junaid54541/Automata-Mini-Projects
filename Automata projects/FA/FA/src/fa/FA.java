/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa;

import java.util.Scanner;

/**
 *
 * @author Syed Taha Alam
 */
public class FA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       char [] chars={'a','b'};
        int [][] transition={{1,2},{0,3},{3,0},{2,1}};
       int state=4;
       int[] finalState={0};
       int initialState=0;
       
       Automata automata=new Automata(state, chars, transition, initialState, finalState);
       
        System.out.println(automata.trueStatement("aaababbb"));
       
        
        
    }
    
}
