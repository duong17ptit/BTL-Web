
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Login</title>
<link href="css/css.css" rel="stylesheet" />

<script> 
function validate()
{ 
     var username = document.form.username.value; 
     var password = document.form.password.value;
 
     if (username == null || username== "")
     { 
     alert("Tai khoan khong duoc de trong"); 
     return false; 
     }
     else if(password == null || password== "")
     { 
     alert("Mat Khau khong duoc de trong"); 
     return false; 
     } 
}
</script> 

</head>
<body>
    <div style="text-align:center; color: #1150a0;"><h1> Admin Login Medkee </h1> </div>
    <br>
    <div class = "form-dang-nhap">
    <form name="form" action="LoginServlet" method="post" onsubmit="return validate()">
        <!-- Do not use table to format fields. As a good practice use CSS -->
        <table align="center">
         <tr>
         <td>Username</td>
         <td><input type="text" name="username" /></td>
         </tr>
         <tr>
         <td>Password</td>
         <td><input type="password" name="password" /></td>
         </tr>
         <tr> <!-- refer to the video to understand request.getAttribute() -->
         <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></span></td>
         </tr>
         <tr>
         <td></td>
         <td><input type="submit" value="Login"></input>
         <input type="reset" value="Reset"></input></td>
         </tr>
        </table>
    </form>
</div>  
</body>
</html>