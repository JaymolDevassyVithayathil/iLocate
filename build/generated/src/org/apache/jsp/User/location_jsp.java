package org.apache.jsp.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class location_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 align=\"center\">LOCATION DETAILS</h1>\n");
      out.write("        <form>\n");
      out.write("         \n");
      out.write("           <table align=\"center\" border=\"2\">\n");
      out.write("            <tr>\n");
      out.write("                <th>SNO</th>\n");
      out.write("                <th>LATITUDE</th>\n");
      out.write("                <th>LONGITUDE</th>\n");
      out.write("                <th>CITY</th>\n");
      out.write("                <th>DATE</th>\n");
      out.write("                <th>TIME </th>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("    ");

        String lid="",lat="",longi="",city="",date="",time="";
        int i=1;
        
            String sel="select * from tbl_location";

            System.out.println(sel);
            ResultSet rs=obj.selectCommand(sel);
            while(rs.next())
            {
                lid=rs.getString("loc_Id");
                lat=rs.getString("loc_Latitude");
                longi=rs.getString("loc_longitude");
                city=rs.getString("loc_City");
                date=rs.getString("loc_Date");
                time=rs.getString("loc_Time");
                
    
      out.write("\n");
      out.write("               <td>");
      out.print(lid);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(lat);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(longi);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(city);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(date);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(time);
      out.write("</td>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("    ");

                i++;
            }
    
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        </form>        \n");
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
