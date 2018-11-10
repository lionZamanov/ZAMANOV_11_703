package App;

import Models.User;
import Repository.BooksRepositoryImpl;
import Repository.UsersRepository;
import Repository.UsersRepositoryImpl;
import Service.BooksService;
import Service.BooksServiceImpl;
import Service.UsersService;
import Service.UsersServiceImpl;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.Scanner;

public class App {
    private static final String URL = "jdbc:postgresql://localhost:5432/BookTrader";
    private static final String USER = "postgres";
    private static final String PASSWORD = "adminroot";

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        UsersRepository usersRepository = new UsersRepositoryImpl(connection);
        UsersService usersService = new UsersServiceImpl(usersRepository);
        login(usersService);
    }

    private static void login(UsersService usersService) {
        Scanner scanner = new Scanner(System.in);
        String k;
        do {
            System.out.println("1.) Войти");
            System.out.println("2.) Зарегистрироваться");
            k = scanner.nextLine();
        } while (!k.equals("1") && !k.equals("2"));
        if (k.equals("1")) {
            comeIn(usersService);
        } else if (k.equals("2")) {
            toRegister(usersService);
        }
    }

    private static void toRegister(UsersService usersService) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Почта: ");
        String email = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();
        System.out.print("Имя: ");
        String name = scanner.nextLine();
        System.out.print("Фамилия: ");
        String lastName = scanner.nextLine();
        System.out.print("Адрес: ");
        String address = scanner.nextLine();
        User newUser = User.builder()
                .rawPassword(password)
                .address(address)
                .email(email)
                .firstName(name)
                .lastName(lastName)
                .build();
        usersService.register(newUser);
        profile(newUser);
    }

    private static void comeIn(UsersService usersService) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Почта: ");
        String email = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();
        if(usersService.isRegistered(User.builder().email(email).rawPassword(password).build())){
            profile(usersService.userBuilder(email, password));
        }else {
            System.out.println("Неверный логин или пароль, попробуйте еще раз");
        }
    }

    @SneakyThrows
    private static void profile(User user) {
        System.out.println("1.) Мои книги");
        System.out.println("2.) Мои обмены");
        System.out.println("3.) Мои успешные обмены");
        System.out.println("4.) Создать новый обмен");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        switch (string){
            case "1":
                System.out.println(user.getMyBooks());
            case "2":
                System.out.println(user.getMyTrades());
            case "3":
                System.out.println(user.getSuccessfulTrades());
            case "4":

        }
    }

}
