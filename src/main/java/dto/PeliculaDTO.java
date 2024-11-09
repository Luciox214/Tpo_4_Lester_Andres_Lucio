package dto;

public class PeliculaDTO {


    private String nombreDTO;
    private String duracionDTO;

    private String directorDTO;

    private String generoDTO;


    public PeliculaDTO(String nombre, String duracion, String director, String genero){
       this.generoDTO=genero;
       this.nombreDTO= nombre;
       this.duracionDTO= duracion;
       this.directorDTO= director;
    }

    public String getNombreDTO() {
        return nombreDTO;
    }

    public void setNombreDTO(String nombreDTO) {
        this.nombreDTO = nombreDTO;
    }

    public String getDuracionDTO() {
        return duracionDTO;
    }

    public void setDuracionDTO(String duracionDTO) {
        this.duracionDTO = duracionDTO;
    }

    public String getDirectorDTO() {
        return directorDTO;
    }

    public void setDirector(String director) {
        this.directorDTO = director;
    }

    public String getGeneroDTO() {
        return generoDTO;
    }

    public void setGenero(String genero) {
        this.generoDTO = genero;
    }
}
