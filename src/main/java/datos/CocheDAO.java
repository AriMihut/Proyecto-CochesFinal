package datos;
    
import dominio.Coche;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CocheDAO {
    
    private static final String SQL_SELECT = 
            "SELECT id, matricula, marca, anoFabricacion, numCilindros "
            + " FROM coche";
    
    private static final String SQL_SELECT_BY_ID = 
            "SELECT id, matricula, marca, anoFabricacion, numCilindros "
            + " FROM coche WHERE id = ?";
    
    private static final String SQL_INSERT = 
            "INSERT INTO coche(matricula, marca, anoFabricacion, numCilindros) "
            + " VALUES (?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = 
            "UPDATE coche SET matricula = ?,"
            +" marca = ?,"
            +" anoFabricacion = ?,"
            +" numCilindros = ?"
            +" WHERE id = ?";
    
    private static final String SQL_DELETE = 
            "DELETE FROM coche WHERE id = ?";
    
    public List<Coche> listar(){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Coche coche = null;
        List<Coche> coches = new ArrayList<>();
        
        try{ 
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_SELECT);
            rs = statement.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String matricula = rs.getString("matricula");
                String marca = rs.getString("marca");
                int anoFabricacion = rs.getInt("anoFabricacion");
                int numCilindros = rs.getInt("numCilindros");
              
                coche = new Coche(id, matricula, marca, anoFabricacion, numCilindros);
                
                coches.add(coche);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Error 1 clase DAO coche");
        }finally{
            Conexion.close(rs);
            Conexion.close(statement);
            Conexion.close(conn);
        }
        return coches;
    }
    
    public Coche encontrar(Coche coche){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try{
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, coche.getId());
            rs = statement.executeQuery();
            rs.next();
            
            String matricula = rs.getString("matricula");
            String marca = rs.getString("marca");
            int anoFabricacion = rs.getInt("anoFabricacion");
            int numCilindros = rs.getInt("numCilindros");
                
            //asigno valores al objeto:
            coche.setMatricula(matricula);
            coche.setMarca(marca);
            coche.setAnoFabricacion(anoFabricacion);
            coche.setNumCilindros(numCilindros);
            
        }catch(SQLException e){
            System.out.println("Encontrar DAO Coche " + e.getMessage());
            System.out.println("Error 2 clase DAO");
        }finally{
            Conexion.close(rs);
            Conexion.close(statement);
            Conexion.close(conn);
        }
        return coche;  
    }
    
    public int insertar(Coche coche){
        Connection conn = null;
        PreparedStatement statement = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_INSERT);
            statement.setString(1, coche.getMatricula());
            statement.setString(2, coche.getMarca());
            statement.setInt(3, coche.getAnoFabricacion());
            statement.setInt(4, coche.getNumCilindros());
           
            rows = statement.executeUpdate(); 
        }catch(SQLException e){
            System.out.println("DAO Insertar coche " + e.getMessage());
            System.out.println("Error 3 clase DAO coche");
        }finally{
            Conexion.close(statement);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int actualizar(Coche coche){
        Connection conn = null;
        PreparedStatement statement = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_UPDATE);
            statement.setString(1, coche.getMatricula());
            statement.setString(2, coche.getMarca());
            statement.setInt(3, coche.getAnoFabricacion());
            statement.setInt(4, coche.getNumCilindros());
            statement.setInt(5, coche.getId());
           
            rows = statement.executeUpdate(); 
        }catch(SQLException e){
            System.out.println("Error actualizar coche: " + e.getMessage());
            System.out.println("Error 4 clase DAO coche");
        }finally{
            Conexion.close(statement);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int eliminar(Coche coche){
        Connection conn = null;
        PreparedStatement statement = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_DELETE);
            statement.setInt(1, coche.getId());
           
            rows = statement.executeUpdate(); 
        }catch(SQLException e){
            System.out.println("Error al eliminar coche: " + e.getMessage());
            System.out.println("Error 5 clase DAO coche");
        }finally{
            Conexion.close(statement);
            Conexion.close(conn);
        }
        return rows;
    }

    
}
