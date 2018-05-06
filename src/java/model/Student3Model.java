/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Major;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bean.Student;

/**
 *
 * @author Administrator
 */
public class Student3Model {

    public Student3Model() {
    }
    
    public static List<Student> showStudent(String tensp){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=LAB1_LOGIN";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "select * from SV";
            if(tensp.length() > 0){
                sql += " where hoten like '%"+tensp+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Student> list = new ArrayList<Student>();
            while(rs.next()){
                int manv = rs.getInt("manv");
                String hoten = rs.getString("hoten");
                String diachi = rs.getString("diachi");
                boolean gioitinh = rs.getBoolean("gioitinh");
                Student sp = new Student(manv , hoten, diachi, gioitinh);
                list.add(sp);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<Major> showCN(String tenCN){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=LAB1_LOGIN";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "select * from ChuyenNganh";
            if(tenCN.length() > 0){
                sql += " where tencn like '%"+tenCN+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Major> list = new ArrayList<Major>();
            while(rs.next()){
                
                String name = rs.getString("macn");
                String major = rs.getString("tencn");
                Major mj = new Major(name, major);
                list.add(mj);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    public static void delete(int masv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=LAB1_LOGIN";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "delete from SV where manv=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, masv);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void insert(Student sv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=LAB1_LOGIN";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "insert into SV values(?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, sv.getManv());
            stm.setString(2, sv.getDiachi());
            stm.setBoolean(3, sv.isGioitinh());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void update(Student sv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=LAB1_LOGIN";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "update SV set hoten=?, diachi=?, gioitinh=? where manv=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, sv.getManv());
            stm.setString(2, sv.getDiachi());
            stm.setBoolean(3, sv.isGioitinh());
            stm.setInt(4, sv.getManv());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
