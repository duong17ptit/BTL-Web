<%-- 
    Document   : layout
    Created on : Oct 22, 2020, 10:54:14 AM
    Author     : Duong
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
        <title>BenhvienPhongkham</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="../../assets/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="../../assets/fontawesome/css/all.css" rel="stylesheet" type="text/css"/>
        <link href="../../assets/fontawesome/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">

        <link href="../../assets/css/style.css" rel="stylesheet" type="text/css"/>
        <!--        <link href="../assets/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


    </head>
    <body class="overlay-scrollbar">
        <!-- navbar -->
        <%@include file="../layouts/layout.jsp" %>


        <div class="wrapper">
            <div class="">

                <div style="display: block; width: 100%">
                    <h3 class="text-center">Danh sách Bệnh Viện</h3>
            
                </div>

                <div class="">

                    <a href="<%=request.getContextPath()%>/admin/benhvienphongkham/new" class="btn btn-success New">Thêm mới bệnh viện</a>
                </div>
                <br>

                <table  style="text-align: left;">
                    <tbody>
                        <tr>
                            <th>ID</th>
                            <th width="15%">Tên </th>
                            <th width="15%">Địa chỉ</th>
                            <th width="15%">Ảnh</th>
                            <th width="13%">Số điện thoại</th>
                            <th>Trạng thái</th>
                            <th>Actions</th>
                        </tr>
                        <c:forEach var="bv" items="${listbv}">

                            <tr>

                                <td>                                  
                                    <b> <c:out value="${bv.id}" /> </b>
                                </td>
                                <td>                                  
                                    <c:out value="${bv.tenBV}" />
                                </td>
                                <td>   
                                    <c:forEach var="tp" items="${tinhtp}">

                                        <c:if test="${bv.thanhphoid == tp.id}">
                                            <c:out value='${tp.tenTP}' /> 
                                        </c:if>      

                                    </c:forEach>
                               
                                </td>
                                <td>

                                    <img style="width: 70%; height: auto"  src="<%=request.getContextPath()%>/uploads/<c:out value="${bv.anhbvchitiet}" />">

                                </td>
                                <td>
                                    <c:out value="${bv.sodienthoai}" />
                                </td>
                                <c:if test="${bv.trangthai ==1}">
                                    <td >
                                        Xuất bản
                                    </td>
                                </c:if>
                                <c:if test="${bv.trangthai ==0}">
                                    <td >
                                        Nháp
                                    </td>
                                </c:if>
                                <td><a class="Edit" href="edit?id=<c:out value='${bv.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; 
                                    <a class="Delete"  onclick="return confirm('Are you sure you want to delete this item?');" href="delete?id=<c:out value='${bv.id}' />">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table> 
                <!-- } -->





                <div class="pagination ">
                    <c:forEach begin="1" end="${totalPage}" var="i">
                        <c:choose>
                            <c:when test="${page eq i}">
                                <button class="btn1 color-phantrang-hientai">  <a  class="">  ${i} </a> </button>
                            </c:when>
                            <c:otherwise> 
                                <button class="btn1 color-phantrang">  <a  href="?page=${i}">${i}</a> </button>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                </div>
            </div>
        </div>

        <script src="../../assets/js/index.js" type="text/javascript"></script>
        <script>


        </script>
        <!-- end import script -->
    </body>
</html>
