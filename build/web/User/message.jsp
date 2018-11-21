<%-- 
    Document   : message
    Created on : 12 Nov, 2018, 9:02:45 PM
    Author     : MyPc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<jsp:useBean class="db.ConnectionClass" id="obj"></jsp:useBean> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">MESSAGE DETAILS</h1>
        <form>
         
           <table align="center" border="2">
            <tr>
                <th>SNO</th>
                <th>PHONE NUMBER</th>
                <th>MESSAGE</th>
                <th>TYPE</th>
                <th>DATE</th>
                <th>TIME </th>
                
                
            </tr>
            <tr>
    <%
        String mid="",no="",msg="",type="",date="",time="";
        int i=0;
        String uid=session.getAttribute("uid").toString();
        
            String sel="select * from tbl_msgs where user_Id='"+uid+"'";

            System.out.println(sel);
            ResultSet rs=obj.selectCommand(sel);
            while(rs.next())
            {
                mid=rs.getString("msg_Id");
                no=rs.getString("msg_Phno");
                msg=rs.getString("msg_Msg");
                type=rs.getString("msg_Type");
                date=rs.getString("msg_Date");
                time=rs.getString("msg_Time");
                
    %>
               <td><%=mid%></td>
                <td><%=no%></td>
                <td><%=msg%></td>
                <td><%=type%></td>
                <td><%=date%></td>
                <td><%=time%></td>
                
                
            </tr>
    <%
                i++;
            }
    %>
            </tr>
        </table>
        </form>        
    </body>
</html>
