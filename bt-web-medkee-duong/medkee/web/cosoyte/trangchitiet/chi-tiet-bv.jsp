<%-- 
    Document   : chi-tiet
    Created on : Dec 23, 2020, 11:36:10 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${bvchitiet.tenBV}" /></title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap&subset=cyrillic,cyrillic-ext,latin-ext,vietnamese" rel="stylesheet" />
        <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
        <script src="../assets/fontawesome/js/all.min.js" type="text/javascript"></script>
        <link href="../../assets/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="../../assets/css/default.css" rel="stylesheet" type="text/css"/>
        <link href="../../assets/css/main.css" rel="stylesheet" type="text/css"/>
        <link href="../../assets/fontawesome/css/all.css" rel="stylesheet" type="text/css"/>
        <link href="../../assets/fontawesome/css/all.min.css" rel="stylesheet" type="text/css"/>
        <script src="../../assets/fontawesome/js/all.min.js" type="text/javascript"></script>
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
                                <input type="text" autocomplete="off" class="searchKeys1" name="searchKeys1" placeholder="Nh???p t??? kh??a">
                                <button type="submit" class="timkiem-btn1">T??m Ki???m</button>
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
                                    <a href=""> Trang Ch??? </a>
                                </li>
                                <li>
                                    <a href=""> ????ng nh???p</a>
                                </li>
                                <li>
                                    <a href=""> B???nh Vi???n, Ph??ng Kh??m</a>
                                </li>
                                <li>
                                    <a href=""> B??c S??</a>
                                </li>
                                <li>
                                    <a href=""> C???m nang </a>

                                </li>
                                <p> V??? ph???n c???a Medkee</p>
                                <li>
                                    <a href=""> Li??n h??? </a>

                                </li>
                                <li>
                                    <a href=""> H???p t??c </a>

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
        <div class="container">

            <div class="path">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="">Trang ch???</a></li>
                        <li class="breadcrumb-item"><a href=""> B???nh Vi???n, Ph??ng Kh??m</a></li>
                        <li class="breadcrumb-item active" aria-current="page"><c:out value="${bvchitiet.tenBV}" /></li>
                    </ol>
                </nav>
            </div>

            <div class="hospital">
                <div class="row">

                    <div class="col-6 col-lg-3 col-md-5 col-sm-6">
                        <ul id="hospital-id" class="hospital_images">
                            <li class="hospital_images-big">
                                <img src="<%=request.getContextPath()%>/uploads/<c:out value="${bvchitiet.anhbvchitiet}" />" alt="">
                            </li>
                            <div class=" image-small owl-carousel owl-theme ">
                               

                                <li class="hospital_images-small item ">
                                    <!-- <img src="/med/medkee/yii1/assets/images/benhvien1.jpg"  class="img-fluid" alt=""> -->
                                    <img src="<?php echo BenhVienPhongKham::getImageSubLinkSize($item, 200) ?>" style="width: 100%; height: auto;" class="" alt="">

                                </li>
                   
                            </div>
                        </ul>
                    </div>

                    <div class="col-6 col-lg-9 col-md-7 col-sm-6">
                        <div class="hospital_infor">
                            <div class="name">
                                <h5><c:out value="${bvchitiet.tenBV}" /></h5>
                            </div>
                            <div class="rating">
                                <span>????nh gi??</span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star"></span>
                            </div>

                            <div class="infor">
                                <p>
                                    ?????a ch???: <c:out value="${bvchitiet.diachi}" />
                                    <br>
                                    ??i???n tho???i: <c:out value="${bvchitiet.sodienthoai}" />
                                    <br>
                                    Fax:
                                </p>
                            </div>
                            <div class="detail-infor">
                                <c:out value="${bvchitiet.tomtat}" />

                            </div>


                        </div>
                    </div>
                </div>
            </div>

            <div class="detail">
                <div class="detail_menu">
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button type="button" class="btn btn-secondary gioithieu special">Gi???i thi???u</button>
                        <button type="button" class="btn btn-secondary bacsi">?????i ng?? b??c s??</button>
                        <button type="button" class="btn btn-secondary lichkham">?????t l???ch kh??m</button>
                        <button type="button" class="btn btn-secondary danhgia">????nh gi?? c???a b???nh vi???n</button>
                    </div>
                </div>
                <div class="detail_main">
                    <div class="detail_main_gioithieu">
                        <!-- <div class="detail_main_gioithieu_image">
                            <img src="<?php echo $data->getImageLinkSize(200) ?>" alt="">
        
                        </div> -->

                        <div class="detail_main_gioithieu_text">
                            <p class="ttbv h3 ">Th??ng tin b???nh vi???n: </p>
                            <div class="mota_bv"> <c:out value="${bvchitiet.mota}" /></div>
                        </div>

                    </div>
                    <div class="detail_main_bacsi" style="display:none;">
                        <p class=" h3 text-primary ">??ang ph??t tri???n </p>
                    </div>
                    <div class="detail_main_lichkham"  style="display:none;" >
                        <p class=" h3 text-primary ">??ang ph??t tri???n </p>
                    </div>
                    <div class="detail_main_danhgia"  style="display:none;" >
                        <p class=" h3 text-primary ">??ang ph??t tri???n </p>
                    </div>

                </div>
            </div>

            <div class="more">
                <div class="more--header">
                
                    <div class="more-header-title"> </div>
                    <h6 class="more-header-xemthem"><a href="">xem th??m</a></h6>

                 

                </div>
                <div class="row">
              <!--   v??ng for-->
                    <div class="col-12  col-md-6 ">
                        <div class="more_hospital">
                            <div class="row">
                                <div class="col-4 col-md-4">
                                    <a href="">
                                        <div class="more_hospital_img">
                                            <img src="" class="img-fluid" alt="">
                                        </div>
                                    </a>
                                </div>
                                <div class="col-8 col-md-8">

                                    <div class="more_hospital_infor">
                                        <h4> <c:out value="${bvchitiet.tenBV}" /></h4>
                                            ?????a ch???: 
                                            <br>
                                          <c:out value="${bvchitiet.mota}" />
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>

<!--            end   v??ng for-->
                </div>
            </div>
        </div>
        <footer id="footer">
            <div class="footer1">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-12 " id="phan1">

                            <a href="" class="brand">
                                <img class="logo-footer" src="../assets/image/MedKee_Logo-01.png" alt="">
                            </a>
                            <p>
                                ??/c: Ng?? 2 Nguy???n Ho??ng, Nam T??? Li??m, H?? N???i
                            </p>
                            <img src="../assets/image/bocongthuong.png" style="width:200px; height:75px" class="nofi" alt="placeholder">
                        </div>
                        <div class="col-lg-9 col-12" id="phan2">
                            <div class="row">
                                <div class="col-12 col-md-3">
                                    <ul class="ul-footer">


                                        <li><a href="#">Trang ch???</a></li>
                                        <li><a href="#">Gi???i thi???u</a></li>
                                        <li><a href="#">Li??n h???</a></li>
                                        <li><a href="#">C??u h???i th?????ng g???p</a></li>
                                        <li><a href="#">??i???u kho???n s??? d???ng</a></li>
                                        <li><a href="#">Ch??nh s??ch b???o m???t</a></li> 
                                        <!--                                        <li><a href="<?php echo Yii::app()->createUrl('trangtinh/default', array('id' => $page->id, 'url' => $page->url)) ?>"> <?php echo $page->ten ?> </a></li>
                                        -->
                                    </ul>
                                </div>
                                <div class="col-12 col-md-3 ">
                                    <ul class=" ul-footer">



                                        <li><a href="#">B???nh vi???n ph??ng kh??m</a></li>
                                        <li><a href="#">Danh m???c b??c s??</a></li>
                                        <li><a href="#">Danh m???c nh?? thu???c</a></li>



                                    </ul>
                                </div>
                                <div class="col-12 col-md-3 ">
                                    <ul class=" ul-footer">
                                        <li><a href="#">Danh m???c thi???t b??? y t???</a></li>
                                        <li><a href="#">Danh m???c x??t nghi???m</a></li>
                                        <li><a href="#">Th???c ph???m ch???c n??ng</a></li> 
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
                <p class="mb-0 p-footer" style="color: #e7ebf0; font-size: 11px;">?? 2020 MEDKEE - BOOKINGCARE. PHI??N B???N TH???
                    NGHI???M</p>
            </div> 


        </footer>
        <script src="../assets/js/app.js" type="text/javascript"></script>
    </body>
</html>
