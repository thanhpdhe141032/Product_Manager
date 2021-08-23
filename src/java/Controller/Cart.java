/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.dao;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thanh Dang
 */
public class Cart extends HttpServlet {

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

        int productId = Integer.parseInt(request.getParameter("productId"));
        System.out.println("----------------------"+productId);
        
        dao d = new dao();
        ArrayList<Product> listSessionProduct = new ArrayList<>();
        ArrayList<Product> listAllProduct = new ArrayList<>();
        listAllProduct = d.getAllProduct();
        listSessionProduct = d.getProductById(productId);
        
        HttpSession session = request.getSession();
        
        if (session.getAttribute("Cart") == null){
            session.setAttribute("Cart", d.getProductById(productId));
        } 
        else {
            listSessionProduct = (ArrayList<Product>) session.getAttribute("Cart");
            boolean check = false;
            for (Product p : listSessionProduct) {
                if (productId == p.getProductId()) {
                    p.setQuantity(p.getQuantity() + 1);
                    check = true;                    
                }
            }
            if (check == false) {
                for (Product p : listAllProduct) {
                    if (productId == p.getProductId()) {
                        listSessionProduct.add(p);
                        session.setAttribute("Cart", listSessionProduct);
                    }
                }
            }
        }
        request.getRequestDispatcher("listCart").forward(request, response);
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
