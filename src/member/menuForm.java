/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package member;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adib
 */
public class menuForm extends javax.swing.JFrame {

    /**
     * Creates new form menuForm
     */
    public menuForm() {
        initComponents();
        konek();
        tampildata();
        id();
//        autoID();
    }
    
    public String sql;
    public Connection con;
    public PreparedStatement ps;
    public Statement st;
    public ResultSet rs;
    
    public void konek() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/daftarmember", "root", "");
            st = con.createStatement();
        } catch (Exception e) {

        }
    }
    private void id(){
        
    }
    
//    private void autoID(){
//        try{
//        
//            sql="select max(near([id],12)) as no from [member]";
//            ps = con.prepareStatement(sql);
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                if(rs.first()==false){
//                    inputID.setText("ID001");
//                    
//                }else{
//                    rs.last();
//                    int autoid = rs.getInt(1) + 1;
//                    String nomor=String.valueOf(autoid);
//                    int noLong = nomor.length();
//                    for(int a=0;a<3-noLong;a++){
//                        nomor = "0" + nomor;
//                    }
//                    inputID.setText("ID" + nomor);
//                }
//            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null,e);
//        }
//    }
    
    private void tampildata() {
        Object[] baris = {"ID", "Nama", "email", "Alamat"};
        DefaultTableModel model = new DefaultTableModel(null, baris);

        try {
            sql = "select * from member";
            ps = member.koneksinya().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String[] data = {
                    rs.getString("id"),
                    rs.getString("nama"),
                    rs.getString("email"),
                    rs.getString("alamat")
                };
                model.addRow(data);
            }
            tabel.setModel(model);
//            modaltabel.setModel(model);
        } catch (SQLException e) {

        }
    }

    private void bersih() {
        inputID.setText(null);
        inputNama.setText(null);
        inputEmail.setText(null);
        inputAlamat.setText(null);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputID = new javax.swing.JTextField();
        inputNama = new javax.swing.JTextField();
        inputEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputAlamat = new javax.swing.JTextArea();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnkeluar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.SystemColor.controlHighlight);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel1KeyTyped(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email       :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 185, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Alamat    :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 246, -1, -1));

        inputID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIDActionPerformed(evt);
            }
        });
        jPanel1.add(inputID, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 88, 186, -1));
        jPanel1.add(inputNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 134, 186, -1));

        inputEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEmailActionPerformed(evt);
            }
        });
        jPanel1.add(inputEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 185, 188, -1));

        inputAlamat.setColumns(20);
        inputAlamat.setRows(5);
        jScrollPane1.setViewportView(inputAlamat);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 246, 188, 117));

        btnCreate.setBackground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, -1));

        tabel.setBackground(new java.awt.Color(153, 153, 255));
        tabel.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "nama", "email", "alamat"
            }
        ));
        tabel.getTableHeader().setReorderingAllowed(false);
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 88, 500, 280));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID            :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 88, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama      :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 137, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        jLabel3.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DAFTAR MEMBER TOKO BUKU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnkeluar.setBackground(new java.awt.Color(255, 255, 255));
        btnkeluar.setText("Exit");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });
        jPanel1.add(btnkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 410, 80, -1));

        jMenu1.setText("Creator by: mayyeoja@gmail.com");
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        if (inputID.getText().equals("") || inputNama.getText().equals("") || inputEmail.getText().equals("") || inputAlamat.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Isi semua data");
        } else {
            sql = "insert into member (id,nama,email,alamat) values ('" + inputID.getText() + "','" + inputNama.getText() + "','" + inputEmail.getText() + "','" + inputAlamat.getText() + "')";
            try {
                st.executeUpdate(sql);
                tampildata();
                bersih();
                JOptionPane.showMessageDialog(rootPane, "BERHASIL");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         if (inputID.getText().equals("") || inputNama.getText().equals("") || inputEmail.getText().equals("") || inputAlamat.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Isikan terlebih dahulu");
        } else {
            sql = "update member set id='" + inputID.getText() + "',nama='" + inputNama.getText() + "',email='" + inputEmail.getText() + "',alamat='" + inputAlamat.getText() + "' where id='" + inputID.getText() + "'";
            try {
                int validasiUpdate = JOptionPane.YES_NO_OPTION;
                int cekUP = JOptionPane.showConfirmDialog(this, "Apakah anda ingin merubah?", "Peringatan", validasiUpdate);
                if (cekUP == 0) {
                    st.executeUpdate(sql);
                    tampildata();
                    bersih();
                    JOptionPane.showMessageDialog(rootPane, "berhasil");
                } else {

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (inputID.getText().equals("") || inputNama.getText().equals("") || inputEmail.getText().equals("") || inputAlamat.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Isikan terlebih dahulu");
        } else {
            sql = "delete from member where id=" + inputID.getText();
            try {
                int validasiDel = JOptionPane.YES_NO_OPTION;
                int cekDel = JOptionPane.showConfirmDialog(rootPane, "apakah ingin menghapus data ini??!", "Peringatan", validasiDel);
                if (cekDel == 0) {
                    st.executeUpdate(sql);
                    tampildata();
                    bersih();
                    JOptionPane.showMessageDialog(rootPane, "Berhasil");
                } else {
                }

            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        inputID.setText(tabel.getValueAt(tabel.getSelectedRow(), 0).toString());
        inputNama.setText(tabel.getValueAt(tabel.getSelectedRow(), 1).toString());
        inputEmail.setText(tabel.getValueAt(tabel.getSelectedRow(), 2).toString());
        inputAlamat.setText(tabel.getValueAt(tabel.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_tabelMouseClicked

    private void jPanel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyTyped

    private void inputEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEmailActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Ya", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)System.exit(0);
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void inputIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIDActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(menuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JTextArea inputAlamat;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputID;
    private javax.swing.JTextField inputNama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
