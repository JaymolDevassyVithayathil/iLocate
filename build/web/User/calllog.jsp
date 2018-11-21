<%-- 
    Document   : calllog
    Created on : 12 Nov, 2018, 9:02:23 PM
    Author     : MyPc
--%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="db.ConnectionClass" id="obj"></jsp:useBean> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">CALL LOG DETAILS</h1>
        <form>
         
           <table align="center" border="2">
            <tr>
                <th>SNO</th>
                <th>NUMBER</th>
                <th>TYPE</th>
                <th>DATE</th>
                <th>TIME </th>
                <th>DURATION</th>
                
            </tr>
            <tr>
    <%
            String cid="",no="",type="",date="",time="",duration="";
            int i=0;
            String uid=session.getAttribute("uid").toString();
            String sel="select * from tbl_call_logs where user_Id='"+uid+"'";
            System.out.println(sel);
            ResultSet rs=obj.selectCommand(sel);
            while(rs.next())
            {
                cid=rs.getString("call_Id");
                no=rs.getString("call_Number");
                type=rs.getString("call_Type");
                date=rs.getString("call_Date");
                time=rs.getString("call_Time");
                duration=rs.getString("call_Duration");
                
    %>
               <td><%=cid%></td>
                <td><%=no%></td>
                <td><%=type%></td>
                <td><%=date%></td>
                <td><%=time%></td>
                <td><%=duration%></td>
                
                
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
