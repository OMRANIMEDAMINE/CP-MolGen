/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Lien utiles : http://jung.sourceforge.net/doc/JUNGVisualizationGuide.html
 * https://www.javatips.net/api/edu.uci.ics.jung.visualization.renderers.vertexlabelrenderer
 */
package molecular.structure.generator.v1.pkg0.entities;


import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import java.awt.Dimension;
import javax.swing.JFrame;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.Enumeration;
import java.util.Hashtable;
import molecular.structure.generator.v1.pkg0.cle;
import org.apache.commons.collections15.Transformer;


/*
class MyNode {
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

class MyLink {
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
*/
/**
 *
 * @author OMRANI
 */
public class GraphModelisation {
    public static int edgeCount=0;   
   
    
    /**
     * @param args the command line arguments
     */
    public GraphModelisation(){};
    public  SparseMultigraph<MyNode, MyLink> CreateMatrix(int Matrix[][], Hashtable m) {
        // TODO code application logic here
        SparseMultigraph<MyNode, MyLink> g = new SparseMultigraph<MyNode, MyLink>();
        MyNode MyNodes []= new MyNode[Matrix.length];
        
       /* Enumeration e = T.keys();
        while (e.hasMoreElements()) {
        String key = (String) e.nextElement();
        System.out.println(key + " : " + T.get(key)); }
         //   this.molStep1.ReadHashtable(this.molStep1.GettableOfSymboles());
        */
       
          Enumeration e = m.keys();
    
        while (e.hasMoreElements()) {
        String key = (String) e.nextElement();
       // System.out.println(key + " : " + m.get(key)); 
          MyNodes[Integer.parseInt(key)] = new MyNode(Integer.parseInt(key),""+m.get(key));
            g.addVertex(MyNodes[Integer.parseInt(key)]);
       
        }
        

        for (int i=0; i<Matrix.length; i++){      
            for (int j=i; j<Matrix.length; j++){
                if(Matrix[i][j]!=0){
                        g.addEdge(new MyLink(Matrix[i][j], 0),  MyNodes[i], MyNodes[j], EdgeType.UNDIRECTED); 
                }

              /*  if(Matrix[i][j]==2){
                    g.addEdge(new MyLink(0, 0), n1, n2, EdgeType.UNDIRECTED); 
                }
                if(Matrix[i][j]==3){
                    g.addEdge(new MyLink(0, 0), n1, n2, EdgeType.UNDIRECTED); 
                }*/
            }
        }
       
       
        return g;
    }
    
        
    public  void  PlotGraph(SparseMultigraph<MyNode, MyLink> g , String MF) {
        // TODO code application logic here
        Layout<MyNode, MyLink> layout = new KKLayout<MyNode, MyLink>(g);
        layout.setSize(new Dimension(400,400)); // sets the initial size of the space
        // The BasicVisualizationServer<V,E> is parameterized by the edge types
        VisualizationViewer<MyNode,MyLink> vv = new VisualizationViewer<MyNode,MyLink>(layout);
        vv.setPreferredSize(new Dimension(450,450)); //Sets the viewing area size
        vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line());
        vv.setBackground(Color.white);
        
      
        
        // Transformer maps the vertex number to a vertex property
        Transformer<MyNode,Paint> vertexColor = new Transformer<MyNode,Paint>() {
            public Paint transform(MyNode i) {
                
                if(i.Symbole.toUpperCase().trim().equals("C"))return new Color(152,152,152);
                if(i.Symbole.toUpperCase().trim().equals("N"))return new Color(202,202,202);
                if(i.Symbole.toUpperCase().trim().equals("H"))return new Color(252,252,252);
                if(i.Symbole.toUpperCase().trim().equals("O"))return new Color(45,118,232);
                if(i.Symbole.toUpperCase().trim().equals("F"))return new Color(204,0,255);
                if(i.Symbole.toUpperCase().trim().equals("S"))return new Color(0,153,153);
                if(i.Symbole.toUpperCase().trim().equals("CL"))return new Color(204,102,0);
                if(i.Symbole.toUpperCase().trim().equals("BR"))return new Color(253,151,50);
                return new Color(250,250,250);
   
            }
        };
        
        Transformer<MyNode,Shape> vertexSize = new Transformer<MyNode,Shape>(){
            public Shape transform(MyNode i){
                Ellipse2D circle = new Ellipse2D.Double(-15, -15, 30, 30);
                // in this case, the vertex is twice as large
                /*if(i ==  new MyNode(2)) return AffineTransform.getScaleInstance(2, 2).createTransformedShape(circle);
                else return circle;*/
                return AffineTransform.getScaleInstance(0.7, 0.7).createTransformedShape(circle);
                //getScaleInstance(2, 2) ou 3,3 pour agrandir les cercle
                
            }
        };
        
       Transformer<MyLink,Paint> edgePaint  = new Transformer<MyLink,Paint>() {
            public Paint transform(MyLink i) {
               
               if(i.weight == 2 ) return Color.BLUE;
               if(i.weight == 3 ) return Color.RED;
                return  Color.BLACK;
            }
       };
            
       // edges ligne discontenu
       /*
         Transformer<MyLink, Stroke> edgeStroke = new Transformer<MyLink, Stroke>() {
        float dash[] = { 10.0f };
        public Stroke transform(MyLink s) {
             //MyLink l= new MyLink((1, 2),  g.my.MyNode[1], MyNodes[2], EdgeType.UNDIRECTED );
            return new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
        }
         };

    */
       
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller() {
                public String transform(MyNode v) {

                    return (v.Symbole);
                }});
        
        vv.getRenderContext().setVertexFillPaintTransformer(vertexColor);
        vv.getRenderContext().setVertexShapeTransformer(vertexSize);
        
        // paint edges
        vv.getRenderContext().setEdgeDrawPaintTransformer(edgePaint);
       
        // edges ligne discontenu // vv.getRenderContext().setEdgeStrokeTransformer(edgeStroke);
      
        // ScalingControl scaler = new CrossoverScalingControl(); 
//caler.scale(vv, 1 / 1.1f, vv.getCenter());

        JFrame frame = new JFrame("Show Molecular Structure of: "+MF);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //frame.getContentPane().add(new JLabel("Molecular Formula: "+MF), BorderLayout.PAGE_START);
        frame.getContentPane().add(new cle(), BorderLayout.PAGE_END);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true); 
        frame.setLocationRelativeTo(null);       

            
     
        }
    
 

    
    
    
 
 public static void main(String args[]) {
  int mat[][] = {
    {0, 3, 2, 0, 0, 0, 0, 1, 0},
    {3, 0, 0, 0, 0, 0, 0, 0, 1},
    {2, 0, 0, 3, 0, 0, 1, 0, 0},
    {0, 0, 3, 0, 0, 0, 0, 0, 1},
    {0, 0, 0, 0, 0, 3, 0, 1, 0},
    {0, 0, 0, 0, 3, 0, 1, 0, 0},
    {0, 0, 1, 0, 0, 1, 0, 1, 1},
    {1, 0, 0, 0, 1, 0, 1, 0, 1},
    {0, 1, 0, 1, 0, 0, 1, 1, 0}
    }; 
  
    GraphModelisation GM = new GraphModelisation();
    Hashtable m= new Hashtable();
    
    m.put("0", "C");
    m.put("1", "C");
    m.put("2", "C");
    m.put("3", "C");
    m.put("4", "C");
    m.put("5", "C");
    m.put("6", "CL");
    m.put("7", "O");
    m.put("8", "C");
    SparseMultigraph<MyNode, MyLink> MoleculeGraph = GM.CreateMatrix(mat,m);
    GM.PlotGraph(MoleculeGraph,"C10H13");
  
    
    
    
 }

}
    
    
