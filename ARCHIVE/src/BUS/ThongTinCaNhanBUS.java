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
import DTO.ThongTinCaNhan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DangKhoa
 */
public class ThongTinCaNhanBUS {
    private static Connection conn;
    
    public static ArrayList<ThongTinCaNhan> ttList() {
        ArrayList<ThongTinCaNhan> ttList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblTTCaNhan");
            ResultSet rs = ps.executeQuery();
            ThongTinCaNhan tt;
            while (rs.next()) {
                tt = new ThongTinCaNhan(
                    rs.getString("MaNV"),
                    rs.getString("NoiSinh"),
                    rs.getString("NguyenQuan"),
                    rs.getString("DCThuongChu"),
                    rs.getString("DCTamChu"),
                    rs.getString("SDT"),
                    rs.getString("DanToc"),
                    rs.getString("TonGiao"),
                    rs.getString("QuocTich"),
                    rs.getString("TiengNN"),
                    rs.getString("TrinhDoNN"),
                    rs.getString("HocVan"),
                    rs.getString("HocHam"),
                    rs.getString("NgayVaoDoan"),
                    rs.getString("TenDoanThe"),
                    rs.getString("ChucVuDoan"),
                    rs.getString("GhiChu")
                );
                ttList.add(tt);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ttList;
    }
    
    public static void Them(String maNhanVien, String noiSinh, String nguyenQuan, String diaChiThuongTru, String diaChiTamTru, String soDienThoai, String danToc, String tonGiao, String quocTich, 
            String tiengNgonNgu, String trinhDoNgonNgu, String hocVan, String hocHam, String ngayVaoDoan, String tenDoanThe, String chucVuDoan, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "INSERT INTO TblTTCaNhan(MaNV, NoiSinh, NguyenQuan, DCThuongChu, DCTamChu, "
            + "SDT, DanToc, TonGiao, QuocTich, TiengNN, TrinhDoNN, HocVan, HocHam, NgayVaoDoan, "
            + "TenDoanThe, ChucVuDoan, GhiChu) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.setString(2, noiSinh);
            ps.setString(3, nguyenQuan);
            ps.setString(4, diaChiThuongTru);
            ps.setString(5, diaChiTamTru);
            ps.setString(6, soDienThoai);
            ps.setString(7, danToc);
            ps.setString(8, tonGiao);
            ps.setString(9, quocTich);
            ps.setString(10, tiengNgonNgu);
            ps.setString(11, trinhDoNgonNgu);
            ps.setString(12, hocVan);
            ps.setString(13, hocHam);
            ps.setString(14, ngayVaoDoan);
            ps.setString(15, tenDoanThe);
            ps.setString(16, chucVuDoan);
            ps.setString(17, ghiChu);
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
            String sql = "DELETE FROM TblTTCaNhan WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Sua(String maNhanVien, String noiSinh, String nguyenQuan, String diaChiThuongTru, String diaChiTamTru, String soDienThoai, String danToc, String tonGiao, String quocTich, 
            String tiengNgonNgu, String trinhDoNgonNgu, String hocVan, String hocHam, String ngayVaoDoan, String tenDoanThe, String chucVuDoan, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "UPDATE TblTTCaNhan SET NoiSinh=?, NguyenQuan=?, DCThuongChu=?, DCTamChu=?, "
            + "SDT=?, DanToc=?, TonGiao=?, QuocTich=?, TiengNN=?, TrinhDoNN=?, HocVan=?, HocHam=?, NgayVaoDoan=?, "
            + "TenDoanThe=?, ChucVuDoan=?, GhiChu=? WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);                       
            ps.setString(1, noiSinh);
            ps.setString(2, nguyenQuan);
            ps.setString(3, diaChiThuongTru);
            ps.setString(4, diaChiTamTru);
            ps.setString(5, soDienThoai);
            ps.setString(6, danToc);
            ps.setString(7, tonGiao);
            ps.setString(8, quocTich);
            ps.setString(9, tiengNgonNgu);
            ps.setString(10, trinhDoNgonNgu);
            ps.setString(11, hocVan);
            ps.setString(12, hocHam);
            ps.setString(13, ngayVaoDoan);
            ps.setString(14, tenDoanThe);
            ps.setString(15, chucVuDoan);
            ps.setString(16, ghiChu);
            ps.setString(17, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
