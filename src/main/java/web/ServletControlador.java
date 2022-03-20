package web;
    
import datos.CocheDAO;
import datos.PilotoDAO;
import datos.UsuarioDAO;
import dominio.Coche;
import dominio.Piloto;
import dominio.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      
        String accion = request.getParameter("accion");
        System.out.println("Accion método doGet " + accion);
        
        if(accion != null){
            switch(accion){
                case "editarCoche":
                    this.editarCoche(request, response);
                    break;
                case "eliminarCoche":
                    this.eliminarCoche(request, response);
                    break;
                case "verPiloto":
                    this.verPiloto(request, response);
                    break;
                case "presentarPiloto":
                    this.presentarPiloto(request, response);
                    break;
                case "editarPiloto":
                    this.editarPiloto(request, response);
                    break;
                case "eliminarPiloto":
                    this.eliminarPiloto(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException{
        List<Coche> coches = new CocheDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("coches", coches);
        sesion.setAttribute("totalCoches", coches.size());
        response.sendRedirect("coches.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String accion = request.getParameter("accion");
       
       if(accion != null){
            System.out.println("Accion doPost= " + accion);
            switch(accion){
                case "hacerLogin":
                    this.hacerLogin(request, response);
                    break;
                case "insertarCoche":
                    this.insertarCoche(request, response);
                    break;
                case "modificarCoche":
                    this.modificarCoche(request, response);
                    break; 
                case "insertarPiloto":
                    this.insertarPiloto(request, response);
                    break;
                case "modificarPiloto":
                    this.modificarPiloto(request, response);
                    break;
                default:
                    this.accionDefault(request, response);   
                    break;
            }
        }else{
            this.accionDefault(request, response);
            }
    }

    private void hacerLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        Usuario usuario1 = new Usuario(usuario, contrasena);
        if(!usuarioDao.comprobarUsuarioExiste(usuario, contrasena)){
           int registrosModificadosUsuario = usuarioDao.insertar(usuario1);
            System.out.println("Registros modificados usuario: " + registrosModificadosUsuario);
            this.accionDefault(request, response);
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarCoche(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        String marca = request.getParameter("marca");
        int anoFabricacion = 0;
        String anoFabricacionString = request.getParameter("anoFabricacion");
        if(anoFabricacionString != null && !"".equals(anoFabricacionString)){
            anoFabricacion = Integer.parseInt(anoFabricacionString);
            
        }
        int numCilindros = 0;
        String numCiliondrosString = request.getParameter("numCilindros");
        if(numCiliondrosString != null && !"".equals(numCiliondrosString)){
            numCilindros = Integer.parseInt(numCiliondrosString);
        }
        Coche coche = new Coche(matricula, marca, anoFabricacion, numCilindros);
        int registrosModificadosCoche = new CocheDAO().insertar(coche);
        System.out.println("Coche insertado: " + registrosModificadosCoche);
        this.accionDefault(request, response);
    }

    private void editarCoche(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Coche coche = new CocheDAO().encontrar(new Coche(id));
        request.setAttribute("coche", coche);
        String jspEditar = "/WEB-INF/paginas/coche/editarCoche.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void modificarCoche(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       int id = Integer.parseInt(request.getParameter("id"));
       String matricula = request.getParameter("matricula");
       String marca = request.getParameter("marca");
       int anoFabricacion = 0;
       String anoFabricacionString = request.getParameter("anoFabricacion");
        if(anoFabricacionString != null && !"".equals(anoFabricacionString)){
            anoFabricacion = Integer.parseInt(anoFabricacionString);
        }
        int numCilindros = 0;
        String numCiliondrosString = request.getParameter("numCilindros");
        if(numCiliondrosString != null && !"".equals(numCiliondrosString)){
            numCilindros = Integer.parseInt(numCiliondrosString);
        }
       
       Coche coche = new Coche(id, matricula, marca, anoFabricacion, numCilindros);
       int registrosModificados = new CocheDAO().actualizar(coche);
       this.accionDefault(request, response);
    }

    private void eliminarCoche(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Coche coche = new Coche(id);
        int registrosEliminadosCoche = new CocheDAO().eliminar(coche);
        this.accionDefault(request, response);
    }

    private void insertarPiloto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String nombrePiloto = request.getParameter("nombrePiloto");
        int idCoche = 0;
        String idCocheString = request.getParameter("idCoche");
        if(idCocheString != null && !"".equals(idCocheString)){
            idCoche = Integer.parseInt(idCocheString);
        }
        Piloto piloto = new Piloto(nombrePiloto, idCoche);
        int registrosInsertadosPiloto = new PilotoDAO().insertar(piloto);
        System.out.println("Piloto insertado: " + registrosInsertadosPiloto);
        this.verPiloto(request, response);
    }

    private void verPiloto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Piloto> pilotos = new PilotoDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("pilotos", pilotos);
        sesion.setAttribute("totalPilotos", pilotos.size());
        response.sendRedirect("pilotos.jsp");
    }    

    private void presentarPiloto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int idPiloto = Integer.parseInt(request.getParameter("idPiloto"));
        Piloto piloto = new PilotoDAO().encontrar(new Piloto(idPiloto));
        request.setAttribute("piloto", piloto);
        String jspPresentar = "/WEB-INF/paginas/coche/presentarPiloto.jsp";
        request.getRequestDispatcher(jspPresentar).forward(request, response);
   
    }

    private void editarPiloto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPiloto = Integer.parseInt(request.getParameter("idPiloto"));
        Piloto piloto = new PilotoDAO().encontrar(new Piloto(idPiloto));
        request.setAttribute("piloto", piloto);
        String jspEditar = "/WEB-INF/paginas/coche/editarPiloto.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response); 
    }
    
    private void modificarPiloto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       int idPiloto = Integer.parseInt(request.getParameter("idPiloto"));
       String nombrePiloto = request.getParameter("nombrePiloto");
       int idCoche = 0;
       String idCocheString = request.getParameter("idCoche");
        if(idCocheString != null && !"".equals(idCocheString)){
            idCoche = Integer.parseInt(idCocheString);
        }
        
       Piloto piloto = new Piloto(idPiloto, nombrePiloto, idCoche);
       int registrosModificadosPiloto = new PilotoDAO().actualizar(piloto);
       this.verPiloto(request, response);
    }

    private void eliminarPiloto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPiloto = Integer.parseInt(request.getParameter("idPiloto"));
        Piloto piloto = new Piloto(idPiloto);
        int registrosEliminadosPiloto = new PilotoDAO().eliminar(piloto);
        this.verPiloto(request, response);
    }
        
}
   
