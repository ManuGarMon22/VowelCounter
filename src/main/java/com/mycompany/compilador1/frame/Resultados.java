/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.compilador1.frame;

import com.mycompany.compilador1.resources.Lexer;
import java.io.Reader;
/**
 *
 * @author manu
 */
public class Resultados extends javax.swing.JDialog {
    
    
    private Lexer lexer;
    /**
     * Creates new form Resultados
     */
    public Resultados(java.awt.Frame parent, boolean modal, Reader reader) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Resultados");
        lexer = new Lexer(reader);
        try {
            int output;
            do {
                lexer.yylex();
                output = lexer.yylex();
            }while (output != Lexer.YYEOF);
            
            Llenar(lexer);
            
            
        } catch (Exception e) {
            System.out.println("Atrape un error y lo maneje de forma correcta");
        }
        
    }
    
    private void Llenar(Lexer lexer){
        int datos[] = lexer.getVowelNumbers();
        
        this.oneVLabel.setText("Cantidad de palabras con una vocal: "+datos[0]);
        this.twoVLabel.setText("Cantidad de palabras con dos vocales: "+datos[1]);
        this.threeVLabel.setText("Cantidad de palabras con tres vocales: "+datos[2]);
        this.fourVLabel.setText("Cantidad de palabras con cuatro vocales: "+datos[3]);
        this.fiveVLabel.setText("Cantidad de palabras con cinco vocales: "+datos[4]);
        
        for(String x: lexer.getNumberInfo()){
            this.jTextArea1.append(x+"\n");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        oneVLabel = new javax.swing.JLabel();
        twoVLabel = new javax.swing.JLabel();
        threeVLabel = new javax.swing.JLabel();
        fourVLabel = new javax.swing.JLabel();
        fiveVLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        oneVLabel.setText("Cantidad de palabras con una vocal: ");

        twoVLabel.setText("Cantidad de palabras con dos vocales: ");

        threeVLabel.setText("Cantidad de palabras con tres vocales: ");

        fourVLabel.setText("Cantidad de palabras con cuatro vocales: ");

        fiveVLabel.setText("Cantidad de palabras con cinco vocales: ");

        jLabel1.setText("Numeros encontrados:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(fiveVLabel)
                    .addComponent(fourVLabel)
                    .addComponent(oneVLabel)
                    .addComponent(threeVLabel)
                    .addComponent(twoVLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(oneVLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(twoVLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(threeVLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fourVLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fiveVLabel)
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    /**
     * @param args the command line arguments
     */
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fiveVLabel;
    private javax.swing.JLabel fourVLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel oneVLabel;
    private javax.swing.JLabel threeVLabel;
    private javax.swing.JLabel twoVLabel;
    // End of variables declaration//GEN-END:variables
}