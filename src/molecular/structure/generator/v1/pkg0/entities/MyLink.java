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
public class MyLink {
double capacity; // should be private
 double weight; // should be private for good practice
 int id;

 public MyLink(double weight, double capacity) {
 this.id = GraphModelisation.edgeCount++; // This is defined in the outer class.
 this.weight = weight;
 this.capacity = capacity;
 }
 public String toString() { // Always good for debugging
 return "E"+id;
 }
}
