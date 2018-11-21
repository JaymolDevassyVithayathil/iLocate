<%-- 
    Document   : state
    Created on : Jun 30, 2018, 3:04:43 PM
    Author     : ANAKHA SHAJI
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
        <% 
            String stname="";
            String state_id="";
            String up_name="";
                      
                        
            if(request.getParameter("eid")!=null)
                {
                    String eid=request.getParameter("eid");
                    String str_eid="select * from tbl_state where states_Id='"+eid+"'";

                    ResultSet res_edit=obj.selectCommand(str_eid);

                    while(res_edit.next())
                    {
                        state_id=res_edit.getString("states_Id");
                        stname=res_edit.getString("states_Name");
                    }
                }
            
            if(request.getParameter("statesubmit")!=null)
                {
                    up_name=request.getParameter("statename");

                    if(request.getParameter("hid")!="") 
                    {
                        String uid=request.getParameter("hid");
                        String up="update tbl_state set states_Name='"+up_name+"' where states_Id='"+request.getParameter("hid")+"'";
                        System.out.println(up);
                        boolean bb=obj.executeCommand(up);
                         if(bb==true)
                        {
                          out.println("New State Inserted");
                        }
                        else
                        {
                          out.println(up);
                        }
                    }
                    else 
                    {
                        stname=request.getParameter("statename");
                        String ins="insert into tbl_state(states_Name) values('"+stname+"')"; 
                        System.out.println(ins);
                        boolean bbb=obj.executeCommand(ins);

                        if(bbb==true)
                        {
                          out.println("New State Inserted");
                        }
                        else
                        {
                          out.println(ins);
                        }
                    }
                
                }
                
            
                    if(request.getParameter("did")!=null)
                    {
                        String did=request.getParameter("did");
                        String str_did="delete from tbl_state where states_Id='"+did+"'";
                        System.out.println(str_did);
                        boolean bb=obj.executeCommand(str_did);
                        if(bb==true)
                        {
                           out.println("deleted");
                        }

                        else
                        {
                           out.println(did+"\t"+str_did);
                        }
                    }
                    
        %>
        <form>
            <h1 align="center">STATE</h1>
            <table border="2" align="center">
                <tr>
                    <th>STATE</th>
                    <td>
                        <input type="hidden" name="hid" value="<%=state_id%>">
                        <input type="text" name="statename" value="<%=stname%>" required="" >
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="statesubmit" value="ADD">
                        <input type="reset" name="statereset" value="CANCEL">
                    </td>
                </tr>
            </table>
        
        <br>
        
            <table align="center" border="2">
                <tr>
                    <th>ID</th>
                    <th>STATE</th>
                    <th>EDIT</th>
                    <th>DELETE</th>
                </tr>
        <%
                    int i=1;
                    String se="select * from tbl_state";
                    ResultSet rsl=obj.selectCommand(se);
                    while(rsl.next())
                    {
        %>
                <tr>
                    <td> <%=i%></td>
                    <td> <%=rsl.getString("states_Name")%> </td>
                    <td><a href="State.jsp?eid=<%=rsl.getString("states_Id")%>">EDIT </a></td>
                    <td><a href="State.jsp?did=<%=rsl.getString("states_Id")%>">DELETE </a></td>
                
                </tr>
            
        <% 
                    i++ ;
                    }
        %>
            
            </table>
        </form>

    </body>
</html>
