package modelo;

public class Casillero {
    private final String tamano;
    private final int horas;

    public Casillero(String tamano, int horas) {
        if (!"Pequeño".equals(tamano) && !"Mediano".equals(tamano) && !"Grande".equals(tamano)) {
            throw new IllegalArgumentException("Selecciona un tamaño válido.");
        }
        if (horas < 1 || horas > 12) {
            throw new IllegalArgumentException("Las horas deben estar entre 1 y 12.");
        }
        this.tamano = tamano;
        this.horas = horas;
    }

    public double obtenerTarifa() {
        switch (tamano) {
            case "Pequeño": return 0.50;
            case "Mediano": return 0.75;
            default: return 1.00;
        }
    }

    public double calcularSubtotal() { return obtenerTarifa() * horas; }
    public double calcularDescuento() { return horas > 5 ? calcularSubtotal() * 0.15 : 0; }
    public double calcularTotal() { return calcularSubtotal() - calcularDescuento(); }
}
