/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molecular.structure.generator.v1.pkg0;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import molecular.structure.generator.v1.pkg0.entities.molecule;

/**
 *
 * @author OMRANI
 */
public class Step2 extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    
    public molecule molStep2 = new molecule() ;
    
    
    java.util.List<JTextField> listOfTextFieldsMult = new ArrayList<JTextField>();
    java.util.List<JTextField> listOfTextFieldsSp = new ArrayList<JTextField>();
    
    public Hashtable tableOfValence = new Hashtable();  
    public Hashtable tableOfMult = new Hashtable();  
    public Hashtable tableOfSp = new Hashtable();  
    public Hashtable tableOfValenceWithoutHydrogen = new Hashtable();  
    
    public Hashtable gettableOfValence(){ return this.tableOfValence; }
    public Hashtable gettableOfMult(){ return this.tableOfMult; }
    public Hashtable gettableOfSp(){ return this.tableOfSp; }
    public Hashtable gettableOftableOfValenceWithoutHydrogen(){ return this.tableOfValenceWithoutHydrogen; }
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
    public Step2(molecule mol) {
       this.molStep2=mol;
        initComponents();
        this.setLocationRelativeTo(null);
        jLabelValidateStep2Go.setVisible(false);
        
         this.jLabel5.setText(this.molStep2.GetStringOfMolecularFormula());
        //System.out.println(this.molStep2.GetStringOfMolecularFormula());
           //jPanel7.setLayout(new GridBagLayout());
        
        jPanel7.setLayout(new BoxLayout(jPanel7, BoxLayout.Y_AXIS));
        jPanel8.setLayout(new BoxLayout(jPanel8, BoxLayout.Y_AXIS));
        jPanel9.setLayout(new BoxLayout(jPanel9, BoxLayout.Y_AXIS));
        jPanel10.setLayout(new BoxLayout(jPanel10, BoxLayout.Y_AXIS));
        jPanel11.setLayout(new BoxLayout(jPanel11, BoxLayout.Y_AXIS));
         

    for (Integer i = 0; i < this.molStep2.GetNumberOfAtomsNoHydrogen(); i++) {
                final JLabel Num = new JLabel();    
                Integer s=i+1;
                Num.setText(s.toString());
                //Num.setFont(new Font(Num.getFont().getName(),Num.getFont().getStyle(), 26));
               // Num.setBorder(new LineBorder(Color.GRAY));
                Num.setMinimumSize(new Dimension(24,24));  
                Num.setPreferredSize(new Dimension(24,24));   
                Num.setForeground(Color.DARK_GRAY);
                Num.setFont(new java.awt.Font("Segoe UI", 0, 25)); 

                jPanel7.add(Num);                   
    }
    for (Integer i = 0; i < this.molStep2.GetNumberOfAtomsNoHydrogen(); i++) {
                final JTextField Symb = new JTextField();    
                String Symbo = this.molStep2.GettableOfSymboles().get(i.toString()).toString();                
                Symb.setText(Symbo.toString()); 
                //Symb.setFont(new Font(Symb.getFont().getName(),Symb.getFont().getStyle(), 26));
               // Num.setBorder(new LineBorder(Color.GRAY));
                //Symb.setMinimumSize(new Dimension(34,34));  
                Symb.setMaximumSize(new java.awt.Dimension(50,34));
                Symb.setMinimumSize(new java.awt.Dimension(50,34));
                Symb.setPreferredSize(new java.awt.Dimension(50,34));
                Symb.setEditable(false);
                Symb.setEnabled(false);
                Symb.setForeground(Color.DARK_GRAY);
                Symb.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
                
                jPanel11.add(Symb);                   
     }
        
    for (Integer i = 0; i <  this.molStep2.GetNumberOfAtomsNoHydrogen(); i++) {
                    final JTextField JTVal = new JTextField();     
                
                    String Sym = this.molStep2.GettableOfSymboles().get(i.toString()).toString().trim();
                    Integer ValSymStandard= this.molStep2.GetValenceStandardOfAtomint(Sym); 
                    JTVal.setText(ValSymStandard.toString()); 

                
                JTVal.setMaximumSize(new java.awt.Dimension(50,34));
                JTVal.setMinimumSize(new java.awt.Dimension(50,34));
                JTVal.setPreferredSize(new java.awt.Dimension(50,34));
                JTVal.setForeground(Color.DARK_GRAY);
                JTVal.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
                jPanel8.add(JTVal);                 
                //listOfTextFieldsVal.add(JTVal);
                JTVal.setEditable(false);
                JTVal.setEnabled(false);
     }
        
        for (Integer i = 0; i <  this.molStep2.GetNumberOfAtomsNoHydrogen(); i++) {
                final JTextField JTMult = new JTextField();                 
                JTMult.setText("Mult");               
                 
                JTMult.setMaximumSize(new java.awt.Dimension(65,34));
                JTMult.setMinimumSize(new java.awt.Dimension(65,34));
                JTMult.setPreferredSize(new java.awt.Dimension(65,34));
                JTMult.setForeground(Color.DARK_GRAY);
                JTMult.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
                jPanel9.add(JTMult);
                  JTMult.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    JTMult.setText("");
                }

                public void focusLost(FocusEvent e) {
                   if(JTMult.getText().toString().isEmpty()){
                       JTMult.setText("Mult");
                   }
                }
                });
                  
        listOfTextFieldsMult.add(JTMult);
                
   }
        for (Integer i = 0; i <  this.molStep2.GetNumberOfAtomsNoHydrogen(); i++) {
                final JTextField JTSp = new JTextField();                 
                JTSp.setText("Sp");
                JTSp.setMaximumSize(new java.awt.Dimension(50,34));
                JTSp.setMinimumSize(new java.awt.Dimension(50,34));
                JTSp.setPreferredSize(new java.awt.Dimension(50,34));
                JTSp.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
                JTSp.setForeground(Color.DARK_GRAY);                            
                jPanel10.add(JTSp);
                
                JTSp.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    JTSp.setText("");
                }

                public void focusLost(FocusEvent e) {
                   if(JTSp.getText().toString().isEmpty()){
                       JTSp.setText("Sp");
                   }
                }
                });
                  
        listOfTextFieldsSp.add(JTSp);      
   }
        
           jPanel7.updateUI();
           jPanel8.updateUI();
           jPanel9.updateUI();
           jPanel10.updateUI();
           jPanel5.setSize(427, 20000);   
           jPanel5.updateUI();   
    
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabelValidateStep2 = new javax.swing.JLabel();
        jLabelValidateStep2Go = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 118, 232), 2));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(245, 245, 245));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 10));

        jPanel5.setBackground(new java.awt.Color(245, 245, 245));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));

        jPanel7.setBackground(new java.awt.Color(245, 245, 245));
        jPanel7.setForeground(new java.awt.Color(45, 118, 232));
        jPanel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel7.setMaximumSize(new java.awt.Dimension(2147483647, 171));
        jPanel7.setPreferredSize(new java.awt.Dimension(171, 105));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel8.setBackground(new java.awt.Color(245, 245, 245));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel8.setMaximumSize(new java.awt.Dimension(2147483647, 171));
        jPanel8.setPreferredSize(new java.awt.Dimension(171, 105));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jPanel9.setBackground(new java.awt.Color(245, 245, 245));
        jPanel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel9.setMaximumSize(new java.awt.Dimension(2147483647, 171));
        jPanel9.setPreferredSize(new java.awt.Dimension(171, 105));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jPanel10.setBackground(new java.awt.Color(245, 245, 245));
        jPanel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel10.setMaximumSize(new java.awt.Dimension(2147483647, 171));
        jPanel10.setPreferredSize(new java.awt.Dimension(171, 105));
        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        jPanel11.setBackground(new java.awt.Color(245, 245, 245));
        jPanel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel11.setMaximumSize(new java.awt.Dimension(2147483647, 171));
        jPanel11.setPreferredSize(new java.awt.Dimension(171, 105));
        jPanel11.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel5);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );

        jLabelValidateStep2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelValidateStep2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelValidateStep2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValidateStep2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/molecular/structure/generator/v1/pkg0/images/icons8_Checked_52px.png"))); // NOI18N
        jLabelValidateStep2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 118, 232)));
        jLabelValidateStep2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelValidateStep2MouseClicked(evt);
            }
        });

        jLabelValidateStep2Go.setBackground(new java.awt.Color(255, 255, 255));
        jLabelValidateStep2Go.setForeground(new java.awt.Color(255, 255, 255));
        jLabelValidateStep2Go.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValidateStep2Go.setIcon(new javax.swing.ImageIcon(getClass().getResource("/molecular/structure/generator/v1/pkg0/images/icons8_Login_64px.png"))); // NOI18N
        jLabelValidateStep2Go.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 118, 232)));
        jLabelValidateStep2Go.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelValidateStep2GoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelValidateStep2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValidateStep2Go, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabelValidateStep2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabelValidateStep2Go, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 51, 204));
        jPanel4.setMaximumSize(new java.awt.Dimension(950, 30));
        jPanel4.setMinimumSize(new java.awt.Dimension(950, 30));

        jLabel6.setFont(new java.awt.Font("Vrinda", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Copyright-2019 © M.A. Omrani & W. Naanaa - LIMTIC Lab");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel10.setBackground(new java.awt.Color(0, 51, 204));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Multiplicity and Hybridation States Of");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jPanel2.setBackground(new java.awt.Color(0, 51, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Constraint-Based Molecular Structure Generator version 1.0");

        jLabel2.setFont(new java.awt.Font("Utsaah", 0, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel2KeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Utsaah", 0, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("?");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jLabel7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel7KeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CP-MolGen");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelValidateStep2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelValidateStep2MouseClicked
        // TODO add your handling code here:
         Integer compteur=0;
        int num;

        boolean error =false;
        for (JTextField JTMult : listOfTextFieldsMult) {
            String Mult = JTMult.getText().toString().trim().toUpperCase();
            num=compteur+1;
            if(containsDigit(Mult)){
                Integer M = Integer.parseInt(Mult);
                tableOfMult.put(compteur.toString(), M);
                if((M>3) || (M<0)){
                    error=true;
                    JOptionPane.showMessageDialog(this, "Atom N°"+num+" Have a False Multiplicity", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }else{  error=true;
                JOptionPane.showMessageDialog(this, "Atom N°"+num+" Have a Not Multiplicity Number", "Error", JOptionPane.ERROR_MESSAGE);
                break;}
            compteur++;
        }

        if (!error){
            compteur=0;
            for (JTextField JTSP : listOfTextFieldsSp) {
                String Sp = JTSP.getText().toString().trim().toUpperCase();
                num=compteur+1;
                if(containsDigit(Sp)){
                    Integer S = Integer.parseInt(Sp);
                    tableOfSp.put(compteur.toString(), S);
                    if((S>3) || (S<1)){
                        error=true;
                        JOptionPane.showMessageDialog(this, "Atom N°"+num+" Have a False Hybridation States", "Error", JOptionPane.ERROR_MESSAGE);
                        break;}
                }else{ error=true;
                    JOptionPane.showMessageDialog(this, "Atom N°"+num+" Have a Not Hybridation States", "Error", JOptionPane.ERROR_MESSAGE);
                    break;}
                compteur++;
            }
        }

        if (!error){

            jLabelValidateStep2Go.setVisible(true);
            this.molStep2.SetHashtableOfMultiplicity(tableOfMult);
            this.molStep2.SetHashtableOfHybridation(tableOfSp);
            
            
            int len = this.tableOfMult.size();
            for(Integer i=0; i<len;i++ ){
                String S = this.molStep2.GettableOfSymboles().get(i.toString()).toString();
                int v= this.molStep2.GetValenceStandardOfAtomint(S);

                Integer m = Integer.parseInt(this.tableOfMult.get(i.toString()).toString());
                Integer d=v-m;
                this.tableOfValenceWithoutHydrogen.put(i.toString(), (d));
            }
            this.molStep2.SettableOfValenceWithoutHydrogene(tableOfValenceWithoutHydrogen);
            
          //  System.out.println("cc"+ this.molStep2.GettableOfMolecularFormula());
        }

       
    
    }//GEN-LAST:event_jLabelValidateStep2MouseClicked

    private void jLabelValidateStep2GoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelValidateStep2GoMouseClicked
        // TODO add your handling code here:
        Step3 s3 =new Step3(this.molStep2);
        //this.hide();
       // s3.show();
        this.setVisible(false);
        s3.setVisible(true);
    }//GEN-LAST:event_jLabelValidateStep2GoMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel2KeyPressed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        new Help().setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7KeyPressed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelValidateStep2;
    private javax.swing.JLabel jLabelValidateStep2Go;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
