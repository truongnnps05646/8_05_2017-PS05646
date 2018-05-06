/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Major;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import bean.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Student3Model;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/student3")
public class Student3Controller {

    @RequestMapping("showall")
    public String showAll(ModelMap model) {
        Student3Model st = new Student3Model();
        List<Student> list = new ArrayList<Student>();
        list = st.showStudent("");
        model.addAttribute("listStudent", list);

        Student sv = new Student();
        sv = list.get(0);
        model.addAttribute("student", sv);
        return "student3";
    }

    @RequestMapping("edit")
    public String edit(HttpServletRequest request, ModelMap model) {
        int masv = Integer.parseInt(request.getParameter("txtMasv"));
        String name = request.getParameter("txtName");
        String diachi =request.getParameter("txtMark");
        boolean gioitinh = Boolean.parseBoolean(request.getParameter("txtMajor")) ;
        Student sv = new Student(masv, name, diachi, gioitinh);
        model.addAttribute("student", sv);

        List<Student> list = new ArrayList<Student>();
        list = Student3Model.showStudent("");
        model.addAttribute("listStudent", list);
        return "student3";
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, ModelMap model,
            @ModelAttribute("student") Student student) {
        int masv = Integer.parseInt(request.getParameter("txtMasv"));
        Student3Model.delete(masv);

        List<Student> list = new ArrayList<Student>();
        list = Student3Model.showStudent("");
        model.addAttribute("listStudent", list);
        return "student3";
    }

    @RequestMapping(params = "btnUpdate")
    public String update(@ModelAttribute("student") Student student, ModelMap model) {
        Student3Model.update(student);

        List<Student> list = new ArrayList<Student>();
        list = Student3Model.showStudent("");
        model.addAttribute("listStudent", list);
        return "student3";
    }

    @RequestMapping(params = "btnInsert")
    public String insert(@ModelAttribute("student") Student student, ModelMap model) {
        Student3Model.insert(student);

        List<Student> list = new ArrayList<Student>();
        list = Student3Model.showStudent("");
        model.addAttribute("listStudent", list);
        return "student3";
    }

    @ModelAttribute("majors")
    public List<Major> getMajors() {
        List<Major> list = new ArrayList<Major>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=LAB1_LOGIN";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "select * from ChuyenNganh";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                list.add(new Major(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception ex) {

        }
        return list;
    }
    
    @RequestMapping(params = "btnSearch")
    public String search(@ModelAttribute("student") Student student, ModelMap model, HttpServletRequest request) {
        String id = request.getParameter("search");
        

        List<Student> list = new ArrayList<Student>();
        list = Student3Model.showStudent(id);
        model.addAttribute("listStudent", list);
        return "student3";
    }
}
