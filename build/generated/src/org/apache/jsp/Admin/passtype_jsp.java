package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class passtype_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      db.ConnectionClass con = null;
      synchronized (_jspx_page_context) {
        con = (db.ConnectionClass) _jspx_page_context.getAttribute("con", PageContext.PAGE_SCOPE);
        if (con == null){
          con = new db.ConnectionClass();
          _jspx_page_context.setAttribute("con", con, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>passwordtype Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
                    
      
      out.write("   \n");
      out.write("        <form name=\"pwdtypeform\">\n");
      out.write("            <table align=\"center\" border=\"1\" >\n");
      out.write("                <tr>\n");
      out.write("                    <th colspan=\"2\" align=\"center\"><h1>TYPE OF PASSWORD</h1></th>\n");
      out.write("                </tr>    \n");
      out.write("                <tr>\n");
      out.write("                    <th>Type</th>\n");
      out.write("                    <td><input type=\"hidden\" name=\"tid\" value=\"");
      out.print(type_id);
      out.write("\">    \n");
      out.write("                       <input type=\"text\" name=\"txttypepwd\" value=\"");
      out.print(typename);
      out.write("\" required=\"\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"submit\" name=\"btnsubmit\" value=\"SUBMIT\"></td>\n");
      out.write("                    <td><input type=\"reset\" name=\"btncancel\" value=\"CANCEL\"></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <br><br>  <br><br>  <br><br>  <br><br>\n");
      out.write("            <table align=\"center\" border=\"2\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>SL NO.</td>\n");
      out.write("                    <td>Password Type</td>\n");
      out.write("                    <td>Edit</td>\n");
      out.write("                    <td>Delete</td>\n");
      out.write("                </tr> \n");
      out.write("                ");

                    int i=1;
                    String se="select * from tbl_type";
                    ResultSet rsl=con.selectCommand(se);
                    while(rsl.next())
                    {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td> ");
      out.print(i);
      out.write("</td>\n");
      out.write("                    <td> ");
      out.print(rsl.getString("type_Name"));
      out.write(" </td>\n");
      out.write("                    <td><a href=\"passtype.jsp?eid=");
      out.print(rsl.getString("type_Id"));
      out.write("\">EDIT </a></td>\n");
      out.write("                    <td><a href=\"passtype.jsp?did=");
      out.print(rsl.getString("type_Id"));
      out.write("\">DELETE </a></td>\n");
      out.write("                \n");
      out.write("                </tr>\n");
      out.write("            \n");
      out.write("                ");
 
                    i++ ;
                    }
                
      out.write("\n");
      out.write("            \n");
      out.write("            </table>    \n");
      out.write("        </form>\n");
      out.write("        \n");
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
