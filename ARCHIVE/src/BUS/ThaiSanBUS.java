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
public class ThaiSanBUS {
    private static Connection conn;
    
    public static ArrayList<ThaiSan> tsList() {
        ArrayList<ThaiSan> tsList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblThaiSan");
            ResultSet rs = ps.executeQuery();
            ThaiSan ts;
            while (rs.next()) {
                ts = new ThaiSan(
                    rs.getString("MaBoPhan"),
                    rs.getString("MaPhong"),
                    rs.getString("MaNV"),
                    rs.getString("HoTen"),
                    rs.getString("NgaySinh"),
                    rs.getString("NgayVeSom"),
                    rs.getString("NgayNghiSinh"),
                    rs.getString("NgayLamTroLai"),
                    rs.getString("TroCapCTY"),
                    rs.getString("GhiChu")
                );
                tsList.add(ts);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return tsList;
    }
    
    public static void Them(String maBoPhan, String maPhong, String maNhanVien, String hoTen, String ngaySinh, String ngayVeSom, String ngayNghiSinh, String ngayLamTroLai, String troCapCongTy, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "INSERT INTO TblThaiSan(MaBoPhan, MaPhong, MaNV, HoTen, "
            + "NgaySinh, NgayVeSom, NgayNghiSinh, NgayLamTroLai, TroCapCTY, GhiChu) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maBoPhan);
            ps.setString(2, maPhong);
            ps.setString(3, maNhanVien);
            ps.setString(4, hoTen);
            ps.setString(5, ngaySinh);
            ps.setString(6, ngayVeSom);
            ps.setString(7, ngayNghiSinh);
            ps.setString(8, ngayLamTroLai);
            ps.setString(9, troCapCongTy);
            ps.setString(10, ghiChu);
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
