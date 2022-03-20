package dominio;

public class Coche {
    
    private int id;
    private String matricula;
    private String marca;
    private int anoFabricacion;

    public Coche(int id) {
        this.id = id;
    }
    private int numCilindros;

    public Coche() {}

    public Coche(int id, String matricula, String marca, int anoFabricacion, int numCilindros) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.anoFabricacion = anoFabricacion;
        this.numCilindros = numCilindros;
    }

    public Coche(String matricula, String marca, int anoFabricacion, int numCilindros) {
        this.matricula = matricula;
        this.marca = marca;
        this.anoFabricacion = anoFabricacion;
        this.numCilindros = numCilindros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public int getNumCilindros() {
        return numCilindros;
    }

    public void setNumCilindros(int numCilindros) {
        this.numCilindros = numCilindros;
    }

    @Override
    public String toString() {
        return "Coche{" + "id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", anoFabricacion=" + anoFabricacion + ", numCilindros=" + numCilindros + '}';
    }
    
}
