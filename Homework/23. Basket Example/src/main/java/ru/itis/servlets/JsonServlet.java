package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Basket;
import ru.itis.repositories.*;
import ru.itis.services.UsersService;
import ru.itis.services.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products.json")
public class JsonServlet extends HttpServlet {

    private UsersService usersService;
    private UsersRepository usersRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("adminroot");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/shop");
        usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        usersService = new UsersServiceImpl(usersRepository, authRepository);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     /*   User user = usersService.getUserById(Long.parseLong(request.getParameter("userId")));
        if (user != null) {
            Basket allProducts = user.getBasket();
            String json = objectMapper.writeValueAsString(allProducts);
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().write(json);
        }*/
        Cookie authCookie = authCookie(request.getCookies());
        if(authCookie != null){
            Basket basket = usersRepository.findByCookie(authCookie.getValue()).getBasket();
            String json = objectMapper.writeValueAsString(basket.getProducts());
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().write(json);
        }
    }

    private Cookie authCookie(Cookie[] cookies){
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
