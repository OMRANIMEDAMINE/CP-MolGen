/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package molecular.structure.generator.v1.pkg0.entities;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class molecule {
    
    //From step 1: MF and atoms 
    private int NumberOfAtoms;
    private int NumberOfAtomsNoHydrogen;
    private  int NumberOfSymboles;
    private  int NumberOfSymboleNoHydrogen;
    public Hashtable tableOfMolecularFormula = new Hashtable();
    public Hashtable tableOfSymboles = new Hashtable();
    public Hashtable tableOfValenceStandard = new Hashtable();
    
    //From step 2: MULT HYB Valence
    public Hashtable tableOfMultiplicity = new Hashtable();
    public Hashtable tableOfHybridation = new Hashtable();
    public Hashtable tableOfValenceWithoutHydrogene = new Hashtable();
    
    //From step 3: Proximity relationShips
    public Hashtable tableOfCorrelationatom1 = new Hashtable();
    public Hashtable tableOfCorrelationatom2 = new Hashtable();
    public Hashtable tableOfCorrelationProximity= new Hashtable();
    public int NumberOfCorrelation;
    
    //From step4
    public boolean [] ImposedFragments={false,false,false,false};
    public boolean [] ForbiddenFragments={false,false,false,false};
    
    public  ArrayList<int[]> ExplicitCycle3 = new ArrayList<int[]>();
    public  ArrayList<int[]> ExplicitCycle4 = new ArrayList<int[]>();
    public  ArrayList<int[]> ExplicitCycle5 = new ArrayList<int[]>();
    public  ArrayList<int[]> ExplicitCycle6 = new ArrayList<int[]>();
    // Final Step
    
    public int Matrix[][]= new int[NumberOfAtoms][NumberOfAtoms];
    
public  molecule()   {
    NumberOfCorrelation=0;
    NumberOfAtoms=0;
    NumberOfAtomsNoHydrogen=0;
    NumberOfSymboles=0;
    NumberOfSymboleNoHydrogen=0;  
    tableOfValenceStandard.put("H", 1);tableOfValenceStandard.put("LI", 1);
    tableOfValenceStandard.put("NA", 1);tableOfValenceStandard.put("K", 1);
    tableOfValenceStandard.put("F", 1);tableOfValenceStandard.put("CL", 1);
    tableOfValenceStandard.put("BR", 1);tableOfValenceStandard.put("I", 1);
    tableOfValenceStandard.put("O", 2);tableOfValenceStandard.put("S", 2);
    tableOfValenceStandard.put("BE", 2);tableOfValenceStandard.put("MG", 2);
    tableOfValenceStandard.put("CA", 2);tableOfValenceStandard.put("N", 3);
    tableOfValenceStandard.put("P", 3);tableOfValenceStandard.put("B", 3);
    tableOfValenceStandard.put("AL", 3);tableOfValenceStandard.put("C", 4);
    tableOfValenceStandard.put("SI", 4);       
    
  /*  tableOfMolecularFormula = null;
    tableOfSymboles = null;
    tableOfValenceStandard = null;
    tableOfMultiplicity = null;
    tableOfHybridation = null;
    tableOfValenceWithoutHydrogene = null;*/
    tableOfCorrelationatom1 = null;
    tableOfCorrelationatom2 = null;
    tableOfCorrelationProximity= null;

};



public  molecule(int NumberOfAtoms, int NumberOfAtomsNoHydrogen,  int NumberOfSymboles,  int NumberOfSymboleNoHydrogen, Hashtable tableOfValenceStandard,Hashtable tableOfValenceWithoutHydrogene){   
    this.NumberOfAtoms=NumberOfAtoms;
    this.NumberOfAtomsNoHydrogen=NumberOfAtomsNoHydrogen;
    this.NumberOfSymboles=NumberOfSymboles;
    this.NumberOfSymboleNoHydrogen=NumberOfSymboleNoHydrogen;
    this.tableOfValenceStandard=tableOfValenceStandard;
    this.tableOfValenceWithoutHydrogene=tableOfValenceWithoutHydrogene;
    this.tableOfValenceStandard.put("H", 1);this.tableOfValenceStandard.put("LI", 1);
    this.tableOfValenceStandard.put("NA", 1);this.tableOfValenceStandard.put("K", 1);
    this.tableOfValenceStandard.put("F", 1);this.tableOfValenceStandard.put("CL", 1);
    this.tableOfValenceStandard.put("BR", 1);this.tableOfValenceStandard.put("I", 1);
    this.tableOfValenceStandard.put("O", 2);this.tableOfValenceStandard.put("S", 2);
    this.tableOfValenceStandard.put("BE", 2);this.tableOfValenceStandard.put("MG", 2);
    this.tableOfValenceStandard.put("CA", 2);this.tableOfValenceStandard.put("N", 3);
    this.tableOfValenceStandard.put("P", 3);this.tableOfValenceStandard.put("B", 3);
    this.tableOfValenceStandard.put("AL", 3);this.tableOfValenceStandard.put("C", 4);
    this.tableOfValenceStandard.put("SI", 4);  
    tableOfCorrelationatom1 = null;
    tableOfCorrelationatom2 = null;
    tableOfCorrelationProximity= null;
};

public int GetNumberOfAtoms(){ return this.NumberOfAtoms;}
public int GetNumberOfAtomsNoHydrogen(){ return this.NumberOfAtomsNoHydrogen;}
public int GetNumberOfSymboles(){ return this.NumberOfSymboles;}
public int GetNumberOfSymboleNoHydrogen(){ return this.NumberOfSymboleNoHydrogen;}
public Hashtable GettableOfSymboles(){ return this.tableOfSymboles;}
public Hashtable GettableOfValenceStandard(){ return this.tableOfValenceStandard;}
public Hashtable GettableOfMolecularFormula(){ return this.tableOfMolecularFormula;}
public Hashtable GettableOfValenceWithoutHydrogene(){ return this.tableOfValenceWithoutHydrogene;}
public Hashtable GettableOfHybridation(){ return this.tableOfHybridation;}
    
public void SetNumberOfAtoms(int n){ this.NumberOfAtoms=n;}  
public void SetNumberOfAtomsNoHydrogen(int n){ this.NumberOfAtomsNoHydrogen=n;}  
public void SetNumberOfSymboles(int n){ this.NumberOfSymboles=n;}  
public void SetNumberOfSymboleNoHydrogen(int n){ this.NumberOfSymboleNoHydrogen=n;}  
public void SettableOfMolecularFormula(Hashtable MF){ this.tableOfMolecularFormula=MF;}  
public void SettableOfSymboles(Hashtable n){ this.tableOfSymboles=n;}  
public void SettableOfValenceWithoutHydrogene(Hashtable n){ this.tableOfValenceWithoutHydrogene=n;}  
public void SettableOfHybridation(Hashtable n){ this.tableOfHybridation=n;}

public String GetValenceStandardOfAtom(String S){return tableOfValenceStandard.get(S).toString();}
public Integer  GetValenceStandardOfAtomint(String S){
    return Integer.parseInt(tableOfValenceStandard.get(S).toString());}

 public void ReadtableOfValenceStandard(){ 
        Enumeration e = tableOfValenceStandard.keys();
        while (e.hasMoreElements()) {
        String key = (String) e.nextElement();
        System.out.println(key + " : " + tableOfValenceStandard.get(key)); }
    }

    public void ReadtableOfSymboles(){ 
        Enumeration e = this.tableOfSymboles.keys();
        while (e.hasMoreElements()) {
        String key = (String) e.nextElement();
        System.out.println(key + " : " + tableOfSymboles.get(key).toString()); }
    }
    
    public void ReadtableOfMolecularFormula(){ 
        Enumeration e = tableOfMolecularFormula.keys();
        while (e.hasMoreElements()) {
        String key = (String) e.nextElement();
        System.out.println(key + " : " + tableOfMolecularFormula.get(key)); }
    } 
    public void ReadHashtable(Hashtable T ){ 
        Enumeration e = T.keys();
        while (e.hasMoreElements()) {
        String key = (String) e.nextElement();
        System.out.println(key + " : " + T.get(key)); }
    }   
    
    public String GetStringOfMolecularFormula(){ 
        String elem="";
        Enumeration e = tableOfMolecularFormula.keys();
        while (e.hasMoreElements()) {
        String key = (String) e.nextElement();
        elem = key + " " + tableOfMolecularFormula.get(key).toString()+" " + elem; 
        }        
         String  reverse = new StringBuffer(elem).reverse().toString();
        return (elem);
    }  
    
    public Hashtable GetHashtableOfMultiplicity(){ 
        return (this.tableOfMultiplicity);
    }     
    
     
    public void SetHashtableOfMultiplicity(Hashtable h){ 
        this.tableOfMultiplicity=h;
    }   
    
    public Hashtable GetHashtableOfHybridation(){ 
        return (this.tableOfHybridation);
    } 
    
    public void SetHashtableOfHybridation(Hashtable h){ 
        this.tableOfHybridation=h;
    }  
        public final boolean containsDigit(String s){  
        boolean containsDigit = false;

        if(s != null && !s.isEmpty()){
            for(char c : s.toCharArray()){
                if(containsDigit = Character.isDigit(c)){
                    break;
                }
            }
        }

        return containsDigit;
    }

}