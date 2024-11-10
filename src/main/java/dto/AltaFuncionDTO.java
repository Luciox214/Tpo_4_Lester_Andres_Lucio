package dto;

public class AltaFuncionDTO {

    /*ATRIBUTOS DE CLASE*/
    private String sucursal;
    private String sala;
    private String nombrePelicula;
    private String horario;

    /* CONSTRUCTOR */
    public AltaFuncionDTO(){
        this.sucursal = "";
        this.sala = "";
        this.nombrePelicula = "";
        this.horario = "";
    }

    /* Getters y Setters*/

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
