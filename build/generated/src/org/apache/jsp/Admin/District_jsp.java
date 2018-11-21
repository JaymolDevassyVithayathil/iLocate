package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class District_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');
      out.write(' ');
      db.ConnectionClass obj = null;
      synchronized (_jspx_page_context) {
        obj = (db.ConnectionClass) _jspx_page_context.getAttribute("obj", PageContext.PAGE_SCOPE);
        if (obj == null){
          obj = new db.ConnectionClass();
          _jspx_page_context.setAttribute("obj", obj, PageContext.PAGE_SCOPE);
        }
      }
      out.write("   \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");

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
            
            
            
      out.write("\n");
      out.write("   \n");
      out.write("        <form>\n");
      out.write("            \n");
      out.write("        <h1 align=\"center\">DISTRICT</h1>\n");
      out.write("        <table border=\"2\" align=\"center\">\n");
      out.write("                    <input type=\"hidden\" name=\"hid\" value=\"");
      out.print(id);
      out.write("\">\n");
      out.write("            <tr>\n");
      out.write("                <th>STATE NAME</th>\n");
      out.write("                <td><select name=\"sel_state\">\n");
      out.write("             ");

                 String stateid="",statename="";
                        
                        String in="select * from tbl_state";
                        ResultSet rs1=obj.selectCommand(in);
                        while(rs1.next())
                        {
                            stateid=rs1.getString("states_Id");
                            statename=rs1.getString("states_Name");
                            
             
      out.write("\n");
      out.write("                        <option");
if (stateid.equals(state_id)){
      out.write(" selected=\"\"");
}
      out.write(" value=\"");
      out.print(stateid);
      out.write('"');
      out.write('>');
      out.print(statename);
      out.write("</option>\n");
      out.write("             ");
       
                        }
             
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                \n");
      out.write("  \n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>DISTRICT</th>\n");
      out.write("                <td><input type=\"text\" name=\"txtdistrict\" value=\"");
      out.print(district_name);
      out.write("\"></td>\n");
      out.write("                    \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"2\" align=\"center\">\n");
      out.write("                    <input type=\"submit\" name=\"btnsubmit\" value=\"ADD\">\n");
      out.write("                    <input type=\"reset\" name=\"txtreset\" value=\"CANCEL\">\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("                <br>\n");
      out.write("                \n");
      out.write("        <table border=\"2\" align=\"center\">\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <th>SNO</th>\n");
      out.write("                <th>DISTRICT</th>\n");
      out.write("                <th>STATE</th>\n");
      out.write("                <th>EDIT</th>\n");
      out.write("                <th>DELETE</th>         \n");
      out.write("                        \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                \n");
      out.write("        ");

                int i=1;
                    String sel="select * from tbl_state s inner join tbl_dist d on s.states_Id=d.state_Id";
                    ResultSet rsdis=obj.selectCommand(sel);
                    while(rsdis.next())
                    {
        
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(i);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rsdis.getString("dist_Name"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rsdis.getString("states_Name"));
      out.write("</td>\n");
      out.write("                <td><a href=\"District.jsp?eid=");
      out.print(rsdis.getString("dist_Id"));
      out.write("\">EDIT</a></td>\n");
      out.write("                <td><a href=\"District.jsp?did=");
      out.print(rsdis.getString("dist_Id"));
      out.write("\">DELETE</a></td> \n");
      out.write("            </tr>            \n");
      out.write("\n");
      out.write("         ");

                 i++;
                    }
         
      out.write("                       \n");
      out.write("                                           \n");
      out.write("                            \n");
      out.write("        \n");
      out.write("        </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write(" </html>");
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
