/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verkkopankki.gui;

import javax.swing.JFrame;
import verkkopankki.logiikka.Jarjestelma;

/**
 *
 * @author oskajoha
 */
public class Kirjautumisikkuna extends javax.swing.JPanel {

    /**
     * Creates new form Kirjautumisikkuna
     */
    private final Jarjestelma j;
    private final JFrame frame;

    public Kirjautumisikkuna(JFrame frame, Jarjestelma j) {
        this.j = j;
        this.frame = frame;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kayttajatunnusField = new javax.swing.JTextField();
        kayttajatunnusLabel = new javax.swing.JLabel();
        salasanaLabel = new javax.swing.JLabel();
        kirjauduButton = new javax.swing.JButton();
        tervetuloaLabel = new javax.swing.JLabel();
        salasanaField = new javax.swing.JPasswordField();

        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        kayttajatunnusLabel.setText("Käyttäjätunnus");

        salasanaLabel.setText("Salasana");

        kirjauduButton.setText("Kirjaudu");
        kirjauduButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirjauduButtonActionPerformed(evt);
            }
        });

        tervetuloaLabel.setFont(new java.awt.Font("Ubuntu", 0, 28)); // NOI18N
        tervetuloaLabel.setText("Tervetuloa Javapankkiin!");

        salasanaField.setText("jPasswordField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tervetuloaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kayttajatunnusLabel)
                            .addComponent(salasanaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kirjauduButton, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(kayttajatunnusField)
                            .addComponent(salasanaField))))
                .addContainerGap(591, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(tervetuloaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kayttajatunnusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kayttajatunnusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salasanaLabel)
                    .addComponent(salasanaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(kirjauduButton)
                .addContainerGap(330, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kirjauduButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirjauduButtonActionPerformed
        if (j.haeAsiakas(kayttajatunnusField.getText()).tasmaakoSalasana(salasanaField.getText())) {
            Etusivu etusivu = new Etusivu();
        }
    }//GEN-LAST:event_kirjauduButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField kayttajatunnusField;
    private javax.swing.JLabel kayttajatunnusLabel;
    private javax.swing.JButton kirjauduButton;
    private javax.swing.JPasswordField salasanaField;
    private javax.swing.JLabel salasanaLabel;
    private javax.swing.JLabel tervetuloaLabel;
    // End of variables declaration//GEN-END:variables
}
