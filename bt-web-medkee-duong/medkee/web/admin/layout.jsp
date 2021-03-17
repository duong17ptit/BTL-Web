<%-- 
    Document   : layout
    Created on : Oct 22, 2020, 10:54:14 AM
    Author     : Duong
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<!--        <title>Layout</title>-->
         <link rel="icon" href="../assets/image/duongavt.jpg" type="image/jpg"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="../assets/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/fontawesome/css/all.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <!--        <link href="../assets/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>-->
        <link href="../assets/css/style.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


    </head>
    <body class="overlay-scrollbar">
        <!-- navbar -->
        <div class="navbar">
            <!-- nav left -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link">

                        <i class="fa fa-bars" aria-hidden="true" onclick="collapseSidebar()" ></i>
                    </a>
                </li>
                <li class="nav-item">
                    <img src="../assets/image/MedKee_Logo-01.svg" alt="medkee logo" class="logo logo-light">
                    <img src="../assets/image/MedKee_Logo-01.svg" alt="medkee logo" class="logo logo-dark">

                </li>
            </ul>
            <!-- end nav left -->
            <!-- form -->
            <form class="navbar-search">
                <input type="text" name="Search" class="navbar-search-input" placeholder="What you looking for...">
                <i class="fa fa-search" aria-hidden="true"></i>
            </form>
            <!-- end form -->
            <!-- nav right -->
            <ul class="navbar-nav nav-right">
                <li class="nav-item mode">
                    <a class="nav-link" href="#" onclick="switchTheme()">
                        <i class="fa fa-sun-o light-icon" aria-hidden="true"></i>
                        <i class="fa fa-moon-o dark-icon" aria-hidden="true"></i>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link">

                        <i class="fa fa-bell dropdown-toggle" data-toggle="notification-menu"></i>
                        <span class="navbar-badge">15</span>
                    </a>
                    <ul id="notification-menu" class="dropdown-menu notification-menu">
                        <div class="dropdown-menu-header">
                            <span>
                                Notifications
                            </span>
                        </div>
                        <div class="dropdown-menu-content overlay-scrollbar scrollbar-hover">
                            <li class="dropdown-menu-item">
                                <a href="#" class="dropdown-menu-link">
                                    <div>
                                        <i class="fas fa-gift"></i>
                                    </div>
                                    <span>
                                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
                                        <br>
                                        <span>
                                            15/07/2020
                                        </span>
                                    </span>
                                </a>
                            </li>
                            <li class="dropdown-menu-item">
                                <a href="#" class="dropdown-menu-link">
                                    <div>
                                        <i class="fas fa-tasks"></i>
                                    </div>
                                    <span>
                                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
                                        <br>
                                        <span>
                                            15/07/2020
                                        </span>
                                    </span>
                                </a>
                            </li>
                            <li class="dropdown-menu-item">
                                <a href="#" class="dropdown-menu-link">
                                    <div>
                                        <i class="fas fa-gift"></i>
                                    </div>
                                    <span>
                                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
                                        <br>
                                        <span>
                                            15/07/2020
                                        </span>
                                    </span>
                                </a>
                            </li>


                            <li class="dropdown-menu-item">
                                <a href="#" class="dropdown-menu-link">
                                    <div>
                                        <i class="fas fa-tasks"></i>
                                    </div>
                                    <span>
                                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
                                        <br>
                                        <span>
                                            15/07/2020
                                        </span>
                                    </span>
                                </a>
                            </li>
                        </div>
                        <div class="dropdown-menu-footer">
                            <span>
                                View all notifications
                            </span>
                        </div>
                    </ul>
                </li>
                <li class="nav-item avt-wrapper">
                    <div class="avt dropdown">
                        <img src="../assets/image/duongavt.jpg" alt="User image" class="dropdown-toggle" data-toggle="user-menu">
                        <ul id="user-menu" class="dropdown-menu">
                            <li  class="dropdown-menu-item">
                                <a class="dropdown-menu-link">
                                    <div>
                                        <i class="fas fa-user-tie"></i>
                                    </div>
                                    <span>Profile</span>
                                </a>
                            </li>
                            <li class="dropdown-menu-item">
                                <a href="#" class="dropdown-menu-link">
                                    <div>
                                        <i class="fas fa-cog"></i>
                                    </div>
                                    <span>Settings</span>
                                </a>
                            </li>
                            <li  class="dropdown-menu-item">
                                <a href="#" class="dropdown-menu-link">
                                    <div>
                                        <i class="far fa-credit-card"></i>
                                    </div>
                                    <span>Payments</span>
                                </a>
                            </li>
                            <li  class="dropdown-menu-item">
                                <a href="#" class="dropdown-menu-link">
                                    <div>
                                        <i class="fas fa-spinner"></i>
                                    </div>
                                    <span>Projects</span>
                                </a>
                            </li>
                            <li  class="dropdown-menu-item">
                                <a href="#" class="dropdown-menu-link">
                                    <div>
                                        <i class="fas fa-sign-out-alt"></i>
                                    </div>
                                    <span>Logout</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
            <!-- end nav right -->
        </div>
        <!-- end navbar -->
        <!-- sidebar -->
        <div class="sidebar">
            <ul class="sidebar-nav">
                <li class="sidebar-nav-item">
                    <a href="#" class="sidebar-nav-link">
                        <div>
                            <i class="fa fa-database" aria-hidden="true"></i>
                        </div>
                        <span>
                            Dashboard
                        </span>
                    </a>
                </li>
                <li class="sidebar-nav-item">
                    <a href="#" class="sidebar-nav-link active">
                        <div>
                            <i class="fa fa-hospital-o" aria-hidden="true"></i>
                        </div>
                        <span>Hospital</span>
                    </a>
                </li>
                <li  class="sidebar-nav-item">
                    <a href="#" class="sidebar-nav-link">
                        <div>
                           <i class="fa fa-plus" aria-hidden="true"></i>
                        </div>
                        <span>Bác sĩ</span>
                    </a>
                </li>
                <li  class="sidebar-nav-item">
                    <a href="#" class="sidebar-nav-link">
                        <div>
                           <i class="fa fa-eercast" aria-hidden="true"></i>
                        </div>
                        <span>Loại Hình</span>
                    </a>
                </li>
                <li  class="sidebar-nav-item">
                    <a href="#" class="sidebar-nav-link">
                        <div>
                           <i class="fa fa-plus-circle" aria-hidden="true"></i>
                        </div>
                        <span>Chuyên khoa</span>
                    </a>
                </li>
                <li  class="sidebar-nav-item">
                    <a href="#" class="sidebar-nav-link">
                        <div>
                           <i class="fa fa-location-arrow" aria-hidden="true"></i>
                        </div>
                        <span>Tỉnh, TP</span>
                    </a>
                </li>
                  <li  class="sidebar-nav-item">
                    <a href="#" class="sidebar-nav-link">
                        <div>
                           <i class="fa fa-h-square" aria-hidden="true"></i>
                        </div>
                        <span>Nhà thuốc</span>
                    </a>
                </li>
                <li  class="sidebar-nav-item">
                    <a href="#" class="sidebar-nav-link">
                        <div>
                            <i class="fa fa-map-marker" aria-hidden="true"></i>
                        </div>
                        <span>Quận, Huyện</span>
                    </a>
                </li>
              
                <li  class="sidebar-nav-item">
                    <a href="#" class="sidebar-nav-link">
                        <div>
                            <i class="fa fa-cogs" aria-hidden="true"></i>
                        </div>
                        <span>Thiết bị</span>
                    </a>
                </li>
                <li  class="sidebar-nav-item">
                    <a href="#" class="sidebar-nav-link">
                        <div>
                           <i class="fa fa-info" aria-hidden="true"></i>
                        </div>
                        <span>Khác</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="wrapper">
            <div class="row">
                <div class="col-3 col-m-6 col-sm-6">
                    <div class="counter bg-primary">
                        <p>
                            <i class="fas fa-tasks"></i>
                        </p>
                        <h3>100+</h3>
                        <p>To do</p>
                    </div>
                </div>

            </div>
        </div>
        <!-- end sidebar -->
        <!-- main content -->


        <!-- end main content -->
        <!-- import script -->

        <script src="../assets/js/index.js" type="text/javascript"></script>
        <!-- end import script -->
    </body>
</html>
