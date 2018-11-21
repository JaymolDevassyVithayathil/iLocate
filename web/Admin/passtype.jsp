<%--
    Document   : passtype
    Created on : 7 Sep, 2018, 2:33:30 PM
    Author     : MyPc
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="db.ConnectionClass" id="con"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>passwordtype Page</title>
    </head>
    <body>
        <%
            String type_id="";
            String typename="";
            String pwdtype=request.getParameter("txttypepwd");
            if(request.getParameter("eid")!=null)
                {
                    String eid=request.getParameter("eid");
                    String str_eid="select * from tbl_type where type_Id='"+eid+"'";

                    ResultSet res_edit=con.selectCommand(str_eid);

                    while(res_edit.next())
                    {
                        type_id=res_edit.getString("type_Id");
                        typename=res_edit.getString("type_Name");
                    }
                }
            if(request.getParameter("btnsubmit")!=null)
                {
                   if(request.getParameter("hid")!="") 
                    {
                        String uid=request.getParameter("hid");
                        String up="update tbl_type set type_Name='"+pwdtype+"' where type_Id='"+request.getParameter("tid")+"'";
                        System.out.println(up);
                        boolean bb=con.executeCommand(up);
                         if(bb==true)
                        {
                          out.println("New Type Inserted");
                        }
                        else
                        {
                          out.println(up);
                        }
                    }
                    else
                    {
                      String ins="insert into tbl_type(type_Name)values('"+typename+"')";
                      if(con.executeCommand(ins)){
                        System.out.println("Inserted Successfully"+ins);
                      }
                      else{
                        System.out.println("Unsuccessfull"+ins);
                      }
                    }
                }   
                if(request.getParameter("did")!=null)
                    {
                        String did=request.getParameter("did");
                        String str_did="delete from tbl_type where type_Id='"+did+"'";
                        System.out.println(str_did);
                        boolean bb=con.executeCommand(str_did);
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
        <form name="pwdtypeform">
            <table align="center" border="1" >
                <tr>
                    <th colspan="2" align="center"><h1>TYPE OF PASSWORD</h1></th>
                </tr>    
                <tr>
                    <th>Type</th>
                    <td><input type="hidden" name="tid" value="<%=type_id%>">    
                       <input type="text" name="txttypepwd" value="<%=typename%>" required=""></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnsubmit" value="SUBMIT"></td>
                    <td><input type="reset" name="btncancel" value="CANCEL"></td>
                </tr>
            </table>
            <br><br>  <br><br>  <br><br>  <br><br>
            <table align="center" border="2">
                <tr>
                    <td>SL NO.</td>
                    <td>Password Type</td>
                    <td>Edit</td>
                    <td>Delete</td>
                </tr> 
                <%
                    int i=1;
                    String se="select * from tbl_type";
                    ResultSet rsl=con.selectCommand(se);
                    while(rsl.next())
                    {
                %>
                <tr>
                    <td> <%=i%></td>
                    <td> <%=rsl.getString("type_Name")%> </td>
                    <td><a href="passtype.jsp?eid=<%=rsl.getString("type_Id")%>">EDIT </a></td>
                    <td><a href="passtype.jsp?did=<%=rsl.getString("type_Id")%>">DELETE </a></td>
                
                </tr>
            
                <% 
                    i++ ;
                    }
                %>
            
            </table>    
        </form>
        
    </body>
</html>
