/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

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
public class BaoHiemBUS {
    private static Connection conn;
    
    public static ArrayList<BaoHiem> bhList() {
        ArrayList<BaoHiem> bhList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblSoBH");
            ResultSet rs = ps.executeQuery();
            BaoHiem bh;
            while (rs.next()) {
                bh = new BaoHiem(
                    rs.getString("MaNV"),
                    rs.getString("MaLuong"),
                    rs.getString("MaSoBH"),
                    rs.getString("NgayCapSo"),
                    rs.getString("NoiCapSo"),
                    rs.getString("GhiChu")
                );
                bhList.add(bh);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return bhList;
    }
    
    public static void Them(String maNhanVien, String maLuong, String maSoBaoHiem, String ngayCapSo, String noiCapSo, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "INSERT INTO TblSoBH(MaNV, MaLuong, MaSoBH, NgayCapSo, NoiCapSo, GhiChu) "
            + "values(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.setString(2, maLuong);
            ps.setString(3, maSoBaoHiem);
            ps.setString(4, ngayCapSo);
            ps.setString(5, noiCapSo);
            ps.setString(6, ghiChu);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void Xoa(String maSoBaoHiem) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "DELETE FROM TblSoBH WHERE MaSoBH=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSoBaoHiem);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Sua(String maNhanVien, String maLuong, String ngayCapSo, String noiCapSo, String ghiChu, String maSoBaoHiem) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "UPDATE TblSoBH SET MaNV=?, MaLuong=?, NgayCapSo=?, NoiCapSo=?, GhiChu=? WHERE MaSoBH=?";
            PreparedStatement ps = conn.prepareStatement(sql);           
            ps.setString(1, maNhanVien);
            ps.setString(2, maLuong);
            ps.setString(3, ngayCapSo);
            ps.setString(4, noiCapSo);
            ps.setString(5, ghiChu);
            ps.setString(6, maSoBaoHiem);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
