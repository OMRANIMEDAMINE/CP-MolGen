/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molecular.structure.generator.v1.pkg0;

import ilog.concert.IloConstraint;
import ilog.concert.IloException;
import ilog.concert.IloIntExpr;
import ilog.concert.IloIntVar;
import ilog.cp.IloCP;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import molecular.structure.generator.v1.pkg0.entities.CyclesGeneration;

/**
 *
 * @author OMRANI
 */
public class Experimental_TESTs {
    
    public static void main(String args[]) {
        IloIntVar[] LS6 = null;
        IloIntVar[] LS5 = null;
        IloIntVar[] LS4 = null;
        IloIntVar[] LS3 = null;    
/*
MULT 1 C 2 0
MULT 2 C 2 0
MULT 3 C 2 0
MULT 4 C 2 0
MULT 5 C 2 1
MULT 6 C 2 1
MULT 7 C 2 1
MULT 8 C 2 1
MULT 9 C 2 1
MULT 10 C 3 1
MULT 11 C 3 2
MULT 12 C 3 1
MULT 13 C 3 1
MULT 14 C 3 2
MULT 15 C 3 0
MULT 16 C 3 2
MULT 17 C 3 1
MULT 18 C 3 2
MULT 19 C 3 2
MULT 20 C 3 1
MULT 21 C 3 2
MULT 22 N 3 0
MULT 23 N 3 0
MULT 24 O 3 0
MULT 25 O 2 0
4,4,4,4,3,3,3,3,3,3,2,3,3,2,4,2,3,2,2,3,2,4,4,4,4*/





        // Strych Standard 
        int N =25;
        int[] GettableOfValenceWithoutHydrogene={4,4,4,4,3,3,3,3,3,3,2,3,3,2,4,2,3,2,2,3,2, 3,3,2,2};
        int[] GettableOfHybridation=            {2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2};


        int NumberOfCorrelation= 60;
        int [] tableOfCorrelationatom1=    {5,1,1,13,17,20,21,12,15,13,17,20,12,15,2,2,4,1,2,3,20,7,10,16,15,13,15,17,5,6,     1,2,2,2,3,3,3,4,4,4,6,6,10,10,12,12,13,14,14,15,15,17,17,            2,3,10,11,15,14,16};
        int [] tableOfCorrelationatom2=    {7,25,22,17,20,21,12,15,13,22,10,3,23,4,8,4,9,19,8,14,21,9,19,18,13,17,18,20,8,11,   10,5,9,13,11,17,21,7,13,18,14,20,11,13,13,20,18,16,20,16,21,19,21,   4,6,24,24,12,23,23};
        int [] tableOfCorrelationProximity={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,                        2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,                       1,1,1,1,1,1,1};

    //Fragments imposed
    boolean[] ImposedFragments={false, false, false,false};
    //Fragments Forbidden 
    boolean[] ForbiddenFragments={true, false, false, false};
 
    
    
    
    ArrayList<int []> ExplicitCycle3 = null;
    ArrayList<int []> ExplicitCycle4 = null;
    ArrayList<int []> ExplicitCycle5 = null;
    ArrayList<int []> ExplicitCycle6 = null;
    
    if (ForbiddenFragments[0]==true){ExplicitCycle3 = CyclesGeneration.Cycles(N, 3);}
    if (ForbiddenFragments[1]==true){ExplicitCycle4 = CyclesGeneration.Cycles(N, 4);}
    if (ForbiddenFragments[2]==true){ExplicitCycle5 = CyclesGeneration.Cycles(N, 5);}
    if (ForbiddenFragments[3]==true){ExplicitCycle6 = CyclesGeneration.Cycles(N, 6);}
    /*
    for(int [] ex: ExplicitCycle5 ){
        for(int i : ex ){
            System.out.print(" "+i);
        }
        System.out.print("\n");
    }
    */
  
    // define Model 
        IloCP cp = new IloCP();
        try {
            cp.setParameter(IloCP.DoubleParam.TimeLimit, 1000000000);
            cp.setParameter(IloCP.IntParam.SearchType,IloCP.ParameterValues.DepthFirst);
            cp.setParameter(IloCP.IntParam.LogVerbosity, IloCP.ParameterValues.Quiet);
            cp.setParameter(IloCP.IntParam.Workers, 1);
        } catch (IloException ex) {
            Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
        }

        //variables Declaration 
        // Example of use :  IloIntVar x = cp.intVar(0, 10);
       //  int domaine[]={0,1,2,3};
      
        IloIntVar[][] MATRIX = new IloIntVar[N][];
        for (int i = 0; i < N; i++) {     
            try {   
                MATRIX[i] = cp.intVarArray(N,0,3);
            } catch (IloException ex) {
                Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
            }
  
        }  

        
        //***************************** Begin CONSTRAINTS ***********************************
        //************** Constraint 1: Null Diagonal of the Adjacency matrix *************
         for (int i=0; i<N; i++){      
            try {   
                cp.add(cp.eq(MATRIX[i][i], 0));
            } catch (IloException ex) {
                Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //************** Constraint 2: Symetry of the Adjacency matrix *************
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                try {   
                    cp.add(cp.eq(MATRIX[i][j], MATRIX[j][i]));
            } catch (IloException ex) {
                Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }

        //************** Constraint 3: Define Degree Constraint *************
        for (Integer i=0; i<N; i++){
  
            int Degree_Of_Atom_i=GettableOfValenceWithoutHydrogene[i];
                    
            try {   
        
                    cp.add(cp.eq(cp.sum(MATRIX[i]),Degree_Of_Atom_i));
            } catch (IloException ex) {
                Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        //************** Constraint 4: Hybridization state *************

        for (Integer i=0; i<N; i++){

                   
            int Hybridization_Of_Atom_i = GettableOfHybridation[i];
            //************** Constraint 4.1: Hybridization state SP3 ************* A revoir de le debut directement filtrer from domain value
            if ( Hybridization_Of_Atom_i==3){
            try {   
                    for (int j=0; j<N; j++){
                        cp.add(cp.le(MATRIX[i][j], 1));
                    }                    
                } catch (IloException ex) {
                    Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            //************** Constraint 4.2: Hybridization state SP2 ************* avec filtrage sur la valeur 3
            
            if ( Hybridization_Of_Atom_i==2){
            try {   
                    for (int j=0; j<N; j++){
                        cp.add(cp.ge(cp.count(MATRIX[i], 2), 1));
                        cp.add(cp.ge(cp.count(MATRIX[i], 3), 0));
                    }                    
                } catch (IloException ex) {
                    Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            //************** Constraint 4.3: Hybridization state SP1 *************          
            
            if ( Hybridization_Of_Atom_i==1){
            try {   
                    for (int j=0; j<N; j++){
                      cp.add(cp.or( cp.ge(cp.count(MATRIX[i], 3), 1)  , cp.ge( cp.count(MATRIX[i], 2),2)));  
                      //   cp.add(cp.eq(b[j], cp.gt(cp.count(v2, values[j]),0)));
                       //          .le(cp.sum(MATRIX[i]),4));
                      //  cp.add(cp.le(MATRIX[i][j], 1));
                    }                    
            } catch (IloException ex) {
                Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
           
        }
       
       
        //************** Constraint 5: Certain Proximity RelationShips Constraint state (HMBC and BOND) *************
        int NbrCorrelations=NumberOfCorrelation;
        //System.out.println("NbrCorrelations "+NbrCorrelations);
       // IloIntVar[] correlations = new IloIntVar[NbrCorrelations] ;
        IloIntVar[] correlations=new IloIntVar[NbrCorrelations] ;
        try {
            correlations = cp.intVarArray(NbrCorrelations,0,N); 
        } catch (IloException ex) {
            Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (NbrCorrelations!=0){  
        // DEFINE CORRELATION VARIABLEs
            try {
            for (int i = 0; i < NbrCorrelations; i++) {      
                
                int Proximity=tableOfCorrelationProximity[i];
                int Atom1=tableOfCorrelationatom1[i]-1;
                int Atom2=tableOfCorrelationatom2[i]-1;
                System.out.println("Proximity "+ Proximity+"Atom1 "+ Atom1+"Atom2 "+ Atom2);

                if (Proximity==1){   
                    cp.add(cp.neq(MATRIX[Atom1][Atom2],0));
                    cp.add(cp.eq(correlations[i],N));
                    
                }else{   
                    //Example of use :  IloIntVar x = cp.intVar(0, 10);
                    //correlations[i]=cp.intVar(0, N-1);
                    for (int inter = 0; inter < N; inter++) {  
                        cp.add(cp.ifThen(cp.eq(correlations[i],inter), cp.and(cp.neq( MATRIX[Atom1][inter],0),cp.neq( MATRIX[Atom1][inter],0))));      
                    
                    }
                 //   cp.add(cp.ifThen(cp.eq(MATRIX[Atom1][Atom2],0),cp.eq(correlations[i],N)))  ;
 
                     cp.add(cp.ifThenElse(  cp.eq(MATRIX[Atom1][Atom2],0),cp.eq(correlations[i],N)   ,  cp.neq(correlations[i],N)  ));
                }
            
            }
         
            } catch (IloException ex) {
                Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
            }
	}		


        //************** Constraint 6: Fragments Data (Imposed and Frobidden) *************
        //************** Constraint 61: Imposed Fragment*************
        if (ImposedFragments[0]==true||ImposedFragments[1]==true||ImposedFragments[2]==true||ImposedFragments[3]==true){
                //Cycle 3
                if (ImposedFragments[0]==true){

                    //IloIntVar[] LS3= new IloIntVar[3];
                    try {
                        LS3 = cp.intVarArray(3,0,N-1);
                        
                        /*
                        cp.add(cp.le(LS3[0],LS3[1]) );
                        cp.add(cp.le(LS3[1],LS3[2]) );
                        */
                        
                       // cp.add(cp.allDiff(LS3)); zayda
                        cp.add(cp.le(LS3[0],LS3[1]) );                         
                        cp.add(cp.le(LS3[0],LS3[2]) );                       
                        cp.add(cp.le(LS3[1],LS3[2]) );

                    // 1 et 2
                    for(int i1=0; i1<N;i1++ ){
                        for(int i2=0; i2<N ;i2++ ){
                            cp.add(cp.imply(cp.and(cp.eq(LS3[0],i1), cp.eq(LS3[1],i2)),  cp.neq(MATRIX[i1][i2],0)));
                        }
                    }
                    
                    // 2 et 3
                    for(int i1=0; i1<N;i1++ ){
                        for(int i2=0; i2<N ;i2++ ){
                            cp.add(cp.imply(cp.and(cp.eq(LS3[1],i1), cp.eq(LS3[2],i2)),  cp.neq(MATRIX[i1][i2],0)));
                        }
                    }
                    // 3 et 1
                    for(int i1=0; i1<N;i1++ ){
                        for(int i2=0; i2<N ;i2++ ){
                            cp.add(cp.imply(cp.and(cp.eq(LS3[2],i1), cp.eq(LS3[0],i2)),  cp.neq(MATRIX[i1][i2],0)));
                        }
                    }
                    
                    } catch (IloException ex) {
                        Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }  

                //#-------------Cycle 4--------------------#
                if (ImposedFragments[1]==true){
                    //IloIntVar[] LS4= new IloIntVar[4];
                    try {
                        LS4 = cp.intVarArray(4,0,N-1);
                        /*
                        cp.add(cp.lt(LS4[0],LS4[1]) );
                        cp.add(cp.lt(LS4[1],LS4[2]) );
                        cp.add(cp.lt(LS4[2],LS4[3]) );
                        */
 
                        cp.add(cp.allDiff(LS4));
                        cp.add(cp.lt(LS4[0],LS4[1]) );
                        cp.add(cp.lt(LS4[0],LS4[2]) );
                        cp.add(cp.lt(LS4[0],LS4[3]) );
                        cp.add(cp.lt(LS4[1],LS4[3]) );
                         
                    // 1 et 2
                    for(int elem=0; elem<N;elem++ ){
                        for(int elem2=0; elem2<N ;elem2++ ){
                            cp.add(cp.ifThen(cp.and(cp.eq(LS4[0],elem), cp.eq(LS4[1],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                        }
                    }
                    
                    // 2 et 3
                    for(int elem=0; elem<N;elem++ ){
                        for(int elem2=0; elem2<N ;elem2++ ){
                            cp.add(cp.ifThen(cp.and(cp.eq(LS4[1],elem), cp.eq(LS4[2],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                        }
                    }
                                       
                    // 3 et 4
                    for(int elem=0; elem<N;elem++ ){
                        for(int elem2=0; elem2<N ;elem2++ ){
                            cp.add(cp.ifThen(cp.and(cp.eq(LS4[2],elem), cp.eq(LS4[3],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                        }
                    }
                    
                    // 4 et 1
                    for(int elem=0; elem<N;elem++ ){
                        for(int elem2=0; elem2<N ;elem2++ ){
                            cp.add(cp.ifThen(cp.and(cp.eq(LS4[3],elem), cp.eq(LS4[0],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                        }

                    }
                     
                    } catch (IloException ex) {
                        Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
                    } 

                }
                //#-------------Cycle 5--------------------#
                if (ImposedFragments[2]==true){
                    //IloIntVar[] LS5 = new IloIntVar[5];
                    try {
                        LS5 = cp.intVarArray(5,0,N-1);
 
                        cp.add(cp.allDiff(LS5));
                        cp.add(cp.lt(LS5[0],LS5[1]) );
                        cp.add(cp.lt(LS5[0],LS5[2]) );
                        cp.add(cp.lt(LS5[0],LS5[3]) );
                        cp.add(cp.lt(LS5[0],LS5[4]) );
                        cp.add(cp.lt(LS5[1],LS5[4]) );
                         
                        // 1 et 2
                        for(int elem=0; elem<N;elem++ ){
                            for(int elem2=0; elem2<N ;elem2++ ){
                                cp.add(cp.ifThen(cp.and(cp.eq(LS5[0],elem), cp.eq(LS5[1],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                            }
                        }

                        // 2 et 3
                        for(int elem=0; elem<N;elem++ ){
                            for(int elem2=0; elem2<N ;elem2++ ){
                                cp.add(cp.ifThen(cp.and(cp.eq(LS5[1],elem), cp.eq(LS5[2],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                            }
                        }

                        // 3 et 4
                        for(int elem=0; elem<N;elem++ ){
                            for(int elem2=0; elem2<N ;elem2++ ){
                                cp.add(cp.ifThen(cp.and(cp.eq(LS5[2],elem), cp.eq(LS5[3],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                            }
                        }
                        
                        
                        // 4 et 5
                        for(int elem=0; elem<N;elem++ ){
                            for(int elem2=0; elem2<N ;elem2++ ){
                                cp.add(cp.ifThen(cp.and(cp.eq(LS5[3],elem), cp.eq(LS5[4],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                            }
                        }

                        // 5 et 1
                        for(int elem=0; elem<N;elem++ ){
                            for(int elem2=0; elem2<N ;elem2++ ){
                                cp.add(cp.ifThen(cp.and(cp.eq(LS5[4],elem), cp.eq(LS5[0],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                            }
                        }
                        
                    } catch (IloException ex) {
                        Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
                
                // #-------------Cycle 6--------------------#
                if (ImposedFragments[3]==true){
                    //IloIntVar[] LS6= new IloIntVar[6];
                    try {
                        LS6 = cp.intVarArray(6,0,N-1);
                        cp.add(cp.allDiff(LS6));
                        cp.add(cp.lt(LS6[0],LS6[1]) );
                        cp.add(cp.lt(LS6[0],LS6[2]) );
                        cp.add(cp.lt(LS6[0],LS6[3]) );
                        cp.add(cp.lt(LS6[0],LS6[4]) );
                        cp.add(cp.lt(LS6[0],LS6[5]) );
                        cp.add(cp.lt(LS6[1],LS6[5]) );
                                    
                        // 1 et 2
                        for(int elem=0; elem<N;elem++ ){
                            for(int elem2=0; elem2<N ;elem2++ ){
                                cp.add(cp.ifThen(cp.and(cp.eq(LS6[0],elem), cp.eq(LS6[1],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                            }
                        }

                        // 2 et 3
                        for(int elem=0; elem<N;elem++ ){
                            for(int elem2=0; elem2<N ;elem2++ ){
                                cp.add(cp.ifThen(cp.and(cp.eq(LS6[1],elem), cp.eq(LS6[2],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                            }
                        }

                        // 3 et 4
                        for(int elem=0; elem<N;elem++ ){
                            for(int elem2=0; elem2<N ;elem2++ ){
                                cp.add(cp.ifThen(cp.and(cp.eq(LS6[2],elem), cp.eq(LS6[3],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                            }
                        }
                        
                        
                        // 4 et 5
                        for(int elem=0; elem<N;elem++ ){
                            for(int elem2=0; elem2<N ;elem2++ ){
                                cp.add(cp.ifThen(cp.and(cp.eq(LS6[3],elem), cp.eq(LS6[4],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                            }
                        }
                        
                        // 5 et 6
                        for(int elem=0; elem<N;elem++ ){
                            for(int elem2=0; elem2<N ;elem2++ ){
                                cp.add(cp.ifThen(cp.and(cp.eq(LS6[4],elem), cp.eq(LS6[5],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                            }
                        }

                        // 6 et 1
                        for(int elem=0; elem<N;elem++ ){
                            for(int elem2=0; elem2<N ;elem2++ ){
                                cp.add(cp.ifThen(cp.and(cp.eq(LS6[5],elem), cp.eq(LS6[0],elem2)),  cp.neq(MATRIX[elem][elem2],0)));
                            }
                        }
                        
                    } catch (IloException ex) {
                        Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
        }  
        
        
        //************** Constraint 61: Forbidden Fragment *************
        if (ForbiddenFragments[0]==true||ForbiddenFragments[1]==true||ForbiddenFragments[2]==true||ForbiddenFragments[3]==true){
            //#-------------Forbidding Cycle 3--------------------#
            
            if (ForbiddenFragments[0]==true){
                    //ArrayList<int[]> ExplicitCycle3= CyclesGeneration.Cycles(N, 3);
                    //#print "\n ExplicitCycle3",ExplicitCycle3
                    //#for cycle in ExplicitCycle3:
                    //#    cycle.append(cycle[0])
                    //#   model.add(  Min([Mesvariables[ (cycle[j]* n + cycle[j+1]) ] for j in range(3)]) ==0)
                for (int i = 0; i<ExplicitCycle3.size();i++) {  
                    int [] Aux = new int[3];
                    Aux=ExplicitCycle3.get(i);
                    try {
                        IloConstraint Cycle3Constraint [] = new IloConstraint[3]  ;
                        Cycle3Constraint[0]= cp.eq(MATRIX[Aux[0]][Aux[1]],0);
                        Cycle3Constraint[1]= cp.eq(MATRIX[Aux[1]][Aux[2]],0);
                        Cycle3Constraint[2]= cp.eq(MATRIX[Aux[2]][Aux[0]],0);
                        cp.add( cp.or( Cycle3Constraint   )  );
                    } catch (IloException ex) {
                            Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }


            //#-------------Forbidding Cycle 4--------------------#
            if (ForbiddenFragments[1]==true){
                    //ArrayList<int[]> ExplicitCycle4= CyclesGeneration.Cycles(N, 4);
                for (int i = 0; i<ExplicitCycle4.size();i++) {  
                    int [] Aux = new int[4];
                    Aux=ExplicitCycle4.get(i);
                    try {
                        IloConstraint Cycle4Constraint [] = new IloConstraint[4]  ;
                        Cycle4Constraint[0]= cp.eq(MATRIX[Aux[0]][Aux[1]],0);
                        Cycle4Constraint[1]= cp.eq(MATRIX[Aux[1]][Aux[2]],0);
                        Cycle4Constraint[2]= cp.eq(MATRIX[Aux[2]][Aux[3]],0);
                        Cycle4Constraint[3]= cp.eq(MATRIX[Aux[3]][Aux[0]],0);
                        cp.add( cp.or( Cycle4Constraint   )  );
                    } catch (IloException ex) {
                            Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }      


            //#-------------Forbidding Cycle 5--------------------#
            if (ForbiddenFragments[2]==true){
                   // ArrayList<int[]> ExplicitCycle5= CyclesGeneration.Cycles(N, 5);
                for (int i = 0; i< ExplicitCycle5.size();i++) {  
                    int [] Aux = ExplicitCycle5.get(i);
                   /* for(int k : Aux ){
                        System.out.print(" "+k);
                    }
                    System.out.print("\n");
                    */
                    try {
                        IloConstraint Cycle5Constraint [] = new IloConstraint[5]  ;
                        
                        Cycle5Constraint[0]= cp.eq(MATRIX[Aux[0]][Aux[1]],0);
                        Cycle5Constraint[1]= cp.eq(MATRIX[Aux[1]][Aux[2]],0);
                        Cycle5Constraint[2]= cp.eq(MATRIX[Aux[2]][Aux[3]],0);
                        Cycle5Constraint[3]= cp.eq(MATRIX[Aux[3]][Aux[4]],0);
                        Cycle5Constraint[4]= cp.eq(MATRIX[Aux[4]][Aux[0]],0);
                        cp.add(cp.or(Cycle5Constraint));
                       
                        //ou bien IloConstraint Cycle5Constraint [] = new IloConstraint[4]  ;
                        //Cycle5Constraint[0]= cp.neq(MATRIX[Aux[0]][Aux[1]],0);
                        //Cycle5Constraint[1]= cp.neq(MATRIX[Aux[1]][Aux[2]],0);
                        //Cycle5Constraint[2]= cp.neq(MATRIX[Aux[2]][Aux[3]],0);
                        //Cycle5Constraint[3]= cp.neq(MATRIX[Aux[3]][Aux[4]],0);
                        //Cycle5Constraint[3]= cp.neq(MATRIX[Aux[4]][Aux[0]],0);
                        //cp.add(cp.ifThen(cp.and(Cycle5Constraint), cp.eq(MATRIX[Aux[4]][Aux[0]],0))   );
                    } catch (IloException ex) {
                            Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }    
            //#-------------Forbidding Cycle 6--------------------#
            if (ForbiddenFragments[3]==true){
                    //ArrayList<int[]> ExplicitCycle6= CyclesGeneration.Cycles(N, 6);
                for (int i = 0; i< ExplicitCycle6.size();i++) {  
                    int [] Aux = new int[6];
                    Aux= ExplicitCycle6.get(i);
                    try {
                        IloConstraint Cycle6Constraint [] = new IloConstraint[6]  ;
                        Cycle6Constraint[0]= cp.eq(MATRIX[Aux[0]][Aux[1]],0);
                        Cycle6Constraint[1]= cp.eq(MATRIX[Aux[1]][Aux[2]],0);
                        Cycle6Constraint[2]= cp.eq(MATRIX[Aux[2]][Aux[3]],0);
                        Cycle6Constraint[3]= cp.eq(MATRIX[Aux[3]][Aux[4]],0);
                        Cycle6Constraint[4]= cp.eq(MATRIX[Aux[4]][Aux[5]],0);
                        Cycle6Constraint[5]= cp.eq(MATRIX[Aux[5]][Aux[0]],0);
                        cp.add( cp.or( Cycle6Constraint   )  );
                    } catch (IloException ex) {
                            Logger.getLogger(FinalStep.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }    
            
            
        }
        //***************************** End CONSTRAINTS ***********************************#
        //***************** Begin Solution Generation Process ****************************#
        //**** All Solution generation ****#

            try{
                 Date Start = new Date();
                boolean ok = false;
                cp.startNewSearch();
                int compteur = 0;
                /*
                System.out.print(" "+cp.getCPImpl());
                System.out.print(" "+cp.getInfo(IloCP.DoubleInfo.SolveTime));
                System.out.print(" "+cp.getModelImplSafe());*/
                while (cp.next()) {
                    compteur++;
                    ok = true;
                    System.out.println("\n \n Solution N°: "+compteur);
                    //jTextAreaResult.append("\n \n Solution N°: "+compteur+"\n");
                    for (int i=0; i<N; i++){
                        for (int j=0; j<N; j++){
                            System.out.print(" "+(int) cp.getValue(MATRIX[i][j]) );
                          //  jTextAreaResult.append(" "+(int) cp.getValue(MATRIX[i][j]));
                        }
                        System.out.print("\n");
                      //  jTextAreaResult.append("\n ");
                    }
                    /*
                    if (NbrCorrelations!=0){  
                        for (int i = 0; i < NbrCorrelations; i++) {                                             
                            System.out.println("\n");
                            System.out.print("correlations["+i+"]:"+ (int)cp.getValue(correlations[i]));
                        }
                    }*/
                    
                    if (ImposedFragments[0]==true){  
                        for (int i = 0; i < 3; i++) {                                             
                                System.out.println("\n");
                                System.out.print("LS3["+i+"]:"+ (int)cp.getValue(LS3[i]));

                        }
                   }
                    if (ImposedFragments[1]==true){  
                        for (int i = 0; i < 4; i++) {                                             
                                System.out.println("\n");
                                System.out.print("LS4["+i+"]:"+ (int)cp.getValue(LS4[i]));

                        }
                   }
                    if (ImposedFragments[2]==true){  
                        for (int i = 0; i < 5; i++) {                                             
                                System.out.println("\n");
                                System.out.print("LS5["+i+"]:"+ (int)cp.getValue(LS5[i]));

                        }
                   }
                    if (ImposedFragments[3]==true){  
                        for (int i = 0; i < 6; i++) {                                             
                                System.out.println("\n");
                                System.out.print("LS6["+i+"]:"+ (int)cp.getValue(LS6[i]));

                        }
                   }
                    

                }
                cp.endSearch();
                if (!ok){
                    System.out.println("No solution found.");
                  //  jTextAreaResult.append("No solution found.");
                    JOptionPane.showMessageDialog(null," No Solution found", "Error", JOptionPane.INFORMATION_MESSAGE);
                }else{
                     Date Stop = new Date();
                    double diff = Stop.getTime() - Start.getTime() ;
                    diff = diff /1000 %60 ;    
                    JOptionPane.showMessageDialog(null,""+compteur+" Solution(s) found with this configuration \n CPU Time: "+diff+" Second(s) \n Thanks for trying...", "Information Messsage", JOptionPane.INFORMATION_MESSAGE);

                }
                //cp.end();
            } catch (Exception e) {
                System.err.println("Error " + e);
            }
  
       
             
             
      
      
  }
    
    
}
