/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending.machine;


import java.util.Scanner;

/**
 *
 * @author Junaid
 */
public class VendingMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
         
        Scanner scan=new Scanner(System.in);
        int[] price={20,30,40};
        
        //for identifier
        int States1=6;
        int[][] tt1={{1,2,4},{2,3,4},{3,5,4},{4,5,6},{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        String[] Inp={"5","10","20"};
        int ist1=0;
        int[] fst1={4,5,6};
        dfa obj1=new dfa(States1,ist1,tt1,Inp,fst1);
      
        
        
        //for 
        int states2=9;
        int[][] tt2={{1,2,4},{2,3,5},{3,4,6},{4,5,6},{5,7,8},{6,7,8},{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        int ist2=0;
        int[] fst2={6,7,8};
        dfa obj2=new dfa(states2,ist2,tt2,Inp,fst2);
      
        
        
        
        int states3=11;
        int[][] tt3={{1,2,4},{2,3,5},{3,4,6},{4,5,7},{5,6,8},{6,7,8},{7,8,9},{8,10,9},{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        int ist3=0;
        int[] fst3={8,9,10};
        dfa obj3=new dfa(states3,ist3,tt3,Inp,fst3);
       
        
        /*//for character
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
    */
            int deposited_amount=0;
            System.out.println("\n-----------------------Select Item No--------------------------");
            System.out.println(" 1. biscuit \t *Prize=20\n 2. snakes \t *Prize=30 \n 3. juice \t *Prize=40");
            int row = scan.nextInt() ;
            int b=row;

            if (b >= 1 && b <= 3 == false)
            {
                System.out.println("\n---------Error------------- \n------------Insert correct option----------------");
            }
            
            
            int temp=1;
            int cs=0;
            if(b==1){
                
                while(temp==1){
            System.out.println("\n---------------------Insert any of these coins----------------------");
            System.out.println("  1. 5Rs \n 2. 10Rs \n 3. 20Rs");
            String inp = scan.next();
            if(inp.equalsIgnoreCase("5") || inp.equalsIgnoreCase("10") || inp.equalsIgnoreCase("20")){
            cs=obj1.transition(cs,inp);
            deposited_amount+=Integer.parseInt(inp);
            System.out.println("Your deposited amount: "+deposited_amount);
                for (int i = 0; i < fst1.length; i++) {
                    if(cs==fst1[i]){
                        temp=0;
                        break;
                    }  
                }
            }
            else{
                System.out.println("\n---------Error------------- \n------------Insert correct option----------------");
                System.out.println("Your deposited amount: "+deposited_amount);
            }    
                }//while ends
            }
            
            if(b==2){
                
                while(temp==1){
            System.out.println("\n---------------------Insert any of these coins----------------------");
            System.out.println("  1. 5Rs \n 2. 10Rs \n 3. 20Rs");
            String inp = scan.next();
            if(inp.equalsIgnoreCase("5") || inp.equalsIgnoreCase("10") || inp.equalsIgnoreCase("20")){
            cs=obj2.transition(cs,inp);
            deposited_amount+=Integer.parseInt(inp);
            System.out.println("Your deposited amount: "+deposited_amount);
                for (int i = 0; i < fst2.length; i++) {
                    if(cs==fst2[i]){
                        temp=0;
                        break;
                    }  
                }
            }
            else{
                System.out.println("\n---------Error------------- \n------------Insert correct option----------------");
                System.out.println("Your deposited amount: "+deposited_amount);
            }
                }//while ends
            }
            
            if(b==3){
                
                while(temp==1){
            System.out.println("\n---------------------Insert any of these coins----------------------");
            System.out.println("  1. 5Rs \n 2. 10Rs \n 3. 20Rs");
            String inp = scan.next();
            if(inp.equalsIgnoreCase("5") || inp.equalsIgnoreCase("10") || inp.equalsIgnoreCase("20")){
            cs=obj3.transition(cs,inp);
            deposited_amount+=Integer.parseInt(inp);
            System.out.println("Your deposited amount: "+deposited_amount);
                for (int i = 0; i < fst3.length; i++) {
                    if(cs==fst3[i]){
                        temp=0;
                        break;
                    }  
                }
            }
            else{
                System.out.println("\n---------Error------------- \n------------Insert correct option----------------");
                System.out.println("Your deposited amount: "+deposited_amount);
            }   
                }//while ends
                
            }
            
            if(deposited_amount>price[b-1]){
            String message= " Rs added more than actual price, please receive it";
                System.out.println((deposited_amount-price[b-1])+message);
                System.out.print("And ");
            }
            if(b==1)
                System.out.println("Biscuit is dispended to you");
            if(b==2)
                System.out.println("Snakes is dispended to you");
            if(b==3)
                System.out.println("Juice is dispended to you");
        // TODO code application logic here
    }
}
    

