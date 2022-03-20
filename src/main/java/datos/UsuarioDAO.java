package datos;

import dominio.Coche;
import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
     private static final String SQL_SELECT_USUARIO_EXISTE = 
            "SELECT  usuario, contrasena"
            + " FROM usuario WHERE usuario = ?" 
            + "and contrasena = ?";
    
    private static final String SQL_INSERT = 
            "INSERT INTO usuario (usuario, contrasena) "
            + " VALUES  (?, ?)";
    
    private static final String SQL_UPDATE = 
            "UPDATE usuario SET usuario = ?,"
            +" contrasena = ?"
            +" WHERE id = ?";
    
    private static final String SQL_DELETE = 
            "DELETE FROM usuario WHERE id = ?";
    
    public boolean comprobarUsuarioExiste(String nombre, String contrasena){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        boolean usuarioExiste = false;
        try{
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_SELECT_USUARIO_EXISTE);
            statement.setString(1, nombre);
            statement.setString(2, contrasena);
            System.out.println("Comprobar usuario existe ==> " + nombre + " " + contrasena);
            rs = statement.executeQuery();
            System.out.println("statement ==> " + statement);
            
            if(rs != null) {
                usuarioExiste = true;
            } else {
                usuarioExiste = false;
            }
            //rs.absolute(1);
                  //asigno valores al objeto:
            
        }catch(SQLException e){
            System.out.println("e" + e.getMessage());
            System.out.println("Error 2 clase DAO usuario");
        }finally{
            Conexion.close(rs);
            Conexion.close(statement);
            Conexion.close(conn);
        }
        return usuarioExiste;  
        
    }
    
    public int insertar(Usuario usuario){
        Connection conn = null;
        PreparedStatement statement = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_INSERT);
            statement.setString(1, usuario.getUsuario());
            statement.setString(2, usuario.getContrasena());
            rows = statement.executeUpdate(); 
        }catch(SQLException e){
            System.out.println("e" + e.getMessage());
            System.out.println("Error 3 clase DAO usuario");
        }finally{
            Conexion.close(statement);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int modificar(Usuario usuario){
        Connection conn = null;
        PreparedStatement statement = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(SQL_UPDATE);
            statement.setString(1, usuario.getUsuario());
            statement.setString(2, usuario.getContrasena());
            statement.setInt(3, usuario.getId());
           
            rows = statement.executeUpdate(); 
        }catch(SQLException e){
            System.out.println("Error DAO Usuario: " + e.getMessage());
            System.out.println("Error 4 clase DAO usuario");
        }finally{
            Conexion.close(statement);
            Conexion.close(conn);
        }
        return rows;
    }
  
}
