<%-- 
    Document   : Place
    Created on : 22 Jun, 2018, 2:04:59 PM
    Author     : hp
--%><%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="obj" class="db.ConnectionClass"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <script src="jQuery.js" type="text/javascript"></script>
        <script>
             function getDistrictName(a)
             {
                    $.ajax({url: "ajax_District.jsp?id="+a, success: function(result){
                    $("#dname").html(result);
                    }});
             }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    </head>
    
    <body>
        
    <%
            String id="",name="",names="",id_place="",id_state="";
            String e="";
             
                if(request.getParameter("eid")!=null)
                    {
                        String edit_id=request.getParameter("eid");
                        String str_edit="select * from tbl_place p inner join tbl_dist d on p.dist_Id=d.dist_Id where p.place_Id='"+edit_id+"'";
                        System.out.println("edit\t"+str_edit);

                        ResultSet res_edit=obj.selectCommand(str_edit);
                        while(res_edit.next())
                          {                   
                                id_place=res_edit.getString("place_Id");
                                id=res_edit.getString("dist_Id");
                                id_state=res_edit.getString("state_Id");
                                name=res_edit.getString("dist_Name");
                                names=res_edit.getString("place_name");
                          }
                    } 
            
            
                if(request.getParameter("btnsubmit")!=null)
                    {    
                        id=request.getParameter("sel_district");
                        name=request.getParameter("txtplace");
                 

                        if(!request.getParameter("hid").equals(""))
                            {    
                                e=request.getParameter("hid");
                                String up="update tbl_place set place_Name='"+name+"' where place_Id='"+e+"'";
                                System.out.println(up);
                                boolean b=obj.executeCommand(up);
                                if(b==true)
                                {
                                   out.println("update");
                                }
                                else
                                {
                                   System.out.println(up);
                                }
                            }
                        else          
                            {  
                                       
                                String ins="insert into tbl_place(place_Name,dist_Id) values('"+name+"','"+id+"')";
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
                if(request.getParameter("did")!=null)
                    {
                        String did=request.getParameter("did");
                        String str_did="delete from tbl_place where place_Id='"+did+"'";
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
            <h1 align="center">PLACE</h1>
            
            <table border="2" align="center">
                        <input type="hidden" name="hid" value="<%=id_place%>">
                <tr>
                    <th>STATE NAME</th>
                    <td>
                        <select name="sel_state" onchange="getDistrictName(this.value)">
        <%
            String stateid="",statename="";
                        
                String in="select * from tbl_state";
                ResultSet rs1=obj.selectCommand(in);
                while(rs1.next())
                {
                    stateid=rs1.getString("states_Id");
                    statename=rs1.getString("states_Name");
                            
        %>
                            <option <%if (stateid.equals(id_state)){%> selected="" <%}%> value="<%=stateid%>"><%=statename%></option>
                       
        <%
                         
                }
        %>                        
                        </select>
                    </td>
                </tr>
            
                <tr>
                    <th>DISTRICT</th>
                    <td>
                        <select name="sel_district" id="dname">
        <%
            String disid1="",disname1="";
                
                String sel="select * from tbl_dist";
                ResultSet rs2=obj.selectCommand(sel);
                while(rs2.next())
                {
                    disid1=rs2.getString("dist_Id");
                    disname1=rs2.getString("dist_Name");
        %>
                            <option <% if(disid1.equals(id)){%> selected="" <%}%> value="<%=disid1%>"><%=disname1%></option>
        <%
                }
        %>
                       </select>
                    </td>
                </tr>
             
                <tr>
                    <th>PLACE</th>
                    <td>
                        <input type="text" name="txtplace" value="<%=names%>">
                    </td>
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
                    <th>STATE</th>
                    <th>DISTRICT</th>
                    <th>PLACE</th> 
                    <th>EDIT</th>
                    <th>DELETE</th>
                </tr>
            
        <%
            int i=1;
                String sele="select * from tbl_place p inner join tbl_dist d on p.dist_Id=d.dist_Id inner join tbl_state s on d.state_Id=s.states_Id";
                System.out.println(sele);
                ResultSet rsdis=obj.selectCommand(sele);
                while(rsdis.next())
                {
        %>
                <tr>
                    <td><%=i%></td>
                    <td><%=rsdis.getString("states_Name")%></td> 
                    <td><%=rsdis.getString("dist_Name")%></td>
                    <td><%=rsdis.getString("place_Name")%></td>
                    <td><a href="Place.jsp?eid=<%=rsdis.getString("place_Id")%>">EDIT</a></td>
                    <td><a href="Place.jsp?did=<%=rsdis.getString("place_Id")%>">DELETE</a></td>    

                </tr>
        <%
            i++;
                }
        %>
        
        </table>
        
        </form>
    </body>

</html>
