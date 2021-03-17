<%-- 
    Document   : benhvienform
    Created on : Oct 21, 2020, 10:11:31 PM
    Author     : Dương
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <title>Hospital Add/Edit</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>

    <body class="overlay-scrollbar">

        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: green">
                <div>
                    <a href="#" class="navbar-brand"> Danh mục </a>
                </div>

                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/admin/danhmuc/list-danh-muc" class="nav-link">Danh sách</a></li>
                </ul>
            </nav>
        </header>
        <br>
        <div class="container-fluid col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${danhmuc != null}">
                        <form  name="Form" action="update" method="post" enctype="multipart/form-data" >
                        </c:if>
                        <c:if test="${danhmuc== null}">
                            <form  name="Form" action="insert" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
                            </c:if>

                            <caption>
                                <h2>
                                    <c:if test="${danhmuc != null}">
                                        Sửa danh mục
                                    </c:if>
                                    <c:if test="${danhmuc == null}">
                                        Thêm mới danh mục
                                    </c:if>
                                </h2>
                            </caption>

                            <c:if test="${danhmuc != null}">
                                <input type="hidden" name="id" value="<c:out value='${danhmuc.id}' />" />
                            </c:if>

                            <fieldset class="form-group">
                                <label>Tên</label> 
                                <input type="text" id="tendanhmuc" value="<c:out value='${danhmuc.tenDanhMuc}' />" class="form-control" name="tenDanhMuc" >


                                <fieldset class="form-group">
                                    <label> Ảnh danh mục</label> 
                                    <input type="hidden" name="anhdanhmuc" value="<c:out value='${danhmuc.anhdanhmuc}' />" />
                                    <input type="file" value="<c:out value='${danhmuc.anhdanhmuc}' />" accept="uploads/*" onchange="loadFile(event)" class="form-control" name="anhDanhMuc">
                                </fieldset>
                                <c:if test="${danhmuc != null}"> 
                                    <img id="output-img-prev-upload" style="width: 30%; height: auto" src="<%=request.getContextPath()%>/uploads/<c:out value='${danhmuc.anhdanhmuc}' />" />
                                </c:if>
                                <img id="output-img" style="width: 30%; height: auto" src="" />

                                <fieldset class="form-group">
                                    <label>Trạng thái</label> 

                                    <div class="radio form-group">
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" id="customRadioInline1" name="trangthai" value="1"
                                                   <c:if test="${danhmuc.trangthai ==1}">
                                                       <c:out value="${'checked'}" />
                                                   </c:if>
                                                   class="custom-control-input">
                                            <label class="custom-control-label" for="customRadioInline1">Xuất bản</label>
                                        </div>
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" id="customRadioInline2" name="trangthai" value="0"<c:if test="${danhmuc.trangthai ==0}">
                                                       <c:out value="${'checked'}" />
                                                   </c:if> class="custom-control-input">
                                            <label class="custom-control-label" for="customRadioInline2">Nháp</label>
                                        </div>
                                    </div>
                                </fieldset>
                                <button type="submit" class="btn btn-success">Save</button>
                            
                                    <a class="btn btn-primary" style="color: white; font-weight: 400" href="<%=request.getContextPath()%>/admin/danhmuc/list-danh-muc"> 
                                        Quay lại
                                    </a>
                                            
                        </form>
                </div>
            </div>
        </div>
        <script>
            document.getElementById('output-img').style.display = 'none';
            var loadFile = function (event) {
                var output = document.getElementById('output-img');
                output.src = URL.createObjectURL(event.target.files[0]);
                output.onload = function () {
                    URL.revokeObjectURL(output.src) // free memory
                    if (document.getElementById('output-img-prev-upload') != null) {
                        document.getElementById('output-img-prev-upload').style.display = 'none';
                    }
                    document.getElementById('output-img').style.display = 'inline';
                }
            };
            function validateForm()
            {
                let ten = document.forms["Form"]["tenDanhMuc"].value;
                //                var password = document.form.password.value; 
                //                  console.log(ten);

                if (ten == null || ten == "")
                {
                    alert("Ten danh muc khong duoc de trong");

                    return false;

                }
            }
            ;

        </script>  



    </body>

</html>