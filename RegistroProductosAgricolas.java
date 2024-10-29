package co.edu.tdeacontruccionm.gestionperfilusuario;

import javax.swing.*;

public class RegistroProductosAgricolas extends JFrame {

    private final JTextField nombreField;
    private final JTextArea descripcionArea;
    private final JTextField cantidadField;
    private final JTextField precioField;

    public RegistroProductosAgricolas() {
        setTitle("Registro de Productos Agrícolas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Descripción:"));
        descripcionArea = new JTextArea();
        add(new JScrollPane(descripcionArea));

        add(new JLabel("Cantidad:"));
        cantidadField = new JTextField();
        add(cantidadField);

        add(new JLabel("Precio:"));
        precioField = new JTextField();
        add(precioField);

        JButton registrarButton = new JButton("Registrar Producto");
        registrarButton.addActionListener(e -> registrarProducto());
        add(registrarButton);
    }

    private void registrarProducto() {
        String nombre = nombreField.getText();
        String descripcion = descripcionArea.getText();
        String cantidad = cantidadField.getText();
        String precio = precioField.getText();

        

        JOptionPane.showMessageDialog(this, "Producto registrado con éxito:" +
                "Nombre: " + nombre + "" +
                "Descripción: " + descripcion + "" +
                "Cantidad: " + cantidad + "" +
                "Precio: " + precio);
    }

   
}
