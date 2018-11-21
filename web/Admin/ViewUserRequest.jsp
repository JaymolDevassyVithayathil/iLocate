<%-- 
    Document   : ViewUserRequest
    Created on : 16 Nov, 2018, 8:08:49 PM
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
       <table border="1" align="center">
           <h1 align="center">USER DETAILS</h1><br>
                <tr>
                    <td>SL.NO</td>
                    <td>FIRSTNAME</td>
                    <td>LAST NAME</td>
                    <td>GENDER</td>
                    <td>DATE OF BIRTH</td>
                    <td>CONTACT</td>
                    <td>E-MAIL</td>
                    <td>HOUSE NAME</td> 
                    <td>PLACE</td>  
                    <td>DISTRICT</td>
                    <td>STATE</td>
                    <td>ACCEPT</td>
                    <td>REJECT</td>
                </tr>
                <%
                    String uid="",fname="",lname="",dob="",gender,contact="",email="",hname="",place="",state="",district="";
        
                   String st="select * from tbl_user_reg c inner join tbl_place p on c.user_Place=p.place_Name inner join tbl_dist d on p.dist_Id=d.dist_Id inner join tbl_state s on d.state_Id=s.states_Id";    
                   ResultSet rs=obj.selectCommand(st);//import
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
                      
                       if(request.getParameter("acceptid")!=null)
                       {
                           String up="update tbl_user_reg set user_Status='1' where user_Id='"+request.getParameter("acceptid")+"'";
                           if(obj.executeCommand(up))
                           {
                               //out.println("ACCEPTED");
                           }
                           else
                           {
                               out.println(up);
                           }
      
                           
                       }
                         if(request.getParameter("rejectid")!=null)
                       {
                           String up="update tbl_user_reg set user_Status='2' where user_Id='"+request.getParameter("rejectid")+"'";
                           if(obj.executeCommand(up))
                           {
                               //out.println("REJECTED");
                           }
                           else
                           {
                               out.println(up);
                           }
      
                           
                       }
                              
                       
                       %>
                       <tr> 
                           <td> <%=uid%></td>
                           <td><%=fname%> </td>
                           <td><%=lname%></td>
                           <td><%=gender%></td>
                           <td><%=dob%></td>
                           <td><%=contact%></td>
                           <td><%=email%></td>
                           <td><%=hname%></td>
                           <td><%=place%></td>
                           <td><%=district%></td>
                           <td><%=state%></td>   
                        
                          <td> <a href="ViewUserRequest.jsp?acceptid=<%=uid%>">ACCEPT</a></td>
                          <td><a href="ViewUserRequest.jsp?rejectid=<%=uid%>">REJECT</a></td></tr>
                       
                       <%
                       
                    }
                %>
            </table>
       </body>
</html>
