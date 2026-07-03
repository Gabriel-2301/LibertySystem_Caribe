package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/liberty_caribe";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error conexion: " + e);
            return null;
        }
    }

    public static boolean probarConexion() { //prueba de conexión
        try (Connection con = conectar()) {
            return con != null && !con.isClosed();
        } catch (Exception e) {
            return false;
        }
    }
}
