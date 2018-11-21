<%-- 
    Document   : State_district
    Created on : 17 Jun, 2018, 2:52:30 PM
    Author     : hp
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
         <%
            String state_id="",distname="",id="",stateidd="",district_name="";
                   if(request.getParameter("did")!=null)
                    {
                        String delete_id=request.getParameter("did");
                        String str_delete="delete from tbl_dist where dist_Id='"+delete_id+"'";
                        boolean b=obj.executeCommand(str_delete);
                            if(b==true)
                            {
                                out.println("deleted");

                            }
                            else
                            {
                                out.println(str_delete);
                            }
                    }   
                   if(request.getParameter("eid")!=null)
                    {
                        String edit_id=request.getParameter("eid");
                        String str_edit="select * from tbl_dist where dist_Id='"+edit_id+"'";
                        ResultSet res_edit=obj.selectCommand(str_edit);
                            if(res_edit.next())
                            {
                               state_id=res_edit.getString("state_Id");
                               district_name=res_edit.getString("dist_Name");
                               id=res_edit.getString("dist_Id");
                            }
                    } 
            
            
                   if(request.getParameter("btnsubmit")!=null)
                    {  
                
                        stateidd=request.getParameter("sel_state");
                        distname=request.getParameter("txtdistrict");
                
                        if(!request.getParameter("hid").equals(""))
                             {
                                String hid=request.getParameter("hid");
                                String up="update tbl_dist set dist_Name='"+distname+"',state_Id='"+stateidd+"' where dist_Id='"+hid+"'"; 
                                System.out.println(up);
                                boolean bv=obj.executeCommand(up);
                                if(bv==true)
                                  {
                                   out.println("updated");
                                  }
                           
                             }
                        else
                             {
                    
                                String ins="insert into tbl_dist(dist_Name,state_Id) values('"+distname+"','"+stateidd+"')";
                                System.out.println(ins);
                                boolean bv=obj.executeCommand(ins);
                                if(bv==true)
                                {
                                    out.println("inserted");
                                }
                                else
                                {
                                    out.println(ins);
                                }
               
                   
                              }
            
                     }
            
            
            %>
   
        <form>
            
        <h1 align="center">DISTRICT</h1>
        <table border="2" align="center">
                    <input type="hidden" name="hid" value="<%=id%>">
            <tr>
                <th>STATE NAME</th>
                <td><select name="sel_state">
             <%
                 String stateid="",statename="";
                        
                        String in="select * from tbl_state";
                        ResultSet rs1=obj.selectCommand(in);
                        while(rs1.next())
                        {
                            stateid=rs1.getString("states_Id");
                            statename=rs1.getString("states_Name");
                            
             %>
                        <option<%if (stateid.equals(state_id)){%> selected=""<%}%> value="<%=stateid%>"><%=statename%></option>
             <%       
                        }
             %>
                    </select>
                
  
                </td>
            </tr>
            <tr>
                <th>DISTRICT</th>
                <td><input type="text" name="txtdistrict" value="<%=district_name%>"></td>
                    
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="btnsubmit" value="ADD">
                    <input type="reset" name="txtreset" value="CANCEL">
                </td>
            </tr>
        </table>
                <br>
                
        <table border="2" align="center">
            
            <tr>
                <th>SNO</th>
                <th>DISTRICT</th>
                <th>STATE</th>
                <th>EDIT</th>
                <th>DELETE</th>         
                        
            </tr>
            <tr>
                
        <%
                int i=1;
                    String sel="select * from tbl_state s inner join tbl_dist d on s.states_Id=d.state_Id";
                    ResultSet rsdis=obj.selectCommand(sel);
                    while(rsdis.next())
                    {
        %>
            <tr>
                <td><%=i%></td>
                <td><%=rsdis.getString("dist_Name")%></td>
                <td><%=rsdis.getString("states_Name")%></td>
                <td><a href="District.jsp?eid=<%=rsdis.getString("dist_Id")%>">EDIT</a></td>
                <td><a href="District.jsp?did=<%=rsdis.getString("dist_Id")%>">DELETE</a></td> 
            </tr>            

         <%
                 i++;
                    }
         %>                       
                                           
                            
        
        </table>
        </form>
    </body>
 </html>