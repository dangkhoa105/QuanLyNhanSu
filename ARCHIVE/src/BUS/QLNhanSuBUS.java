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
import DTO.QLNhanSu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class QLNhanSuBUS {
    private static Connection conn;
    
    public static ArrayList<QLNhanSu> nsList() {
        ArrayList<QLNhanSu> nsList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblTTNVCoBan");
            ResultSet rs = ps.executeQuery();
            QLNhanSu ns;
            while (rs.next()) {
                ns = new QLNhanSu(
                    rs.getString("MaBoPhan"),
                    rs.getString("MaPhong"),
                    rs.getString("MaNV"),
                    rs.getString("HoTen"),
                    rs.getString("NgaySinh"),
                    rs.getString("GioiTinh"),
                    rs.getString("CMTND"),
                    rs.getString("NgayCap"),
                    rs.getString("NoiCap"),
                    rs.getString("ChucVu"),
                    rs.getString("ChucDanh"),
                    rs.getString("LoaiHD"),
                    rs.getString("NgayKy"),
                    rs.getString("NgayHetHan"),
                    rs.getString("GhiChu")
                );
                nsList.add(ns);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return nsList;
    }
    
    public static void Them(String maBoPhan, String maPhong, String maNhanVien, String hoTen, String ngaySinh, String gioiTinh, String CMND, String ngayCap, String noiCap, String chucVu, 
            String chucDanh, String loaiHD, String ngayKy, String ngayHetHan, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "INSERT INTO TblTTNVCoBan(MaBoPhan, MaPhong, MaNV, HoTen, NgaySinh, "
            + "GioiTinh, CMTND, NgayCap, NoiCap, ChucVu, ChucDanh, LoaiHD, NgayKy, NgayHetHan, GhiChu) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maBoPhan);
            ps.setString(2, maPhong);
            ps.setString(3, maNhanVien);
            ps.setString(4, hoTen);
            ps.setString(5, ngaySinh);
            ps.setString(6, gioiTinh);
            ps.setString(7, CMND);
            ps.setString(8, ngayCap);
            ps.setString(9, noiCap);
            ps.setString(10, chucVu);
            ps.setString(11, chucDanh);
            ps.setString(12, loaiHD);
            ps.setString(13, ngayKy);
            ps.setString(14, ngayHetHan);
            ps.setString(15, ghiChu);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void Xoa(String maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "DELETE FROM TblTTNVCoBan WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Sua(String maBoPhan, String maPhong, String hoTen, String ngaySinh, String gioiTinh, String CMND, String ngayCap, String noiCap, String chucVu, 
            String chucDanh, String loaiHD, String ngayKy, String ngayHetHan, String ghiChu, String maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "UPDATE TblTTNVCoBan SET MaBoPhan=?, MaPhong=?, HoTen=?, NgaySinh=?, "
            + "GioiTinh=?, CMTND=?, NgayCap=?, NoiCap=?, ChucVu=?, ChucDanh=?, "
            + "LoaiHD=?, NgayKy=?, NgayHetHan=?, GhiChu=? WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);           
            ps.setString(1, maBoPhan);
            ps.setString(2, maPhong);         
            ps.setString(3, hoTen);
            ps.setString(4, ngaySinh);
            ps.setString(5, gioiTinh);
            ps.setString(6, CMND);
            ps.setString(7, ngayCap);
            ps.setString(8, noiCap);
            ps.setString(9, chucVu);
            ps.setString(10, chucDanh);
            ps.setString(11, loaiHD);
            ps.setString(12, ngayKy);
            ps.setString(13, ngayHetHan);
            ps.setString(14, ghiChu);
            ps.setString(15, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
