<%-- 
    Document   : benhvienform
    Created on : Oct 21, 2020, 10:11:31 PM
    Author     : Dương
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <title>LoaiHinhForm</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body class="overlay-scrollbar">

        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: green">
                <div>
                    <a href="#" class="navbar-brand">Quận Huyện </a>
                </div>

                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/admin/quanhuyen/list-quan-huyen" class="nav-link">Danh sách</a></li>
                </ul>
            </nav>
        </header>
        <br>
        <div class="container-fluid col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${quanhuyen != null}">
                        <form name="Form" action="update" method="post" onsubmit="return validateForm()">
                        </c:if>
                        <c:if test="${quanhuyen== null}">
                            <form name="Form" action="insert" method="post" onsubmit="return validateForm()">
                            </c:if>

                            <caption>
                                <h2>
                                    <c:if test="${quanhuyen != null}">
                                        Sửa quận huyện
                                    </c:if>
                                    <c:if test="${quanhuyen == null}">
                                        Thêm mới quận huyện
                                    </c:if>
                                </h2>
                            </caption>

                            <c:if test="${quanhuyen != null}">
                                <input type="hidden" name="id" value="<c:out value='${quanhuyen.id}' />" />
                            </c:if>

                            <fieldset class="form-group">
                                <label>Tên quận huyện</label> <input type="text" value="<c:out value='${quanhuyen.tenQH}' />" class="form-control" name="tenqh" >
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Thuộc tỉnh/thành phố</label> 
                                <c:if test="${quanhuyen != null}">
                                    <select name="thanhphoid" id="tinhthanhpho" class="form-control">
                                        <option value="0" <c:if test="${BenhVien.thanhphoid ==0}">
                                                    <c:out value="${'selected'}" />
                                                </c:if> >--- Trống ---</option>
                                        <c:forEach var="tp" items="${tinhtp}">
                                            <c:if test="${tp.trangthai ==1}">
                                                <option value="<c:out value='${tp.id}' />"  <c:if test="${quanhuyen.thanhphoid == tp.id}">
                                                            <c:out value="${'selected'}" />
                                                        </c:if> >     <c:out value='${tp.tenTP}' /> </option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </c:if> 


                                <c:if  test="${quanhuyen== null}">
                                    <select name="thanhphoid" id="tinhthanhpho" class="form-control">
                                        <option value="0" <c:if test="${quanhuyen.thanhphoid ==0}">
                                                    <c:out value="${'selected'}" />
                                                </c:if> >--- Trống ---</option>
                                        <c:forEach var="tp1" items="${tinhtp}">
                                            <c:if test="${tp1.trangthai ==1}">
                                                <option value="<c:out value='${tp1.id}' />"> <c:out value='${tp1.tenTP}' /> </option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </c:if> 

                            </fieldset>

                            <fieldset class="form-group">

                                <label>Trạng thái</label> 

                                <div class="radio form-group">
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <input type="radio" id="customRadioInline1" name="trangthai" value="1"
                                               <c:if test="${quanhuyen.trangthai ==1}">
                                                   <c:out value="${'checked'}" />
                                               </c:if>
                                               class="custom-control-input">
                                        <label class="custom-control-label" for="customRadioInline1">Xuất bản</label>
                                    </div>
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <input type="radio" id="customRadioInline2" name="trangthai" value="0"<c:if test="${quanhuyen.trangthai ==0}">
                                                   <c:out value="${'checked'}" />
                                               </c:if> class="custom-control-input">
                                        <label class="custom-control-label" for="customRadioInline2">Nháp</label>
                                    </div>
                                </div>
                            </fieldset>  
                            <button type="submit" class="btn btn-success">Lưu</button>
                       
                                <a class="btn btn-primary" style="color: white; font-weight: 400" href="<%=request.getContextPath()%>/admin/quanhuyen/list-quan-huyen"> 
                                    Quay lại
                                </a>
                             
                        </form>
                </div>
            </div>
        </div>


        <script>
            function validateForm()
            {
                let ten = document.forms["Form"]["tenqh"].value;
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