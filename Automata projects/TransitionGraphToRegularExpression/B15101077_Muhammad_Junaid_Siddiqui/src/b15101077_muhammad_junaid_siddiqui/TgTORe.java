/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b15101077_muhammad_junaid_siddiqui;

import java.util.ArrayList;

/**
 *
 * @author Junaid
 */
public class TgTORe {
    
     
    ArrayList<ArrayList<Transition>> list;
     int states;
     
     
     
     
     
    public  TgTORe( ArrayList<ArrayList<Transition>> list,int states)
    { this.list=list;
    this.states=states;
    }
    
    
    
     public void TgtoRE(){
    String ret="",temp;
    String[] Inc_arr_s;
    String[] Out_arr_s;
    int sop,jk=0;
         for (int j = 0; j < this.states; j++) {
             this.reduceEdges(j);
         }
       for (int i = 0; i < this.states; i++) {
            
            Inc_arr_s=incomingEdges(i);
            
            Out_arr_s=OutgoingEdges(i);
            
            temp=getloop(i);
            
            eliminate(i,Inc_arr_s,Out_arr_s,temp);
            
     }    
         reduceEdges(this.states);// to remove reduncancy of edges in the last and make it one
         for (int i = 0; i < this.states; i++) {
             this.list.remove(0);
         }
    }
    
    private void reduceEdges(int j){
    String temp,cont=null;
    int sop;
    String[] arr_s=new String[this.states+2];
        for (int i = 0; i < this.list.get(j).size(); i++) {
            sop=this.list.get(j).get(i).state;
            if(sop!=j){
                cont=this.list.get(j).get(i).str;
                if (arr_s[sop] != null){
                    temp=arr_s[sop];
                    cont="("+temp+"+"+cont+")";
                    arr_s[sop]=cont;
                }
                else
                    arr_s[sop]=cont;  
            }  
        } //for loop ends
        
        //now, we eliminate all indices
        for (int i = 0; i < this.list.get(j).size(); i++) {    
        sop=this.list.get(j).get(i).state;
            if(sop!=j){
                this.list.get(j).remove(i);
                i--;
            }
        } //elimniation wala loop ends
        
        
        //now lets add reduced edges
        for (int i = 0; i < arr_s.length; i++) {
            if(arr_s[i]!=null){
            Transition tra=new Transition(i,arr_s[i]); //arr_s is containg reduced string with respect to states
            list.get(j).add(tra);
            }
        } //adding reduced edges wala loop ends
    
    }//reduce edges ends
    
    
    
    private String[] incomingEdges(int st){
    String[] Inc_arr_s=new String[this.states+2];
        for (int i = 0; i < this.states+1; i++) {
        if(i!=st)
            for (int j = 0; j < this.list.get(i).size(); j++) {
                if(this.list.get(i).get(j).state==st){
                Inc_arr_s[i]=this.list.get(i).get(j).str;
                }
            }
        }
    return Inc_arr_s;
    }
    
    
     private String[] OutgoingEdges(int st){
    String[] Out_arr_s=new String[this.states+2];
            for (int j = 0; j < this.list.get(st).size(); j++) {
                if(this.list.get(st).get(j).state!=st){
                Out_arr_s[this.list.get(st).get(j).state]=this.list.get(st).get(j).str;
                }
            }
    return Out_arr_s;
    }
     
     
     
    public String getloop(int st){
    String temp="(";
    
        for (int i = 0; i < this.list.get(st).size(); i++) {
            if(this.list.get(st).get(i).state==st)
                temp+= this.list.get(st).get(i).str;
        }
    if(temp=="(")
        return null;
    else
        return temp+")";
    } 
    
    
    private void eliminate(int i,String[] Inc_arr_s,String[] Out_arr_s,String temp){
    String mine,ret;
    int sop;
        for (int j = 0; j < Inc_arr_s.length; j++) {
            if(Inc_arr_s[j]!=null){
                mine=Inc_arr_s[j];
                for (int k = 0; k < Out_arr_s.length; k++) {
                    if(Out_arr_s[k]!=null){
                    if(temp!=null)
                        ret=mine+temp+"*"+Out_arr_s[k];
                    else
                        ret=mine+Out_arr_s[k];
                    this.list.get(j).add(new Transition(k,ret));
                    
                    for (int l = 0; l < this.list.get(j).size(); l++) {
                            sop=this.list.get(j).get(l).state;
                            if(sop==i){
                            this.list.get(j).remove(l);
                            l--;
                            break;
                            } 
                    }
            }
        }
     }
        }
        this.list.get(i).clear();
    
    }
    
    
    
    public void displayList(){
        for (int i = 0; i < 2; i++) {
            System.out.println("State: "+(i+this.states));
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.println("no " +list.get(i).get(j).toString());//+" string "+list.get(i).get(j).ch);
            }
            }
            System.out.println();
        }
    
    
    }
    
    
    

