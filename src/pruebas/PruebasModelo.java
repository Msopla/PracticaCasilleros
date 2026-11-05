package pruebas;
import modelo.Casillero;

public class PruebasModelo {
    public static void main(String[] args) {
        String[] tamanos = {"Pequeño", "Mediano", "Grande"};
        double[] tarifas = {0.50, 0.75, 1.00};
        for (int i = 0; i < tamanos.length; i++) {
            for (int horas = 1; horas <= 12; horas++) {
                Casillero c = new Casillero(tamanos[i], horas);
                double subtotal = tarifas[i] * horas;
                double descuento = horas > 5 ? subtotal * 0.15 : 0;
                comprobar(c.calcularSubtotal(), subtotal);
                comprobar(c.calcularDescuento(), descuento);
                comprobar(c.calcularTotal(), subtotal - descuento);
            }
        }
        comprobar(new Casillero("Grande", 5).calcularTotal(), 5.00);
        comprobar(new Casillero("Grande", 6).calcularTotal(), 5.10);
        comprobar(new Casillero("Mediano", 12).calcularTotal(), 7.65);
        for (int horas : new int[]{0, -1, 13}) {
            try { new Casillero("Pequeño", horas); throw new AssertionError("Aceptó horas inválidas"); }
            catch (IllegalArgumentException esperado) { }
        }
        try { new Casillero("Otro", 1); throw new AssertionError("Aceptó tamaño inválido"); }
        catch (IllegalArgumentException esperado) { }
        System.out.println("OK: tarifas, horas 1-12, descuento y entradas inválidas.");
    }
    private static void comprobar(double actual, double esperado) {
        if (Math.abs(actual - esperado) > 0.000001) throw new AssertionError(actual + " != " + esperado);
    }
}
