import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryMain {
    private static final String URL = "jdbc:postgresql://localhost:5432/logs";
    private static final String USER = "postgres";
    private static final String PASSWORD = "adminroot";

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet monthResult = statement.executeQuery("SELECT * FROM log WHERE date BETWEEN '20150301' AND '20150401'");

        //Сколько посетителей было на сайте за месяц?
        int visitsCounter = 0;
        monthResult.next();
        while (monthResult.next()) {
            visitsCounter++;
        }
        System.out.println("Количество заходов за месяц:" + visitsCounter);

        //Сколько в среднем посетителей бывает за час?
        double result = 0;
        for (int dayCounter = 1; dayCounter <= 31; ++dayCounter) {
            for (int hourCounter = 0; hourCounter < 23; ++hourCounter) {
                String query;
                if (dayCounter < 10) {
                    //query = "SELECT *FROM log WHERE date = '2015030" + dayCounter + "' AND DATEPART(hh,date) >= " + hourCounter + " AND DATEPART(hh, date) <= " + hourCounter + 1;
                    query = "SELECT *FROM log WHERE date BETWEEN '2015030" + dayCounter +" " + hourCounter + ":00:000' AND '2015030" + dayCounter + " " + (hourCounter + 1) + ":00:000'";
                } else {
                    query = "SELECT *FROM log WHERE date BETWEEN '201503" + dayCounter + " " + hourCounter + ":00:000' AND '201503" + dayCounter + " " + (hourCounter + 1) + ":00:000'";
                }

                //if(hourCounter < 10){
                ResultSet perHour = statement.executeQuery(query);
                int visitsPerHour = 0;
                perHour.next();
                while (perHour.next()) {
                    visitsPerHour++;
                }
                result += (double)visitsPerHour / (31 * 24);
            }
        }

        System.out.println("Среднее количество посетителей за час: " + result);

        //Сколько посетителей сделало заказы?
        ResultSet allOrders = statement.executeQuery("SELECT * FROM log WHERE path LIKE '/addbasket.phtml?id_book=%'");
        int allOrdersCounter = 0;
        allOrders.next();
        while (allOrders.next()) {
            allOrdersCounter++;
        }
        System.out.println("Посетителей сделало заказы:" + allOrdersCounter);

    }
}
