/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molecular.structure.generator.v1.pkg0.entities;

/**
 *
 * @author OMRANI
 */
public class MyNode {
 int id; // good coding practice would have this as private
 String Symbole; // good coding practice would have this as private
 public MyNode(int id, String Symbole) {
 this.id = id;
 this.Symbole = Symbole;
 }
 public String toString() { // Always a good idea for debuging
 return ""+this.Symbole+id; // JUNG2 makes good use of these.
 }
 }
