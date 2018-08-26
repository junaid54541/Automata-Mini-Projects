/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b15101077_muhammad_junaid_siddiqui;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Junaid
 */
public class B15101077_Muhammad_Junaid_Siddiqui {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        int NoOfStates=5;
        int [] InitialStates={0,3};
        int [] FinalStates={2,4};
        int [] Array=new int[NoOfStates+2];
        ArrayList<ArrayList<Transition>> list=new ArrayList<ArrayList<Transition>>();
        for(int i=0;i<Array.length;i++)
        {
             list.add(new ArrayList<Transition>());
        }
     list.get(0).add(new Transition(1,"a"));
     list.get(1).add(new Transition(1,"b"));
     list.get(1).add(new Transition(2,"bb"));   
     list.get(2).add(new Transition(2,"a"));
     list.get(2).add(new Transition(6,""));
     list.get(3).add(new Transition(1,"aa"));
     list.get(3).add(new Transition(4,"ba"));
     list.get(4).add(new Transition(2,"b"));
     list.get(4).add(new Transition(6,""));
     list.get(5).add(new Transition(0,""));
     list.get(5).add(new Transition(3,""));
    
        /*System.out.println("Welcom to TG to RE");
        
        System.out.println("Please enter no of states");
        Scanner scan=new Scanner(System.in);
        int No_Of_States=scan.nextInt();
        */
        
    
    
     
     TgTORe TG=new TgTORe(list,NoOfStates);
     TG.TgtoRE();
     
       //System.out.println(RE);
     TG.displayList();
    }
    
}
