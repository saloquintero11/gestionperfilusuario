
package co.edu.tdeacontruccionm.gestionperfilusuario;

import javax.swing.*;

public class GestionPedidos extends JFrame {

    private final JTextField productoField;
    private final JTextField cantidadField;
    private final JTextField precioField;
    private final JTextArea pedidosArea;
    private final Pedido[] pedidos;
    private int pedidoCount;

    public GestionPedidos() {
        setTitle("Gestión de Pedidos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        pedidos = new Pedido[100]; 
        pedidoCount = 0;

        add(new JLabel("Producto:"));
        productoField = new JTextField();
        add(productoField);

        add(new JLabel("Cantidad:"));
        cantidadField = new JTextField();
        add(cantidadField);

        add(new JLabel("Precio:"));
        precioField = new JTextField();
        add(precioField);

        JButton crearPedidoButton = new JButton("Crear Pedido");
        crearPedidoButton.addActionListener(e -> crearPedido());
        add(crearPedidoButton);

        pedidosArea = new JTextArea();
        pedidosArea.setEditable(false);
        add(new JScrollPane(pedidosArea));

        JButton gestionarPedidosButton = new JButton("Gestionar Pedidos");
        gestionarPedidosButton.addActionListener(e -> gestionarPedidos());
        add(gestionarPedidosButton);
    }

    private void crearPedido() {
        String producto = productoField.getText();
        String cantidad = cantidadField.getText();
        String precio = precioField.getText();

        if (pedidoCount < pedidos.length) {
            Pedido pedido = new Pedido(producto, cantidad, precio);
            pedidos[pedidoCount++] = pedido;

            pedidosArea.append("Pedido creado: " + pedido + "");

            productoField.setText("");
            cantidadField.setText("");
            precioField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "No se pueden crear más pedidos. Capacidad máxima alcanzada.");
        }
    }

    private void gestionarPedidos() {
        StringBuilder gestion = new StringBuilder("Gestión de Pedidos:");
        for (int i = 0; i < pedidoCount; i++) {
            gestion.append(pedidos[i]).append("");
        }
        JOptionPane.showMessageDialog(this, gestion.toString());
    }

    

    static class Pedido {
        private final String producto;
        private final String cantidad;
        private final String precio;

        public Pedido(String producto, String cantidad, String precio) {
            this.producto = producto;
            this.cantidad = cantidad;
            this.precio = precio;
        }

        
      
        @Override
        public String toString() {
            return "Producto: " + producto + ", Cantidad: " + cantidad + ", Precio: " + precio;
        }
    }
}

