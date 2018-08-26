/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b15101077_muhammad_junaid_siddiqui_dfa_opr;

import java.util.ArrayList;

/**
 *
 * @author Junaid
 */
public class B15101077_Muhammad_Junaid_Siddiqui_Dfa_Opr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
           //FOr DFA1
        int NoOfStates=2;
        int InitialStates=0;
        int [] FinalStates={1};
        int [] Array=new int[NoOfStates];
        ArrayList<ArrayList<tr>> DFA1=new ArrayList<ArrayList<tr>>();
        for(int i=0;i<Array.length;i++)
        {
             DFA1.add(new ArrayList<tr>());
        }
     DFA1.get(0).add(new tr(1,'a'));
     DFA1.get(0).add(new tr(0,'b'));
     DFA1.get(1).add(new tr(1,'a'));   
     DFA1.get(1).add(new tr(0,'b'));
     
     
     /*DFA1.get(2).add(new tr(3,'a'));
     DFA1.get(2).add(new tr(3,'b'));
     DFA1.get(3).add(new tr(4,'b'));
     DFA1.get(3).add(new tr(2,'a'));
     DFA1.get(4).add(new tr(1,'a'));
     DFA1.get(4).add(new tr(2,'b'));*/
     
     
     
     //FOr DFA2
     /*
        int NoOfStates_2=3;
        int InitialStates_2=0;
        int [] FinalStates_2={2};
        int [] Array_2=new int[NoOfStates_2];
        ArrayList<ArrayList<tr>> DFA2=new ArrayList<ArrayList<tr>>();
        for(int i=0;i<Array_2.length;i++)
        {
             DFA2.add(new ArrayList<tr>());
        }
     DFA2.get(0).add(new tr(1,'a'));
     DFA2.get(0).add(new tr(0,'b'));
     DFA2.get(1).add(new tr(1,'a'));
     DFA2.get(1).add(new tr(2,'b'));
     DFA2.get(2).add(new tr(2,'a'));
     DFA2.get(2).add(new tr(2,'b'));
     
     DFA_Operations dfaopr= new DFA_Operations(NoOfStates,NoOfStates_2,InitialStates, FinalStates, InitialStates_2, FinalStates_2,DFA1, DFA2);
    */
     
     
     int NoOfStates_2=4;
        int InitialStates_2=0;
        int [] FinalStates_2={3};
        int [] Array_2=new int[NoOfStates_2];
        ArrayList<ArrayList<tr>> DFA2=new ArrayList<ArrayList<tr>>();
        for(int i=0;i<Array_2.length;i++)
        {
             DFA2.add(new ArrayList<tr>());
        }
     DFA2.get(0).add(new tr(1,'a'));
     DFA2.get(0).add(new tr(2,'b'));
     DFA2.get(1).add(new tr(3,'a'));
     DFA2.get(1).add(new tr(2,'b'));
     DFA2.get(2).add(new tr(1,'a'));
     DFA2.get(2).add(new tr(3,'b'));
     DFA2.get(3).add(new tr(3,'a'));
     DFA2.get(3).add(new tr(3,'b'));
     
     DFA_Operations dfaopr= new DFA_Operations(NoOfStates,NoOfStates_2,InitialStates, FinalStates, InitialStates_2, FinalStates_2,DFA1, DFA2);
    
     
     
     
     dfaopr.ADD_DFAs(DFA1, DFA2);
     dfaopr.display_StateCombs();
    /* int[] val=dfaopr.Complement(DFA2);
        for (int i = 0; i < val.length; i++) {
            System.out.println("    "+val[i]);
        }
     */
    
    
    
    
     
        
    }
    
}
