package tierrasucia;

/**
 * Representa un registro de tierra y carga de un camión
 * dentro del vertedero.
 *
 * @author Cristian Herrera
 */
public class TierraSucia {

    // Datos de cada registro del vertedero
    private String patente;
    private Integer tierraRecibida;
    private Integer cargaCamion;

    // Constructor con los datos obligatorios
    public TierraSucia(String patente, Integer cargaCamion) {

        // Valores iniciales seguros
        this.patente = "SIN PATENTE";
        this.tierraRecibida = 0;
        this.cargaCamion = 0;

        // Usamos los setters para validar los datos recibidos
        setPatente(patente);
        setCargaCamion(cargaCamion);
    }

    // Constructor con todos los datos
    public TierraSucia(
            String patente,
            Integer tierraRecibida,
            Integer cargaCamion
    ) {
        // Reutiliza el primer constructor
        this(patente, cargaCamion);

        // Guarda la tierra recibida usando su validación
        setTierraRecibida(tierraRecibida);
    }

    // Getter de patente
    public String getPatente() {
        return patente;
    }

    // Setter de patente
    public void setPatente(String patente) {

        if (patente != null && !patente.isBlank()) {
            this.patente = patente.trim().toUpperCase();
        }
    }

    // Getter de tierra recibida
    public Integer getTierraRecibida() {
        return tierraRecibida;
    }

    // Setter de tierra recibida
    public void setTierraRecibida(Integer tierraRecibida) {

        if (tierraRecibida != null && tierraRecibida >= 0) {
            this.tierraRecibida = tierraRecibida;
        }
    }

    // Getter de carga del camión
    public Integer getCargaCamion() {
        return cargaCamion;
    }

    // Setter de carga del camión
    public void setCargaCamion(Integer cargaCamion) {

        if (cargaCamion != null && cargaCamion >= 0) {
            this.cargaCamion = cargaCamion;
        }
    }

    // Método para descargar tierra en el vertedero
    public void descargar(Integer cantidad) {

        if (cantidad != null && cantidad > 0) {
            tierraRecibida = tierraRecibida + cantidad;
            System.out.println("Descarga realizada correctamente.");
        } else {
            System.out.println(
                    "La cantidad no puede ser negativa ni cero."
            );
        }
    }

    // Sobrecarga del método descargar
    public void descargar() {
        descargar(cargaCamion);
    }

    // Método para retirar tierra del vertedero
    public void cargar(Integer cantidad) {

        if (cantidad == null || cantidad <= 0) {
            System.out.println(
                    "La cantidad debe ser mayor que cero."
            );

        } else if (cantidad > tierraRecibida) {
            System.out.println(
                    "No hay tierra suficiente para cargar."
            );

        } else {
            tierraRecibida = tierraRecibida - cantidad;
            System.out.println("Carga realizada correctamente.");
        }
    }

    // Sobrecarga del método cargar
    public void cargar() {
        cargar(cargaCamion);
    }

    // Muestra los datos completos del registro
    @Override
    public String toString() {
        return "TierraSucia{"
                + "patente='" + patente + '\''
                + ", tierraRecibida=" + tierraRecibida
                + ", cargaCamion=" + cargaCamion
                + '}';
    }
}
