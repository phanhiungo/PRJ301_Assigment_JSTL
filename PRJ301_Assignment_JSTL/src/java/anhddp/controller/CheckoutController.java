package anhddp.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.shopping.ProductDAO;
import sample.shopping.Cart;
import sample.shopping.Tea;

@WebServlet(name = "CheckoutController", urlPatterns = {"/CheckoutController"})
public class CheckoutController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Retrieve the customer's full name from the request parameters
        String customerFullName = request.getParameter("customerFullName");

        // Retrieve the cart from the session
        Cart cart = (Cart) request.getSession().getAttribute("CART");

        // Create an instance of the ProductDAO
        ProductDAO productDAO = new ProductDAO();

        // Iterate over the items in the cart and save the checkout information for each item
        for (Tea tea : cart.getCart().values()) {
            String itemID = tea.getId();
            String itemName = tea.getName();
            int quantity = tea.getQuantity();
            double totalPrice = tea.getPrice() * tea.getQuantity();

            try {
                // Call the ProductDAO to save the checkout information to the database
                productDAO.saveCheckoutInfo(customerFullName, itemID, itemName, quantity, totalPrice);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
                // Handle the exception or log the error
            }
        }

        // Clear the cart
        cart.clear();

        // Redirect to a confirmation page or perform any other necessary actions
        response.sendRedirect("confirmation.jsp"); // Replace with the appropriate confirmation page
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
