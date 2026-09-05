import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("Parque universitario de atracciones");
        System.out.print("Ingrese el nombre del parque: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el código del parque: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el nombre del encargado: ");
        String encargado = scanner.nextLine();

        Parque parque = new Parque(nombre, codigo, encargado);

        while (opcion != 13) {
            try {
                System.out.println("\nMenú principal");
                System.out.println("1. Nuevo parque");
                System.out.println("2. Habilitar punto de acceso");
                System.out.println("3. Consultar puntos de acceso");
                System.out.println("4. Consultar un punto de acceso");
                System.out.println("5. Modificar punto de acceso");
                System.out.println("6. Cerrar punto de acceso");
                System.out.println("7. Registrar visitante");
                System.out.println("8. Consultar visitantes");
                System.out.println("9. Buscar visitante");
                System.out.println("10. Modificar visitante");
                System.out.println("11. Eliminar visitante");
                System.out.println("12. Mostrar reporte del parque");
                System.out.println("13. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1: {
                        System.out.print("Ingrese el nombre del parque: ");
                        nombre = scanner.nextLine();
                        System.out.print("Ingrese el código del parque: ");
                        codigo = scanner.nextLine();
                        System.out.print("Ingrese el nombre del encargado: ");
                        encargado = scanner.nextLine();

                        parque = new Parque(nombre, codigo, encargado);
                        System.out.println("El nuevo parque fue creado correctamente.");
                        break;
                    }

                    case 2: {
                        System.out.print("Ingrese una posición del 1 al 5: ");
                        int posicion = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese el código del punto: ");
                        codigo = scanner.nextLine();
                        System.out.print("Ingrese el nombre del punto: ");
                        nombre = scanner.nextLine();
                        System.out.print("Ingrese la ubicación: ");
                        String ubicacion = scanner.nextLine();
                        System.out.print("Ingrese la capacidad máxima: ");
                        int capacidad = scanner.nextInt();
                        System.out.print("Seleccione el estado (1. Activo, 2. Inactivo): ");
                        int numeroEstado = scanner.nextInt();
                        scanner.nextLine();

                        Estado estado = Estado.ACTIVO;

                        if (numeroEstado == 2) {
                            estado = Estado.INACTIVO;
                        } else if (numeroEstado != 1) {
                            throw new IllegalArgumentException(
                                "Debe seleccionar el estado 1 o 2."
                            );
                        }

                        PuntoAcceso punto = new PuntoAcceso(
                            codigo, nombre, ubicacion, capacidad, estado
                        );

                        parque.habilitarPunto(posicion, punto);
                        System.out.println("El punto de acceso fue habilitado.");
                        break;
                    }

                    case 3: {
                        parque.mostrarPuntos();
                        break;
                    }

                    case 4: {
                        System.out.print("Ingrese una posición del 1 al 5: ");
                        int posicion = scanner.nextInt();
                        scanner.nextLine();

                        PuntoAcceso punto = parque.consultarPunto(posicion);

                        if (punto == null) {
                            System.out.println("La posición seleccionada está vacía.");
                        } else {
                            punto.mostrar();
                        }
                        break;
                    }

                    case 5: {
                        System.out.print("Ingrese una posición del 1 al 5: ");
                        int posicion = scanner.nextInt();
                        System.out.print("Ingrese la nueva capacidad: ");
                        int capacidad = scanner.nextInt();
                        System.out.print("Seleccione el estado (1. Activo, 2. Inactivo): ");
                        int numeroEstado = scanner.nextInt();
                        scanner.nextLine();

                        Estado estado = Estado.ACTIVO;

                        if (numeroEstado == 2) {
                            estado = Estado.INACTIVO;
                        } else if (numeroEstado != 1) {
                            throw new IllegalArgumentException(
                                "Debe seleccionar el estado 1 o 2."
                            );
                        }

                        parque.modificarPunto(posicion, capacidad, estado);
                        System.out.println("El punto de acceso fue modificado.");
                        break;
                    }

                    case 6: {
                        System.out.print("Ingrese una posición del 1 al 5: ");
                        int posicion = scanner.nextInt();
                        scanner.nextLine();

                        parque.cerrarPunto(posicion);
                        System.out.println("El punto de acceso fue cerrado.");
                        break;
                    }

                    case 7: {
                        System.out.print("Ingrese el código de entrada: ");
                        codigo = scanner.nextLine();
                        System.out.print("Ingrese el nombre del visitante: ");
                        nombre = scanner.nextLine();
                        System.out.print("Ingrese la edad: ");
                        int edad = scanner.nextInt();
                        System.out.print("Ingrese las atracciones visitadas: ");
                        int atracciones = scanner.nextInt();
                        System.out.print("Ingrese los puntos acumulados: ");
                        int puntos = scanner.nextInt();
                        scanner.nextLine();

                        Visitante visitante = new Visitante(
                            codigo, nombre, edad, atracciones, puntos
                        );

                        if (parque.registrarVisitante(visitante)) {
                            System.out.println("El visitante fue registrado.");
                        } else {
                            System.out.println(
                                "Ya existe un visitante con ese código."
                            );
                        }
                        break;
                    }

                    case 8: {
                        parque.mostrarVisitantes();
                        break;
                    }

                    case 9: {
                        System.out.print("Ingrese el código de entrada: ");
                        codigo = scanner.nextLine();

                        Visitante visitante = parque.buscarVisitante(codigo);

                        if (visitante == null) {
                            System.out.println("No se encontró al visitante.");
                        } else {
                            visitante.mostrar();
                        }
                        break;
                    }

                    case 10: {
                        System.out.print("Ingrese el código de entrada: ");
                        codigo = scanner.nextLine();
                        System.out.print("Ingrese el nuevo nombre: ");
                        nombre = scanner.nextLine();
                        System.out.print("Ingrese la nueva edad: ");
                        int edad = scanner.nextInt();
                        System.out.print("Ingrese la nueva cantidad de atracciones: ");
                        int atracciones = scanner.nextInt();
                        System.out.print("Ingrese los nuevos puntos: ");
                        int puntos = scanner.nextInt();
                        scanner.nextLine();

                        boolean modificado = parque.modificarVisitante(
                            codigo, nombre, edad, atracciones, puntos
                        );

                        if (modificado) {
                            System.out.println("El visitante fue modificado.");
                        } else {
                            System.out.println("No se encontró al visitante.");
                        }
                        break;
                    }

                    case 11: {
                        System.out.print("Ingrese el código de entrada: ");
                        codigo = scanner.nextLine();

                        if (parque.eliminarVisitante(codigo)) {
                            System.out.println("El visitante fue eliminado.");
                        } else {
                            System.out.println("No se encontró al visitante.");
                        }
                        break;
                    }

                    case 12: {
                        parque.mostrarReporte();
                        break;
                    }

                    case 13: {
                        System.out.println("El programa ha finalizado.");
                        break;
                    }

                    default: {
                        System.out.println("La opción debe estar entre 1 y 13.");
                    }
                }
            } catch (InputMismatchException error) {
                System.out.println("Debe ingresar un valor numérico.");
                scanner.nextLine();
            } catch (IllegalArgumentException error) {
                System.out.println("Error: " + error.getMessage());
            } finally {
                if (opcion != 13) {
                    System.out.println(
                        "La operación finalizó. Regresando al menú principal."
                    );
                }
            }
        }
        scanner.close();
    }
}