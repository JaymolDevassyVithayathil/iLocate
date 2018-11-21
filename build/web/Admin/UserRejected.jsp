<%-- 
    Document   : UserRejected
    Created on : 13 Nov, 2018, 2:01:32 PM
    Author     : MyPc
--%>
<%@page import="java.sql.ResultSet"%>
<jsp:useBean class="db.ConnectionClass" id="obj"></jsp:useBean> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1 align="center">REJECTED USER LIST</h1>
       <%
            if(request.getParameter("rid")!=null)
               {
                   String accept=request.getParameter("rid");
                   String acQry="update tbl_user_reg set user_Status='1' where user_Id="+accept;
                   boolean b= obj.executeCommand(acQry);
                   if(b==true)
                   {
                       //out.println("Accepted");
                   }
                   else
                   {
                       System.out.println(acQry);
                   }
               }
    %>
        <table align="center" border="2">
            <tr>
                <th>SNO</th>
                <th>FIRST NAME</th>
                <th>LAST NAME</th>
                <th>DATE OF BIRTH</th>
                <th>GENDER</th>
                <th>CONTACT</th>
                <th>EMAIL</th>
                
                <th>PLACE</th>
                <th>DISTRICT</th>
                <th>STATE</th>
                <th>STATUS</th>
            </tr>
            <tr>
    <%
        String uid="",fname="",lname="",dob="",gender,contact="",email="",hname="",place="",state="",district="";
        int i=1;
        
             String sel="select * from tbl_user_reg c inner join tbl_state s inner join tbl_dist d inner join tbl_place p on c.user_Place=p.place_Name and p.dist_Id=d.dist_Id and d.state_Id=s.states_Id  where user_Status='2'";
            System.out.println(sel);
            ResultSet rs=obj.selectCommand(sel);
            while(rs.next())
            {
               uid=rs.getString("user_Id"); 
               fname=rs.getString("user_Fname");
                lname=rs.getString("user_Lname");
                dob=rs.getString("user_Dob");
                gender=rs.getString("user_Gender");
                contact=rs.getString("user_Contact");
                email=rs.getString("user_Email");
                
                hname=rs.getString("user_Hname");
                place=rs.getString("user_Place");
                district=rs.getString("dist_Name");
                state=rs.getString("states_Name");
    %>
                <td><%=uid%></td>
                <td><%=fname%></td>
                <td><%=lname%></td>
                <td><%=dob%></td>
                <td><%=gender%></td>
                <td><%=contact%></td>
                <td><%=email%></td>
                
                <td><%=hname%></td>
                <td><%=place%></td>
                <td><%=district%></td>
                <td><%=state%></td>
               
               
              <td><a href="UserRejected.jsp?rid=<%=uid%>">ACCEPT </a></td></tr>
            </tr>
    <%
                i++;
            }
    %>
            </tr>
        </table>
            
    </body>
</html>
