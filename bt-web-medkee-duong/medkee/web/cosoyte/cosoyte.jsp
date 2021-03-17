<%-- 
    Document   : cosoyte
    Created on : Dec 19, 2020, 12:49:18 PM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cosoyte</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap&subset=cyrillic,cyrillic-ext,latin-ext,vietnamese" rel="stylesheet" />
        <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
        <link href="../css/benhviencss.css" rel="stylesheet" type="text/css"/>
        <script src="../assets/fontawesome/js/all.min.js" type="text/javascript"></script>
        <link href="../css/main.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/css/default.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/fontawesome/css/all.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/fontawesome/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700,800,900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="row">
                    <div class="col-4 col-md-3 col-lg-3 col-sm-4">
                        <div class="header-logo">
                            <!-- <a href="<?php echo Yii::app()->baseUrl ?>/"> <img src="<?php echo Yii::app()->baseUrl ?>/assets/logo/medkee.png" style="width: auto; height: 50px;" alt="Medkee" /> </a>  -->
                            <a href="" class="brand">

                                <img src="../assets/image/MedKee_Logo-01.png" alt="medkee">
                            </a>
                        </div>
                    </div>
                    <div class="col col-md-7 col-lg-6 col-sm-6">
                        <div class="header-input">
                            <form method="GET" id="search-engine1" action="">
                                <input type="text" autocomplete="off" class="searchKeys1" name="searchKeys1" placeholder="Nhập từ khóa">
                                <button type="submit" class="timkiem-btn1">Tìm Kiếm</button>
                            </form>
                            <div class="resultSearch1" id="resultSearch1">

                            </div>

                        </div>
                    </div>
                    <div class="col-4 col-md-2 col-lg-3 col-sm-2">
                        <div class="header-btn header-btn1">
                            <button id="header-icon-btn" type="button" class="header-icon-btn"> <i class="fa fa-bars" aria-hidden="true"></i></button>
                        </div>
                        <nav id="menu" class="nav-side ">

                            <ul class="open-menu-side">
                                <li>
                                    <a href="<?php echo Yii::app()->baseUrl ?>/"> Trang Chủ </a>
                                </li>
                                <li>
                                    <a href="<?php echo Yii::app()->baseUrl ?>/login"> Đăng nhập</a>
                                </li>
                                <li>
                                    <a href="<?php echo Yii::app()->baseUrl ?>/benhvienphongkham"> Bệnh Viện, Phòng Khám</a>
                                </li>
                                <li>
                                    <a href=""> Bác Sĩ</a>
                                </li>
                                <li>
                                    <a href=""> Cẩm nang </a>

                                </li>
                                <p> Về phần của Medkee</p>
                                <li>
                                    <a href=""> Liên hệ </a>

                                </li>
                                <li>
                                    <a href=""> Hợp tác </a>

                                </li>

                            </ul>

                            <div class="menu-mxh">
                                <a href="">
                                    <img src="" alt="">

                                </a>

                            </div>

                            <i id="remove-list" class="fa fa-times" aria-hidden="true"></i>
                        </nav>
                        <div id="outclick1" class="out-click"></div>
                    </div>
                </div>
            </div>
        </div>
        <div id="wrapper">
            <div class="container">
                <div class="bread-cumb">
                    <nav aria-label="breadcumb">
                        <ul class="ul-bread-cumb px-0">
                            <li><a href="<?php echo MyUtil::getHomeUrl()?>">Trang chủ</a> ></li>

                            <li><a href="<?php echo Yii::app()->baseUrl ?>/benhvienphongkham"> Bệnh Viện, Phòng Khám</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="content">
                    <h2 class="dsbv"> Danh sách bệnh viện</h2>

                    <div class="row">

                        <div class="col-md-4 col-12">
                            <form method="GET" id="form1">
                                <div class="option option1 seclectdiv">
                                    <label for="content-option-address">Địa chỉ</label>
                                    <br>
                                    <select id="content-option" class="custom-select" name="diachi" onchange="this.form.submit()">

                                        <option value="">Tất Cả</option>

                                        <c:forEach var="tp1" items="${tinhtp}">
                                            <c:if test="${tp1.trangthai ==1}">
                                                <option value="<c:out value='${tp1.id}' />"  ${tp1.id == param.diachi ? "selected" : ''} > <c:out value='${tp1.tenTP}' /> </option>
                                            </c:if>
                                        </c:forEach>

                                    </select>
                                    <br>
                                    <label for="content-option-ck">Chuyên Khoa</label>
                                    <br>
                                    <select id="content-option" class="custom-select" name="chuyenkhoa" onchange="this.form.submit()">
                                        <option value="">Tất Cả</option>

                                        <c:forEach var="ck1" items="${listck}">
                                            <c:if test="${ck1.trangthai ==1}">
                                                <option value="<c:out value='${ck1.id}'/>"  ${ck1.id == param.chuyenkhoa ? "selected" : ''} > <c:out value='${ck1.tenCK}' /> </option>
                                            </c:if>
                                        </c:forEach>

                                    </select>
                                    <br>
                                    <label for="content-option-type">Loại hình</label>
                                    <br>
                                    <select id="content-option" class="custom-select" name="loaihinh" onchange="this.form.submit()">

                                        <option value="">Tất Cả</option>

                                        <c:forEach var="lh1" items="${listlh}">
                                            <c:if test="${lh1.trangthai ==1}">
                                                <option value="<c:out value='${lh1.id}'/>"  ${lh1.id == param.loaihinh ? "selected" : ''} > <c:out value='${lh1.tenLH}' /> </option>
                                            </c:if>
                                        </c:forEach>

                                    </select>

                                </div>
                            </form>
                        </div>

                        <div class="col-md-8 col-12">
                            <div class="hospital-info">

                                <!--                                <?php if (!$data123) : ?>
                                                                <div class="alert alert-secondary" role="alert">
                                                                    <h4 class="alert-heading">No Results</h4>
                                                                    <p style="font-size: 22px;">Thông tin bạn cần tìm không có!</p>
                                                                    <hr>
                                                                    <p class="mb-0">Hãy thử tìm với thông tin khác nhé. </p>
                                                                    <p class="mb-0 ">Try finding other information. </p>
                                                                </div>-->
                                <c:if test="${empty listbv}">
                                    <div class="alert alert-secondary" role="alert">
                                        <h4 class="alert-heading">No Results</h4>
                                        <p style="font-size: 22px;">Thông tin bạn cần tìm không có!</p>
                                        <hr>
                                        <p class="mb-0">Hãy thử tìm với thông tin khác nhé. </p>
                                        <p class="mb-0 ">Try finding other information. </p>
                                    </div>
                                </c:if>
                          
                                <c:forEach var="bv" items="${listbv}">

                                    <div class="item-benhvien">
                                        <div class="row ">
                                            <div class="col-lg-4 col-md-5 col-sm-4 col-12">
                                                <a href="<%=request.getContextPath()%>/cosoyte/trangchitiet?id=<c:out value="${bv.id}"/>" >
                                                    <img src="<%=request.getContextPath()%>/uploads/<c:out value="${bv.anhbvchitiet}" />" 
                                                         style="width: 100%; height:auto;" alt="Benh vien">
                                                </a>
                                            </div>

                                            <div class="col-lg-8 col-md-7 col-sm-8 col-12 ">
                                                <div class="head-bv ">
                                                    <a class="tenbv" href="<%=request.getContextPath()%>/cosoyte/trangchitiet?id=<c:out value="${bv.id}"/>" class="h6"><c:out value="${bv.tenBV}" /></a>
                                                    <br>
                                                    <p class="diachi-bv"><b>Đ/c:</b><c:out value="${bv.diachi}" /></p>
                                                </div>
                                                <div class="tomtat-bv"> <c:out value="${bv.tomtat}" /></div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

       
                                <nav aria-label="Search results pages">
                                    <div class="pagination">
                                        <c:url var="nextUrl" value="">
                                            <c:forEach items="${param}" var="entry">
                                                <c:if test="${entry.key != 'page'}">
                                                    <c:param name="${entry.key}" value="${entry.value}" />
                                                </c:if>
                                            </c:forEach>
                                            <c:param name="page" value="${i}" />

                                        </c:url>
                                        <c:forEach begin="1" end="${totalPage}" var="i">
                                            <c:choose>
                                                <c:when test="${page eq i}">
                                                    <button class=" btn1 color-phantrang-hientai mr-2">  <a  class="a-phantrang">  ${i} </a> </button>
                                                </c:when>
                                                <c:otherwise> 
                                                    <button class="btn1 color-phantrang mr-2">  <a class="a-phantrang" href="${nextUrl}${i}">${i}</a> </button>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>

                                    </div>
                                </nav>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Đang phát triển!
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- <?php echo Yii::app()->baseUrl ?> -->
        <footer id="footer">
            <div class="footer1">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-12 " id="phan1">

                            <a href="" class="brand">
                                <img class="logo-footer" src="../assets/image/MedKee_Logo-01.png" alt="">
                            </a>
                            <p>
                                Đ/c: Ngõ 2 Nguyễn Hoàng, Nam Từ Liêm, Hà Nội
                            </p>
                            <img src="../assets/image/bocongthuong.png" style="width:200px; height:75px" class="nofi" alt="placeholder">
                        </div>
                        <div class="col-lg-9 col-12" id="phan2">
                            <div class="row">
                                <div class="col-12 col-md-3">
                                    <ul class="ul-footer">


                                        <li><a href="#">Trang chủ</a></li>
                                        <li><a href="#">Giới thiệu</a></li>
                                        <li><a href="#">Liên hệ</a></li>
                                        <li><a href="#">Câu hỏi thường gặp</a></li>
                                        <li><a href="#">Điều khoản sử dụng</a></li>
                                        <li><a href="#">Chính sách bảo mật</a></li> 
                                        <!--                                        <li><a href="<?php echo Yii::app()->createUrl('trangtinh/default', array('id' => $page->id, 'url' => $page->url)) ?>"> <?php echo $page->ten ?> </a></li>
                                        -->
                                    </ul>
                                </div>
                                <div class="col-12 col-md-3 ">
                                    <ul class=" ul-footer">

                                        <li><a href="#">Bệnh viện phòng khám</a></li>
                                        <li><a href="#">Danh mục bác sĩ</a></li>
                                        <li><a href="#">Danh mục nhà thuốc</a></li>

                                    </ul>
                                </div>
                                <div class="col-12 col-md-3 ">
                                    <ul class=" ul-footer">
                                        <li><a href="#">Danh mục thiết bị y tế</a></li>
                                        <li><a href="#">Danh mục xét nghiệm</a></li>
                                        <li><a href="#">Thực phẩm chức năng</a></li> 
                                    </ul>
                                </div>
                                <div class="col-12 col-md-3 ">
                                    <ul class="ul-footer">

                                        <a href=" https://www.youtube.com/channel/UC9l2RhMEPCIgDyGCH8ijtPQ"> <img src="../assets/image/youtube.png" class="yt" alt="Logo-Youtube"> </a>
                                        <a href="https://www.facebook.com/bookingcare"> <img src="../assets/image/Facebook.png" class="fb" alt="Logo-Facebook"> </a>
                                    </ul> 

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer2">
                <p class="mb-0 p-footer" style="color: #e7ebf0; font-size: 11px;">© 2020 MEDKEE - BOOKINGCARE. PHIÊN BẢN THỬ
                    NGHIỆM</p>
            </div> 


        </footer>
        <script src="../assets/js/app.js" type="text/javascript"></script>
    </body>
</html>
