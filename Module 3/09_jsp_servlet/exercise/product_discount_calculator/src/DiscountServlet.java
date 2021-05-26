import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet",urlPatterns = "/calculator")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String productDescription = request.getParameter("product_description");
        double listPrice = Double.parseDouble(request.getParameter("list_price"));
        double discountPercent = Double.parseDouble(request.getParameter("discount_percent"));

        double discountAmount = listPrice * discountPercent * 0.01 ;

        double discountPrice = listPrice - discountAmount;
        request.setAttribute("productDescription1",productDescription);
        request.setAttribute("discountAmount1",discountAmount);
        request.setAttribute("discountPrice1",discountPrice);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/display-discount.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
