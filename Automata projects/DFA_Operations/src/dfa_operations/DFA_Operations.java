/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_operations;

import java.util.Scanner;

/**
 *
 * @author Junaid
 */
public class DFA_Operations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String[] VC = {"a", "b"};
        int S1 = 2;
        int IS1 = 0;
        int FS1[] = {1};
        int[][] TranTable1 = {{1, 0}, {1, 0}};

//        int S2 = 3;
//        int IS2 = 0;
//        int FS2[] = {2};
//        int[][] TranTable2 = {{1, 0}, {1, 2}, {2, 2}};
        int S2 = 3;
        int IS2 = 0;
        int FS2[] = {2};
        int[][] TranTable2 = {{1, 0}, {1, 2}, {2, 2}};

        FiniteAutomata DFA1 = new FiniteAutomata(S1, VC, TranTable1, IS1, FS1);
        FiniteAutomata DFA2 = new FiniteAutomata(S2, VC, TranTable2, IS2, FS2);
        Operations O1 = new Operations(DFA1, DFA2);
        FiniteAutomata ODFA = O1.DFACOMPLIMENT(DFA1);

        System.out.println("States\n" + ODFA.States);
        System.out.println("Initial state\n" + ODFA.InitState);
        System.out.println("Final States");
        for (int i = 0; i < ODFA.FinalStates.length; i++) {
            System.out.print(ODFA.FinalStates[i] + ",");
        }
        System.out.println();
        System.out.println("Transition Table");
        for (int i = 0; i < ODFA.TranTable.length; i++) {
            for (int j = 0; j < ODFA.validChars.length; j++) {
                System.out.print(ODFA.TranTable[i][j] + ",");
            }
            System.out.println();
        }
/*
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter input");
        String InputCharacter = scan.next();
        boolean valid = ODFA.validate(InputCharacter);
        if (valid == true) {
            System.out.println("Valid");
        } else if (valid == false) {
            System.out.println("Invalid");
        } else {
            System.out.println("Invalid input characters");

        }
*/
    }

}
