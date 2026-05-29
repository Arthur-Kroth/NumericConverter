package com.view;

import com.model.Conversor;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class ConversorInterface extends javax.swing.JFrame {

    Conversor c = new Conversor();
    private boolean isUpdating = false;
    
    public ConversorInterface() {
        initComponents();
        
        txtBinary.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                convert("binaria");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                convert("binaria");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                convert("binaria"); // Para mudanças de estilo
            }
        });
        
        txtOctal.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                convert("octal");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                convert("octal");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                convert("octal"); // Para mudanças de estilo
            }
        });
        
        txtDecimal.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                convert("decimal");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                convert("decimal");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                convert("decimal"); // Para mudanças de estilo
            }
        });
        
        txtHexadecimal.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                convert("hexadecimal");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                convert("hexadecimal");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                convert("hexadecimal"); // Para mudanças de estilo
            }
        });
    }
    
    private void convert(String base) {
        if (isUpdating) return;

        isUpdating = true;
        try {
            lblStatus.setText("");
            
            String texto = switch (base) {
                case "binaria" -> txtBinary.getText().trim();
                case "octal"  -> txtOctal.getText().trim();
                case "hexadecimal"    -> txtHexadecimal.getText().trim();
                default       -> txtDecimal.getText().trim();
            };

            if (texto.isEmpty()) {
                if (!base.equals("binaria"))  txtBinary.setText("");
                if (!base.equals("octal"))   txtOctal.setText("");
                if (!base.equals("decimal")) txtDecimal.setText("");
                if (!base.equals("hexadecimal"))     txtHexadecimal.setText("");
                return;
            }

            double decimal = switch (base) {
                case "binaria" -> c.binaryToDeci(texto);
                case "octal"  -> c.octalToDeci(texto);
                case "hexadecimal"    -> c.hexaToDeci(texto);
                default       -> c.parseDeciInput(texto);
            };

            if (!base.equals("binaria"))
                txtBinary.setText(c.deciToBinary(decimal));
            if (!base.equals("octal"))
                txtOctal.setText(c.deciToOctal(decimal));
            if (!base.equals("decimal"))
                txtDecimal.setText(c.formatDeciOutput(decimal));
            if (!base.equals("hexadecimal"))
                txtHexadecimal.setText(c.deciToHexa(decimal));

        } catch (NumberFormatException ex) {
            lblStatus.setText("Numero invalido para a base " + base);
        } catch (IllegalArgumentException ex) {
            lblStatus.setText("Numero invalido para a base " + base);
        } finally {
            isUpdating = false;
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtBinary = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtDecimal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtOctal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtHexadecimal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversor Numérico");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(17, 20, 28));

        jPanel2.setBackground(new java.awt.Color(39, 48, 65));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 27, 37), 2));
        jPanel2.setPreferredSize(new java.awt.Dimension(220, 120));

        txtBinary.setBackground(new java.awt.Color(26, 30, 42));
        txtBinary.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtBinary.setForeground(new java.awt.Color(255, 255, 255));
        txtBinary.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBinary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(28, 33, 45), 2));
        txtBinary.setCaretColor(new java.awt.Color(255, 255, 255));
        txtBinary.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("BINÁRIO");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setText("base 2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel2)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CONVERSOR NUMÉRICO");

        jPanel3.setBackground(new java.awt.Color(39, 48, 65));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 27, 37), 2));
        jPanel3.setPreferredSize(new java.awt.Dimension(220, 120));

        txtDecimal.setBackground(new java.awt.Color(26, 30, 42));
        txtDecimal.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtDecimal.setForeground(new java.awt.Color(255, 255, 255));
        txtDecimal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDecimal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(28, 33, 45), 2));
        txtDecimal.setCaretColor(new java.awt.Color(255, 255, 255));
        txtDecimal.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 153, 255));
        jLabel10.setText("DECIMAL");

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 153, 255));
        jLabel11.setText("base 10");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtDecimal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel11)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDecimal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel4.setBackground(new java.awt.Color(39, 48, 65));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 27, 37), 2));
        jPanel4.setPreferredSize(new java.awt.Dimension(220, 120));

        txtOctal.setBackground(new java.awt.Color(26, 30, 42));
        txtOctal.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtOctal.setForeground(new java.awt.Color(255, 255, 255));
        txtOctal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOctal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(28, 33, 45), 2));
        txtOctal.setCaretColor(new java.awt.Color(255, 255, 255));
        txtOctal.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 204, 0));
        jLabel12.setText("OCTAL");

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 204, 0));
        jLabel13.setText("base 8");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtOctal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel13)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOctal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel5.setBackground(new java.awt.Color(39, 48, 65));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 27, 37), 2));
        jPanel5.setPreferredSize(new java.awt.Dimension(220, 120));

        txtHexadecimal.setBackground(new java.awt.Color(26, 30, 42));
        txtHexadecimal.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtHexadecimal.setForeground(new java.awt.Color(255, 255, 255));
        txtHexadecimal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHexadecimal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(28, 33, 45), 2));
        txtHexadecimal.setCaretColor(new java.awt.Color(255, 255, 255));
        txtHexadecimal.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 102, 153));
        jLabel14.setText("HEXADECIMAL");

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 102, 153));
        jLabel15.setText("base 16");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(txtHexadecimal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel15)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHexadecimal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel6.setBackground(new java.awt.Color(122, 122, 206));
        jPanel6.setForeground(new java.awt.Color(153, 153, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(488, 4));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        lblStatus.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(lblStatus)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(18, 18, 18))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ConversorInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConversorInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConversorInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConversorInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConversorInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtBinary;
    private javax.swing.JTextField txtDecimal;
    private javax.swing.JTextField txtHexadecimal;
    private javax.swing.JTextField txtOctal;
    // End of variables declaration//GEN-END:variables
}
