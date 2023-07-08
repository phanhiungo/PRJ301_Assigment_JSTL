/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhddp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author moneymaker
 */
public class MainController extends HttpServlet {
    private final String LOGIN_PAGE = "login.html";
    private final String LOGIN_CONTROLLER = "LoginController";
    private final String SEARCH_CONTROLLER = "SearchController";
    private final String DELETE_CONTROLLER = "DeleteController";
    private final String UPDATE_CONTROLLER = "UpdateController";
    private final String CREATE_CONTROLLER = "CreateController";
    private final String ADD_CONTROLLER = "AddController";
    private final String REMOVE_CONTROLLER = "RemoveController";
    private final String EDIT_CONTROLLER = "EditController";
    private final String LOGOUT_CONTROLLER = "LogoutController";
    private final String CHECKOUT_CONTROLLER = "CheckoutController";
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
        String url = LOGIN_PAGE;
        try{
           String action = request.getParameter("action");
           if(action == null){
               url = LOGIN_PAGE;
           }
           else if(action.equals("Logout")){
               url = LOGOUT_CONTROLLER;
           }
           else if(action.equals("Login")){
               url = LOGIN_CONTROLLER;
           }
           else if(action.equals("Search")){
               url = SEARCH_CONTROLLER;
           }
           else if(action.equals("Delete")){
               url = DELETE_CONTROLLER;
           }
           else if(action.equals("Update")){
               url = UPDATE_CONTROLLER;
           }
           else if(action.equals("Create")){
               url = CREATE_CONTROLLER;
           }
           else if(action.equals("addCart")){
               url = ADD_CONTROLLER;
           }
           else if(action.equals("Remove")){
               url = REMOVE_CONTROLLER;
           }
           else if(action.equals("Edit")){
               url = EDIT_CONTROLLER;
           }
           else if(action.equals("Checkout")){
               url = CHECKOUT_CONTROLLER;
           }
        }
        catch(Exception e){
            log("Error at MainController: "+e.toString());
        }
        finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
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
