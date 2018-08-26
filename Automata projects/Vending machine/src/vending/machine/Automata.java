/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending.machine;

/**
 *
 * @author Junaid
 */
public class Automata {
 
    private final int noOfState;
    private final String [] inputCharacter;
    private final int [][] transitionOfState;
    private final int initialState;
    private final int [] finalState;

    public Automata(int noOfState, String[] inputCharacter, int[][] transitionOfState, int initialState, int[] finalState) {
        this.noOfState = noOfState;
        this.inputCharacter = inputCharacter.clone();
        this.transitionOfState = transitionOfState.clone();
        this.initialState = initialState;
        this.finalState = finalState.clone();
    }
    
    /**
     * it will return whether the statement is true or not according to the given finite state machine
     * @param given array that holds the input character
     * @return true||false on the basis of the matching state 
     */
    /*public boolean trueStatement(String given){
        int cs=initialState;
        
        for (int i = 0; i < given.length(); i++) {
            cs=transition(cs,given.charAt(i));
             if(cs==-1){
                 return false;
             }
            
        }
        
        
        return verifyFinalState(cs); 
    }*/
    /**
     * match the state with the final state
     * @param state current state
     * @return 
     */
    public boolean verifyFinalState(int state){
        for (int i = 0; i < finalState.length; i++) {
            if(state==finalState[i])
                return true;
        }
        
        return false;
    }
    /**
     * return the transition from the current state to the next possible state
     * @param state current state
     * @param currentCharacter current character
     * @return the next state
     */
    public int transition(int state,String currentCharacter){
        int ind=getIndex(currentCharacter);
        if(ind ==-1)
            return -1;
        else
        return transitionOfState[state][ind];
    }
    
    
    /**
     * returns the column index of the Transition Table
     * @param givenCharacter the character to be checked
     * @return the value of the column if the givenCharacter is in the array else return -1
     */
    private int getIndex(String givenCharacter){
        int i=0;
        for(;i<this.inputCharacter.length;i++){
            if(givenCharacter==this.inputCharacter[i])
               return i;
        }
       
            return 0;
    }
    
    
}
