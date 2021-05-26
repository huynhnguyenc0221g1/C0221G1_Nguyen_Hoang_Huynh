package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value="/display-discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("product_description");
        Double listPrice = Double.parseDouble(request.getParameter("list_price"));
        Double discountPercent = Double.parseDouble(request.getParameter("discount_percent"));
        Double discountAmount = listPrice * discountPercent * 0.01;
        Double discountPrice = listPrice - discountAmount;
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Product Description: " + productDescription);
        printWriter.println("List Price: " + listPrice);
        printWriter.println("Discount Percent: " + discountPercent + "%");
        printWriter.println("Discount Amounnt: " + discountAmount);
        printWriter.println("Discount Price: " + discountPrice);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
