/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.controller;

import evoting.dao.UserDAO;
import evoting.dto.UserDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adarshkumar
 */
public class ShowUserDetailsServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = null;
        HttpSession sess = request.getSession();
        String userid = (String)sess.getAttribute("userID");
        if(userid == null)
        {
            sess.invalidate();
            response.sendRedirect("accessDenied.html");
            return;
        }
        
        try{
            
            StringBuffer displayBlock = new StringBuffer();
            displayBlock.append("<h3>User Details</h3><br /><table border='2'><tr><th>User Id</th><th>Username</th><th>Address</th><th>City</th><th>Email</th><th>Mobile No</th><td>");
            List<UserDetails> userDetails = UserDAO.getUserDetails();
            for(int i=0; i < userDetails.size(); i++){
                UserDetails ud = userDetails.get(i);
                displayBlock.append("<tr><td>"+ud.getUserID()+"</td><td>"+ud.getUserName()+"</td><td>"+ud.getAddress()+"</td><td>"+ud.getCity()+"</td><td>"+ud.getEmail()+"</td><td>"+ud.getMobile()+"</td></tr>");
            }
            displayBlock.append("</table>");
            out.println(displayBlock.toString());
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
                rd = request.getRequestDispatcher("showexception.jsp");
                request.setAttribute("Exception", ex);
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
