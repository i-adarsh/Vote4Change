/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.controller;

import evoting.dao.CandidateDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author adarshkumar
 */
public class AddCandidateControllerServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        if (userId == null){
            session.invalidate();
            response.sendRedirect("accessDenied.html");
        }
        String candidate = (String)request.getParameter("id");
        String usId = (String)request.getParameter("uid");
        if (candidate != null && candidate.equals("getid")){
            try{
                String id = CandidateDAO.getNewId();
                out.println(id);
                return;
            }
            catch(SQLException ex){
                RequestDispatcher rd = request.getRequestDispatcher("showException.jsp");
                request.setAttribute("Exception", ex);
                rd.forward(request, response);
            }
        }
        else if(usId != null){
            try{
                String userName = CandidateDAO.getUserNameById(usId);
                ArrayList<String> city = CandidateDAO.getCity();
                JSONObject json = new JSONObject();
                StringBuffer sb = new StringBuffer();
                for (String c : city){
                    sb.append("option value='"+c+"'>"+c+"</option>");
                }
                System.out.println(sb);
                if (userName == null)
                    userName = "wrong";
                json.put("username", userName);
                json.put("city", sb.toString());
                out.println(json);
            }
            catch(SQLException ex){
                RequestDispatcher rd = request.getRequestDispatcher("showException.jsp");
                request.setAttribute("Exception", ex);
                rd.forward(request, response);
            }
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
