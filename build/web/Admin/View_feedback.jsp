<%-- 
    Document   : View_feedback
    Created on : Jul 22, 2018, 5:26:22 PM
    Author     : ANAKHA SHAJI
--%>
<%@page import="java.sql.ResultSet"%>

<jsp:useBean id="obj" class="db.ConnectionClass"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>VIEW FEEDBACK</h1>
        
<table border="2" align="center">
     <tr>
         
         <th>NO</th>
               <th>USER NAME</th>
                <th>FEEDBACK</th>
              
     
             
            </tr>
            <tr>
    <%
        String uname=session.getAttribute("uid").toString();
        String feedback="";
        int i=1;
        
            String sel="select * from tbl_feedback f inner join tbl_user_reg u on u.user_Id=f.user_Id";
          System.out.println(sel);
            ResultSet rs=obj.selectCommand(sel);
            while(rs.next())
            {
           uname=rs.getString("user_name");
               feedback=rs.getString("user_suggestion");
               
    %>
                <td><%=i%></td>
                <td><%=rs.getString("user_name")%></td>
                <td><%=rs.getString("user_suggestion")%></td>
              
             
             
            </tr>
           <%
                i++;
            }
    %>
   </tr>
    </table>
    </body>

    
</html>

    </body>
</html>
