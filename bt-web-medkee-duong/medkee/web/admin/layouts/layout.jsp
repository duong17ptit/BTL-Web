<%-- 
    Document   : layout
    Created on : Oct 22, 2020, 10:54:14 AM
    Author     : Duong
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar">
    <!-- nav left -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link">

                <i class="fa fa-bars" aria-hidden="true" onclick="collapseSidebar()" ></i>
            </a>
        </li>
        <li class="nav-item">
            <img src="../../assets/image/MedKee_Logo-01.svg" alt="medkee logo" class="logo logo-light">
            <img src="../../assets/image/MedKee_Logo-01.svg" alt="medkee logo" class="logo logo-dark">

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
                                <i class="fa fa-tasks" aria-hidden="true"></i>
                            </div>
                            <span>
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
                                <br>
                                <span>
                                    15/11/2020
                                </span>
                            </span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fa fa-tasks" aria-hidden="true"></i>
                            </div>
                            <span>
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
                                <br>
                                <span>
                                    15/11/2020
                                </span>
                            </span>
                        </a>
                    </li>

                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fa fa-tasks" aria-hidden="true"></i>
                            </div>
                            <span>
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
                                <br>
                                <span>
                                    15/11/2020
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
                <img src="../../assets/image/duongavt.jpg" alt="User image" class="dropdown-toggle" data-toggle="user-menu">
                <ul id="user-menu" class="dropdown-menu">
                    <li  class="dropdown-menu-item">
                        <a class="dropdown-menu-link">
                            <div>
                                <i class="fa fa-user" aria-hidden="true"></i>
                            </div>
                            <span>Profile</span>
                        </a>
                    </li>
                    <li class="dropdown-menu-item">
                        <a href="#" class="dropdown-menu-link">
                            <div>
                                <i class="fa fa-cog" aria-hidden="true"></i>
                            </div>
                            <span>Settings</span>
                        </a>
                    </li>

                    <li  class="dropdown-menu-item">
                        <a href="<c:url value = "/logout"/>" class="dropdown-menu-link">
                            <div>
                                <i class="fa fa-sign-out" aria-hidden="true"></i>
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

            <a href="../views/home.jsp" class="sidebar-nav-link">
                <div>
                    <i class="fa fa-hashtag" aria-hidden="true"></i>
                </div>
                <span>
                    Dashboard
                </span>
            </a>
        </li>
        <li class="sidebar-nav-item">
            <a href="/medkee/admin/danhmuc/list-danh-muc" class="sidebar-nav-link ">
                <div>
                    <i class="fa fa-list-alt" aria-hidden="true"></i>
                </div>
                <span>Danh mục</span>
            </a>
        </li>
        <li class="sidebar-nav-item">
            <a href="/medkee/admin/benhvienphongkham/list-benh-vien" class="sidebar-nav-link ">
                <div>
                    <i class="fa fa-hospital-o" aria-hidden="true"></i>
                </div>
                <span>Hospital</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="#" class="sidebar-nav-link">
                <div>
                    <i class="fa fa-user-md" aria-hidden="true"></i>
                </div>
                <span>Bác sĩ</span>
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
            <a href="/medkee/admin/loaihinh/list-loai-hinh" class="sidebar-nav-link">
                <div>
                    <i class="fa fa-eercast" aria-hidden="true"></i>
                </div>
                <span>Loại Hình</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="/medkee/admin/chuyenkhoa/list-ck" class="sidebar-nav-link">
                <div>
                    <i class="fa fa-plus-circle" aria-hidden="true"></i>
                </div>
                <span>Chuyên khoa</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="/medkee/admin/tinhthanhpho/list-tinh-thanh-pho" class="sidebar-nav-link">
                <div>
                    <i class="fa fa-location-arrow" aria-hidden="true"></i>
                </div>
                <span>Tỉnh, TP</span>
            </a>
        </li>
        <li  class="sidebar-nav-item">
            <a href="/medkee/admin/quanhuyen/list-quan-huyen" class="sidebar-nav-link">
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


