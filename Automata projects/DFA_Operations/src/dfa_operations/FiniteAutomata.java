/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_operations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Junaid
 */
public class FiniteAutomata {
 
      int States;
    String[] validChars;
    int[][] TranTable;
    int InitState;
    int[] FinalStates;

     public FiniteAutomata(int S, String VC[], int[][] TT, int IS, int[] FS) {
        this.States = S;
        validChars = new String[VC.length];
        this.validChars = VC;
        TranTable = new int[S][VC.length];
        this.TranTable = TT;
        this.InitState = IS;
        this.FinalStates = FS;
    }

    boolean validate(String inputChars) {
        int CS = InitState;
        for (int i = 0; i < inputChars.length(); i++) {
            CS = transition(CS, inputChars.substring(i, i + 1));
        }
        for (int i = 0; i < FinalStates.length; i++) {
            if (CS == FinalStates[i]) {
                return true;
            }
        }
        return false;
    }

    int transition(int st, String ch) {
        int pos = 0;
        for (int i = 0; i < validChars.length; i++) {
            Pattern p = Pattern.compile(validChars[i]);
            Matcher m = p.matcher(ch);
            if (m.matches()) {
                pos = i;
                break;
            }
        }
        return TranTable[st][pos];
    }
    }
    
    

