/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 
 */
public class into extends HttpServlet {

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
            String area=request.getParameter("ar").toLowerCase();
            String core=request.getParameter("cr").toLowerCase();
            String ram=request.getParameter("rm").toLowerCase();
            String storage=request.getParameter("str").toLowerCase();
            String cost=request.getParameter("cost").toLowerCase();
            String availability=request.getParameter("avail").toLowerCase();
            String bandwidth=request.getParameter("bw").toLowerCase();
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>DESICION</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center>IaaS That Satisfy Your Need</center></h1>");
            out.println("<center><table style='border:2px'>");
           // out.println("jiji");
            //out.println("<h1>Servlet into at " + request.getContextPath() + "</h1>");
           Connection con=db.createConnection();
            String querry="select * from manaks.cloud";
          PreparedStatement ps=con.prepareStatement(querry);
   //        out.println("jijhbnbg34i");
           ResultSet rs=ps.executeQuery();
     //       out.println("jijjbjjni");
           int counter =0; 
           while(rs.next())
            {
             if(area.equals(rs.getString("AREA")) && core.equals(rs.getString("CORE")) && ram.equals(rs.getString("RAM")) && storage.equals(rs.getString("STORAGE")) )   
             { 
                 if((Integer.parseInt(cost)>=Integer.parseInt(rs.getString("COST"))) && (Integer.parseInt(availability)<=Integer.parseInt(rs.getString("AVAIBILITY"))) && (Integer.parseInt(bandwidth)<=Integer.parseInt(rs.getString("BANDWIDTH"))))
                 {    out.println("<tr><td>"+rs.getString("AREA").toUpperCase(Locale.ENGLISH)+"</td><td>"+rs.getString("CORE")+"</td><td>"+rs.getString("RAM")+"</td><td>"+rs.getString("AVAIBILITY")+"</td><td>"+rs.getString("BANDWIDTH")+"</td><td>"+rs.getString("COST")+"</td><td>"+rs.getString("STORAGE")+"</td><td>"+rs.getString("COMPANY")+"</td></tr>");
              counter++;
                 }}
            }
           if(counter==0)
           {
               response.sendRedirect("error.html");
           }
            out.println("</table></center>");

            
            
            out.println("</body>");
            out.println("</html>");
        }
        catch(SQLException e)
        {
            System.out.println(e.getStackTrace());
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
        processRequest(request, response);
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
        processRequest(request, response);
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
