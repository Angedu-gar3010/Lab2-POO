public class Visitante {

    private String codigo;
    private String nombre;
    private int edad;
    private int atracciones;
    private int puntos;

    public Visitante(String codigo, String nombre, int edad,
                     int atracciones, int puntos) {
        this.codigo = codigo;
        modificar(nombre, edad, atracciones, puntos);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getAtracciones() {
        return atracciones;
    }

    public int getPuntos() {
        return puntos;
    }

    public void modificar(String nombre, int edad,
                          int atracciones, int puntos) {
        if (edad <= 0) {
            throw new IllegalArgumentException(
                "La edad debe ser mayor que 0."
            );
        }

        if (atracciones < 0 || puntos < 0) {
            throw new IllegalArgumentException(
                "Las atracciones y los puntos no pueden ser negativos."
            );
        }

        this.nombre = nombre;
        this.edad = edad;
        this.atracciones = atracciones;
        this.puntos = puntos;
    }

    public void mostrar() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Atracciones visitadas: " + atracciones);
        System.out.println("Puntos acumulados: " + puntos);
    }
}