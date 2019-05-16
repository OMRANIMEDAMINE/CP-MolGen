/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 */
package molecular.structure.generator.v1.pkg0.entities;
import java.util.ArrayList;

/**
 *
 * @author rocame
 */
public class Atom {    
    private int numero;
    private String symbole;
    private int sp;
    private int  mult;
    private int valence;
    private int valencestandard;  
    
public  Atom()   {};
public  Atom(int numero, String symbole, int valence, int mult, int sp, int valencestandard){
    this.numero=numero;
    this.symbole=symbole;
    this.valence=valence;
    this.mult=mult;
    this.sp=sp;
    this.valencestandard=valencestandard;

};

public int Getnumero(){ return this.numero;}
public String Getsymbole(){ return this.symbole;}
public int Getsp(){ return this.sp;}
public int Getmult(){ return this.mult;}
public int Getvalence(){ return this.valence;}
public int Getvalencestandard(){ return this.valencestandard;}
    
public void Setnumero(int n){ this.numero=n;}  
public void Setsymbole(String n){ this.symbole=n;}  
public void Setsp(int n){ this.sp=n;}  
public void Setmult(int n){ this.mult=n;}  
public void Setvalence(int n){ this.valence=n;}  
public void Setvalencestandard(int n){ this.valencestandard=n;}  
    
    
}
