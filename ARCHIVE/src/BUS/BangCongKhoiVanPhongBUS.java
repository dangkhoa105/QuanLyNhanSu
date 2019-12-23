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
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DTO.BangCongKhoiDieuHanh;
import DTO.BangCongThuViec;
import DTO.BangCongKhoiSanXuat;
import DTO.BangCongKhoiVanChuyen;
import DTO.BangCongKhoiVanPhong;

/**
 *
 * @author DangKhoa
 */
public class BangCongKhoiVanPhongBUS {
    private static Connection conn;
    
    public static ArrayList<BangCongKhoiVanPhong> vpList() {
        ArrayList<BangCongKhoiVanPhong> vpList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblCongKhoiVanPHong");
            ResultSet rs = ps.executeQuery();
            BangCongKhoiVanPhong vp;
            while (rs.next()) {
                vp = new BangCongKhoiVanPhong(
                    rs.getString("MaNV"),
                    rs.getString("LCB"),
                    rs.getString("PhuCapCVu"),
                    rs.getString("PhuCapKhac"),
                    rs.getString("Thang"),
                    rs.getString("Nam"),
                    rs.getString("SoNgayCongThang"),
                    rs.getString("SoNgayNghi"),
                    rs.getString("SoGioLamThem"),
                    rs.getString("GhiChu")
                );
                vpList.add(vp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return vpList;
    }
    
    public static ArrayList<BangCongKhoiVanPhong> vptcList() {
        ArrayList<BangCongKhoiVanPhong> vpList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT TblCongKhoiVanPHong.MaNV, HoTen, NgaySinh, LCB, PhuCapCVu, PhuCapKhac, Thang, "
            + "Nam, SoNgayCongThang, SoNgayNghi, SoGioLamThem FROM TblCongKhoiVanPHong, TblTTNVCoBan WHERE TblCongKhoiVanPHong.MaNV = TblTTNVCoBan.MaNV ");
            ResultSet rs = ps.executeQuery();
            BangCongKhoiVanPhong vp;
            while (rs.next()) {
                vp = new BangCongKhoiVanPhong(
                    rs.getString("MaNV"),
                    rs.getString("HoTen"),
                    rs.getString("NgaySinh"),
                    rs.getString("LCB"),
                    rs.getString("PhuCapCVu"),
                    rs.getString("PhuCapKhac"),
                    rs.getString("Thang"),
                    rs.getString("Nam"),
                    rs.getString("SoNgayCongThang"),
                    rs.getString("SoNgayNghi"),
                    rs.getString("SoGioLamThem")
                );
                vpList.add(vp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return vpList;
    }
    
    public static void Them(String maNhanVien, String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "INSERT INTO TblCongKhoiVanPHong(MaNV, LCB, PhuCapCVu, PhuCapKhac, Thang, "
            + "Nam, SoNgayCongThang, SoNgayNghi, SoGioLamThem, GhiChu) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.setString(2, luongCoBan);
            ps.setString(3, phuCap);
            ps.setString(4, phuCapKhac);
            ps.setString(5, thang);
            ps.setString(6, nam);
            ps.setString(7, soNgayCong);
            ps.setString(8, soNgayNghi);
            ps.setString(9, soGioLam);
            ps.setString(10, ghiChu);
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
            String sql = "DELETE FROM TblCongKhoiVanPHong WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Sua(String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu, String maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "UPDATE TblCongKhoiVanPHong SET LCB=?, PhuCapCVu=?, PhuCapKhac=?, Thang=?, "
            + "Nam=?, SoNgayCongThang=?, SoNgayNghi=?, SoGioLamThem=?, GhiChu=? WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, luongCoBan);
            ps.setString(2, phuCap);
            ps.setString(3, phuCapKhac);
            ps.setString(4, thang);
            ps.setString(5, nam);
            ps.setString(6, soNgayCong);
            ps.setString(7, soNgayNghi);
            ps.setString(8, soGioLam);
            ps.setString(9, ghiChu);
            ps.setString(10, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
