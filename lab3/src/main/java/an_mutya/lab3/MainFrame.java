/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package an_mutya.lab3;


import handlerAndManager.Manager;
import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


/**
 *
 * @author annamutovkina
 */
public class MainFrame extends javax.swing.JFrame {
    private Manager manager = new Manager();
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        treeDialog = new javax.swing.JDialog();
        panelTree = new javax.swing.JPanel();
        scrollPaneForTree = new javax.swing.JScrollPane();
        treeReactors = new javax.swing.JTree();
        panelLoadFile = new javax.swing.JPanel();
        buttonLoadFile = new javax.swing.JButton();
        textAddedFilesScroll = new javax.swing.JScrollPane();
        textAddedFiles = new javax.swing.JTextArea();
        labelLoadedFiles = new javax.swing.JTextField();
        buildTree = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();

        treeDialog.setMinimumSize(new java.awt.Dimension(600, 600));
        treeDialog.setVisible(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeReactors.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        scrollPaneForTree.setViewportView(treeReactors);

        javax.swing.GroupLayout panelTreeLayout = new javax.swing.GroupLayout(panelTree);
        panelTree.setLayout(panelTreeLayout);
        panelTreeLayout.setHorizontalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneForTree, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );
        panelTreeLayout.setVerticalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTreeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneForTree, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout treeDialogLayout = new javax.swing.GroupLayout(treeDialog.getContentPane());
        treeDialog.getContentPane().setLayout(treeDialogLayout);
        treeDialogLayout.setHorizontalGroup(
            treeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, treeDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        treeDialogLayout.setVerticalGroup(
            treeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, treeDialogLayout.createSequentialGroup()
                .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonLoadFile.setText("Загрузить файл");
        buttonLoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoadFileActionPerformed(evt);
            }
        });

        textAddedFiles.setEditable(false);
        textAddedFiles.setColumns(20);
        textAddedFiles.setRows(5);
        textAddedFilesScroll.setViewportView(textAddedFiles);

        labelLoadedFiles.setEditable(false);
        labelLoadedFiles.setText("Загруженные файлы:");

        buildTree.setText("Сделать дерево");
        buildTree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildTreeActionPerformed(evt);
            }
        });

        buttonDelete.setText("Удалить загрузки");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoadFileLayout = new javax.swing.GroupLayout(panelLoadFile);
        panelLoadFile.setLayout(panelLoadFileLayout);
        panelLoadFileLayout.setHorizontalGroup(
            panelLoadFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoadFileLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelLoadFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoadFileLayout.createSequentialGroup()
                        .addComponent(textAddedFilesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonDelete))
                    .addComponent(labelLoadedFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLoadFileLayout.createSequentialGroup()
                        .addComponent(buttonLoadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(buildTree)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLoadFileLayout.setVerticalGroup(
            panelLoadFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoadFileLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelLoadFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLoadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buildTree, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(panelLoadFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoadFileLayout.createSequentialGroup()
                        .addComponent(labelLoadedFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAddedFilesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonDelete, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLoadFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLoadFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoadFileActionPerformed
        try {
            JFileChooser jFileChooser = new JFileChooser();
            File currentDirectory = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile();
            jFileChooser.setCurrentDirectory(currentDirectory);
            int resonse = jFileChooser.showOpenDialog(null);
            if(resonse == 0){
                try {
                    manager.loadFile(jFileChooser.getSelectedFile().getAbsolutePath());
                    textAddedFiles.append(jFileChooser.getSelectedFile().getAbsolutePath() + "\n");
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "Импортируйте правильный файл!\nНе умею с таким работать", "Алло!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonLoadFileActionPerformed

    private void buildTreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildTreeActionPerformed
        DefaultTreeModel model;
        DefaultMutableTreeNode node = manager.buildTree();
        model = (DefaultTreeModel)treeReactors.getModel();
        model.setRoot(node);
        treeReactors.setModel(model);
        treeDialog.setVisible(true);
    }//GEN-LAST:event_buildTreeActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        manager.deleteFiles();
        textAddedFiles.setText("");
    }//GEN-LAST:event_buttonDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buildTree;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonLoadFile;
    private javax.swing.JTextField labelLoadedFiles;
    private javax.swing.JPanel panelLoadFile;
    private javax.swing.JPanel panelTree;
    private javax.swing.JScrollPane scrollPaneForTree;
    private javax.swing.JTextArea textAddedFiles;
    private javax.swing.JScrollPane textAddedFilesScroll;
    private javax.swing.JDialog treeDialog;
    private javax.swing.JTree treeReactors;
    // End of variables declaration//GEN-END:variables
}
