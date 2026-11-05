package vista;

import java.awt.GridLayout;
import javax.swing.*;

public class VistaCasillero extends JFrame {
    private static final long serialVersionUID = 1L;
    public final JTextField txtNombre = new JTextField();
    public final JComboBox<String> cmbTamano = new JComboBox<>(new String[]{"Pequeño", "Mediano", "Grande"});
    public final JTextField txtHoras = new JTextField();
    public final JButton btnCalcular = new JButton("Calcular");
    public final JButton btnLimpiar = new JButton("Limpiar");
    public final JLabel lblSubtotal = new JLabel("$0.00");
    public final JLabel lblDescuento = new JLabel("$0.00");
    public final JLabel lblTotal = new JLabel("$0.00");

    public VistaCasillero() {
        setTitle("Cobro de casilleros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(new JLabel("Nombre del cliente:")); panel.add(txtNombre);
        panel.add(new JLabel("Tamaño del casillero:")); panel.add(cmbTamano);
        panel.add(new JLabel("Horas de uso (1 a 12):")); panel.add(txtHoras);
        panel.add(btnCalcular); panel.add(btnLimpiar);
        panel.add(new JLabel("Subtotal:")); panel.add(lblSubtotal);
        panel.add(new JLabel("Descuento:")); panel.add(lblDescuento);
        panel.add(new JLabel("Total:")); panel.add(lblTotal);
        setContentPane(panel);
        setSize(480, 350);
        setLocationRelativeTo(null);
    }
}
