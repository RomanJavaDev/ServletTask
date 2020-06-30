
package com.myproject.servlet;

import com.myproject.dao.LaptopDao;
import com.myproject.pojo.Laptop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addlaptop")
public class AddLaptopServlet extends HttpServlet {

    private LaptopDao laptopDao;

    @Override
    public void init() throws ServletException {
        laptopDao = (LaptopDao) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("PageTitle", "New Laptops");
        req.setAttribute("PageBody", "form.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String productGroup = req.getParameter("productGroup");
        String price = req.getParameter("price");
        Laptop laptop = new Laptop(null, name, productGroup, Double.valueOf(price));
        laptopDao.addLaptop(laptop);

        resp.sendRedirect(req.getContextPath() + "/alllaptops");
    }
}