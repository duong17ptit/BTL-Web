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

   <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js"></script>

        <script>
            $(document).ready(function () {
                $('.select-js-2').select2();
            });
        </script>
    </head>

    <body class="overlay-scrollbar">

        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: green">
                <div>
                    <a href="#" class="navbar-brand"> Bệnh viện, Phòng khám </a>
                </div>

                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/admin/benhvienphongkham/list-benh-vien" class="nav-link">Danh sách</a></li>
                </ul>
            </nav>
        </header>
        <br>
        <div class="container-fluid col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${BenhVien != null}">
                        <form name="Form" action="update" method="post" enctype="multipart/form-data">
                        </c:if>
                        <c:if test="${BenhVien== null}">
                            <form name="Form" action="insert" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
                            </c:if>

                            <caption>
                                <h2>
                                    <c:if test="${BenhVien != null}">
                                        Sửa bệnh viện
                                    </c:if>
                                    <c:if test="${BenhVien == null}">
                                        Thêm bệnh viện
                                    </c:if>
                                </h2>
                                <div id="error_message"></div>
                            </caption>

                            <c:if test="${BenhVien != null}">
                                <input type="hidden" name="id" value="<c:out value='${BenhVien.id}' />" />
                            </c:if>

                            <fieldset class="form-group">
                                <label>Tên</label> <input type="text" value="<c:out value='${BenhVien.tenBV}' />" class="form-control" name="tenbv" >
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Địa chỉ</label> <input type="text" value="<c:out value='${BenhVien.diachi}' />" class="form-control" name="diachi">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Số điện thoại</label> <input type="text" value="<c:out value='${BenhVien.sodienthoai}' />" class="form-control" name="sodienthoai">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Tóm tắt</label> <input type="text" value="<c:out value='${BenhVien.tomtat}' />" class="form-control" name="tomtat">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Mô tả</label> <input type="text" value="<c:out value='${BenhVien.mota}' />" class="form-control" name="mota">
                            </fieldset>
                            <fieldset class="form-group">
                                <input type="hidden" name="anhchitiet" value="<c:out value='${BenhVien.anhbvchitiet}' />" />
                                <label> ảnh bệnh viện </label> 
                                <input type="file" value="<c:out value='${BenhVien.anhbvchitiet}' />" accept="uploads/*" onchange="loadFile(event)" class="form-control" name="anhbvchitiet">

                            </fieldset>
                            <c:if test="${BenhVien != null}"> 
                                <img id="output-img-prev-upload" style="width: 30%; height: auto" src="<%=request.getContextPath()%>/uploads/<c:out value='${BenhVien.anhbvchitiet}' />" />
                            </c:if>

                            <img id="output-img" style="width: 30%; height: auto" src="" />


                            <fieldset class="form-group">
                                <label>Link ảnh nhỏ</label> <input type="text" value="<c:out value='${BenhVien.anhdaidien}' />" class="form-control" name="anhdaidien">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Thành Phố</label> 
<!--                                <input type="text" value="<c:out value='${BenhVien.thanhphoid}' />" class="form-control" name="thanhphoid">-->
                                <c:if test="${BenhVien != null}">
                                    <select name="thanhphoid" id="tinhthanhpho" class="form-control">
                                        <option value="0" <c:if test="${BenhVien.thanhphoid ==0}">
                                                    <c:out value="${'selected'}" />
                                                </c:if> >--- Trống ---</option>
                                        <c:forEach var="tp" items="${tinhtp}">
                                            <c:if test="${tp.trangthai ==1}">
                                                <option value="<c:out value='${tp.id}' />"  <c:if test="${BenhVien.thanhphoid == tp.id}">
                                                            <c:out value="${'selected'}" />
                                                        </c:if> >     <c:out value='${tp.tenTP}' /> </option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </c:if> 


                                <c:if  test="${BenhVien== null}">
                                    <select name="thanhphoid" id="tinhthanhpho" class="form-control">
                                        <option value="0" <c:if test="${BenhVien.thanhphoid ==0}">
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
                                <label>Quận huyện</label> 
                                <c:if test="${BenhVien != null}">
                                    <select name="quanhuyenid" id="quanhuyen" class="form-control">
                                        <option value="0" <c:if test="${BenhVien.quanhuyenid ==0}">
                                                    <c:out value="${'selected'}" />
                                                </c:if> >--- Trống ---</option>
                                        <c:forEach var="qh" items="${listqh}">
                                            <c:if test="${qh.trangthai ==1}">
                                                <option value="<c:out value='${qh.id}' />"  <c:if test="${BenhVien.quanhuyenid == qh.id}">
                                                            <c:out value="${'selected'}" />
                                                        </c:if> >     <c:out value='${qh.tenQH}' /> </option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </c:if> 


                                <c:if  test="${BenhVien== null}">
                                    <select name="quanhuyenid" id="quanhuyen" class="form-control">
                                        <option value="0" <c:if test="${BenhVien.quanhuyenid ==0}">
                                                    <c:out value="${'selected'}" />
                                                </c:if> >--- Trống ---</option>
                                        <c:forEach var="qh1" items="${listqh}">
                                            <c:if test="${qh1.trangthai ==1}">
                                                <option value="<c:out value='${qh1.id}' />"> <c:out value='${qh1.tenQH}' /> </option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </c:if> 
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Loại hình</label> 
                                <c:if test="${BenhVien != null}">
                                    <select name="loaihinhid" id="loaihinh" class="form-control">
                                        <option value="0" <c:if test="${BenhVien.loaihinhid ==0}">
                                                    <c:out value="${'selected'}" />
                                                </c:if> >--- Trống ---</option>
                                        <c:forEach var="lh" items="${lhlist}">
                                            <c:if test="${lh.trangthai ==1}">
                                                <option value="<c:out value='${lh.id}' />"  <c:if test="${BenhVien.loaihinhid == lh.id}">
                                                            <c:out value="${'selected'}" />
                                                        </c:if> >     <c:out value='${lh.tenLH}' /> </option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </c:if> 


                                <c:if  test="${BenhVien== null}">
                                    <select name="loaihinhid" id="loaihinh" class="form-control">
                                        <option value="0" <c:if test="${BenhVien.loaihinhid ==0}">
                                                    <c:out value="${'selected'}" />
                                                </c:if> >--- Trống ---</option>
                                        <c:forEach var="lh1" items="${lhlist}">
                                            <c:if test="${lh1.trangthai ==1}">
                                                <option value="<c:out value='${lh1.id}' />"> <c:out value='${lh1.tenLH}' /> </option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </c:if> 
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Chuyên khoa</label> 
                                <select name="chuyenkhoa[]" id="chuỵenkhoa" class="form-control select-js-2 " multiple>
                                    <c:forEach var="itemck" items="${cklist}">
                                        <c:if test="${itemck.trangthai ==1}">
                                            <option value="<c:out value='${itemck.id}' />"> <c:out value='${itemck.tenCK}' /> </option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </fieldset>
                            <fieldset class="form-group">
                                <label>URL</label> <input type="text" value="<c:out value='${BenhVien.urlbv}' />" class="form-control" name="urlbv">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Xếp Hạng</label> <input type="text" value="<c:out value='${BenhVien.rank}' />" class="form-control" name="rank">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Trạng thái</label> 
                                <div class="radio form-group">
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <input type="radio" id="customRadioInline1" name="trangthai" value="1"
                                               <c:if test="${BenhVien.trangthai ==1}">
                                                   <c:out value="${'checked'}" />
                                               </c:if>
                                               class="custom-control-input">
                                        <label class="custom-control-label" for="customRadioInline1">Xuất bản</label>
                                    </div>
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <input type="radio" id="customRadioInline2" name="trangthai" value="0"<c:if test="${BenhVien.trangthai ==0}">
                                                   <c:out value="${'checked'}" />
                                               </c:if> class="custom-control-input">
                                        <label class="custom-control-label" for="customRadioInline2">Nháp</label>
                                    </div>
                                </div>
                            </fieldset>

                            <button type="submit" class="btn btn-success">Lưu</button>
                            <button type="btn" class="btn btn-primary">
                                <a style="color: white; font-weight: 400" href="<%=request.getContextPath()%>/admin/benhvienphongkham/list-benh-vien"> 
                                    Quay lại
                                </a>
                            </button>                   
                        </form>
                </div>
            </div>
        </div>

        <input type="hidden" id="get_quan_huyen_url" value="<%=request.getContextPath()%>/admin/quanhuyen/QuanHuyenByTpid?thanhphoid=">

        <script src="../../assets/js/main.js" type="text/javascript"></script>
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

                                    function validatePhone(phonenum) {
                                        var vnf_regex = /((09|01|02|03|06|04|03|07|08|05)+([0-9]{8})\b)/g;
                                        return vnf_regex.test(phonenum);
                                    }
                                    function validateForm()
                                    {
                                        let ten = document.forms["Form"]["tenbv"].value;
                                        //                var password = document.form.password.value; 
                                        //                  console.log(ten);
                                        let sdt = document.forms["Form"]["sodienthoai"].value;

                                        if (ten == null || ten == "")
                                        {
                                            alert("Ten benh vien khong duoc de trong");

                                            return false;

                                        }
                                        if (!validatePhone(sdt) || isNaN(sdt)) {
                                            //                    text = "Please Enter valid Phone Number";
                                            //                    error_message.innerHTML = text;
                                            alert("So dien thoai khong hop le !");
                                            return false;
                                        }
                                    }
                                    ;


        </script>  
    </body>

</html>