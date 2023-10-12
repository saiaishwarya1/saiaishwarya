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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aishu
 */
public class contactUs extends HttpServlet {

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
            out.println("<title>Servlet contactUs</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet contactUs at " + request.getContextPath() + "</h1>");
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
String name=request.getParameter("name");
String mail=request.getParameter("mail");
String feedback=request.getParameter("feedback");
String send=request.getParameter("send");


if(send.equals("SEND"))
{
     
        try
     {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/aishwarya","aishwarya","aishu123");
                RequestDispatcher rd=null;
         PreparedStatement ps=con.prepareStatement("insert into contactProject values(?,?,?)");
        
         ps.setString(1,name);
         
         ps.setString(2,mail);
         ps.setString(3,feedback);
         
         int r=ps.executeUpdate();
         if(r>=0)
         {
        out.println("<script>alert('RECORD INSERTED SUCCESFULLY...!!'); </script>");  
       }
         

     }
        
         catch(Exception e)
        {
               out.println(e);
        }  
       
}
        
else if(send.equals("VIEW"))
      try{

                    
                   Class.forName("org.apache.derby.jdbc.ClientDriver");
                
                  Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/aishwarya", "aishwarya","aishu123");
                 
                  // prepared statement 
                  
                  PreparedStatement ps = con.prepareStatement("Insert into contactProject values (?,?,?)");
                  //display the details
                  Statement stmt = con.createStatement();

                      String query = "select * from contactProject";
 ResultSet rs = stmt.executeQuery(query);
              System.out.println("DISPLAYING THE DETAILS ....!!!! \n");

                      while (rs.next()) {
        String n = rs.getString("name");
        String c= rs.getString("mail");
        String cv= rs.getString("feedback");
                    
 out.println(" <h1 align=\"center\"> DISPLAYING THE CONTACT FORM DETAILS</h1>" );
out.println("<table border=1 align=center background-color=blue >\n" +
"<tr>\n" +
" <th>NAME</th> <th>MAIL ID </th> <th>FEEDBACK</th>  </tr>\n" +
"<tr>\n" +
" <td>" + rs.getString(1) + "</td>\n" +
" <td>" + rs.getString(2) + "</td>\n" +
"<td>" +rs.getString(3) +"</td></tr>\n");
out.println("</table>");
                  
}         }
            
           catch (Exception e2)
              {

                   out.print(e2);
                }
  
    
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
