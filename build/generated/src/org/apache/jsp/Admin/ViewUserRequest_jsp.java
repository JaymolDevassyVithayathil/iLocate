package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class ViewUserRequest_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      db.ConnectionClass obj = null;
      synchronized (_jspx_page_context) {
        obj = (db.ConnectionClass) _jspx_page_context.getAttribute("obj", PageContext.PAGE_SCOPE);
        if (obj == null){
          obj = new db.ConnectionClass();
          _jspx_page_context.setAttribute("obj", obj, PageContext.PAGE_SCOPE);
        }
      }
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <table border=\"1\" align=\"center\">\n");
      out.write("           <h1 align=\"center\">USER DETAILS</h1><br>\n");
      out.write("                <tr>\n");
      out.write("                    <td>SL.NO</td>\n");
      out.write("                    <td>FIRSTNAME</td>\n");
      out.write("                    <td>LAST NAME</td>\n");
      out.write("                    <td>GENDER</td>\n");
      out.write("                    <td>DATE OF BIRTH</td>\n");
      out.write("                    <td>CONTACT</td>\n");
      out.write("                    <td>E-MAIL</td>\n");
      out.write("                    <td>HOUSE NAME</td> \n");
      out.write("                    <td>PLACE</td>  \n");
      out.write("                    <td>DISTRICT</td>\n");
      out.write("                    <td>STATE</td>\n");
      out.write("                    <td>ACCEPT</td>\n");
      out.write("                    <td>REJECT</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    String uid="",fname="",lname="",dob="",gender,contact="",email="",hname="",place="",state="",district="";
        
                   String st="select * from tbl_user_reg c inner join tbl_place p on c.user_Place=p.place_Name inner join tbl_dist d on p.dist_Id=d.dist_Id inner join tbl_state s on d.state_Id=s.states_Id";    
                   ResultSet rs=obj.selectCommand(st);//import
                   while(rs.next())
                   {
                        uid=rs.getString("user_Id");
                        fname=rs.getString("user_Fname");
                        lname=rs.getString("user_Lname");
                        dob=rs.getString("user_Dob");
                        gender=rs.getString("user_Gender");
                        contact=rs.getString("user_Contact");
                        email=rs.getString("user_Email");
                        hname=rs.getString("user_Hname");
                        place=rs.getString("user_Place");
                        district=rs.getString("dist_Name");
                        state=rs.getString("states_Name");
                      
                       if(request.getParameter("acceptid")!=null)
                       {
                           String up="update tbl_user_reg set user_Status='1' where user_Id='"+request.getParameter("acceptid")+"'";
                           if(obj.executeCommand(up))
                           {
                               //out.println("ACCEPTED");
                           }
                           else
                           {
                               out.println(up);
                           }
      
                           
                       }
                         if(request.getParameter("rejectid")!=null)
                       {
                           String up="update tbl_user_reg set user_Status='2' where user_Id='"+request.getParameter("rejectid")+"'";
                           if(obj.executeCommand(up))
                           {
                               //out.println("REJECTED");
                           }
                           else
                           {
                               out.println(up);
                           }
      
                           
                       }
                              
                       
                       
      out.write("\n");
      out.write("                       <tr> \n");
      out.write("                           <td> ");
      out.print(uid);
      out.write("</td>\n");
      out.write("                           <td>");
      out.print(fname);
      out.write(" </td>\n");
      out.write("                           <td>");
      out.print(lname);
      out.write("</td>\n");
      out.write("                           <td>");
      out.print(gender);
      out.write("</td>\n");
      out.write("                           <td>");
      out.print(dob);
      out.write("</td>\n");
      out.write("                           <td>");
      out.print(contact);
      out.write("</td>\n");
      out.write("                           <td>");
      out.print(email);
      out.write("</td>\n");
      out.write("                           <td>");
      out.print(hname);
      out.write("</td>\n");
      out.write("                           <td>");
      out.print(place);
      out.write("</td>\n");
      out.write("                           <td>");
      out.print(district);
      out.write("</td>\n");
      out.write("                           <td>");
      out.print(state);
      out.write("</td>   \n");
      out.write("                        \n");
      out.write("                          <td> <a href=\"ViewUserRequest.jsp?acceptid=");
      out.print(uid);
      out.write("\">ACCEPT</a></td>\n");
      out.write("                          <td><a href=\"ViewUserRequest.jsp?rejectid=");
      out.print(uid);
      out.write("\">REJECT</a></td></tr>\n");
      out.write("                       \n");
      out.write("                       ");

                       
                    }
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("       </body>\n");
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
