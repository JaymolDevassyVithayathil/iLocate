package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class UserAccepted_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <h1 align=\"center\">USER ACCEPTED LIST</h1>\n");
      out.write("        ");

            if(request.getParameter("rid")!=null)
               {
                   String reject=request.getParameter("rid");
                   String acQry="update tbl_user_reg set user_Status='2' where user_Id="+reject;
                   boolean b= obj.executeCommand(acQry);
                   if(b==true)
                   {
                       //out.println("Rejected");
                   }
                   else
                   {
                       System.out.println(acQry);
                   }
               }
        
      out.write("\n");
      out.write("         <table align=\"center\" border=\"2\">\n");
      out.write("            <tr>\n");
      out.write("                <th>SNO</th>\n");
      out.write("                <th>FIRST NAME</th>\n");
      out.write("                <th>LAST NAME</th>\n");
      out.write("                <th>DATE OF BIRTH</th>\n");
      out.write("                <th>GENDER </th>\n");
      out.write("                <th>CONTACT</th>\n");
      out.write("                <th>EMAIL</th>\n");
      out.write("                <th>HOUSE NAME</th>\n");
      out.write("                <th>PLACE</th>\n");
      out.write("                <th>DISTRICT</th>\n");
      out.write("                <th>STATE</th>\n");
      out.write("                <th>STATUS</th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("               ");

        String uid="",fname="",lname="",dob="",gender,contact="",email="",username,hname="",place="",state="",district="";
        
        int i=1;
        
            String sel="select * from tbl_user_reg c inner join tbl_state s inner join tbl_dist d inner join tbl_place p on c.user_Place=p.place_Name and p.dist_Id=d.dist_Id and d.state_Id=s.states_Id  where user_Status='1'";
            System.out.println(sel);
            ResultSet rs=obj.selectCommand(sel);
            
            while(rs.next())
            {
                uid=rs.getString("user_Id");
                fname=rs.getString("user_Fname");
                lname=rs.getString("user_Lname");
                dob=rs.getString("user_Dob");
                gender=rs.getString("user_Gender");
                contact=rs.getString("user_Contact");
                email=rs.getString("user_Email");
                username=rs.getString("user_Username");
                hname=rs.getString("user_Hname");
                place=rs.getString("user_Place");
                district=rs.getString("dist_Name");
                state=rs.getString("states_Name");
    
      out.write("\n");
      out.write("                <td>");
      out.print(uid);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(fname);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(lname);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(dob);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gender);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(contact);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(email);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(username);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(hname);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(place);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(district);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(state);
      out.write("</td>\n");
      out.write("                <td><a href=\"UserAccepted.jsp?rid=");
      out.print(uid);
      out.write("\">REJECT </a></td></tr>\n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("    ");

                 i++;
            }
    
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>     \n");
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
