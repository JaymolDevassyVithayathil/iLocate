package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.ResultSet;

public final class Place_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      db.ConnectionClass obj = null;
      synchronized (_jspx_page_context) {
        obj = (db.ConnectionClass) _jspx_page_context.getAttribute("obj", PageContext.PAGE_SCOPE);
        if (obj == null){
          obj = new db.ConnectionClass();
          _jspx_page_context.setAttribute("obj", obj, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <script src=\"jQuery.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("             function getDistrictName(a)\n");
      out.write("             {\n");
      out.write("                    $.ajax({url: \"ajax_District.jsp?id=\"+a, success: function(result){\n");
      out.write("                    $(\"#dname\").html(result);\n");
      out.write("                    }});\n");
      out.write("             }\n");
      out.write("        </script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("    ");

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
            
        
      out.write("\n");
      out.write("        <form>\n");
      out.write("            <h1 align=\"center\">PLACE</h1>\n");
      out.write("            \n");
      out.write("            <table border=\"2\" align=\"center\">\n");
      out.write("                        <input type=\"hidden\" name=\"hid\" value=\"");
      out.print(id_place);
      out.write("\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>STATE NAME</th>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"sel_state\" onchange=\"getDistrictName(this.value)\">\n");
      out.write("        ");

            String stateid="",statename="";
                        
                String in="select * from tbl_state";
                ResultSet rs1=obj.selectCommand(in);
                while(rs1.next())
                {
                    stateid=rs1.getString("states_Id");
                    statename=rs1.getString("states_Name");
                            
        
      out.write("\n");
      out.write("                            <option ");
if (stateid.equals(id_state)){
      out.write(" selected=\"\" ");
}
      out.write(" value=\"");
      out.print(stateid);
      out.write('"');
      out.write('>');
      out.print(statename);
      out.write("</option>\n");
      out.write("                       \n");
      out.write("        ");

                         
                }
        
      out.write("                        \n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            \n");
      out.write("                <tr>\n");
      out.write("                    <th>DISTRICT</th>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"sel_district\" id=\"dname\">\n");
      out.write("        ");

            String disid1="",disname1="";
                
                String sel="select * from tbl_dist";
                ResultSet rs2=obj.selectCommand(sel);
                while(rs2.next())
                {
                    disid1=rs2.getString("dist_Id");
                    disname1=rs2.getString("dist_Name");
        
      out.write("\n");
      out.write("                            <option ");
 if(disid1.equals(id)){
      out.write(" selected=\"\" ");
}
      out.write(" value=\"");
      out.print(disid1);
      out.write('"');
      out.write('>');
      out.print(disname1);
      out.write("</option>\n");
      out.write("        ");

                }
        
      out.write("\n");
      out.write("                       </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("             \n");
      out.write("                <tr>\n");
      out.write("                    <th>PLACE</th>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"txtplace\" value=\"");
      out.print(names);
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" align=\"center\">\n");
      out.write("                        <input type=\"submit\" name=\"btnsubmit\" value=\"ADD\">\n");
      out.write("                        <input type=\"reset\" name=\"txtreset\" value=\"CANCEL\">\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("        \n");
      out.write("            </table>\n");
      out.write("        \n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            <table border=\"2\" align=\"center\">\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <th>SNO</th>\n");
      out.write("                    <th>STATE</th>\n");
      out.write("                    <th>DISTRICT</th>\n");
      out.write("                    <th>PLACE</th> \n");
      out.write("                    <th>EDIT</th>\n");
      out.write("                    <th>DELETE</th>\n");
      out.write("                </tr>\n");
      out.write("            \n");
      out.write("        ");

            int i=1;
                String sele="select * from tbl_place p inner join tbl_dist d on p.dist_Id=d.dist_Id inner join tbl_state s on d.state_Id=s.states_Id";
                System.out.println(sele);
                ResultSet rsdis=obj.selectCommand(sele);
                while(rsdis.next())
                {
        
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(i);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rsdis.getString("states_Name"));
      out.write("</td> \n");
      out.write("                    <td>");
      out.print(rsdis.getString("dist_Name"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rsdis.getString("place_Name"));
      out.write("</td>\n");
      out.write("                    <td><a href=\"Place.jsp?eid=");
      out.print(rsdis.getString("place_Id"));
      out.write("\">EDIT</a></td>\n");
      out.write("                    <td><a href=\"Place.jsp?did=");
      out.print(rsdis.getString("place_Id"));
      out.write("\">DELETE</a></td>    \n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("        ");

            i++;
                }
        
      out.write("\n");
      out.write("        \n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
