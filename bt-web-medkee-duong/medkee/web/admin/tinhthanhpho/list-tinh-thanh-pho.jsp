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
        <title>Tinhthanhpho</title>
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
                    <h3 class="text-center">Danh sách Tỉnh/ Thành phố</h3>

                </div>

                <div class="">

                    <a href="<%=request.getContextPath()%>/admin/tinhthanhpho/new" class="btn btn-success New">Thêm mới Tỉnh/Thành phố</a>
                </div>
                <br>

                <table  style="text-align: left;">
                    <tbody>
                        <tr>
                            <th>ID</th>
                            <th width="15%">Name</th>
                            <th width="15%">Trạng Thái</th>
                            <th>Actions</th>
                        </tr>
                        <c:forEach var="tp" items="${listTp}">

                            <tr>

                                <td>                                  
                                    <c:out value="${tp.id}" />
                                </td>
                                <td>
                                    <c:out value="${tp.tenTP}" />
                                </td>
                                <c:if test="${tp.trangthai ==1}">
                                    <td >
                                        Xuất bản
                                    </td>
                                </c:if>
                                <c:if test="${tp.trangthai ==0}">
                                    <td >
                                        Nháp
                                    </td>
                                </c:if>

                                <td><a class="Edit" href="edit?id=<c:out value='${tp.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; 
                                    <a class="Delete" onclick="return confirm('Are you sure you want to delete this item?');" href="delete?id=<c:out value='${tp.id}' />">Delete</a></td>
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
        <!-- end sidebar -->
        <!-- main content -->


        <!-- end main content -->
        <!-- import script -->

        <script src="../../assets/js/index.js" type="text/javascript"></script>
        <!-- end import script -->
    </body>
</html>
