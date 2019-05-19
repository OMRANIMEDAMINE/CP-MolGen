/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molecular.structure.generator.v1.pkg0.entities;

import ilog.concert.IloException;
import ilog.concert.IloIntVar;
import ilog.cp.IloCP;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import molecular.structure.generator.v1.pkg0.FinalStep;

/**
 *
 * @author OMRANI
 */
public class CyclesGeneration {
    public static ArrayList<int []> Cycles(int N, int P){

        ArrayList<int []> ExplicitCycle= new ArrayList();
        // CP Modelisation
        IloCP cp = new IloCP();
        try {
            cp.setParameter(IloCP.DoubleParam.TimeLimit, 10000000);
            cp.setParameter(IloCP.IntParam.SearchType,IloCP.ParameterValues.DepthFirst);
            cp.setParameter(IloCP.IntParam.LogVerbosity, IloCP.ParameterValues.Quiet);
            cp.setParameter(IloCP.IntParam.Workers, 1);
        } catch (IloException ex) {
            Logger.getLogger(CyclesGeneration.class.getName()).log(Level.SEVERE, null, ex);
        }
      
            
        IloIntVar[] Mesvariables=null;
        try {
            Mesvariables = cp.intVarArray(P,0,N-1);
        } catch (Exception ex) {
            Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //**** CP Constraint  *****
            //**  Constraint 1: Tous les sommets sont differents ( AllDiff )  **//
           cp.add( cp.allDiff(Mesvariables));
        } catch (IloException ex) {
            Logger.getLogger(CyclesGeneration.class.getName()).log(Level.SEVERE, null, ex);
        }


        //**  Constraint 2: min = first  **//
        for (int i=1;i<P;i++ ){
            try {
                cp.add(cp.le(Mesvariables[0], Mesvariables[i]));
            } catch (IloException ex) {
                Logger.getLogger(CyclesGeneration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //**  Constraint 3: Second < last  **//
        try {
                cp.add(cp.le(Mesvariables[1], Mesvariables[P-1]));
        } catch (IloException ex) {
                Logger.getLogger(CyclesGeneration.class.getName()).log(Level.SEVERE, null, ex);
        }
        

   /*
        try {
            // Configuration à faire et à verifier avec les resultats de l'article
            /*
            cp.param.FailLimit = 10000;
            cp.param.SearchType="DepthFirst";
            // no redundant solutions
            cp.param.logVerbosity="Quiet";
            cp.param.workers=1;
            // end no redundant solutions
            var model =thisOplModel;
            
         


        } catch (IloException ex) {
            Logger.getLogger(CyclesGeneration.class.getName()).log(Level.SEVERE, null, ex);
        }*/
         try{    

                boolean ok = false;
                cp.startNewSearch();
                int compteur = 0;
                while (cp.next()) {
                    int [] Aux = new int [P];
                    ok = true;
                    compteur++;
                    //System.out.println("\n ");
                    for (int i=0;i<P;i++ ){
                       // System.out.print(" "+ (int)cp.getValue(Mesvariables[i])); 
                        Aux[i]=(int)cp.getValue(Mesvariables[i]);
                        
                    } 
                    ExplicitCycle.add(Aux);
                    
                }
                cp.endSearch();
                 //System.out.println("Total: "+ compteur);
                if (!ok){
                   
                    JOptionPane.showMessageDialog(null," No Solution found", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                cp.clearAbort();                
                cp.end();
                return ExplicitCycle;
            } catch (IloException e) {
                System.err.println("Error " + e);
            }
         return ExplicitCycle;
    }
            
            
         
    
    public static void main(String args[]) {
        
         Date Start = new Date();
                   
         //System.out.println(""+CyclesGeneration.Cycles(10, 3));
        CyclesGeneration.Cycles(10, 4);
        Date Stop = new Date();
                    double diff = Stop.getTime() - Start.getTime() ;
                    diff = diff /1000 %60 ;
                     System.out.println(diff);
      }
    
}
