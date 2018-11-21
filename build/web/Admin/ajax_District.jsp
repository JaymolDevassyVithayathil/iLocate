<%-- 
    Document   : ajax_district
    Created on : 24 Jun, 2018, 10:40:44 AM
    Author     : hp
--%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="obj" class="db.ConnectionClass"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
    </body>
    <%
    String district_name,district_id,placeid,placename;           
    %>   
            <option value="">---Select---</option>     
            <%
     
    String sid = request.getParameter("id");
    String str = "SELECT * FROM tbl_dist WHERE state_Id="+sid;
    ResultSet res=obj.selectCommand(str);
      while(res.next())
        {

            district_id=res.getString("dist_Id");
           district_name=res.getString("dist_Name");
           
            %>                     
                            <option value="<%=district_id%>"> <%=district_name%></option>
                                
                               
            <%
        }
%>

</html>
