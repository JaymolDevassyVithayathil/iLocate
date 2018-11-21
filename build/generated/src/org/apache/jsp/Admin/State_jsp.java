package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class State_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      db.ConnectionClass obj = null;
      synchronized (_jspx_page_context) {
        obj = (db.ConnectionClass) _jspx_page_context.getAttribute("obj", PageContext.PAGE_SCOPE);
        if (obj == null){
          obj = new db.ConnectionClass();
          _jspx_page_context.setAttribute("obj", obj, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 
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
                    
        
      out.write("\n");
      out.write("        <form>\n");
      out.write("            <h1 align=\"center\">STATE</h1>\n");
      out.write("            <table border=\"2\" align=\"center\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>STATE</th>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"hidden\" name=\"hid\" value=\"");
      out.print(state_id);
      out.write("\">\n");
      out.write("                        <input type=\"text\" name=\"statename\" value=\"");
      out.print(stname);
      out.write("\" required=\"\" >\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" align=\"center\">\n");
      out.write("                        <input type=\"submit\" name=\"statesubmit\" value=\"ADD\">\n");
      out.write("                        <input type=\"reset\" name=\"statereset\" value=\"CANCEL\">\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        \n");
      out.write("        <br>\n");
      out.write("        \n");
      out.write("            <table align=\"center\" border=\"2\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>ID</th>\n");
      out.write("                    <th>STATE</th>\n");
      out.write("                    <th>EDIT</th>\n");
      out.write("                    <th>DELETE</th>\n");
      out.write("                </tr>\n");
      out.write("        ");

                    int i=1;
                    String se="select * from tbl_state";
                    ResultSet rsl=obj.selectCommand(se);
                    while(rsl.next())
                    {
        
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td> ");
      out.print(i);
      out.write("</td>\n");
      out.write("                    <td> ");
      out.print(rsl.getString("states_Name"));
      out.write(" </td>\n");
      out.write("                    <td><a href=\"State.jsp?eid=");
      out.print(rsl.getString("states_Id"));
      out.write("\">EDIT </a></td>\n");
      out.write("                    <td><a href=\"State.jsp?did=");
      out.print(rsl.getString("states_Id"));
      out.write("\">DELETE </a></td>\n");
      out.write("                \n");
      out.write("                </tr>\n");
      out.write("            \n");
      out.write("        ");
 
                    i++ ;
                    }
        
      out.write("\n");
      out.write("            \n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("    </body>\n");
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
