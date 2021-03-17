<%-- 
    Document   : index
    Created on : Oct 17, 2020, 9:28:16 AM
    Author     : Dương đẹp trai
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <script>
            fetch('<%=request.getContextPath()%>/admin/loaihinh/list-loai-hinh').then(function(response){
                return response.json();
           
                
            }).then(function(obj){
                console.log(obj);
            }).catch(function(error){
                console.error('Something went wrong');
                console.log(error);
            });  
            
        </script>
    </body>
    
</html>
