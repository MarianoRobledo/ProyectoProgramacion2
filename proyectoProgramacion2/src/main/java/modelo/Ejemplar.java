package modelo;

public class Ejemplar {
    private int idEjemplar;
    private Libro libro;

    public Ejemplar() {}

    public Ejemplar(int idEjemplar, Libro libro) {
        this.idEjemplar = idEjemplar;
        this.libro = libro;
    }

    public int getIdEjemplar() { return idEjemplar; }
    public void setIdEjemplar(int idEjemplar) { this.idEjemplar = idEjemplar; }

    public Libro getLibro() { return libro; }
    public void setLibro(Libro libro) { this.libro = libro; }

    @Override
    public String toString() {
        return "Ejemplar{" +
                "idEjemplar=" + idEjemplar +
                ", libroTitulo=" + (libro != null ? libro.getTitulo() : "null") +
                '}';
    }
}
