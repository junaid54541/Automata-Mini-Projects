/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_operations;


import java.util.ArrayList;

/**
 *
 * @author Junaid
 */
public class Operations {
    
    FiniteAutomata DFA1;
    FiniteAutomata DFA2;
    ArrayList<States> li = new ArrayList<States>();
    ArrayList<String> li2 = new ArrayList<String>();
    int count = 0;
    int[][] Trantable;
    ArrayList<Integer> FS = new ArrayList<Integer>();
    int[] FinalStates;
    ArrayList<Integer> TT=new ArrayList<Integer>();
    char[] No_Char={'a','b'};
    String con;
    
    
    

    

    public Operations(FiniteAutomata FA1, FiniteAutomata FA2) {
        this.DFA1 = FA1;
        this.DFA2 = FA2;
    }
    
    public FiniteAutomata OR(FiniteAutomata f1,FiniteAutomata f2){
    
    States s= new States();
    s.x=0;
    s.y=0;
    li.add(s);
    States s2=new States();
    while(count<li.size()){
        s=li.get(count);
        for (int i = 0; i < 2; i++) {
            s2.x=this.DFA1.transition(s.x,""+No_Char[i]);
            s2.y=this.DFA2.transition(s.y,""+No_Char[i]);
            
            
            boolean check = false;
                for (int j = 0; j < li.size(); j++) {
                    if ((s2.equal1(li.get(j)))) {
                        TT.add(j);
                        check = true;
                        break;
                    }
                }
                if (check == false) {
                    States s3=new States();
                    li.add(s3);
                    li.get(li.size()-1).x=s2.x;
                    li.get(li.size()-1).y=s2.y;
                    TT.add(li.size()-1);
                }
        }
        
        count++;
    }
    
    Trantable = new int[li.size()][No_Char.length];
        int a=0;
        for (int i = 0; i < li.size(); i++) {
            for (int j = 0; j < No_Char.length; j++) {
                Trantable[i][j] = TT.get(a);
                a++;
            }
        }
        
        for (int i = 0; i < li.size(); i++) {
            States sp = li.get(i);
            boolean check = false;
            for (int j = 0; j < DFA1.FinalStates.length; j++) {
                if (sp.x == DFA1.FinalStates[j]) {
                    check = true;
                }
            }
            for (int j = 0; j < DFA2.FinalStates.length; j++) {
                if (sp.y == DFA2.FinalStates[j]) {
                    check = true;
                }
            }
            if (check == true) {
                FS.add(i);
            }
        }
        
    FinalStates = new int[FS.size()];
        for (int i = 0; i < FS.size(); i++) {
            FinalStates[i] = FS.get(i);
        }
        return new FiniteAutomata(li.size(), DFA1.validChars, Trantable, 0, FinalStates);
    }
    
    
    
    public FiniteAutomata CONCATENATE(FiniteAutomata f1,FiniteAutomata f2){
     int count=0;
     boolean te = false;
       for (int i = 0; i < DFA1.FinalStates.length; i++) {
            if (DFA1.InitState == DFA1.FinalStates[i]) {
                te = true;
            }
        }
        if (te == true) {
            this.li2.add("" + DFA1.InitState + "," + DFA2.InitState);
        } else {
            this.li2.add("" + DFA1.InitState);
        }
        while (count < this.li2.size()) {
            String[] splitter = this.li2.get(count).split(",");
            for (int i = 0; i < DFA1.validChars.length; i++) {
                String con = "" + DFA1.TranTable[Integer.parseInt(splitter[0])][i];
                boolean te1 = false;
                for (int j = 0; j < DFA1.FinalStates.length; j++) {
                    if (DFA1.TranTable[Integer.parseInt(splitter[0])][i] == DFA1.FinalStates[j] || Integer.parseInt(splitter[0]) == DFA1.FinalStates[j]) {
                        te1 = true;
                        break;
                    }
                }
                if (te1 == true) {
                    con = con + "," + DFA2.InitState;
                }
                if (splitter.length > 1) {
                    boolean chk = false;
                    for (int j = 1; j < splitter.length; j++) {
                        String[] split1 = con.split(",");
                        chk = false;
                        for (int k = 1; k < split1.length; k++) {
                            if (DFA2.TranTable[Integer.parseInt(splitter[j])][i] == Integer.parseInt(split1[k])) {
                                chk = true;
                            }
                        }
                        if (chk == false) {
                            con = con + "," + DFA2.TranTable[Integer.parseInt(splitter[j])][i];
                        }
                    }
                }
                boolean status = false;
                for (int j = 0; j < this.li2.size(); j++) {
                    if (this.li2.get(j).equals(con)) {
                        this.TT.add(j);
                        status = true;
                    }
                }
                if (status == false) {
                    this.li2.add(con);
                    this.TT.add(this.li2.size() - 1);
                }
            }
            count++;
        }
        this.Trantable = new int[this.li2.size()][DFA1.validChars.length];
        int a = 0;
        for (int i = 0; i < this.li2.size(); i++) {
            for (int j = 0; j < DFA1.validChars.length; j++) {
                this.Trantable[i][j] = this.TT.get(a);
                a++;
            }
        }
        for (int i = 0; i < this.li2.size(); i++) {
            String[] split = this.li2.get(i).split(",");
            boolean check = false;
            for (int f = 1; f < split.length; f++) {
                for (int j = 0; j < this.DFA2.FinalStates.length; j++) {
                    if (Integer.parseInt(split[f]) == DFA2.FinalStates[j]) {
                        check = true;
                        break;
                    }
                }
            }
            if (check == true) {
                this.FS.add(i);
            }
        }
        this.FinalStates = new int[this.FS.size()];
        for (int i = 0; i < this.FS.size(); i++) {
            this.FinalStates[i] = this.FS.get(i);
        }
    
    return new FiniteAutomata(this.li2.size(), this.DFA1.validChars, this.Trantable, 0, this.FinalStates);
    
}
    
    public FiniteAutomata DFACOMPLIMENT(FiniteAutomata F) {
        ArrayList<Integer> li = new ArrayList<Integer>();
        ArrayList<Integer> nonfnl = new ArrayList<Integer>();
        int[] arr;

        for (int j = 0; j < F.FinalStates.length; j++) {
            li.add(F.FinalStates[j]);
        }

        for (int i = 0; i < F.States; i++) {
            boolean p = false;
            for (int r = 0; r < li.size(); r++) {
                if (li.get(r) == i) {
                    p = true;
                    break;
                }
            }
            if (p == false) {
                nonfnl.add(i);
            }
        }
        this.FinalStates = new int[nonfnl.size()];
        for (int i = 0; i < nonfnl.size(); i++) {
            this.FinalStates[i] = nonfnl.get(i);
        }

        return new FiniteAutomata(F.States, F.validChars, F.TranTable, F.InitState, this.FinalStates);

    }//COMPLIMENT FUNCTION END

    public FiniteAutomata DFAINTERSECTION(FiniteAutomata dfa1, FiniteAutomata dfa2) {
        FiniteAutomata dfa1c = DFACOMPLIMENT(dfa1);
        FiniteAutomata dfa2c = DFACOMPLIMENT(dfa2);
        Operations OBJ = new Operations(dfa1c, dfa2c);
        FiniteAutomata union = OBJ.OR(dfa1, dfa2);
        FiniteAutomata unionc = DFACOMPLIMENT(union);
        return unionc;
    }

    public FiniteAutomata DFACLOSURE(FiniteAutomata F) {
        int t=0;
        
        this.li2.add("" + F.InitState);

        while (count < this.li2.size()) {
            String[] split = this.li2.get(count).split(",");
            for (int i = 0; i < F.validChars.length; i++) {
                this.con = "" + F.TranTable[Integer.parseInt(split[0])][i];
                fin(Integer.parseInt(split[0]), i, F);
                if (split.length > 1) {
                    boolean ch;
                    for (int j = 1; j < split.length; j++) {
                        String[] split1 = this.con.split(",");
                        ch = false;
                        for (int k = 0; k < split1.length; k++) {
                            if (F.TranTable[Integer.parseInt(split[j])][i] == Integer.parseInt(split1[k])) {
                                ch = true;
                                break;
                            }
                        }

                        if (ch == false) {
                            this.con = this.con + "," + F.TranTable[Integer.parseInt(split[j])][i];
                        }

                        String split2[] = con.split(",");
                        boolean ch3=false;
                        for (int w = 0; w < F.FinalStates.length; w++) {
                            if (F.TranTable[Integer.parseInt(split[j])][i] == F.FinalStates[w]) {
                                for (int u = 0; u < split2.length; u++) {
                                    if (Integer.parseInt(split2[u]) == F.InitState) {
                                        ch3 = true;
                                        break;
                                    }
                                }

                            }
                            if(ch3=true)
                            {
                                break;
                            }
                        }
                        if(ch3=false)
                        {
                            this.con+=","+F.InitState;
                        }

                    }
                }
                int q=0;
                if(this.li2.size()>1&&t==0)
                {
                   if(this.li2.get(0).equals(this.con))
                   {
                       t=1;
                       q=1;
                   }
                }
                boolean check = false;
                if(q==0)
                {
                for (int j = 1; j < this.li2.size(); j++) {
                    if (this.li2.get(j).equals(this.con)) {
                        this.TT.add(j);
                        check = true;
                    }
                }
                }
                if (check == false) {
                    this.li2.add(this.con);
                    TT.add(this.li2.size() - 1);
                }
            }
            this.count++;
        }
        this.Trantable = new int[this.li2.size()][F.validChars.length];
        int a = 0;
        for (int i = 0; i < this.li2.size(); i++) {
            for (int j = 0; j < F.validChars.length; j++) {
                this.Trantable[i][j] = this.TT.get(a);
                a++;
            }
        }
        this.FS.add(0);
        for (int i = 1; i < this.li2.size(); i++) {
            String[] split = this.li2.get(i).split(",");
            boolean check = false;
            for (int j = 0; j < split.length; j++) {
                for (int k = 0; k < F.FinalStates.length; k++) {
                    if (Integer.parseInt(split[j]) == F.FinalStates[k]) {
                        check = true;
                    }
                }
            }
            if (check == true) {
                this.FS.add(i);
            }
        }
        this.FinalStates = new int[this.FS.size()];
        for (int i = 0; i < FS.size(); i++) {
            this.FinalStates[i] = FS.get(i);
        }
        return new FiniteAutomata(this.li2.size(), F.validChars, this.Trantable, 0, this.FinalStates);

    }

    public void fin(int Z1, int Z2, FiniteAutomata F) {
        boolean fin = false;
        for (int j = 0; j < F.FinalStates.length; j++) {
            if (F.TranTable[Z1][Z2] == F.FinalStates[j] || Z1 == F.FinalStates[j]) {
                if (F.TranTable[Z1][Z2] != F.InitState) {
                    fin = true;
                    break;
                }
            }
        }
        if (fin == true) {
            this.con = this.con + "," + F.InitState;
        }
    }
}
