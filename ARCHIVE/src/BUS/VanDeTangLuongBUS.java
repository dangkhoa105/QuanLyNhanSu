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
public class VanDeTangLuongBUS {
    private static Connection conn;
    
    public static ArrayList<VanDeTangLuong> tlList() {
        ArrayList<VanDeTangLuong> tlList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblTangLuong");
            ResultSet rs = ps.executeQuery();
            VanDeTangLuong tl;
            while (rs.next()) {
                tl = new VanDeTangLuong(
                    rs.getString("MaNV"),
                    rs.getString("HoTen"),
                    rs.getString("GioiTinh"),
                    rs.getString("ChucVu"),
                    rs.getString("ChucDanh"),
                    rs.getString("LCBCu"),
                    rs.getString("LCBMoi"),
                    rs.getString("PCapCu"),
                    rs.getString("PcapMoi"),
                    rs.getString("NgayTang"),
                    rs.getString("LyDo")
                );
                tlList.add(tl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return tlList;
    }
    
    public static void Them(String maNhanVien, String hoTen, String gioiTinh, String chucVu, String chucDanh, String luongCoBanCu, String luongCoBanMoi, String phuCapCVCu, String phuCapCVMoi, String ngayTang, String lyDo) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "INSERT INTO TblTangLuong(MaNV, HoTen, GioiTinh, ChucVu, "
            + "ChucDanh, LCBCu, LCBMoi, PCapCu, PcapMoi, NgayTang, LyDo) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.setString(2, hoTen);
            ps.setString(3, gioiTinh);
            ps.setString(4, chucVu);
            ps.setString(5, chucDanh);
            ps.setString(6, luongCoBanCu);
            ps.setString(7, luongCoBanMoi);
            ps.setString(8, phuCapCVCu);
            ps.setString(9, phuCapCVMoi);
            ps.setString(10, ngayTang);
            ps.setString(11, lyDo);
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
            String sql = "DELETE FROM TblTangLuong WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Sua(String hoTen, String gioiTinh, String chucVu, String chucDanh, String luongCoBanCu, String luongCoBanMoi, String phuCapCVCu, String phuCapCVMoi, String ngayTang, String lyDo, String maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "UPDATE TblTangLuong SET HoTen=?, GioiTinh=?, ChucVu=?, "
            + "ChucDanh=?, LCBCu=?, LCBMoi=?, PCapCu=?, PcapMoi=?, NgayTang=?, LyDo=? WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);           
            ps.setString(1, hoTen);
            ps.setString(2, gioiTinh);
            ps.setString(3, chucVu);
            ps.setString(4, chucDanh);
            ps.setString(5, luongCoBanCu);
            ps.setString(6, luongCoBanMoi);
            ps.setString(7, phuCapCVCu);
            ps.setString(8, phuCapCVMoi);
            ps.setString(9, ngayTang);
            ps.setString(10, lyDo);
            ps.setString(11, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
