/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhammadjunaidsiddiqui_b15101077;

import java.util.Scanner;

/**
 *
 * @author junaid
 */
public class MuhammadJunaidSiddiqui_B15101077 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         System.out.println("Enter String");
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
        
        //for identifier
        int States_I=4;
        int[][] tt_I={{2,3,1},{2,2,1},{2,2,2},{3,3,3},{4,4,4}};
        String[] RE_I={"[A-Za-z]","[0-9]","_"};
        int ist1=0;
        int[] fst_I={2};
        dfa obj1=new dfa(States_I,ist1,tt_I,RE_I,fst_I);
      
        
        
        //for integer
        int states_in=4;
        int[][] tt_in={{1,2},{3,2},{3,2},{3,3},{4,4}};
        String[] RE_in={"[+-]","[0-9]"};
        int ist_in=0;
        int[] fst_in={2};
        dfa obj2=new dfa(states_in,ist_in,tt_in,RE_in,fst_in);
      
        
        
        //for float
        int states_f=8;
        int[][] tt_f={{2,1,3,2},{1,1,1,1},{2,1,3,1},{4,1,1,1},{4,5,1,1},{7,1,1,6},{7,1,1,1},{7,1,1,1}};
        String[] RE_f={"[0-9]","e","[.]","[+-]"};
        int ist_f=0;
        int[] fst_f={4,7};
        dfa obj3=new dfa(states_f,ist_f,tt_f,RE_f,fst_f);
       
        
        //for character
        int states_chr=6;
        int[][] tt_chr={{5,1,5,5},{2,2,3,3},{5,4,3,5},{5,4,5,5},{5,5,5,5},{5,5,5,5},{5,5,5,5}};
        String[] RE_chr={"(\\\\)","'","\\\\\"|n|b|t|r|0","[^'nbtr0]"};
        int ist_chr=0;
        int[] fst_chr={4};
        dfa obj4=new dfa(states_chr,ist_chr,tt_chr,RE_chr,fst_chr);
    
        
         
        //for string
        int states_str=5;
        int[][] tt_str={{1,4},{3,2},{3,2},{3,2},{4,4},{4,4}};
        String[] RE_str={"\"","[^\"]"};
        int ist_str=0;
        int[] fst_str={3};
        dfa obj5=new dfa(states_str,ist_str,tt_str,RE_str,fst_str);
    
        
        if(obj1.validate(input))
            System.out.println("It is an identifier");
        else{
            if(obj2.validate(input))
                System.out.println("It is an integer");
            else{
                if(obj3.validate(input))
                    System.out.println("It is a float");
                else{
                    if(obj4.validate(input))
                        System.out.println("It is a character");
                    else{
                        if(obj5.validate(input))
                            System.out.println("It is a string");
                        else
                            System.out.println("Not Valid");
                    }
                }
            }
            }
    }
    }
    

