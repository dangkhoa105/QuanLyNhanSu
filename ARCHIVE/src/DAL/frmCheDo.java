/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BUS.BaoHiemBUS;
import BUS.ThaiSanBUS;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DTO.BaoHiem;
import DTO.ThaiSan;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author DangKhoa
 */
public class frmCheDo extends javax.swing.JPanel {

    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
    
    DefaultTableModel modelBH;
    DefaultTableModel modelTS;
    
    private Connection conn;
    /**
     * Creates new form frmCheDo
     */
    public frmCheDo() {
        initComponents();
        
        getCBboxMaNV();
        getCBboxBP();
        getCBboxPB();
        getCBboxMaLuong();
        
        showBH();
        showTS();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        modelBH = (DefaultTableModel)tblBaoHiem.getModel();
        modelTS = (DefaultTableModel)tblThaiSan.getModel();
    }
    
    private void getCBboxMaNV() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT MaNV FROM TblTTNVCoBan ORDER BY MaNV");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbxMaNhanVien.addItem(rs.getString("MaNV"));
                cbxMaNhanVien_1.addItem(rs.getString("MaNV"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void getCBboxBP() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ns = conn.prepareStatement("SELECT MaBoPhan FROM TblBoPhan ORDER BY MaBoPhan");
            ResultSet rs = ns.executeQuery();
            while (rs.next()) {
                cbxMaBoPhan.addItem(rs.getString("MaBoPhan"));
            }
            //cbxID.setModel(modelCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void getCBboxPB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ns = conn.prepareStatement("SELECT MaPhong FROM TblPhongBan ORDER BY MaPhong");
            ResultSet rs = ns.executeQuery();
            while (rs.next()) {
                cbxMaPhong.addItem(rs.getString("MaPhong"));
            }
            //cbxID.setModel(modelCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void getCBboxMaLuong() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ns = conn.prepareStatement("SELECT MaLuong FROM TblBangLuongCTy ORDER BY MaLuong");
            ResultSet rs = ns.executeQuery();
            while (rs.next()) {
                cbxMaLuong.addItem(rs.getString("MaLuong"));
            }
            //cbxID.setModel(modelCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public ArrayList<BaoHiem> bhList() {
//        ArrayList<BaoHiem> bhList = new ArrayList<>();
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblSoBH");
//            ResultSet rs = ps.executeQuery();
//            BaoHiem bh;
//            while (rs.next()) {
//                bh = new BaoHiem(
//                    rs.getString("MaNV"),
//                    rs.getString("MaLuong"),
//                    rs.getString("MaSoBH"),
//                    rs.getString("NgayCapSo"),
//                    rs.getString("NoiCapSo"),
//                    rs.getString("GhiChu")
//                );
//                bhList.add(bh);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//        return bhList;
//    }
    
    public void showBH() {
        ArrayList<BaoHiem> bh = BaoHiemBUS.bhList();
        DefaultTableModel model = (DefaultTableModel)tblBaoHiem.getModel();
        Object[] row = new Object[17];
        for (int i=0;i<bh.size();i++) {
            row[0]=bh.get(i).getMaNhanVien();
            row[1]=bh.get(i).getMaLuong();
            row[2]=bh.get(i).getMaSoBaoHiem();
            row[3]=bh.get(i).getNgayCapSo();
            row[4]=bh.get(i).getNoiCapSo();
            row[5]=bh.get(i).getGhiChu();
            model.addRow(row);
        };
    }
    
//    public ArrayList<ThaiSan> tsList() {
//        ArrayList<ThaiSan> tsList = new ArrayList<>();
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblThaiSan");
//            ResultSet rs = ps.executeQuery();
//            ThaiSan ts;
//            while (rs.next()) {
//                ts = new ThaiSan(
//                    rs.getString("MaBoPhan"),
//                    rs.getString("MaPhong"),
//                    rs.getString("MaNV"),
//                    rs.getString("HoTen"),
//                    rs.getString("NgaySinh"),
//                    rs.getString("NgayVeSom"),
//                    rs.getString("NgayNghiSinh"),
//                    rs.getString("NgayLamTroLai"),
//                    rs.getString("TroCapCTY"),
//                    rs.getString("GhiChu")
//                );
//                tsList.add(ts);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//        return tsList;
//    }
    
    public void showTS() {
        ArrayList<ThaiSan> ts = ThaiSanBUS.tsList();
        DefaultTableModel model = (DefaultTableModel)tblThaiSan.getModel();
        Object[] row = new Object[17];
        for (int i=0;i<ts.size();i++) {
            row[0]=ts.get(i).getMaBoPhan();
            row[1]=ts.get(i).getMaPhong();
            row[2]=ts.get(i).getMaNhanVien();
            row[3]=ts.get(i).getHoTen();
            row[4]=ts.get(i).getNgaySinh();
            row[5]=ts.get(i).getNgayVeSom();
            row[6]=ts.get(i).getNgayNghiSinh();
            row[7]=ts.get(i).getNgayLamTroLai();
            row[8]=ts.get(i).getTroCapCongTy();
            row[9]=ts.get(i).getGhiChu();
            model.addRow(row);
        };
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
        btnMoi10 = new javax.swing.JTabbedPane();
        pnBaoHiem10 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        lblHeader13 = new javax.swing.JLabel();
        lblMaNhanVien = new javax.swing.JLabel();
        cbxMaNhanVien = new javax.swing.JComboBox<>();
        lblMaLuong = new javax.swing.JLabel();
        cbxMaLuong = new javax.swing.JComboBox<>();
        lblNgayCapSo = new javax.swing.JLabel();
        lblMaBaoHiem = new javax.swing.JLabel();
        txtMaBaoHiem = new javax.swing.JTextField();
        lblGhiChu = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        lblNoiCapSo = new javax.swing.JLabel();
        txtNoiCapSo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lblHeader1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoiTV = new javax.swing.JButton();
        btnXuat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBaoHiem = new javax.swing.JTable();
        txtNgayCapSo = new com.toedter.calendar.JDateChooser();
        pbThaiSan = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lblHeader3 = new javax.swing.JLabel();
        lblMaBoPhan = new javax.swing.JLabel();
        cbxMaBoPhan = new javax.swing.JComboBox<>();
        lblGhiChu_1 = new javax.swing.JLabel();
        txtGhiChu_1 = new javax.swing.JTextField();
        lblNgaySinh = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        lblNgayLamTroLai = new javax.swing.JLabel();
        lblNgayNghiSinh = new javax.swing.JLabel();
        lblTroCap = new javax.swing.JLabel();
        txtTroCap = new javax.swing.JTextField();
        lblMaNhanVien_1 = new javax.swing.JLabel();
        cbxMaNhanVien_1 = new javax.swing.JComboBox<>();
        lblNgayVeSom = new javax.swing.JLabel();
        lblMaPhong = new javax.swing.JLabel();
        cbxMaPhong = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        lblHeader7 = new javax.swing.JLabel();
        btnThem_1 = new javax.swing.JButton();
        btnSua_1 = new javax.swing.JButton();
        btnXoa_1 = new javax.swing.JButton();
        btnMoi_1 = new javax.swing.JButton();
        btnXuat_1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblThaiSan = new javax.swing.JTable();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        txtNgayVeSom = new com.toedter.calendar.JDateChooser();
        txtNgayNghiSinh = new com.toedter.calendar.JDateChooser();
        txtNgayLamTroLai = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(107, 195, 196));

        jPanel1.setBackground(new java.awt.Color(107, 195, 196));

        pnBaoHiem10.setBackground(new java.awt.Color(255, 255, 255));
        pnBaoHiem10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

        jPanel23.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader13.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader13.setText("Thông tin về chế độ bảo hiểm");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblHeader13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader13, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        lblMaNhanVien.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaNhanVien.setForeground(new java.awt.Color(3, 100, 117));
        lblMaNhanVien.setText("Mã nhân viên");

        cbxMaNhanVien.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaNhanVien.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaNhanVien.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaNhanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        lblMaLuong.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaLuong.setForeground(new java.awt.Color(3, 100, 117));
        lblMaLuong.setText("Mã lương");

        cbxMaLuong.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaLuong.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaLuong.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaLuong.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        lblNgayCapSo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNgayCapSo.setForeground(new java.awt.Color(3, 100, 117));
        lblNgayCapSo.setText("Ngày cấp số");

        lblMaBaoHiem.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaBaoHiem.setForeground(new java.awt.Color(3, 100, 117));
        lblMaBaoHiem.setText("Mã bảo hiểm");

        txtMaBaoHiem.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtMaBaoHiem.setForeground(new java.awt.Color(3, 100, 117));
        txtMaBaoHiem.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtMaBaoHiem.setEnabled(false);
        txtMaBaoHiem.setMinimumSize(new java.awt.Dimension(3, 26));
        txtMaBaoHiem.setPreferredSize(new java.awt.Dimension(36, 28));

        lblGhiChu.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblGhiChu.setForeground(new java.awt.Color(3, 100, 117));
        lblGhiChu.setText("Ghi chú");

        txtGhiChu.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtGhiChu.setForeground(new java.awt.Color(3, 100, 117));
        txtGhiChu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtGhiChu.setEnabled(false);
        txtGhiChu.setMinimumSize(new java.awt.Dimension(3, 26));
        txtGhiChu.setPreferredSize(new java.awt.Dimension(36, 28));

        lblNoiCapSo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNoiCapSo.setForeground(new java.awt.Color(3, 100, 117));
        lblNoiCapSo.setText("Nơi cấp số");

        txtNoiCapSo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNoiCapSo.setForeground(new java.awt.Color(3, 100, 117));
        txtNoiCapSo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtNoiCapSo.setEnabled(false);
        txtNoiCapSo.setMinimumSize(new java.awt.Dimension(3, 26));
        txtNoiCapSo.setPreferredSize(new java.awt.Dimension(36, 28));

        jSeparator1.setBackground(new java.awt.Color(3, 100, 117));
        jSeparator1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(107, 195, 196)));

        jPanel8.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader1.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader1.setText("Chức năng");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblHeader1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        btnThem.setBackground(new java.awt.Color(3, 100, 117));
        btnThem.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(107, 195, 196));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(null);
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.setEnabled(false);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(3, 100, 117));
        btnSua.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(107, 195, 196));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setBorder(null);
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.setEnabled(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(3, 100, 117));
        btnXoa.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(107, 195, 196));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/remove-user.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.setBorder(null);
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.setEnabled(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoiTV.setBackground(new java.awt.Color(3, 100, 117));
        btnMoiTV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnMoiTV.setForeground(new java.awt.Color(107, 195, 196));
        btnMoiTV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnMoiTV.setText("Mới");
        btnMoiTV.setBorder(null);
        btnMoiTV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoiTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiTVActionPerformed(evt);
            }
        });

        btnXuat.setBackground(new java.awt.Color(3, 100, 117));
        btnXuat.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXuat.setForeground(new java.awt.Color(107, 195, 196));
        btnXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/document.png"))); // NOI18N
        btnXuat.setBorder(null);
        btnXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMoiTV, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMoiTV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblBaoHiem.setBackground(new java.awt.Color(254, 255, 250));
        tblBaoHiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblBaoHiem.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblBaoHiem.setForeground(new java.awt.Color(3, 100, 117));
        tblBaoHiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Mã lương", "Mã bảo hiểm", "Ngày cấp số", "Nơi cấp số", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBaoHiem.setGridColor(new java.awt.Color(3, 100, 117));
        tblBaoHiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBaoHiemMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBaoHiem);

        txtNgayCapSo.setForeground(new java.awt.Color(3, 100, 117));
        txtNgayCapSo.setDate(new java.util.Date(1575261535000L));
        txtNgayCapSo.setDateFormatString("yyyy-MM-dd");
        txtNgayCapSo.setEnabled(false);
        txtNgayCapSo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnBaoHiem10Layout = new javax.swing.GroupLayout(pnBaoHiem10);
        pnBaoHiem10.setLayout(pnBaoHiem10Layout);
        pnBaoHiem10Layout.setHorizontalGroup(
            pnBaoHiem10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnBaoHiem10Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(pnBaoHiem10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnBaoHiem10Layout.createSequentialGroup()
                        .addComponent(lblMaLuong)
                        .addGap(46, 46, 46)
                        .addComponent(cbxMaLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBaoHiem10Layout.createSequentialGroup()
                        .addComponent(lblMaNhanVien)
                        .addGap(18, 18, 18)
                        .addComponent(cbxMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(pnBaoHiem10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBaoHiem10Layout.createSequentialGroup()
                        .addComponent(lblMaBaoHiem)
                        .addGap(18, 18, 18))
                    .addGroup(pnBaoHiem10Layout.createSequentialGroup()
                        .addComponent(lblNgayCapSo)
                        .addGap(20, 20, 20)))
                .addGroup(pnBaoHiem10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaBaoHiem, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayCapSo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(pnBaoHiem10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNoiCapSo)
                    .addComponent(lblGhiChu))
                .addGap(18, 18, 18)
                .addGroup(pnBaoHiem10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNoiCapSo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnBaoHiem10Layout.setVerticalGroup(
            pnBaoHiem10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBaoHiem10Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnBaoHiem10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNhanVien)
                    .addComponent(lblMaBaoHiem)
                    .addComponent(txtMaBaoHiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNoiCapSo)
                    .addComponent(cbxMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoiCapSo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnBaoHiem10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaLuong)
                    .addComponent(lblNgayCapSo)
                    .addComponent(lblGhiChu)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMaLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayCapSo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        btnMoi10.addTab("Bảo hiểm", pnBaoHiem10);

        pbThaiSan.setBackground(new java.awt.Color(255, 255, 255));
        pbThaiSan.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

        jPanel9.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader3.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader3.setText("Thông tin về chế độ thai sản");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblHeader3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader3, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        lblMaBoPhan.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaBoPhan.setForeground(new java.awt.Color(3, 100, 117));
        lblMaBoPhan.setText("Mã bộ phận");

        cbxMaBoPhan.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaBoPhan.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaBoPhan.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaBoPhan.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        lblGhiChu_1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblGhiChu_1.setForeground(new java.awt.Color(3, 100, 117));
        lblGhiChu_1.setText("Ghi chú");

        txtGhiChu_1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtGhiChu_1.setForeground(new java.awt.Color(3, 100, 117));
        txtGhiChu_1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtGhiChu_1.setEnabled(false);
        txtGhiChu_1.setMinimumSize(new java.awt.Dimension(3, 26));
        txtGhiChu_1.setPreferredSize(new java.awt.Dimension(3, 26));
        txtGhiChu_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChu_1ActionPerformed(evt);
            }
        });

        lblNgaySinh.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNgaySinh.setForeground(new java.awt.Color(3, 100, 117));
        lblNgaySinh.setText("Ngày sinh");

        lblHoTen.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(3, 100, 117));
        lblHoTen.setText("Họ tên");

        txtHoTen.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtHoTen.setForeground(new java.awt.Color(3, 100, 117));
        txtHoTen.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtHoTen.setEnabled(false);
        txtHoTen.setMinimumSize(new java.awt.Dimension(3, 26));
        txtHoTen.setPreferredSize(new java.awt.Dimension(36, 28));

        lblNgayLamTroLai.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNgayLamTroLai.setForeground(new java.awt.Color(3, 100, 117));
        lblNgayLamTroLai.setText("Ngày làm trở lại");

        lblNgayNghiSinh.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNgayNghiSinh.setForeground(new java.awt.Color(3, 100, 117));
        lblNgayNghiSinh.setText("Ngày nghỉ sinh");

        lblTroCap.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTroCap.setForeground(new java.awt.Color(3, 100, 117));
        lblTroCap.setText("Trợ cấp công ty");

        txtTroCap.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtTroCap.setForeground(new java.awt.Color(3, 100, 117));
        txtTroCap.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtTroCap.setEnabled(false);
        txtTroCap.setMinimumSize(new java.awt.Dimension(3, 26));
        txtTroCap.setPreferredSize(new java.awt.Dimension(36, 28));
        txtTroCap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTroCapKeyPressed(evt);
            }
        });

        lblMaNhanVien_1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaNhanVien_1.setForeground(new java.awt.Color(3, 100, 117));
        lblMaNhanVien_1.setText("Mã nhân viên");

        cbxMaNhanVien_1.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaNhanVien_1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaNhanVien_1.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaNhanVien_1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        lblNgayVeSom.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNgayVeSom.setForeground(new java.awt.Color(3, 100, 117));
        lblNgayVeSom.setText("Ngày về sớm");

        lblMaPhong.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaPhong.setForeground(new java.awt.Color(3, 100, 117));
        lblMaPhong.setText("Mã phòng");

        cbxMaPhong.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaPhong.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaPhong.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaPhong.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(107, 195, 196)));

        jPanel16.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader7.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader7.setText("Chức năng");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblHeader7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader7, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        btnThem_1.setBackground(new java.awt.Color(3, 100, 117));
        btnThem_1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnThem_1.setForeground(new java.awt.Color(107, 195, 196));
        btnThem_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnThem_1.setText("Thêm");
        btnThem_1.setBorder(null);
        btnThem_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem_1.setEnabled(false);
        btnThem_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_1ActionPerformed(evt);
            }
        });

        btnSua_1.setBackground(new java.awt.Color(3, 100, 117));
        btnSua_1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSua_1.setForeground(new java.awt.Color(107, 195, 196));
        btnSua_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/edit.png"))); // NOI18N
        btnSua_1.setText("Sửa");
        btnSua_1.setBorder(null);
        btnSua_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua_1.setEnabled(false);
        btnSua_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_1ActionPerformed(evt);
            }
        });

        btnXoa_1.setBackground(new java.awt.Color(3, 100, 117));
        btnXoa_1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXoa_1.setForeground(new java.awt.Color(107, 195, 196));
        btnXoa_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/remove-user.png"))); // NOI18N
        btnXoa_1.setText("Xoá");
        btnXoa_1.setBorder(null);
        btnXoa_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa_1.setEnabled(false);
        btnXoa_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_1ActionPerformed(evt);
            }
        });

        btnMoi_1.setBackground(new java.awt.Color(3, 100, 117));
        btnMoi_1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnMoi_1.setForeground(new java.awt.Color(107, 195, 196));
        btnMoi_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnMoi_1.setText("Mới");
        btnMoi_1.setBorder(null);
        btnMoi_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoi_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoi_1ActionPerformed(evt);
            }
        });

        btnXuat_1.setBackground(new java.awt.Color(3, 100, 117));
        btnXuat_1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXuat_1.setForeground(new java.awt.Color(107, 195, 196));
        btnXuat_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/document.png"))); // NOI18N
        btnXuat_1.setBorder(null);
        btnXuat_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuat_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuat_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMoi_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnThem_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnSua_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnXoa_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnXuat_1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem_1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua_1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa_1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMoi_1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnXuat_1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSeparator3.setBackground(new java.awt.Color(3, 100, 117));
        jSeparator3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        tblThaiSan.setBackground(new java.awt.Color(254, 255, 250));
        tblThaiSan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblThaiSan.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblThaiSan.setForeground(new java.awt.Color(3, 100, 117));
        tblThaiSan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã bộ phận", "Mã phòng", "Mã nhân viên ", "Họ tên", "Ngày sinh", "Ngày về sớm", "Ngày nghỉ sinh", "Ngày làm trở lại", "Trợ cấp công ty", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThaiSan.setGridColor(new java.awt.Color(3, 100, 117));
        tblThaiSan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThaiSanMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblThaiSan);

        txtNgaySinh.setForeground(new java.awt.Color(3, 100, 117));
        txtNgaySinh.setDateFormatString("dd-MM-yyyy");
        txtNgaySinh.setEnabled(false);
        txtNgaySinh.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNgaySinh.setOpaque(false);

        txtNgayVeSom.setForeground(new java.awt.Color(3, 100, 117));
        txtNgayVeSom.setDate(new java.util.Date(1575261535000L));
        txtNgayVeSom.setDateFormatString("dd-MM-yyyy");
        txtNgayVeSom.setEnabled(false);
        txtNgayVeSom.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtNgayNghiSinh.setForeground(new java.awt.Color(3, 100, 117));
        txtNgayNghiSinh.setDateFormatString("dd-MM-yyyy");
        txtNgayNghiSinh.setEnabled(false);
        txtNgayNghiSinh.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtNgayLamTroLai.setForeground(new java.awt.Color(3, 100, 117));
        txtNgayLamTroLai.setDateFormatString("dd-MM-yyyy");
        txtNgayLamTroLai.setEnabled(false);
        txtNgayLamTroLai.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        javax.swing.GroupLayout pbThaiSanLayout = new javax.swing.GroupLayout(pbThaiSan);
        pbThaiSan.setLayout(pbThaiSanLayout);
        pbThaiSanLayout.setHorizontalGroup(
            pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pbThaiSanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pbThaiSanLayout.createSequentialGroup()
                        .addComponent(lblGhiChu_1)
                        .addGap(18, 18, 18)
                        .addComponent(txtGhiChu_1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pbThaiSanLayout.createSequentialGroup()
                        .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaNhanVien_1)
                            .addComponent(lblMaPhong)
                            .addComponent(lblMaBoPhan))
                        .addGap(18, 18, 18)
                        .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMaBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMaNhanVien_1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pbThaiSanLayout.createSequentialGroup()
                                .addComponent(lblHoTen)
                                .addGap(63, 63, 63)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pbThaiSanLayout.createSequentialGroup()
                                .addComponent(lblNgaySinh)
                                .addGap(41, 41, 41)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pbThaiSanLayout.createSequentialGroup()
                                .addComponent(lblNgayVeSom)
                                .addGap(18, 18, 18)
                                .addComponent(txtNgayVeSom, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pbThaiSanLayout.createSequentialGroup()
                                .addComponent(lblNgayLamTroLai)
                                .addGap(18, 18, 18)
                                .addComponent(txtNgayLamTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pbThaiSanLayout.createSequentialGroup()
                                .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTroCap)
                                    .addComponent(lblNgayNghiSinh))
                                .addGap(16, 16, 16)
                                .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNgayNghiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTroCap, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pbThaiSanLayout.setVerticalGroup(
            pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pbThaiSanLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMaBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHoTen)
                        .addComponent(lblMaBoPhan)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNgayNghiSinh))
                    .addComponent(txtNgayNghiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pbThaiSanLayout.createSequentialGroup()
                        .addComponent(txtNgayLamTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(pbThaiSanLayout.createSequentialGroup()
                        .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNgaySinh)
                                .addComponent(lblMaPhong)
                                .addComponent(cbxMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayLamTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayVeSom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMaNhanVien_1)
                                .addComponent(cbxMaNhanVien_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNgayVeSom)
                                .addComponent(lblTroCap, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTroCap, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(pbThaiSanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGhiChu_1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGhiChu_1))
                .addGap(29, 29, 29)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
        );

        btnMoi10.addTab("Thai sản", pbThaiSan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMoi10)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMoi10, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
//            String sql = "INSERT INTO TblSoBH(MaNV, MaLuong, MaSoBH, NgayCapSo, NoiCapSo, GhiChu) "
//            + "values(?, ?, ?, ?, ?, ?)";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, cbxMaNhanVien.getSelectedItem().toString());
//            ps.setString(2, cbxMaLuong.getSelectedItem().toString());
//            ps.setString(3, txtMaBaoHiem.getText());
//            //ps.setString(4, txtNgayCapSo.getDate().toString());
        String dateBH = dateFormat.format(txtNgayCapSo.getDate());
//            ps.setString(4, dateBH);
//            ps.setString(5, txtNoiCapSo.getText());
//            ps.setString(6, txtGhiChu.getText());
//            ps.executeUpdate();
        BaoHiemBUS.Them(cbxMaNhanVien.getSelectedItem().toString(), cbxMaLuong.getSelectedItem().toString(), txtMaBaoHiem.getText(), dateBH, txtNoiCapSo.getText(), txtGhiChu.getText());
        DefaultTableModel model = (DefaultTableModel) tblBaoHiem.getModel();
        model.setRowCount(0);
        showBH();
//            JOptionPane.showMessageDialog(null, "Thêm thành công!");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        String dateBH = dateFormat.format(txtNgayCapSo.getDate());
        BaoHiemBUS.Sua(cbxMaNhanVien.getSelectedItem().toString(), cbxMaLuong.getSelectedItem().toString(), dateBH, txtNoiCapSo.getText(), txtGhiChu.getText(), txtMaBaoHiem.getText());
        DefaultTableModel model = (DefaultTableModel) tblBaoHiem.getModel();
        model.setRowCount(0);
        showBH();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        BaoHiemBUS.Xoa(txtMaBaoHiem.getText());
        DefaultTableModel model = (DefaultTableModel) tblBaoHiem.getModel();
        model.setRowCount(0);
        showBH();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiTVActionPerformed
        // TODO add your handling code here:
        txtNgayCapSo.setEnabled(true);
        txtNoiCapSo.setEnabled(true);
        txtGhiChu.setEnabled(true);
        btnThem.setEnabled(true);
//        btnXoa.setEnabled(true);
//        btnSua.setEnabled(true);
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ns = conn.prepareStatement("SELECT COUNT(*)+1 AS SL FROM TblSoBH");
            ResultSet rs = ns.executeQuery();
            if (rs.next()) {
                String rnno = rs.getString("SL");
                cbxMaNhanVien.setSelectedIndex(0);
                cbxMaLuong.setSelectedIndex(0);
                txtMaBaoHiem.setText("ms0" + rnno);
                //txtNgayCapSo.setText(" " + dateFormat.format(dateBH));
                //txtNgayCapSo.setDateFormatString(modelBH.getValueAt(i, 3).toString());
                txtNgayCapSo.setDateFormatString("yyyy-MM-dd");
                txtNoiCapSo.setText("");
                txtGhiChu.setText("");
            } else {
                cbxMaNhanVien.setSelectedIndex(0);
                cbxMaLuong.setSelectedIndex(0);
                txtMaBaoHiem.setText("ms01");
                //txtNgayCapSo.setText(" " + dateFormat.format(dateBH));
                //txtNgayCapSo.setDateFormatString(modelBH.getValueAt(i, 3).toString());
                txtNgayCapSo.setDateFormatString("yyyy-MM-dd");
                txtNoiCapSo.setText("");
                txtGhiChu.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnMoiTVActionPerformed

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        // TODO add your handling code here:
        String link = "C:\\Users\\dangk\\Desktop\\QLNSVTL\\ARCHIVE\\src\\Report\\frmBaoCaoCheDoBH.jrxml";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            JasperReport jr = JasperCompileManager.compileReport(link);

            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);

            JasperViewer.viewReport(jp);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnXuatActionPerformed

    private void tblBaoHiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBaoHiemMouseClicked
        // TODO add your handling code here:
        txtNgayCapSo.setEnabled(true);
        txtNoiCapSo.setEnabled(true);
        txtGhiChu.setEnabled(true);
        btnThem.setEnabled(true);
        btnXoa.setEnabled(true);
        btnSua.setEnabled(true);
        
        int i = tblBaoHiem.getSelectedRow();
        cbxMaNhanVien.setSelectedItem(modelBH.getValueAt(i, 0).toString());
        cbxMaLuong.setSelectedItem(modelBH.getValueAt(i, 1).toString());
        txtMaBaoHiem.setText(modelBH.getValueAt(i, 2).toString());
        txtNoiCapSo.setText(modelBH.getValueAt(i, 4).toString());
        txtGhiChu.setText(modelBH.getValueAt(i, 5).toString());
        try {
            int srow = tblBaoHiem.getSelectedRow();
            Date NgayCap = new SimpleDateFormat("yyyy-MM-dd").parse((String)modelBH.getValueAt(srow, 3));
            txtNgayCapSo.setDate(NgayCap);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblBaoHiemMouseClicked

    private void txtGhiChu_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChu_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChu_1ActionPerformed

    private void txtTroCapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTroCapKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTroCapKeyPressed

    private void btnThem_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThem_1ActionPerformed

    private void btnSua_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSua_1ActionPerformed

    private void btnXoa_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoa_1ActionPerformed

    private void btnMoi_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoi_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoi_1ActionPerformed

    private void btnXuat_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuat_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuat_1ActionPerformed

    private void tblThaiSanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThaiSanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblThaiSanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane btnMoi10;
    private javax.swing.JButton btnMoiTV;
    private javax.swing.JButton btnMoi_1;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua_1;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem_1;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa_1;
    private javax.swing.JButton btnXuat;
    private javax.swing.JButton btnXuat_1;
    private javax.swing.JComboBox<String> cbxMaBoPhan;
    private javax.swing.JComboBox<String> cbxMaLuong;
    private javax.swing.JComboBox<String> cbxMaNhanVien;
    private javax.swing.JComboBox<String> cbxMaNhanVien_1;
    private javax.swing.JComboBox<String> cbxMaPhong;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblGhiChu_1;
    private javax.swing.JLabel lblHeader1;
    private javax.swing.JLabel lblHeader13;
    private javax.swing.JLabel lblHeader3;
    private javax.swing.JLabel lblHeader7;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMaBaoHiem;
    private javax.swing.JLabel lblMaBoPhan;
    private javax.swing.JLabel lblMaLuong;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblMaNhanVien_1;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JLabel lblNgayCapSo;
    private javax.swing.JLabel lblNgayLamTroLai;
    private javax.swing.JLabel lblNgayNghiSinh;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblNgayVeSom;
    private javax.swing.JLabel lblNoiCapSo;
    private javax.swing.JLabel lblTroCap;
    private javax.swing.JPanel pbThaiSan;
    private javax.swing.JPanel pnBaoHiem10;
    private javax.swing.JTable tblBaoHiem;
    private javax.swing.JTable tblThaiSan;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtGhiChu_1;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaBaoHiem;
    private com.toedter.calendar.JDateChooser txtNgayCapSo;
    private com.toedter.calendar.JDateChooser txtNgayLamTroLai;
    private com.toedter.calendar.JDateChooser txtNgayNghiSinh;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private com.toedter.calendar.JDateChooser txtNgayVeSom;
    private javax.swing.JTextField txtNoiCapSo;
    public javax.swing.JTextField txtTroCap;
    // End of variables declaration//GEN-END:variables
}
