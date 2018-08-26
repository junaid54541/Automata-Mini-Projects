/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhammadjunaidsiddiqui_b15101077;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author junaid
 */
public class dfa {
    
      int NoOfSt;
        int iniSt=0;
        int[][] tt;
        int [] fst;
        String []arr;
        
    public dfa(int nost,int i_st,int [][]ttable,String[] Arr1,int []fst){
        this.NoOfSt=nost;
        this.iniSt=i_st;
        this.fst=fst;
        arr=Arr1;
        tt=ttable;
    }   
    
    public boolean validate(String word){
        int cs=iniSt;
        for (int i = 0; i < word.length(); i++) {
            cs=transition(cs,word.charAt(i));
            if(cs==-1)
                return false;
        }
         
        for (int i = 0; i < fst.length; i++) {
            if(cs==fst[i]){
                return true;
            }
        }
           return false;
    }
     
    public int transition(int state,char Chr){
        
        String ss=""+Chr;
            for(int i=0;i<arr.length;i++){
                Pattern p1=Pattern.compile(arr[i]);
                Matcher m1=p1.matcher(ss);
                if(m1.matches())
                    return tt[state][i];
                
            }
         return -1;
        }    
}
