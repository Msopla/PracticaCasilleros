package controlador;

import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelo.Casillero;
import vista.VistaCasillero;

public class ControladorCasillero {
    private final VistaCasillero vista;

    public ControladorCasillero(VistaCasillero vista) {
        this.vista = vista;
        vista.btnCalcular.addActionListener(e -> calcular());
        vista.btnLimpiar.addActionListener(e -> limpiar());
    }

    private void calcular() {
        restablecerResultados();
        String nombre = vista.txtNombre.getText().trim();
        String textoHoras = vista.txtHoras.getText().trim();
        if (nombre.isEmpty() || textoHoras.isEmpty()) {
            mostrarError("Completa el nombre y las horas.");
            return;
        }
        try {
            int horas = Integer.parseInt(textoHoras);
            Casillero casillero = new Casillero((String) vista.cmbTamano.getSelectedItem(), horas);
            vista.lblSubtotal.setText(String.format(Locale.US, "$%.2f", casillero.calcularSubtotal()));
            vista.lblDescuento.setText(String.format(Locale.US, "$%.2f", casillero.calcularDescuento()));
            vista.lblTotal.setText(String.format(Locale.US, "$%.2f", casillero.calcularTotal()));
        } catch (NumberFormatException ex) {
            mostrarError("Las horas deben ser un número entero.");
        } catch (IllegalArgumentException ex) {
            mostrarError(ex.getMessage());
        }
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(vista, mensaje, "Revisa los datos", JOptionPane.WARNING_MESSAGE);
    }

    private void restablecerResultados() {
        vista.lblSubtotal.setText("$0.00");
        vista.lblDescuento.setText("$0.00");
        vista.lblTotal.setText("$0.00");
    }

    private void limpiar() {
        vista.txtNombre.setText("");
        vista.txtHoras.setText("");
        vista.cmbTamano.setSelectedIndex(0);
        restablecerResultados();
        vista.txtNombre.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaCasillero vista = new VistaCasillero();
            new ControladorCasillero(vista);
            vista.setVisible(true);
        });
    }
}
