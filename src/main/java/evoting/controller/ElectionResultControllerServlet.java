/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.controller;

import evoting.dao.CandidateDAO;
import evoting.dao.VoteDAO;
import evoting.dto.CandidateDetails;
import evoting.dto.ElectionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.*;
import java.util.Set;
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
public class ElectionResultControllerServlet extends HttpServlet {

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
        RequestDispatcher rd = null;
        HttpSession session = request.getSession();
        String userID = (String)session.getAttribute("userID");
        String type = request.getParameter("type");
        if (userID == null){
            session.invalidate();
            response.sendRedirect("accessDenied.html");
            return;
        }
        try{
            if (type != null && type.equals("candidate")){
                Map <String, Integer> result = VoteDAO.getResult();
            Set s = result.entrySet();
            Iterator it = s.iterator();
            LinkedHashMap<CandidateDetails, Integer> resultDetails = new LinkedHashMap<>();
            while(it.hasNext()){
                Map.Entry<String,Integer> e = (Map.Entry)it.next();
                CandidateDetails cd = CandidateDAO.getDetailsById(e.getKey());
                resultDetails.put(cd, e.getValue());
            }
            
            request.setAttribute("votecount", VoteDAO.getVoteCount());
            request.setAttribute("result", resultDetails);
            request.setAttribute("resultType", "candidate");
            rd = request.getRequestDispatcher("electionResult.jsp");
            }
            else if (type != null && type.equals("party")){
                System.out.println("Iske Andar");
                Map<String,Integer> result = VoteDAO.getResultBasedOnParty();
                Set s = result.entrySet();
                Iterator it = s.iterator();
                LinkedHashMap<ElectionDTO , Integer> resultDetails = new LinkedHashMap<>();
                while(it.hasNext()){
                    Map.Entry<String, Integer> e = (Map.Entry)it.next();
                    String symbol = CandidateDAO.getSymbolByParty(e.getKey());
                    ElectionDTO er = new ElectionDTO(e.getKey(), symbol);
                    resultDetails.put(er, e.getValue());
                }
                System.out.println("Hello Party");
                request.setAttribute("votecount", VoteDAO.getVoteCount());
                
            request.setAttribute("result", resultDetails);
            request.setAttribute("resultType", "party");
            rd = request.getRequestDispatcher("electionResult.jsp");
            }
            
        }
        catch(Exception ex){
            ex.printStackTrace();
            request.setAttribute("Exception", ex);
            rd = request.getRequestDispatcher("showException.jsp");
        }
        finally{
            System.out.println("inside finally");
            rd.forward(request, response);
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
