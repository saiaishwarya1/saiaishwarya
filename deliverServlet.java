/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aishu
 */
public class deliverServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet deliverServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet deliverServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
          RequestDispatcher rd; 
      request.getRequestDispatcher("address.html").include(request, response);
      
   String name=request.getParameter("name");
      String mobile=request.getParameter("mobile");
String code=request.getParameter("code");

out.println("<br><br>");

out.println(" <h1 align=center><font color=\"red\">DELIVERY DETAILS ARE</font>  "+" </h1> <br><br>" );
out.println("<table border=1 align=\"center\" background-color=blue >\n" +
"<tr>\n" +
" <th>NAME</th> <th>MOBILE NUMBER</th> <th>POSTAL CODE</th></tr>\n" +
"<tr>\n" );

out.println(" <td>" + name+ "</td>\n" +
" <td>" + mobile+ "</td>\n"+
  
"<td>" + code +"</td></tr>\n");
out.println("</table>");

out.println("<br><br>");

out.println("<br><br>");

out.println("<form action=\"pay.html\" method=\"POST\">\n" +
"     <P>\n" +
"<input type=\"submit\" value=\"NEXT\" style=\"width:250px;height:70px;margin-RIGHT:5px;\" >\n" +
"    </form>\n" +
"</p>\n" +
"");

          
          
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
