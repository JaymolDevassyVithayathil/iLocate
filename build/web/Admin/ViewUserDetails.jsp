<%-- 
    Document   : ViewUserDetails
    Created on : 15 Nov, 2018, 4:29:37 PM
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
        <h1 align="center">USER DETAILS</h1>
    <%
            
            if(request.getParameter("aid")!=null)
            {
                String accept=request.getParameter("aid");
                String acQry="update tbl_user_reg set user_Status='accepted' where user_Id="+accept;
                boolean b= obj.executeCommand(acQry);
                if(b==true)
                {
                    out.println("Accepted");
                }
                else
                {
                    System.out.println(acQry);
                }
            }

            
            
            if(request.getParameter("rid")!=null)
            {
                String reject=request.getParameter("rid");
                String acQry="update tbl_user_reg set user_Status='rejected' where user_Id="+reject;
                boolean b= obj.executeCommand(acQry);
                if(b==true)
                {
                    out.println("Rejected");
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
                <th>GENDER </th>
                <th>CONTACT</th>
                <th>EMAIL</th>
                <th>USERNAME</th>
                <th>HOUSE NAME</th>
                <th>PLACE</th>
                <th>DISTRICT</th>
                <th>STATE</th>
                <th colspan="2">STATUS</th>
            </tr>
            <tr>
    <%
        String fname="",lname="",dob="",gender,contact="",email="",username,hname="",place="",state="",district="";
        int i=1;
        
            String sel="select * from tbl_user_reg c inner join tbl_place p on c.user_Place=p.place_Name inner join tbl_dis d inner join tbl_place p on p.dist_Id=d.dist_Id and d.state_Id=states_Id  where user_Status='accepted'";

            System.out.println(sel);
            ResultSet rs=obj.selectCommand(sel);
            while(rs.next())
            {
                fname=rs.getString("user_Fname");
                lname=rs.getString("user_Lname");
                dob=rs.getString("user_Dob");
                gender=rs.getString("user_Gender");
                contact=rs.getString("user_Contact");
                email=rs.getString("user_Email");
                username=rs.getString("user_Username");
                hname=rs.getString("user_Hame");
                place=rs.getString("user_Place");
                district=rs.getString("dist_Name");
                state=rs.getString("states_Name");
    %>
                 <td><%=i%></td>
                <td><%=fname%></td>
                <td><%=lname%></td>
                <td><%=dob%></td>
                <td><%=gender%></td>
                <td><%=contact%></td>
                <td><%=email%></td>
                <td><%=username%></td>
                <td><%=hname%></td>
                <td><%=place%></td>
                <td><%=district%></td>
                <td><%=state%></td>
                <td><a href="ViewUserDetails.jsp?rid=<%=rs.getString("user_Id")%>">REJECT </a></td>
                <td><a href="ViewUserDetails.jsp?aid=<%=rs.getString("user_Id")%>">ACCEPT </a></td>
            </tr>
    <%
                i++;
            }
    %>
            </tr>
        </table>
            
        
    </body>
</html>
