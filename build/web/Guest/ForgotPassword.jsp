<%-- 
    Document   : ForgotPassword
    Created on : Oct 11, 2018, 10:47:55 PM
    Author     : Aswathy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<jsp:useBean class="db.ConnectionClass" id="con"></jsp:useBean>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1 align="center">FORGOT PASSWORD</h1>
          <%
             
           String email="",usertype="";   
          if(request.getParameter("btnlogin")!=null)
          {
           String uname=request.getParameter("Admin_uname");  
              
          String asel="select * from tbl_admin_reg where admin_Username='"+uname+"'";
          System.out.println(asel);
          ResultSet rs= con.selectCommand(asel);
          
          String fsel="select * from tbl_user_reg where user_Username='"+uname+"'";
          System.out.println(fsel);
          ResultSet rsc=con.selectCommand(fsel);
          
          
          
            if (rs.next()) {
                      usertype="Admin";
                     
                      uname=rs.getString("admin_Username");
                      
                      session.setAttribute("usertype", usertype);
                      response.sendRedirect("PasswordChange.jsp");

                  } else if (rsc.next()) {
                       usertype="Farmer";
                      email=rsc.getString("user_Email");
                      uname=rsc.getString("user_Username");
                      
                      session.setAttribute("email", email);
                      session.setAttribute("usertype", usertype);
                      response.sendRedirect("PasswordChange.jsp");
                      

                  } 
                     
                  else
                  {
                      %>
                      <script>
                          alert("failed");
                      </script>
                      
                      <%
                  }
          
          }
          
          %>
        <form>
            <table align="center" border="2">
                <tr>
                  <th>
                   Enter your Email :
                  </th>
                  <td>
                      <input type="email" name="email">
                  </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="btnsubmit" value="SUBMIT">
                    </td>
                </tr>
                
            </table> 
        </form>   
      
    </body>
</html>
