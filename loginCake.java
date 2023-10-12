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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aishu
 */
public class loginCake extends HttpServlet {

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
            out.println("<title>Servlet loginCake</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginCake at " + request.getContextPath() + "</h1>");
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
String u=request.getParameter("user");
String p=request.getParameter("pass");
String button=request.getParameter("btn");
	

	

if(button.equals("REGISTER"))
{
     
        try
     {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/aishwarya","aishwarya","aishu123");
                RequestDispatcher rd=null;
         PreparedStatement ps=con.prepareStatement("insert into CakeProject values(?,?)");
        
         ps.setString(1,u);
         
         ps.setString(2,p);
         
         int r=ps.executeUpdate();
         if(r>=0)
         {
       
      request.getRequestDispatcher("loginCss.html").include(request, response);
out.println("<script>alert('YOU HAVE REGISTERED SUCCESFULLY...!!'); </script>");  
         }
        
     }
        
        
        catch(Exception e)
        {
               out.println(e);
        }  
        
     
}
else if(button.equals("LOGIN"))
{
   try
     {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/aishwarya","aishwarya","aishu123");
                RequestDispatcher rd=null;
                 PreparedStatement ps=con.prepareStatement("select * from CakeProject where username=? and password=? ");
          
                ps.setString(1,u);
                ps.setString(2,p);
                
                
                ResultSet r=ps.executeQuery();
                if(r.next())
                {
                      request.getRequestDispatcher("homeCss.html").include(request, response);
out.println("<script>alert('WELCOME TO CAKE WORLD ---> YOU HAVE SUCCESSFULLY LOGGED IN...!! '); </script>");
            
                }
    else
        {
               request.getRequestDispatcher("loginCss.html").include(request, response);
out.println("<script>alert('USER NAME OR PASSWORD IS INCORRECT . PLEASE REGISTER AND THEN LOGIN ...!'); </script>");
                }
               
}
  
  catch(Exception e)
        {
               out.println(e);
        }  
     
}}


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
