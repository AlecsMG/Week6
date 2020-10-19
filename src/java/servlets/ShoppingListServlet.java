/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
 * @author 831690
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").
                forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username;

        ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("itemList");

        if (itemList == null) {

            itemList = new ArrayList<>();
        }

        if (action == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").
                    forward(request, response);
        } else if (action.equals("register")) {

            username = request.getParameter("username");
            session.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").
                    forward(request, response);

        } else if (action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").
                    forward(request, response);

        } else if (action.equals("add")) {
            String item = request.getParameter("item");
            itemList.add(item);
            session.setAttribute("itemList", itemList);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").
                    forward(request, response);
        }
        
        else if (action.equals("delete")) {  
            int itemToDelete = Integer.parseInt(request.getParameter("item"));
            itemList.remove(itemToDelete);
            session.setAttribute("itemList", itemList);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").
                    forward(request, response);
        }
    }

}
