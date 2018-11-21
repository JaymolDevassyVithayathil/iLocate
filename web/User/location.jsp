<%-- 
    Document   : location
    Created on : 12 Nov, 2018, 9:03:19 PM
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
        <h1 align="center">LOCATION DETAILS</h1>
        <form>
         
           <table align="center" border="2">
            <tr>
                <th>SNO</th>
                <th>LATITUDE</th>
                <th>LONGITUDE</th>
                <th>CITY</th>
                <th>DATE</th>
                <th>TIME </th>
                
                
            </tr>
            <tr>
    <%
        String lid="",lat="",longi="",city="",date="",time="";
        int i=0;
        String uid=session.getAttribute("uid").toString();
        
            String sel="select * from tbl_location where user_Id='"+uid+"'";
            
            System.out.println(sel);
            ResultSet rs=obj.selectCommand(sel);
            while(rs.next())
            {
                lid=rs.getString("loc_Id");
                lat=rs.getString("loc_Latitude");
                longi=rs.getString("loc_longitude");
                city=rs.getString("loc_City");
                date=rs.getString("loc_Date");
                time=rs.getString("loc_Time");
                
    %>
               <td><%=lid%></td>
                <td><%=lat%></td>
                <td><%=longi%></td>
                <td><%=city%></td>
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
