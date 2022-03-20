package dominio;

public class Piloto {
    
    private int idPiloto;
    private String nombrePiloto;
    private int idCoche;

    public Piloto(int idPiloto, String nombrePiloto, int idCoche) {
        this.idPiloto = idPiloto;
        this.nombrePiloto = nombrePiloto;
        this.idCoche = idCoche;
    }
    
    public Piloto(int idPiloto){
        this.idPiloto = idPiloto;
    }
    
    public Piloto(String nombrePiloto, int idCoche) {
        this.nombrePiloto = nombrePiloto;
        this.idCoche = idCoche;
    }

    public int getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(int idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getNombrePiloto() {
        return nombrePiloto;
    }

    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
    }

    public int getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(int idCoche) {
        this.idCoche = idCoche;
    }
    
}
