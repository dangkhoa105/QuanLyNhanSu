package qlnstl.DTO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.logging.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import DTO.QLNSTL;
import DTO.ThongTinCaNhan;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ngoc
 */
public class frmDangNhap extends javax.swing.JFrame {

    /**
     * Creates new form frmSignIn
     */
    private Connection conn;
    
    public frmDangNhap() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
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
        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        lblMini = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnSignIn = new javax.swing.JButton();
        icoTenDangNhap = new javax.swing.JLabel();
        icoPassword = new javax.swing.JLabel();
        lblThongBao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(107, 195, 196));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(107, 195, 196)));

        jPanel2.setBackground(new java.awt.Color(3, 100, 117));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblLogo.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(254, 255, 250));
        lblLogo.setText("Đăng Nhập");

        lblClose.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        lblClose.setForeground(new java.awt.Color(254, 255, 250));
        lblClose.setText("X");
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });

        lblMini.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblMini.setForeground(new java.awt.Color(254, 255, 250));
        lblMini.setText("-");
        lblMini.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMiniMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(lblMini, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblClose)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMini, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(254, 255, 250));

        lblUsername.setBackground(new java.awt.Color(3, 100, 117));
        lblUsername.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(3, 100, 117));
        lblUsername.setText("Tên đăng nhập");

        lblPassword.setBackground(new java.awt.Color(3, 100, 117));
        lblPassword.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(3, 100, 117));
        lblPassword.setText("Mật khẩu");

        txtUsername.setBackground(new java.awt.Color(254, 255, 250));
        txtUsername.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(3, 100, 117));
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(107, 195, 196)));
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(254, 255, 250));
        txtPassword.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(3, 100, 117));
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(107, 195, 196)));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        btnSignIn.setBackground(new java.awt.Color(3, 100, 117));
        btnSignIn.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnSignIn.setForeground(new java.awt.Color(254, 255, 250));
        btnSignIn.setText("Đăng nhập");
        btnSignIn.setBorder(null);
        btnSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSignInMouseClicked(evt);
            }
        });
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        btnSignIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSignInKeyPressed(evt);
            }
        });

        icoTenDangNhap.setBackground(new java.awt.Color(3, 100, 117));
        icoTenDangNhap.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        icoTenDangNhap.setForeground(new java.awt.Color(3, 100, 117));
        icoTenDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/user(1).png"))); // NOI18N
        icoTenDangNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(107, 195, 196)));

        icoPassword.setBackground(new java.awt.Color(3, 100, 117));
        icoPassword.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        icoPassword.setForeground(new java.awt.Color(3, 100, 117));
        icoPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/key-silhouette-security-tool-interface-symbol-of-password.png"))); // NOI18N
        icoPassword.setLabelFor(icoTenDangNhap);
        icoPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(107, 195, 196)));

        lblThongBao.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblThongBao.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsername)
                            .addComponent(lblPassword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(icoPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(icoTenDangNhap)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icoTenDangNhap))
                .addGap(31, 31, 31)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icoPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblCloseMousePressed

    private void lblMiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMiniMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame .ICONIFIED);
    }//GEN-LAST:event_lblMiniMouseClicked

    private void btnSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignInMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnSignInMouseClicked

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        // TODO add your handling code here:
        try {          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");                       
            
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            //String ten = cbxTen.getSelectedItem().toString();
            
            String query1 = "SELECT * FROM tbuser WHERE Username=? AND Pass=?";
            PreparedStatement st = conn.prepareStatement(query1);
            st.setString(1, username);
            st.setString(2, password);
            //st.setString(3, ten);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                String ten = rs.getString("ChucVu");
                if (ten.equalsIgnoreCase("Direction")) {
                    lblThongBao.setText("Đăng nhập thành công");
                    this.dispose();
                    frmMain main = new frmMain();
                    main.setVisible(true);
                    main.pack();
                    main.setLocationRelativeTo(null);
                    main.k = 0;
                    main.execute();
                } else if (ten.equalsIgnoreCase("Managers")) {
                    lblThongBao.setText("Đăng nhập thành công");
                    this.dispose();
                    frmMain main = new frmMain();
                    main.setVisible(true);
                    main.pack();
                    main.setLocationRelativeTo(null);
                    main.k = 1;
                    main.execute();
                } else if (ten.equalsIgnoreCase("Employees")) {
                    lblThongBao.setText("Đăng nhập thành công");
                    this.dispose();
                    frmMain main = new frmMain();
                    main.setVisible(true);
                    main.pack();
                    main.setLocationRelativeTo(null);
                    main.k = 2;
                    main.execute();
                }
            }
            else {
                lblThongBao.setText("Đăng nhập thất bại");
                txtUsername.setText("");
                txtPassword.setText("");
            }         
            
        }
        catch (SQLException ex) {
            Logger.getLogger(frmDangNhap.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    private void btnSignInKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSignInKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            try {          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");                       
            
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            //String ten = cbxTen.getSelectedItem().toString();
            
            String query1 = "SELECT * FROM tbuser WHERE Username=? AND Pass=?";
            PreparedStatement st = conn.prepareStatement(query1);
            st.setString(1, username);
            st.setString(2, password);
            //st.setString(3, ten);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                String ten = rs.getString("ChucVu");
                    if (ten.equalsIgnoreCase("Direction")) {
                        lblThongBao.setText("Đăng nhập thành công");
                        this.dispose();
                        frmMain main = new frmMain();
                        main.setVisible(true);
                        main.pack();
                        main.setLocationRelativeTo(null);
                        main.k = 0;
                        main.execute();                
                    } else if (ten.equalsIgnoreCase("Managers")) {
                        lblThongBao.setText("Đăng nhập thành công");
                        this.dispose();
                        frmMain main = new frmMain();
                        main.setVisible(true);
                        main.pack();
                        main.setLocationRelativeTo(null);
                        main.k = 1;
                        main.execute();      
                    } else if (ten.equalsIgnoreCase("Employees")) {
                        lblThongBao.setText("Đăng nhập thành công");
                        this.dispose();
                        frmMain main = new frmMain();
                        main.setVisible(true);
                        main.pack();
                        main.setLocationRelativeTo(null);
                        main.k = 2;
                        main.execute();              
                    }
                } else {
                    lblThongBao.setText("Đăng nhập thất bại");
                    txtUsername.setText("");
                    txtPassword.setText("");
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmDangNhap.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btnSignInKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            try {          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");                       
            
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            //String ten = cbxTen.getSelectedItem().toString();
            
            String query1 = "SELECT * FROM tbuser WHERE Username=? AND Pass=?";
            PreparedStatement st = conn.prepareStatement(query1);
            st.setString(1, username);
            st.setString(2, password);
            //st.setString(3, ten);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                String ten = rs.getString("ChucVu");
                    if (ten.equalsIgnoreCase("Direction")) {
                        lblThongBao.setText("Đăng nhập thành công");
                        this.dispose();
                        frmMain main = new frmMain();
                        main.setVisible(true);
                        main.pack();
                        main.setLocationRelativeTo(null);
                        main.k = 0;
                        main.execute();      
                    } else if (ten.equalsIgnoreCase("Managers")) {
                        lblThongBao.setText("Đăng nhập thành công");
                        this.dispose();
                        frmMain main = new frmMain();
                        main.setVisible(true);
                        main.pack();
                        main.setLocationRelativeTo(null);
                        main.k = 1;
                        main.execute();    
                    } else if (ten.equalsIgnoreCase("Employees")) {
                        lblThongBao.setText("Đăng nhập thành công");
                        this.dispose();
                        frmMain main = new frmMain();
                        main.setVisible(true);
                        main.pack();
                        main.setLocationRelativeTo(null);
                        main.k = 2;
                        main.execute();  
                    }
                } else {
                    lblThongBao.setText("Đăng nhập thất bại");
                    txtUsername.setText("");
                    txtPassword.setText("");
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmDangNhap.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            try {          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");                       
            
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            //String ten = cbxTen.getSelectedItem().toString();
            
            String query1 = "SELECT * FROM tbuser WHERE Username=? AND Pass=?";
            PreparedStatement st = conn.prepareStatement(query1);
            st.setString(1, username);
            st.setString(2, password);
            //st.setString(3, ten);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                String ten = rs.getString("ChucVu");
                    if (ten.equalsIgnoreCase("Direction")) {
                        lblThongBao.setText("Đăng nhập thành công");
                        this.dispose();
                        frmMain main = new frmMain();
                        main.setVisible(true);
                        main.pack();
                        main.setLocationRelativeTo(null);
                        main.k = 0;
                        main.execute();

                        
                        
                        
                    } else if (ten.equalsIgnoreCase("Managers")) {
                        lblThongBao.setText("Đăng nhập thành công");
                        this.dispose();
                        frmMain main = new frmMain();
                        main.setVisible(true);
                        main.pack();
                        main.setLocationRelativeTo(null);
                        main.k = 1;
                        main.execute();

                        
                        
                        
                    } else if (ten.equalsIgnoreCase("Employees")) {
                        lblThongBao.setText("Đăng nhập thành công");
                        this.dispose();
                        frmMain main = new frmMain();
                        main.setVisible(true);
                        main.pack();
                        main.setLocationRelativeTo(null);
                        main.k = 2;
                        main.execute();

                        
                       
                        
                    }
                } else {
                    lblThongBao.setText("Đăng nhập thất bại");
                    txtUsername.setText("");
                    txtPassword.setText("");
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmDangNhap.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

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
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnSignIn;
    private javax.swing.JLabel icoPassword;
    private javax.swing.JLabel icoTenDangNhap;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMini;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblUsername;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
