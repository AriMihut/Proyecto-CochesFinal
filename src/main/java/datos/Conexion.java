package datos;
    
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    
    private static final String JDBC_URL =
            "jdbc:mysql://localhost:3306/coche?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    
    public static DataSource getDataSource() throws SQLException{
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        ds.setInitialSize(30);
        return ds;
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection(); //obtengo una conexión a partir de nuestro pool de conexiones
    }
        
    public static void close(ResultSet rs){
        try{
            rs.close();
        }catch(SQLException ex){
            System.out.println("ex");
            System.out.println("Error 1 clase Conexion");
        }
    }
    
    public static void close(PreparedStatement statement){
        try{
            statement.close();
        }catch(SQLException ex){
            System.out.println("ex");
            System.out.println("Error 2 clase Conexion");
        }
    }
    
     public static void close(Connection conn){
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println("ex");
            System.out.println("Error 3 clase Conexion");
        }
    }

    
}
