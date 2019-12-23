/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.TableUI;
import javax.swing.table.DefaultTableModel;
import DTO.QLPhongBan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DangKhoa
 */
public class QLPhongBanBUS {
    private static Connection conn;
    
    public static ArrayList<QLPhongBan> pbList() {
        ArrayList<QLPhongBan> pbList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblPhongBan");
            ResultSet rs = ps.executeQuery();
            QLPhongBan pb;
            while (rs.next()) {
                pb = new QLPhongBan(
                    rs.getString("MaBoPhan"),
                    rs.getString("MaPhong"),
                    rs.getString("TenPhong"),
                    rs.getString("NgayTLap"),
                    rs.getString("GhiChu")
                );
                pbList.add(pb);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return pbList;
    }
    
    public static void Them(String maBoPhan, String maPhong, String tenPhong, String ngayThanhLap, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "INSERT INTO TblPhongBan(MaBoPhan, MaPhong, TenPhong, NgayTLap, GhiChu) "
            + "values(?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maBoPhan);
            ps.setString(2, maPhong);
            ps.setString(3, tenPhong);
            ps.setString(4, ngayThanhLap);
            ps.setString(5, ghiChu);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void Xoa(String maPhong) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "DELETE FROM TblPhongBan WHERE MaPhong=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maPhong);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Sua(String maBoPhan, String tenPhong, String ngayThanhLap, String ghiChu, String maPhong) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "UPDATE TblPhongBan SET MaBoPhan=?, TenPhong=?, NgayTLap=?, GhiChu=? WHERE MaPhong=?";
            PreparedStatement ps = conn.prepareStatement(sql);           
            ps.setString(1, maBoPhan);
            ps.setString(2, tenPhong);         
            ps.setString(3, ngayThanhLap);
            ps.setString(4, ghiChu);
            ps.setString(5, maPhong);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
