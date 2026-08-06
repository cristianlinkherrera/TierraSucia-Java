package tierrasucia;

import java.util.Scanner;

/**
 * Clase principal del sistema Tierra Sucia.
 *
 * Permite registrar un camión, validar sus datos y probar las operaciones
 * disponibles en la clase TierraSucia.
 *
 * @author Cristian Herrera
 */
public class Principal {

    /**
     * Método principal: punto de inicio del programa.
     *
     * @param args argumentos recibidos desde la consola
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la patente del camión: ");
        String entradaPatente = teclado.nextLine().trim();

        System.out.print("Ingrese la carga del camión: ");
        String entradaCarga = teclado.nextLine().trim();

        String patente;
        int cargaCamion;

        // Validar patente
        if (entradaPatente.isEmpty()) {
            patente = "SIN PATENTE";
        } else {
            patente = entradaPatente.toUpperCase();
        }

        // Validar carga
        if (entradaCarga.isEmpty()) {
            cargaCamion = 0;
        } else {
            try {
                cargaCamion = Integer.parseInt(entradaCarga);

                if (cargaCamion < 0) {
                    System.out.println(
                            "La carga no puede ser negativa. Se asignará 0."
                    );
                    cargaCamion = 0;
                }

            } catch (NumberFormatException error) {
                System.out.println(
                        "La carga ingresada no es válida. Se asignará 0."
                );
                cargaCamion = 0;
            }
        }

        // Verificar si no se ingresó ningún dato
        if (entradaPatente.isEmpty() && entradaCarga.isEmpty()) {
            System.out.println("SIN DATOS INGRESADOS");
        }

        // Crear el primer registro
        TierraSucia camion1 = new TierraSucia(
                patente,
                cargaCamion
        );

        System.out.println("\nRegistro inicial:");
        System.out.println(camion1);

        // Probar una descarga válida
        System.out.println("\nProbamos una descarga válida:");
        camion1.descargar(5000);
        System.out.println(camion1);

        // Probar una descarga inválida
        System.out.println("\nProbamos una descarga inválida:");
        camion1.descargar(-1000);
        System.out.println(camion1);

        // Probar una carga válida
        System.out.println("\nProbamos una carga válida:");
        camion1.cargar(3000);
        System.out.println(camion1);

        // Probar cargar más tierra de la disponible
        System.out.println(
                "\nProbamos cargar más tierra de la disponible:"
        );
        camion1.cargar(20000);
        System.out.println(camion1);

        // Crear otro registro usando el segundo constructor
        TierraSucia camion2 = new TierraSucia(
                "ZXCV98",
                15000,
                6000
        );

        System.out.println(
                "\nRegistro creado con el segundo constructor:"
        );
        System.out.println(camion2);

        // Consultar datos mediante getters
        System.out.println("\nDatos consultados mediante getters:");

        System.out.println(
                "Patente: " + camion2.getPatente()
        );

        System.out.println(
                "Tierra recibida: "
                + camion2.getTierraRecibida()
        );

        System.out.println(
                "Carga del camión: "
                + camion2.getCargaCamion()
        );

        // Modificar datos mediante setters
        System.out.println("\nDatos modificados mediante setters:");

        camion2.setPatente("JKLM45");
        camion2.setCargaCamion(7000);

        System.out.println(camion2);

        // Probar la sobrecarga del método descargar
        System.out.println(
                "\nProbamos descargar usando la carga del camión:"
        );

        camion2.descargar();
        System.out.println(camion2);

        // Probar la sobrecarga del método cargar
        System.out.println(
                "\nProbamos cargar usando la carga del camión:"
        );

        camion2.cargar();
        System.out.println(camion2);

        teclado.close();
    }
}
