package controller;

import model.bean.Category;
import model.bean.Product;
import model.service.IProductService;
import model.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
    private IProductService productService;
    private List<Category> categoryList;
    @Override
    public void init() throws ServletException {
        productService = new ProductServiceImpl();
        categoryList = productService.selectAllCategories();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request,response);
                break;
            case "edit":
                editProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteFrom(request,response);
                break;
            case "search":
                findByName(request,response);
                break;
            default:
                listProduct(request,response);
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        int count = 0;
        List<Product> productList = productService.selectAllProduct();
        for (Product product : productList) {
            if (id == product.getId()) {
                count++;
            }
        }
        if (count!=0) {
            request.setAttribute("message_error", "ID is not available!! The creation is not successful!");
        } else {
            Product newProduct = new Product(id, name, price, quantity, color, description, categoryId);
            productService.insertProduct(newProduct);
            request.setAttribute("message", "Successfully Created!");
        }
        request.setAttribute("categories",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/create-product.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/create-product.jsp");
        request.setAttribute("categories",categoryList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        Product product = new Product(id,name,price,quantity,color,description,categoryId);
        boolean check = productService.updateProduct(product);
        if (check) {
            request.setAttribute("message","Successfully Edited The Product!");
        } else {
            request.setAttribute("message","Not Successful");
        }
        List<Product> productList = productService.selectAllProduct();
        request.setAttribute("product",product);
        request.setAttribute("products",productList);
        request.setAttribute("categories",categoryList);
        request.setAttribute("id",id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/edit-product.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> productList = productService.selectAllProduct();
        Product product = productService.selectProduct(id);
        request.setAttribute("products",productList);
        request.setAttribute("categories",categoryList);
        request.setAttribute("id",id);
        RequestDispatcher requestDispatcher;
        if (product == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/view/product/edit-product.jsp");
            request.setAttribute("product",product);
            request.setAttribute("categories",categoryList);
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteFrom(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product deletedProduct = productService.selectProduct(id);
        RequestDispatcher requestDispatcher;
        if (deletedProduct == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/view/product/list-product.jsp");
            request.setAttribute("deleted_product",deletedProduct);
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Product> productList = productService.findByName(search);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/list-product.jsp");
        request.setAttribute("products",productList);
        request.setAttribute("categories",categoryList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.selectAllProduct();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/product/list-product.jsp");
        request.setAttribute("products",productList);
        request.setAttribute("categories",categoryList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

