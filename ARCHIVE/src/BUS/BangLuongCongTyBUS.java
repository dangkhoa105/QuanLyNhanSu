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
import DTO.BangLuongCongTy;
import DTO.VanDeTangLuong;
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
public class BangLuongCongTyBUS {
    private static Connection conn;
    
    public static ArrayList<BangLuongCongTy> blList() {
        ArrayList<BangLuongCongTy> blList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblBangLuongCTy");
            ResultSet rs = ps.executeQuery();
            BangLuongCongTy bl;
            while (rs.next()) {
                bl = new BangLuongCongTy(
                    rs.getString("MaLuong"),
                    rs.getString("ChucVu"),
                    rs.getString("ChucDanh"),
                    rs.getString("LCB"),
                    rs.getString("PCChucVu"),
                    rs.getString("NgayNhap"),
                    rs.getString("LCBMoi"),
                    rs.getString("NgaySua"),
                    rs.getString("LyDo"),
                    rs.getString("PCCVuMoi"),
                    rs.getString("NgaySuaPC"),
                    rs.getString("GhiChu")
                );
                blList.add(bl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return blList;
    }
    
    public static void Them(String maLuong, String chucVu, String chucDanh, String luongCoBan, String phuCapChucVu, String ngayNhap, String luongCoBanMoi, String ngaySua, String lyDo, String phuCapCVuMoi, String ngaySuaPhuCap, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "INSERT INTO TblBangLuongCTy(MaLuong, ChucVu, ChucDanh, LCB, PCChucVu, "
            + "NgayNhap, LCBMoi, NgaySua, LyDo, PCCVuMoi, NgaySuaPC, GhiChu)"
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maLuong);
            ps.setString(2, chucVu);
            ps.setString(3, chucDanh);
            ps.setString(4, luongCoBan);
            ps.setString(5, phuCapChucVu);
            ps.setString(6, ngayNhap);
            ps.setString(7, luongCoBanMoi);
            ps.setString(8, ngaySua);
            ps.setString(9, lyDo);
            ps.setString(10, phuCapCVuMoi);
            ps.setString(11, ngaySuaPhuCap);
            ps.setString(12, ghiChu);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void Xoa(String maLuong) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "DELETE FROM TblBangLuongCTy WHERE MaLuong=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maLuong);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Sua(String chucVu, String chucDanh, String luongCoBan, String phuCapChucVu, String ngayNhap, String luongCoBanMoi, String ngaySua, String lyDo, String phuCapCVuMoi, String ngaySuaPhuCap, String ghiChu, String maLuong) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "UPDATE TblBangLuongCTy SET ChucVu=?, ChucDanh=?, LCB=?, PCChucVu=?, "
            + "NgayNhap=?, LCBMoi=?, NgaySua=?, LyDo=?, PCCVuMoi=?, NgaySuaPC=?, GhiChu=? WHERE MaLuong=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, chucVu);
            ps.setString(2, chucDanh);
            ps.setString(3, luongCoBan);
            ps.setString(4, phuCapChucVu);
            ps.setString(5, ngayNhap);
            ps.setString(6, luongCoBanMoi);
            ps.setString(7, ngaySua);
            ps.setString(8, lyDo);
            ps.setString(9, phuCapCVuMoi);
            ps.setString(10, ngaySuaPhuCap);
            ps.setString(11, ghiChu);
            ps.setString(12, maLuong);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
