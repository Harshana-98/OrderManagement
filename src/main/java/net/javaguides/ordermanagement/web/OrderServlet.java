//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.javaguides.ordermanagement.web;

import lombok.SneakyThrows;
import net.javaguides.ordermanagement.dao.ItemDAO;
import net.javaguides.ordermanagement.dao.OrderDAO;
import net.javaguides.ordermanagement.model.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/"})
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.doGet(request, response);
    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        switch (action) {
            case "/":
                this.showOrderForm(request, response);
                break;
            case "/create":
                this.insertOrder(request, response);
                break;
            case "/list":
                this.listOrder(request, response);
                break;
            case "/list_update":
                this.updateOrder(request, response);
                break;
            case "/list_delete":
                this.deleteOrder(request, response);
                break;
        }
    }

    private void showOrderForm(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Order.jsp");
        request.setAttribute("items", ItemDAO.getItemDao().selectAllItems());
        dispatcher.forward(request, response);
    }

    private void insertOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            OrderDAO.getOrderDAO().insertOrder(new Order(
                    request.getParameter("itemName"),
                    Double.parseDouble(request.getParameter("price")),
                    Integer.parseInt(request.getParameter("qty")),
                    Double.parseDouble(request.getParameter("subTotal")),
                    Double.parseDouble(request.getParameter("grandTotal"))));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        response.sendRedirect("list");
    }

    private void listOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Order> listOrder = null;
        try {
            listOrder = OrderDAO.getOrderDAO().selectAllOrder();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        request.setAttribute("listOrder", listOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Orderview.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Order.jsp");
        dispatcher.forward(request, response);
    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String itemName = request.getParameter("itemName");
        Double price = Double.valueOf(request.getParameter("price"));
        int qty = Integer.parseInt(request.getParameter("qty"));
        Double subTotal = Double.valueOf(request.getParameter("subTotal"));
        Double grandTotal = Double.valueOf(request.getParameter("grandTotal"));
        Order book = new Order(id, itemName, price, qty, subTotal, grandTotal);
        try {
            OrderDAO.getOrderDAO().updateOrder(book);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        response.sendRedirect("list_update");
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            OrderDAO.getOrderDAO().deleteOrder(id);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        response.sendRedirect("list_delete");
    }

}
