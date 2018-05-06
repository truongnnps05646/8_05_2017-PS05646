<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Spring MVC - Databinding</title>
        <base href="${pageContext.servletContext.contextPath}/">
    </head>
    <body>
        <h2>Quản lý sinh viên</h2>
        <form:form action="student3.html" modelAttribute="student">
            <div>Mã SV</div>
            <form:input path="manv" readonly="true"/>
            <div>Họ và tên</div>
            <form:input path="hoten"/>

            <div>Diachi</div>
            <form:input path="diachi"/>

            <div>Gioitinh</div>
            <select id="gioitinh" name="gioitinh">
                <option value="true">Nam</option>
                <option value="false">Nu</option>
            </select> 
            <div>
                <input name="search">
            </div>


            <div>
                <button name="btnInsert">Thêm</button>
                <button name="btnUpdate">Cập nhật</button>   
                <button name="btnSearch">Search</button>
            </div>
        </form:form>

        <br>            


        <table border="1">
            <tr>
                <td>MaNV</td>
                <td>HoTen</td>
                <td>Diachi</td>
                <td>GioiTinh</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <c:forEach var="rows" items="${listStudent}">
                <form action="student3/delete.html">
                    <tr>
                        <td>${rows.manv}</td>
                        <td>${rows.hoten}</td>
                        <td>${rows.diachi}</td>
                        <td>
                            <c:choose>
                                <c:when test="${rows.gioitinh == true}">
                                    Nam
                                </c:when>
                                <c:otherwise>
                                    Nữ
                                </c:otherwise>
                            </c:choose> 
                        </td>
                        <c:url var="edit" value="student3/edit.html">
                            <c:param name="txtMasv" value="${rows.manv}"/>
                            <c:param name="txtName" value="${rows.hoten}"/>
                            <c:param name="txtMark" value="${rows.diachi}"/>
                            <c:param name="txtMajor" value="${rows.gioitinh}"/>
                        </c:url>
                        <td><a href="${edit}">Edit</a></td>
                        <td>
                            <input type="hidden" name="txtMasv" value="${rows.manv}"/>
                            <input type="submit" name="action" value="Delete"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>    
        </table>
    </body>
</html>
