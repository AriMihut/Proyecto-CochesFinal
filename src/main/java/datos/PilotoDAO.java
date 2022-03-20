package datos;

import dominio.Piloto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PilotoDAO {
    
    private static final String SQL_SELECT = 
            "SELECT idPiloto, nombrePiloto, idCoche "
            + " FROM piloto";
    
    private static final String SQL_SELECT_BY_ID = 
            "SELECT idPiloto, nombrePiloto, idCoche "
            + " FROM piloto WHERE idPiloto = ?";
    
    private static final String SQL_INSERT = 
            "INSERT INTO piloto(nombrePiloto, idCoche) "
            + " VALUES (?, ?)";
    
    private static final String SQL_UPDATE = 
            "UPDATE piloto SET nombrePiloto = ?,"
            +" idCoche = ?"
            +" WHERE idPiloto = ?";
    
    private static final String SQL_DELETE = 
            "DELETE FROM piloto WHERE idPiloto = ?";
    
    public List<Piloto> listar(){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Piloto piloto = null;
        List<Piloto> pilotos = new ArrayList<>();
        
        try{ 
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_SELECT);
            rs = statement.executeQuery();
            
            while(rs.next()){
                int idPiloto = rs.getInt("idPiloto");
                String nombrePiloto = rs.getString("nombrePiloto");
                int idCoche = rs.getInt("idCoche");
              
                piloto = new Piloto(idPiloto, nombrePiloto, idCoche);
                
                pilotos.add(piloto);
            }
        }catch(SQLException e){
            System.out.println("error al listar los pilotos: " + e.getMessage());
            System.out.println("Error 1 clase DAO piloto");
        }finally{
            Conexion.close(rs);
            Conexion.close(statement);
            Conexion.close(conn);
        }
        return pilotos;
    }
    
    public Piloto encontrar(Piloto piloto){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try{
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, piloto.getIdPiloto());
            rs = statement.executeQuery();
            rs.next();
            
            String nombrePiloto = rs.getString("nombrePiloto");
            int idCoche = rs.getInt("idCoche");
               
            piloto.setNombrePiloto(nombrePiloto);
            piloto.setIdCoche(idCoche);
            
        }catch(SQLException e){
            System.out.println("Encontrar DAO Piloto " + e.getMessage());
            System.out.println("Error 2 clase PilotoDAO");
        }finally{
            Conexion.close(rs);
            Conexion.close(statement);
            Conexion.close(conn);
        }
        return piloto;  
    }
    
    public int insertar(Piloto piloto){
        Connection conn = null;
        PreparedStatement statement = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_INSERT);
            statement.setString(1, piloto.getNombrePiloto());
            statement.setInt(2, piloto.getIdCoche());
           
            rows = statement.executeUpdate(); 
        }catch(SQLException e){
            System.out.println("DAO Insertar piloto " + e.getMessage());
            System.out.println("Error 3 clase DAO piloto");
        }finally{
            Conexion.close(statement);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int actualizar(Piloto piloto){
        Connection conn = null;
        PreparedStatement statement = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_UPDATE);
            statement.setString(1, piloto.getNombrePiloto());
            statement.setInt(2, piloto.getIdCoche());
            statement.setInt(3, piloto.getIdPiloto());
           
            rows = statement.executeUpdate(); 
        }catch(SQLException e){
            System.out.println("Error actualizar piloto: " + e.getMessage());
            System.out.println("Error 4 clase DAO piloto");
        }finally{
            Conexion.close(statement);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int eliminar(Piloto piloto){
        Connection conn = null;
        PreparedStatement statement = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_DELETE);
            statement.setInt(1, piloto.getIdPiloto());
           
            rows = statement.executeUpdate(); 
        }catch(SQLException e){
            System.out.println("Error al eliminar piloto: " + e.getMessage());
            System.out.println("Error 5 clase DAO piloto");
        }finally{
            Conexion.close(statement);
            Conexion.close(conn);
        }
        return rows;
    }
    
}
