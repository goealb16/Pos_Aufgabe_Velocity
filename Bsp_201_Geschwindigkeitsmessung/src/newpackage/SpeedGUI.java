

package newpackage;

import java.awt.Frame;
import javax.swing.JOptionPane;


public class SpeedGUI extends java.awt.Frame {
private TableModel model = new TableModel();
   
    public SpeedGUI() {
        initComponents();
        jtTable.setModel(model);
        jtTable.setDefaultRenderer(Object.class, new TableCellRenderer());
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        miAdd = new javax.swing.JMenuItem();
        miDel = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miDurch = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTable = new javax.swing.JTable();

        miAdd.setText("Hinzufügen");
        miAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miAdd);

        miDel.setText("Löschen");
        miDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDelActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miDel);
        jPopupMenu1.add(jSeparator1);

        miDurch.setText("Durchschnitt");
        miDurch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDurchActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miDurch);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);

        jtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtTable.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jtTable);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void miAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddActionPerformed
        SpeedDialoge dialoge = new SpeedDialoge(new Frame(), true);
        dialoge.setVisible(true);
        if(dialoge.isOk()){
            model.add(dialoge.getMes());
        }
    }//GEN-LAST:event_miAddActionPerformed

    private void miDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDelActionPerformed
        int[] selectedR= jtTable.getSelectedRows();
        model.delete(selectedR);
    }//GEN-LAST:event_miDelActionPerformed

    private void miDurchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDurchActionPerformed
        JOptionPane.showMessageDialog(this, model.getDurch());
    }//GEN-LAST:event_miDurchActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SpeedGUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jtTable;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miDel;
    private javax.swing.JMenuItem miDurch;
    // End of variables declaration//GEN-END:variables

}
