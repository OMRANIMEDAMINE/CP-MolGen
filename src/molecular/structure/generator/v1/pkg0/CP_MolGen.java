/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molecular.structure.generator.v1.pkg0;


/*
class MyNode {
 int id; // good coding practice would have this as private
 public MyNode(int id) {
 this.id = id;
 }
 public String toString() { // Always a good idea for debuging
 return "V"+id; // JUNG2 makes good use of these.
 }
 }

 class MyLink {
 double capacity; // should be private
 double weight; // should be private for good practice
 int id;

 public MyLink(double weight, double capacity) {
 this.id = CP_MolGen.edgeCount++; // This is defined in the outer class.
 this.weight = weight;
 this.capacity = capacity;
 }
 public String toString() { // Always good for debugging
 return "E"+id;
 }

 }*/

/**
 *
 * @author OMRANI
 */
public class CP_MolGen {
    public static int edgeCount=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.loadLibrary("opl1260");
        // TODO code application logic here
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                new Home().setVisible(true);
            }
        });
    }
    
    
}