package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Basket;
import ru.itis.models.Product;
import ru.itis.models.User;
import ru.itis.repositories.*;
import ru.itis.services.ProductService;
import ru.itis.services.ProductsServiceImpl;
import ru.itis.services.UsersService;
import ru.itis.services.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 25.10.2018
 * ShopServlet
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

    private ProductService productService;
    private UsersService usersService;
    private UsersRepository usersRepository;
    private ProductRepository productRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("adminroot");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/shop");
        productRepository = new ProductRepositoryImpl(dataSource);
        usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        productService = new ProductsServiceImpl(productRepository);
        usersService = new UsersServiceImpl(usersRepository, authRepository);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> allProducts = productRepository.findAll();
        Cookie authCookie = authCookie(request.getCookies());
        /*if(authCookie != null){
            Basket basket = usersRepository.findByCookie(authCookie.getValue()).getBasket();
            request.setAttribute("userProducts", basket.getProducts());
        }*/
        request.setAttribute("products", allProducts);
        request.getRequestDispatcher("jsp/shop.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie authCookie = authCookie(req.getCookies());
        if (authCookie != null) {
            User user = usersRepository.findByCookie(authCookie.getValue());
            Product product = productRepository.find(Long.parseLong(req.getParameter("id")));
            usersService.addProduct(user, product);
        }
    }

    private Cookie authCookie(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("auth")) {
                    if (usersService.isExistByCookie(cookie.getValue())) {
                        return cookie;
                    }
                }
            }
        }
        return null;
    }
}
