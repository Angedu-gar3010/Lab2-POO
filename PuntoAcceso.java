enum Estado {
    ACTIVO,
    INACTIVO
}

public class PuntoAcceso {

    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidad;
    private Estado estado;

    public PuntoAcceso(String codigo, String nombre, String ubicacion, int capacidad, Estado estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        setCapacidad(capacidad);
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException(
                "La capacidad debe ser mayor que 0."
            );
        }
        this.capacidad = capacidad;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void mostrar() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Estado: " + estado);
    }
}