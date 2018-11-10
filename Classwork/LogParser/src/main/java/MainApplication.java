import java.io.File;
import java.sql.*;
import java.util.Scanner;

public class MainApplication {
    private static final String URL = "jdbc:postgresql://localhost:5432/logs";
    private static final String USER = "postgres";
    private static final String PASSWORD = "adminroot";

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Scanner scanner = new Scanner(new File("src/main/resources/access.log"));
        Statement statement = connection.createStatement();
        String line = scanner.nextLine();
        int q = 0;
        while (statement.executeQuery("SELECT ID FROM log").next()) {
            q++;
        }
        int i = q;
        while (scanner.hasNextLine()) {
            statement.execute((queryBuilder(line, i)));
            line = scanner.nextLine();
            i++;
        }
    }

    public static String queryBuilder(String line, int i) {
        String result = null;
        String[] items = line.split(" ");
        int k = 1;
        result = "INSERT INTO log (id, ip, date, query, path, protocol, ver_protocol, result, cookie, user_id) VALUES (" + i + ",'" + items[0] + "','" + items[3] + items[4] + "','" + items[5].substring(1) + "','" + items[6] + "','" + items[7] + "'," + items[8].substring(0, items[8].length() - 1) + "," + items[9] + "," + items[10] + "," + items[11].substring(2) + ")";
        return result;
    }
}
