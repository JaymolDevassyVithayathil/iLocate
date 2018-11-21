<%-- 
    Document   : admin_Login
    Created on : 13 Nov, 2018, 1:19:58 PM
    Author     : MyPc
--%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page import="java.sql.ResultSet"%>--%>
 <jsp:useBean class="db.ConnectionClass" id="obj"></jsp:useBean> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">LOGIN</h1>
        
        <%
        String aname="",apass="";
        String uid="";
        if(request.getParameter("txtsubmit")!=null)
        {
          aname=request.getParameter("txtusername");
          apass=request.getParameter("txtpassword");
          String asel="select * from tbl_admin_reg where admin_Username='"+aname+"' and admin_Password='"+apass+"'";
          ResultSet rs=obj.selectCommand(asel);
          String usel="select * from tbl_user_reg where user_Username='"+aname+"' and user_Password='"+apass+"'";
          ResultSet rsu=obj.selectCommand(usel);
          if (rs.next())
                    {
                      uid=rs.getString("admin_Id");
                      session.setAttribute("uid", uid);
                      response.sendRedirect("../Admin/Home.jsp");
                    }
          else if(rsu.next())
                    {
                      uid=rsu.getString("user_Id");
                      session.setAttribute("uid", uid);
                      response.sendRedirect("../User/home.jsp"); 
                    }
          else
                  {
                      %>
                      <script>
                          alert("Login failed! Please check your Username and Password.");
                      </script>
                      
                      <%
                  }
        }

       %>  
        <form>
        <table border="2" align="center">
            <tr>
                <th>USERNAME</th>
                <td><input type="text" name="txtusername"></td>
            </tr>
            <tr>
                <th>PASSWORD</th>
                <td><input type="password" name="txtpassword"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="txtsubmit" value="LOGIN">
                    <input type="reset" name="txtreset" value="CANCEL">
                </td>
            </tr>
            <tr>
                
                
                <td><a href="ForgotPassword.jsp"> Forgot Password?</a></td>
                 
            </tr>
        </table>
        </form>
    </body>
</html>
