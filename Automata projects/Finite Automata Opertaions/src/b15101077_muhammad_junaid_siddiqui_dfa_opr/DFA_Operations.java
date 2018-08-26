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
public class DFA_Operations {
    
    private int NoOfSt_1;
    private int NoOfSt_2;
    private int IS_1;
    private int[] FS_1;
    private int IS_2;
    private int[] FS_2;
    private char[] No_Char={'a','b'};
    private ArrayList<ArrayList<tr>> tt_1=new ArrayList<ArrayList<tr>>();
    private ArrayList<ArrayList<tr>> tt_2=new ArrayList<ArrayList<tr>>();
    int[][] statesComb;

    public DFA_Operations(int NoOfSt_1, int NoOfSt_2, int IS_1, int[] FS_1, int IS_2, int[] FS_2,ArrayList<ArrayList<tr>> tt_1, ArrayList<ArrayList<tr>> tt_2) {
        this.NoOfSt_1 = NoOfSt_1;
        this.NoOfSt_2 = NoOfSt_2;
        this.IS_1 = IS_1;
        this.FS_1 = FS_1;
        this.IS_2 = IS_2;
        this.FS_2 = FS_2;
        this.tt_1=tt_1;
        this.tt_2=tt_2;
        
        if (this.NoOfSt_1>=this.NoOfSt_2){
        statesComb= new int[this.NoOfSt_1][this.NoOfSt_1];
            System.out.println("    kkk");
        }
        else
            statesComb= new int[this.NoOfSt_2][this.NoOfSt_2];
        
        
        for (int i = 0; i < statesComb.length; i++) {
            for (int j = 0; j < statesComb.length; j++) {
                
              statesComb[i][j]=-1;
            }
        }
    }

    
    
    public int[] Complement(ArrayList<ArrayList<tr>> tt){
        boolean tt_1=false;
        boolean temp=true;
        int k=0;
        int[] new_Fs= new int[2];
    if(tt==this.tt_1)
        tt_1=true;
    
    if(tt_1){
        for (int i = 0; i < this.NoOfSt_1; i++) {
            for (int j = 0; j < this.FS_1.length; j++) {
                if(i==this.FS_1[j]){
                   temp=false;
                   break;
                }
            }
            if(temp){
                new_Fs[k]=i;
                k++;
                temp=true;
        }
    
    
    }
    this.FS_1=new_Fs;
    }
    else{
    
    for (int i = 0; i < this.NoOfSt_2; i++) {
            for (int j = 0; j < this.FS_2.length; j++) {
                if(i==this.FS_2[j]){
                   temp=false;
                   break;
                }
            }
            if(temp){
                new_Fs[k]=i;
                k++;
                temp=true;
        }
    
    
    }
    
    this.FS_2=new_Fs;
    }
    return new_Fs;
    }

    public void ADD_DFAs(ArrayList<ArrayList<tr>> tt_1,ArrayList<ArrayList<tr>> tt_2){
    String temp;
    int val;
    State s= new State();
    s.x=this.IS_1;
    s.y=this.IS_2;
    temp=""+s.x+""+s.y;
    val=Integer.parseInt(temp);
    statesComb[s.x][s.y]=val;
    State s2= new State();
    
    
        for (int i = 0; i < No_Char.length; i++) {
            s2.x=transition_1(s.x,No_Char[i]);
            //System.out.println("value:    "+s2.x);
            s2.y=transition_2(s.y,No_Char[i]);
            //System.out.println("value:    "+s2.y);
            if(!Exist(s2)){
            temp=""+s2.x+""+s2.y;
            val=Integer.parseInt(temp);
            statesComb[s2.x][s2.y]=val;
            }
            //System.out.println("gap");
        }
    
    
    
    }
    
    public int transition_1(int state, char ch){
    char temp;
        for (int i = 0; i < this.tt_1.get(state).size(); i++) {
            temp=this.tt_1.get(state).get(i).ch;
            if(temp==ch)
                return this.tt_1.get(state).get(i).state;
        }
    return -1;
    }
    
    public int transition_2(int state, char ch){
    char temp;
        for (int i = 0; i < this.tt_2.get(state).size(); i++) {
            temp=this.tt_2.get(state).get(i).ch;
            if(temp==ch)
                return this.tt_2.get(state).get(i).state;
        }
    return -1;
    }
    
    
    private boolean Exist(State s){
    
    State so=new State();
    so.x=s.x;
    so.y=s.y;
    String temp=""+so.x+""+so.y;
    int val=Integer.parseInt(temp);
    
        for (int i = 0; i < statesComb.length; i++) {
            for (int j = 0; j < statesComb.length; j++) {
                if(statesComb[i][j]==val)
                    return true;
            }
        }
    
    return false;
    }
    
    public void display_StateCombs(){
    for (int i = 0; i < statesComb.length; i++) {
            for (int j = 0; j < statesComb.length; j++) {
                if(statesComb[i][j]!=-1){
                    if(statesComb[i][j]==0)
                        System.out.println("value= "+statesComb[i][j]+"0");
                    else{
                        if(statesComb[i][j]<10)
                            System.out.println("value= 0"+statesComb[i][j]);
                       else
                            System.out.println("value= "+statesComb[i][j]);
                
                }
                }
            }
        }
    
    
    }
    
    
}
