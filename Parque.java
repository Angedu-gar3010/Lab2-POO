import java.util.ArrayList;

public class Parque {
    private String nombre;
    private String codigo;
    private String encargado;
    private PuntoAcceso[] puntos;
    private ArrayList<Visitante> visitantes;

    public Parque(String nombre, String codigo, String encargado) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.encargado = encargado;
        puntos = new PuntoAcceso[5];
        visitantes = new ArrayList<>();
    }

    public void habilitarPunto(int posicion, PuntoAcceso punto) {
        int indice = obtenerIndice(posicion);

        if (puntos[indice] != null) {
            throw new IllegalArgumentException(
                "La posición seleccionada está ocupada."
            );
        }

        if (punto == null) {
            throw new IllegalArgumentException(
                "El punto de acceso no puede ser null."
            );
        }

        puntos[indice] = punto;
    }

    public PuntoAcceso consultarPunto(int posicion) {
        int indice = obtenerIndice(posicion);
        return puntos[indice];
    }

    public void mostrarPuntos() {
        boolean hayPuntos = false;

        for (int i = 0; i < puntos.length; i++) {
            if (puntos[i] != null) {
                hayPuntos = true;
                System.out.println("\nPosición: " + (i + 1));
                puntos[i].mostrar();
            }
        }

        if (!hayPuntos) {
            System.out.println("No hay puntos de acceso habilitados.");
        }
    }

    public void modificarPunto(int posicion, int capacidad, Estado estado) {
        int indice = obtenerIndice(posicion);

        if (puntos[indice] == null) {
            throw new IllegalArgumentException(
                "La posición seleccionada está vacía."
            );
        }

        puntos[indice].setCapacidad(capacidad);
        puntos[indice].setEstado(estado);
    }

    public void cerrarPunto(int posicion) {
        int indice = obtenerIndice(posicion);

        if (puntos[indice] == null) {
            throw new IllegalArgumentException(
                "La posición seleccionada está vacía."
            );
        }

        puntos[indice] = null;
    }

    public int obtenerIndice(int posicion) {
        if (posicion < 1 || posicion > 5) {
            throw new IllegalArgumentException(
                "La posición debe estar entre 1 y 5."
            );
        }

        return posicion - 1;
    }

    public boolean registrarVisitante(Visitante visitante) {
        if (visitante == null) {
            throw new IllegalArgumentException(
                "El visitante no puede ser null."
            );
        }

        if (buscarVisitante(visitante.getCodigo()) != null) {
            return false;
        }

        visitantes.add(visitante);
        return true;
    }

    public Visitante buscarVisitante(String codigo) {
        for (int i = 0; i < visitantes.size(); i++) {
            if (visitantes.get(i).getCodigo().equals(codigo)) {
                return visitantes.get(i);
            }
        }

        return null;
    }

    public void mostrarVisitantes() {
        if (visitantes.isEmpty()) {
            System.out.println("No hay visitantes registrados.");
        } else {
            for (int i = 0; i < visitantes.size(); i++) {
                System.out.println("\nVisitante " + (i + 1));
                visitantes.get(i).mostrar();
            }
        }
    }

    public boolean modificarVisitante(String codigo, String nombre, int edad, int atracciones, int puntos) {
        Visitante visitante = buscarVisitante(codigo);

        if (visitante == null) {
            return false;
        }

        visitante.modificar(nombre, edad, atracciones, puntos);
        return true;
    }

    public boolean eliminarVisitante(String codigo) {
        Visitante visitante = buscarVisitante(codigo);

        if (visitante == null) {
            return false;
        }

        visitantes.remove(visitante);
        return true;
    }

    public void mostrarReporte() {
        int habilitados = 0;
        PuntoAcceso mayorPunto = null;

        for (int i = 0; i < puntos.length; i++) {
            if (puntos[i] != null) {
                habilitados++;

                if (mayorPunto == null
                        || puntos[i].getCapacidad() > mayorPunto.getCapacidad()) {
                    mayorPunto = puntos[i];
                }
            }
        }

        System.out.println("\nReporte del parque");
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Encargado: " + encargado);
        System.out.println("Puntos habilitados: " + habilitados);
        System.out.println("Espacios disponibles: " + (5 - habilitados));

        if (mayorPunto == null) {
            System.out.println("No hay puntos de acceso habilitados.");
        } else {
            System.out.println(
                "Punto con mayor capacidad: " + mayorPunto.getNombre()
            );
            System.out.println(
                "Capacidad máxima: " + mayorPunto.getCapacidad()
            );
        }

        System.out.println(
            "Visitantes registrados: " + visitantes.size()
        );

        if (visitantes.isEmpty()) {
            System.out.println(
                "No hay visitantes para realizar los cálculos."
            );
            return;
        }

        Visitante mayorPuntos = visitantes.get(0);
        Visitante mayorAtracciones = visitantes.get(0);
        int sumaEdades = 0;

        for (int i = 0; i < visitantes.size(); i++) {
            Visitante visitante = visitantes.get(i);
            sumaEdades += visitante.getEdad();

            if (visitante.getPuntos() > mayorPuntos.getPuntos()) {
                mayorPuntos = visitante;
            }

            if (visitante.getAtracciones()
                    > mayorAtracciones.getAtracciones()) {
                mayorAtracciones = visitante;
            }
        }

        double promedioEdad =
            (double) sumaEdades / visitantes.size();

        System.out.println(
            "Visitante con más puntos: " + mayorPuntos.getNombre()
        );
        System.out.println(
            "Puntos acumulados: " + mayorPuntos.getPuntos()
        );
        System.out.println(
            "Visitante con más atracciones: "
            + mayorAtracciones.getNombre()
        );
        System.out.println(
            "Atracciones visitadas: "
            + mayorAtracciones.getAtracciones()
        );
        System.out.println(
            "Promedio de edad: " + promedioEdad
        );
    }
}